import net.spy.memcached.MemcachedClient;
import news.News;
import news.NewsDao;
import news.NewsDaoImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Random;

class thread implements Runnable {
    static NewsDao newsDao = new NewsDaoImpl();
    static String []str = new String[10];
    static {
        str[0] = "First";
        str[1] = "Second";
        str[2] = "Third";
        str[3] = "Fourth";
        str[4] = "Fifth";
    }
    static void update(MemcachedClient mcc) {
        Random random = new Random(10);
        for (int i = 0; i < 100; ++i) {
            int id = random.nextInt(10)+1;
            id = id * id * id % 10 + 1;
            newsDao.updateNews(id);
        }
        List<News> query = newsDao.queryNews();
        int cnt = 0;
        for (int i = 0; i < 5; ++i) mcc.delete(str[i]);
        for (News cur: query) {
            mcc.set(str[cnt], cnt++, cur.toString());
//            System.out.println(cnt + " " + cur.toString());
        }
    }

    public void run(MemcachedClient mcc) {
        run();
        update(mcc);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    static NewsDaoImpl newsDao = new NewsDaoImpl();
    static MemcachedClient mcc;
    static String []str = new String[10];
    static {
        str[0] = "First";
        str[1] = "Second";
        str[2] = "Third";
        str[3] = "Fourth";
        str[4] = "Fifth";
    }

    static {
        try {
            mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<News> query = newsDao.queryNews();
        for (News cur: query) {
            System.out.println(cur.toString());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        thread thd = new thread();
        thd.run(mcc);
        for (int i = 0; i < 5; ++i) {
            System.out.println(mcc.get(str[i]));
        }
    }
}
