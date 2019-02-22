package com.lb.util;

import java.sql.*;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 *          ####   com.mysql.jdbc.Driver 和 com.mysql.cj.jdbc.Driver的区别    ####
 *          1、JDBC连接Mysql5 com.mysql.jdbc.Driver:
 *              driverClassName=com.mysql.jdbc.Driver
 *              url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false
 *              username=root
 *              password=
 *
 *           2、JDBC连接Mysql6 com.mysql.cj.jdbc.Driver， 需要指定时区serverTimezone:
 *              在设定时区的时候，如果设定serverTimezone=UTC，会比中国时间早8个小时，如果在中国，可以选择Asia/Shanghai或者Asia/Hongkong
 *              driverClassName=com.mysql.cj.jdbc.Driver
 *              url=jdbc:mysql://localhost:3306/test?serverTimezone=Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false
 *              username=root
 *              password=
 *           --------------------------------------------------------------------------------------------
 * @ Modified By：
 *
 */
public class MySqlDBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql8";
    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    static {
        try {
            Class.forName(DRIVERNAME);
            System.out.println("注册驱动成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     */
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 增
     * @param sql
     */
    public void insert(String sql){
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删
     * @param sql
     */
    public void delete(String sql){
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 改
     * @param sql
     */
    public void update(String sql){
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查
     * @param sql
     * @return
     */
    public ResultSet select(String sql){
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void main(String[] args) {

        try {
            Class.forName(DRIVERNAME);
            System.out.println("注册驱动成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        //2、获得数据库的连接访问权限
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //3、向数据库发送执行的SQL执行语句
        Statement statement = null;
        try {
            statement = connection.createStatement();
            //编写SQL语句
            String sql = "select * from USER ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String userName = resultSet.getString("user");
                System.out.println("查询结果：" + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        //5、关闭数据库连接
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
