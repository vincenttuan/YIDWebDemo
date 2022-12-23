package test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.yid.repository.YIDConnection;
import com.yid.repository.guestbook.entity.GuestBook;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateSample {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql = "select * from guestbook";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("12345678");
        dataSource.setDatabaseName("YID");

        try {
            dataSource.setCharacterEncoding("utf-8");
            conn = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        
        List<GuestBook> guestBooks = jdbcTemplate.query(sql, new BeanPropertyRowMapper(GuestBook.class));
        System.out.println(guestBooks);
    }

}
