package com.ynusoft.stucoursechoose.view;

import com.ynusoft.stucoursechoose.entity.Student;

public interface IStudentView {
    Student login();
    void createStu();
    void deleteStu();
    void updateStu();
    void listStu();
}
