package com.ynusoft.stucoursechoose.dao;

import com.ynusoft.stucoursechoose.entity.Course;
import java.util.List;

public interface ICourseDao {
    int create(Course c);//新增
    int update(Course c);//修改
    int delete(String Id);//删除
    Course getOne(String Id);//查询并以Course对象返回
    List getAll();//查询并以List返回
    List getByKeyword(String CourseName);//关键字查询
}
