package com.ynusoft.stucoursechoose.view.impl;

import com.ynusoft.stucoursechoose.dao.IStudentDao;
import com.ynusoft.stucoursechoose.dao.impl.StudentDaoImpl;
import com.ynusoft.stucoursechoose.entity.Student;
import com.ynusoft.stucoursechoose.view.IStudentView;

import java.util.List;
import java.util.Scanner;

public class StudentViewImpl implements IStudentView {

    private Scanner input = new Scanner(System.in);

    @Override
    public Student login() {
        System.out.println("请输入学生学号：");
        String studid = input.next();
        System.out.println("请输入密码：");
        String password = input.next();

        IStudentDao sdao = new StudentDaoImpl();
        return sdao.loginbyidbypassword(studid,password);
    }

    @Override
    public void createStu() {
        IStudentDao sdao = new StudentDaoImpl();
        Student student = new Student();
        System.out.println("请输入学生学号：");
        student.setId(input.next());
        System.out.println("请输入学生姓名：");
        student.setName(input.next());
        System.out.println("请输入学生性别(true/false)：");
        student.setSex(Boolean.parseBoolean(input.next()));
        System.out.println("请输入学生年龄：");
        student.setAge(Integer.parseInt(input.next()));
        int rs = sdao.create(student);
        if (rs == 0) {
            System.out.println("学生信息录入失败！");
        }else {
            System.out.println("学生信息录入成功！");
        }
    }

    @Override
    public void deleteStu() {
        IStudentDao sdao = new StudentDaoImpl();
        System.out.println("删除的学生学号：");
        String Sid = input.next();
        int rs = sdao.deletebyid(Sid);
        if (rs == 0) {
            System.out.println("删除失败！");
        }else {
            System.out.println("删除成功！");
        }
    }

    @Override
    public void updateStu() {
        IStudentDao sdao = new StudentDaoImpl();
        Student student = new Student();
        System.out.println("请输入需要更新的学生学号：");
        student.setId(input.next());
        System.out.println("请输入学生姓名：");
        student.setName(input.next());
        System.out.println("请输入学生性别(true/false)：");
        student.setSex(Boolean.parseBoolean(input.next()));
        System.out.println("请输入更新的密码：");
        student.setPassword(input.next());
        System.out.println("请输入学生年龄：");
        student.setAge(Integer.parseInt(input.next()));
        int rs = sdao.updatebyid(student);
        if (rs == 0) {
            System.out.println("学生信息更新失败！");
        }else {
            System.out.println("学生信息更新成功！");
        }
    }

    @Override
    public void listStu() {
        String Sid = "";
        String Sname = "";

        String inputStr = "";
        System.out.println("是否以学生学号查询(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入学生学号：");
            Sid = input.next();
        }

        System.out.println("是否以学生姓名关键字查询(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入学生姓名关键字：");
            Sname = input.next();
        }

        IStudentDao sdao = new StudentDaoImpl();
        List<Student> list = sdao.getOnebyidbyname(Sid,Sname);
        System.out.println("学生学号\t学生姓名\t学生性别\t密码\t学生年龄");
        for(Student s : list) {
            System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.isSex()+"\t"+s.getPassword()+"\t"+s.getAge());
        }
    }
}
