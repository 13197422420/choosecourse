package com.ynusoft.stucoursechoose;

import com.ynusoft.stucoursechoose.view.ICourseView;
import com.ynusoft.stucoursechoose.view.IScoreView;
import com.ynusoft.stucoursechoose.view.IStudentView;
import com.ynusoft.stucoursechoose.view.impl.CourseViewImpl;
import com.ynusoft.stucoursechoose.view.impl.ScoreViewImpl;
import com.ynusoft.stucoursechoose.view.impl.StudentViewImpl;

import java.util.Scanner;

public class AdminEntry {

    public void entry() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 学生选课管理系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        int menu = 0;
        while(menu!=4) {
            System.out.println("\n========= 1.学生信息管理=2.课程信息管理=3.分数管理=4.退出系统 =========");
            System.out.println("请输入你的选择：");
            menu = input.nextInt();
            switch(menu) {
                case 1:
                    s_manager();
                    break;
                case 2:
                    c_manager();
                    break;
                case 3:
                    sc_manager();
                    break;
                case 4:
                    System.out.println("------------------------▄︻┻┳═一…… ☆（>○<）-----------------------");
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    private void s_manager() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 学生信息管理  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        IStudentView sview = new StudentViewImpl();

        int menu = 0;
        while(menu!=5) {
            System.out.println("\n========= 1.学生信息录入=2.学生信息删除=3.学生信息更新=4.学生信息查询=5.退出学生信息管理界面 =========");
            System.out.println("请输入你的选择：");
            menu = input.nextInt();
            switch(menu) {
                case 1:
                    sview.createStu();
                    break;
                case 2:
                    sview.deleteStu();
                    break;
                case 3:
                    sview.updateStu();
                    break;
                case 4:
                    sview.listStu();
                    break;
                case 5:
                    System.out.println("------------------------▄︻┻┳═一…… ☆（>○<）-----------------------");
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    private void c_manager() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 课程信息管理  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        IStudentView sview = new StudentViewImpl();
        ICourseView cview = new CourseViewImpl();
        IScoreView scview = new ScoreViewImpl();

        int menu = 0;
        while(menu!=5) {
            System.out.println("\n========= 1.课程信息录入=2.课程信息删除=3.课程信息更新=4.课程信息查询=5.退出课程信息管理界面 =========");
            System.out.println("请输入你的选择：");
            menu = input.nextInt();
            switch(menu) {
                case 1:
                    cview.createCourse();
                    break;
                case 2:
                    cview.deleteCourse();
                    break;
                case 3:
                    cview.updateCourse();
                    break;
                case 4:
                    cview.listCourseByKeyword();
                    break;
                case 5:
                    System.out.println("------------------------▄︻┻┳═一…… ☆（>○<）-----------------------");
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    private void sc_manager() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 分数管理  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        IScoreView scview = new ScoreViewImpl();

        int menu = 0;
        while(menu!=4) {
            System.out.println("\n========= 1.分数录入=2.分数更新=3.分数查询=4.退出分数信息管理界面 =========");
            System.out.println("请输入你的选择：");
            menu = input.nextInt();
            switch(menu) {
                case 1:
                    scview.updateScore();
                    break;
                case 2:
                    scview.updateScore();
                    break;
                case 3:
                    scview.listChosen();
                    break;
                case 4:
                    System.out.println("------------------------▄︻┻┳═一…… ☆（>○<）-----------------------");
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new AdminEntry().entry();
    }
}
