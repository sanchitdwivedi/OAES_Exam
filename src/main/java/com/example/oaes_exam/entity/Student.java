package com.example.oaes_exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Student extends User{
    @Column(nullable = false, unique = true)
    private String rollNo;
    @ManyToOne
    private College college;
    @Column(nullable = false)
    private int locked;
    @Column(nullable = false)
    private int triesLeft;
    private int testStatus;

    public Student(long uuid, long userID, String password, String email, String rollNo, College college, int locked, int triesLeft) {
        super(uuid, userID, password);
        this.rollNo = rollNo;
        this.college = college;
        this.locked = locked;
        this.triesLeft = triesLeft;
        this.testStatus = 0;
    }

    public Student() {

    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public void setTriesLeft(int triesLeft) {
        this.triesLeft = triesLeft;
    }

    public int getTestStatus() {
        return testStatus;
    }

    public void setTestStatus() {
        this.testStatus = 1;
    }

    public void setTestStatus(int testStatus) {
        this.testStatus = testStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", college=" + college +
                ", locked=" + locked +
                ", triesLeft=" + triesLeft +
                ", testStatus=" + testStatus +
                '}';
    }
}