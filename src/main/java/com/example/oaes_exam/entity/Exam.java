package com.example.oaes_exam.entity;

import javax.persistence.*;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;

    @OneToOne
    private Student student;

    public Exam(long uuid, Student student) {
        this.uuid = uuid;
        this.student = student;
    }

    public Exam(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "uuid=" + uuid +
                ", student=" + student +
                '}';
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam() {
    }
}
