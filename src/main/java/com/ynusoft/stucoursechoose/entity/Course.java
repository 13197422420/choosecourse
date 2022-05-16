package com.ynusoft.stucoursechoose.entity;

public class Course {
    private String id; //课程号
    private String name; //课程名
    private int hour; //课程学时

    @Override
    public String toString() {
        return "Course{" +
                "课程号='" + id + '\'' +
                ", 课程名='" + name + '\'' +
                ", 课程学时=" + hour +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
