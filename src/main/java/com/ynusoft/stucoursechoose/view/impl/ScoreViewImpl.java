package com.ynusoft.stucoursechoose.view.impl;

import com.ynusoft.stucoursechoose.dao.IScoreDao;
import com.ynusoft.stucoursechoose.dao.impl.ScoreDaoImpl;
import com.ynusoft.stucoursechoose.entity.Score;
import com.ynusoft.stucoursechoose.view.IScoreView;

import java.util.List;
import java.util.Scanner;

public class ScoreViewImpl implements IScoreView {

    private Scanner input = new Scanner(System.in);

    @Override
    public void listAllChosen(String Sid) {
        IScoreDao sdao = new ScoreDaoImpl();
        List<Score> list = sdao.getScoreBySid(Sid);
        System.out.println("学号\t课程号\t分数");
        for(Score s : list) {
            System.out.println(s.getSid()+"\t"+s.getCid()+"\t"+s.getScore());
        }
    }

    @Override
    public void chooseCourse(String Sid) {
        IScoreDao sdao = new ScoreDaoImpl();
        System.out.println("请输入选择的课程号：");
        String Cid = input.next();
        int rs = sdao.create(Sid,Cid);
        if (rs == 0) {
            System.out.println("选课失败！");
        }else {
            System.out.println("选课成功！");
        }
    }

    @Override
    public void dropCourse(String Sid) {
        IScoreDao sdao = new ScoreDaoImpl();
        System.out.println("请输入选择退课的课程号：");
        String Cid = input.next();
        int rs = sdao.deleteBySidByCid(Sid,Cid);
        if (rs == 0) {
            System.out.println("退课失败！");
        }else {
            System.out.println("退课成功！");
        }
    }

    @Override
    public void updateScore() {
        IScoreDao sdao = new ScoreDaoImpl();
        Score score = new Score();
        System.out.println("请输入学生学号：");
        score.setSid(input.next());
        System.out.println("请输入课程号：");
        score.setCid(input.next());
        System.out.println("请输入分数：");
        score.setScore(Float.parseFloat(input.next()));
        int rs = sdao.update(score);
        if (rs == 0) {
            System.out.println("分数录入失败！");
        }else {
            System.out.println("分数录入成功！");
        }
    }

    @Override
    public void listChosen() {
        String Sid = "";
        String Cid = "";

        String inputStr = "";
        System.out.println("是否以学生学号查询(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入学生学号：");
            Sid = input.next();
        }

        System.out.println("是否以课程号查询(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入课程号：");
            Cid = input.next();
        }

        IScoreDao sdao = new ScoreDaoImpl();
        List<Score> list = sdao.getScoreBySidByCid(Sid,Cid);
        System.out.println("学号\t课程号\t分数");
        for(Score s : list) {
            System.out.println(s.getSid()+"\t"+s.getCid()+"\t"+s.getScore());
        }
    }
}
