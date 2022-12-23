package test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.yid.repository.guestbook.entity.GuestBook;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

// MysqlDataSource 25種用法
// https://www.programcreek.com/java-api-examples/?api=com.mysql.cj.jdbc.MysqlDataSource

public class JdbcTemplateSample {

    public static void main(String[] args) throws Exception {
        String sql = "select * from guestbook";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("12345678");
        dataSource.setDatabaseName("YID");
        dataSource.setCharacterEncoding("utf-8");
            
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        
        List<GuestBook> guestBooks = jdbcTemplate.query(sql, new BeanPropertyRowMapper(GuestBook.class));
        System.out.println(guestBooks);
    }

}
