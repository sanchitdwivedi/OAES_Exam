package com.example.oaes_exam.entity;

import javax.persistence.*;

@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;

    @Column(nullable = false, unique = true)
    private long userID;
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(long uuid, long userID, String password) {
        this.uuid = uuid;
        this.userID = userID;
        this.password = password;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userID=" + userID +
                ", password='" + password + '\'' +
                '}';
    }
}
