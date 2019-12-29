package news;

import dao.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    @Override
    public void insertNews(News news) {
        Connection connection = DbUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sq = "select Max(id) from news";


            String sql = "insert into news values(?, ?, ?)";
            pstmt = connection.prepareStatement(sq);

            rs = pstmt.executeQuery();
            int id = 1;
            if (rs.next()) {
                id += rs.getInt(1);
            }

            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.setString(2, news.getName());
            pstmt.setInt(3, news.getCnt());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbUtils.closeResultSet(rs);
        DbUtils.closeStatement(pstmt);
        DbUtils.closeConnection(connection);
    }

    @Override
    public List<News> queryNews() {
        List<News> res = new ArrayList<News>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "select * from news order by cnt desc limit 5";

            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setName(rs.getString("name"));
                news.setCnt(rs.getInt("cnt"));
                res.add(news);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DbUtils.closeResultSet(rs);
        DbUtils.closeStatement(pstmt);
        DbUtils.closeConnection(connection);
        return res;
    }

    @Override
    public void updateNews(int id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DbUtils.getConnection();
            String sql = "update news set cnt = cnt + 1 where id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbUtils.closeStatement(pstmt);
        DbUtils.closeConnection(connection);
    }
}
