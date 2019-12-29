package news;

public class News {
    String name;
    int cnt, id;

    public News() {}

    public News(String name) {
        this.name = name;
        cnt = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "id=" + id + " name='" + name + '\'' + ", cnt=" + cnt;
    }
}
