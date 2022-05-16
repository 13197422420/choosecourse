package com.ynusoft.stucoursechoose;

import com.ynusoft.stucoursechoose.entity.Student;
import com.ynusoft.stucoursechoose.view.ICourseView;
import com.ynusoft.stucoursechoose.view.IScoreView;
import com.ynusoft.stucoursechoose.view.IStudentView;
import com.ynusoft.stucoursechoose.view.impl.CourseViewImpl;
import com.ynusoft.stucoursechoose.view.impl.ScoreViewImpl;
import com.ynusoft.stucoursechoose.view.impl.StudentViewImpl;

import java.util.Scanner;

public class StudentEntry {

    public void entry() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 学生选课系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        IStudentView sview = new StudentViewImpl();
        ICourseView cview = new CourseViewImpl();
        IScoreView scview = new ScoreViewImpl();
        Student student = sview.login();

        if (student != null) {
            int menu = 0;
            while(menu!=6) {
                System.out.println("\n========= 1.所有课程列表=2.搜索课程=3.查看已选课程=4.选课=5.退课=6.退出系统 =========");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch(menu) {
                    case 1:
                        cview.listCourseAll();
                        break;
                    case 2:
                        cview.listCourseByKeyword();
                        break;
                    case 3:
                        scview.listAllChosen(student.getId());
                        break;
                    case 4:
                        scview.chooseCourse(student.getId());
                        break;
                    case 5:
                        scview.dropCourse(student.getId());
                        break;
                    case 6:
                        System.out.println("------------------------▄︻┻┳═一…… ☆（>○<）-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }
        }else {
            System.out.println("\n学生学号或密码输入错误!\n");
        }
    }

    public static void main(String[] args) {
        new StudentEntry().entry();
    }
}
