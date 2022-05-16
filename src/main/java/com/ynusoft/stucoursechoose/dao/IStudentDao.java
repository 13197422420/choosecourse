package com.ynusoft.stucoursechoose.dao;

import com.ynusoft.stucoursechoose.entity.Student;
import java.util.List;

public interface IStudentDao {
    int create(Student s);//新增
    int updatebyid(Student s);//修改
    int deletebyid(String Id);//删除
    List getOnebyidbyname(String Id,String Name);//查询并以Student对象返回
    List getAll();//查询并以List返回
    Student loginbyidbypassword(String Id,String password);//登录
}
