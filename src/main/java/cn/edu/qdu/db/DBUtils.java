package cn.edu.qdu.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtils {

    private static DataSource ds = null;
    private static final Properties PROPERTIES = new Properties();
    static {
        try {
            PROPERTIES.load(DBUtils.class.getResourceAsStream("/db.properties"));
            ds = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDs(){
        return ds;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql:///todo");
//        Statement stmt = connection.createStatement();
//        ResultSet resultSet = stmt.executeQuery("select * from todo");

        QueryRunner qr = new QueryRunner(ds);

        List<Map<String, Object>> maps = qr.query("select * from todo", new MapListHandler());
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }

        qr.update("update todo t set t.todo_item = '改了没？'");

    }
}
