package com.example.oaes_exam.dao;

import com.example.oaes_exam.entity.Student;

import java.util.List;

public interface ExamDao {
    List<Student> getStudents();
    void addStudent(Student student);
}
