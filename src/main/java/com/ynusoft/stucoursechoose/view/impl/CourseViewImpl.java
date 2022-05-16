package com.ynusoft.stucoursechoose.view.impl;

import com.ynusoft.stucoursechoose.dao.ICourseDao;
import com.ynusoft.stucoursechoose.dao.impl.CourseDaoImpl;
import com.ynusoft.stucoursechoose.entity.Course;
import com.ynusoft.stucoursechoose.view.ICourseView;

import java.util.List;
import java.util.Scanner;

public class CourseViewImpl implements ICourseView {

    private Scanner input = new Scanner(System.in);

    @Override
    public void listCourseAll() {
        ICourseDao cdao = new CourseDaoImpl();
        List<Course> list = cdao.getAll();
        System.out.println("课程号\t课程名称\t课程学时");
        for(Course c : list) {
            System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getHour());
        }
    }

    @Override
    public void listCourseByKeyword() {
        String coursename = "";
        System.out.println("请输入课程名称关键字");
        coursename = input.next();

        ICourseDao cdao = new CourseDaoImpl();
        List<Course> list = cdao.getByKeyword(coursename);
        System.out.println("课程号\t课程名称\t课程学时");
        for(Course c : list) {
            System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getHour());
        }
    }

    @Override
    public void createCourse() {
        ICourseDao cdao = new CourseDaoImpl();
        Course course = new Course();
        System.out.println("请输入课程号：");
        course.setId(input.next());
        System.out.println("请输入课程名：");
        course.setName(input.next());
        System.out.println("请输入课程学时：");
        course.setHour(Integer.parseInt(input.next()));
        int rs = cdao.create(course);
        if (rs == 0) {
            System.out.println("课程信息录入失败！");
        }else {
            System.out.println("课程信息录入成功！");
        }
    }

    @Override
    public void updateCourse() {
        ICourseDao cdao = new CourseDaoImpl();
        Course course = new Course();
        System.out.println("请输入需要更新的课程号：");
        course.setId(input.next());
        System.out.println("请输入更新的课程名：");
        course.setName(input.next());
        System.out.println("请输入更新的课程学时：");
        course.setHour(Integer.parseInt(input.next()));
        int rs = cdao.update(course);
        if (rs == 0) {
            System.out.println("课程信息更新失败！");
        }else {
            System.out.println("课程信息更新成功！");
        }
    }

    @Override
    public void deleteCourse() {
        ICourseDao cdao = new CourseDaoImpl();
        System.out.println("删除的课程号：");
        String Cid = input.next();
        int rs = cdao.delete(Cid);
        if (rs == 0) {
            System.out.println("删除失败！");
        }else {
            System.out.println("删除成功！");
        }
    }
}
