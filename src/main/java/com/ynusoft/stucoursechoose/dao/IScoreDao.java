package com.ynusoft.stucoursechoose.dao;

import com.ynusoft.stucoursechoose.entity.Score;

import java.util.List;

public interface IScoreDao {
    int create(String Studid, String Courseid);//新增
    int update(Score s);//修改
    int deleteBySidByCid(String Studid, String Courseid);//删除
    List getScoreBySid(String Studid);
    List getScoreByCid(String Courseid);
    List getScoreBySidByCid(String Studid, String Courseid);
}
