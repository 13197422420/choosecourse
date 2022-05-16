package com.ynusoft.stucoursechoose.dao.impl;

import com.ynusoft.stucoursechoose.dao.IStudentDao;
import com.ynusoft.stucoursechoose.entity.Student;
import com.ynusoft.stucoursechoose.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int create(Student s) {
        int result = 0;
        String sql = "insert into studinfo values(?,?,?,'123456',?)";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getId());
            preparedStatement.setString(2,s.getName());
            preparedStatement.setBoolean(3,s.isSex());
            preparedStatement.setInt(4,s.getAge());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int updatebyid(Student s) {
        int result = 0;
        String sql = "update studinfo set studname=?,studsex=?,password=?,studage=? where studid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s.getName());
            preparedStatement.setBoolean(2,s.isSex());
            preparedStatement.setString(3,s.getPassword());
            preparedStatement.setInt(4,s.getAge());
            preparedStatement.setString(5,s.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int deletebyid(String Id) {
        int result = 0;
        String delscoresql = "delete from scoreinfo where studid=?";
        String delstusql = "delete from studinfo where studid=?";

        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false); //关闭自动提交

            preparedStatement = connection.prepareStatement(delscoresql);
            preparedStatement.setString(1,Id);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(delstusql);
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
    public List<Student> getOnebyidbyname(String Id,String Name) {
        List<Student> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from studinfo where 1=1 ");
        if(Id!=null&&!Id.equals("")) {
            sql.append(" and studid="+Id);
        }
        if(Name!=null&&!Name.equals("")) {
            sql.append(" and studname like '%"+Name+"%' ");
        }

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("studid"));
                student.setName(resultSet.getString("studname"));
                student.setSex(resultSet.getBoolean("studsex"));
                student.setPassword(resultSet.getString("password"));
                student.setAge(resultSet.getInt("studage"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from studinfo where 1=1";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("studid"));
                student.setName(resultSet.getString("studname"));
                student.setSex(resultSet.getBoolean("studsex"));
                student.setPassword(resultSet.getString("password"));
                student.setAge(resultSet.getInt("studage"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Student loginbyidbypassword(String Id, String password) {
        Student student = null;
        String sql = "select * from studinfo where studid=? and password=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Id);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getString("studid"));
                student.setName(resultSet.getString("studname"));
                student.setSex(resultSet.getBoolean("studsex"));
                student.setPassword(resultSet.getString("password"));
                student.setAge(resultSet.getInt("studage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return student;
    }
}
