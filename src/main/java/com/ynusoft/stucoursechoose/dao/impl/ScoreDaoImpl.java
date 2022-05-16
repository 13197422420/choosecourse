package com.ynusoft.stucoursechoose.dao.impl;

import com.ynusoft.stucoursechoose.dao.IScoreDao;
import com.ynusoft.stucoursechoose.entity.Course;
import com.ynusoft.stucoursechoose.entity.Score;
import com.ynusoft.stucoursechoose.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImpl implements IScoreDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int create(String Studid, String Courseid) {
        int result = 0;
        String sql = "insert into scoreinfo(studid,courseid,score) values(?,?,null)";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Studid);
            preparedStatement.setString(2,Courseid);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int update(Score s) {
        int result = 0;
        String sql = "update scoreinfo set score=? where studid=? and courseid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1,s.getScore());
            preparedStatement.setString(2,s.getSid());
            preparedStatement.setString(3,s.getCid());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public int deleteBySidByCid(String Studid, String Courseid) {
        int result = 0;
        String sql = "delete from scoreinfo where studid=? and courseid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Studid);
            preparedStatement.setString(2,Courseid);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }

    @Override
    public List<Score> getScoreBySid(String Studid) {
        List<Score> list = new ArrayList<>();
        String sql = "select * from scoreinfo where studid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Studid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Score score = new Score();
                score.setSid(resultSet.getString("studid"));
                score.setCid(resultSet.getString("courseid"));
                score.setScore(resultSet.getFloat("score"));
                list.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Score> getScoreByCid(String Courseid) {
        List<Score> list = new ArrayList<>();
        String sql = "select * from scoreinfo where courseid=?";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Courseid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Score score = new Score();
                score.setSid(resultSet.getString("studid"));
                score.setCid(resultSet.getString("courseid"));
                score.setScore(resultSet.getFloat("score"));
                list.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Score> getScoreBySidByCid(String Studid, String Courseid) {
        List<Score> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from scoreinfo where 1=1 ");
        if(Studid!=null&&!Studid.equals("")) {
            sql.append(" and studid="+Studid);
        }
        if(Courseid!=null&&!Courseid.equals("")) {
            sql.append(" and courseid="+Courseid);
        }

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Score score = new Score();
                score.setSid(resultSet.getString("studid"));
                score.setCid(resultSet.getString("courseid"));
                score.setScore(resultSet.getFloat("score"));
                list.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
