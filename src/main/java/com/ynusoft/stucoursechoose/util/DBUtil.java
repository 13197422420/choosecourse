package com.ynusoft.stucoursechoose.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {

    // Suppresses default constructor, ensuring non-instantiability.
    private DBUtil(){}

    //类加载时绑定属性资源文件
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    //注册驱动
    static {
        try {
            Class.forName(resourceBundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return 新的连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 释放资源
     * @param connection 连接对象
     * @param statement 数据库操作对象
     * @param resultSet 查询结果集
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
