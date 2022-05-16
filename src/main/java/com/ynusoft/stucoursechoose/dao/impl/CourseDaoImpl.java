package com.ynusoft.stucoursechoose.dao.impl;

import com.ynusoft.stucoursechoose.dao.ICourseDao;
import com.ynusoft.stucoursechoose.entity.Course;
import com.ynusoft.stucoursechoose.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int create(Course c) {
        int result = 0;
        String sql = "insert into courseinfo values(?,?,?)";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,c.getId());
            preparedStatement.setString(2,c.getName());
            preparedStatement.setInt(3,c.getHour());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int update(Course c) {
        int result = 0;
        String sql = "update courseinfo set coursename=?,coursehour=? where courseid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,c.getName());
            preparedStatement.setInt(2,c.getHour());
            preparedStatement.setString(3,c.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int delete(String Id) {
        int result = 0;
        String delscoresql = "delete from scoreinfo where courseid=?";
        String delcoursesql = "delete from courseinfo where courseid=?";

        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false); //关闭自动提交

            preparedStatement = connection.prepareStatement(delscoresql);
            preparedStatement.setString(1,Id);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(delcoursesql);
            preparedStatement.setString(1,Id);
            result = preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public Course getOne(String Id) {
        String sql = "";

        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "select * from courseinfo where 1=1";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getString("courseid"));
                course.setName(resultSet.getString("coursename"));
                course.setHour(resultSet.getInt("coursehour"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List getByKeyword(String CourseName) {
        List<Course> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from courseinfo where 1=1 ");
        if(CourseName!=null&&!CourseName.equals("")) {
            sql.append(" and coursename like '%"+CourseName+"%' ");
        }

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getString("courseid"));
                course.setName(resultSet.getString("coursename"));
                course.setHour(resultSet.getInt("coursehour"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
