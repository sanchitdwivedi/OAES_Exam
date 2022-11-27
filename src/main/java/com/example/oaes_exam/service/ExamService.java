package com.example.oaes_exam.service;

import com.example.oaes_exam.dao.ExamDao;
import com.example.oaes_exam.dao.ExamDaoImpl;
import com.example.oaes_exam.dao.UserDao;
import com.example.oaes_exam.dao.UserDaoImpl;
import com.example.oaes_exam.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private ExamDao examDao;
    private UserDao userDao;

    public ExamService(){
        examDao = new ExamDaoImpl();
        userDao = new UserDaoImpl();
    }

    public void subscribe(Student student){
        examDao.addStudent(student);
    }

//    public void unsubscribe(Student student){
//        List<Student> students = examDao.getStudents();
//        for(Student s: students){
//            if(s.getUuid()==student.getUuid()){
//                students.remove(s);
//                break;
//            }
//        }
//    }

    public void notifySubscribers() throws Exception {
        List<Student> students = examDao.getStudents();
        for(Student s: students){
            s.setTestStatus();
            System.out.println(s);
            userDao.save(s);
        }
    }

    public void startTest() throws Exception {
        notifySubscribers();
    }
}
