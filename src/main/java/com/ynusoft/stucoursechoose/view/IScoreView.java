package com.ynusoft.stucoursechoose.view;

public interface IScoreView {
    void listAllChosen(String Sid);
    void chooseCourse(String Sid);
    void dropCourse(String Sid);
    void updateScore();
    void listChosen();
}
