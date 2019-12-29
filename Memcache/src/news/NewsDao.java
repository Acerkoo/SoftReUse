package news;

import java.util.List;

public interface NewsDao {
    void insertNews(News news);
    List<News> queryNews();
    void updateNews(int id);
}
