package com.ynusoft.stucoursechoose.entity;

public class Score {
    private String sid; //学号
    private String cid; //课程号
    private float score; //分数

    @Override
    public String toString() {
        return "Score{" +
                "学号='" + sid + '\'' +
                ", 课程号='" + cid + '\'' +
                ", 分数=" + score +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
