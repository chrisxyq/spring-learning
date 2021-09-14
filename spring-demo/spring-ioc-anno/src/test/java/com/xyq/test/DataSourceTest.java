package com.xyq.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author chrisxu
 * @create 2021-09-14 19:41
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class DataSourceTest {
    /**
     * 手动创建druid数据源
     * 加载配置文件
     *
     * @throws SQLException
     */
    @Test
    public void test() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/school");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 手动创建druid数据源
     * druid不能加载配置文件？
     *
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
