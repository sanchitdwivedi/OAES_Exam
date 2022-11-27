package com.example.oaes_exam.dao;

import com.example.oaes_exam.entity.Exam;
import com.example.oaes_exam.entity.Student;
import com.example.oaes_exam.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ExamDaoImpl implements ExamDao{
    @Override
    public List<Student> getStudents() {
        Session session = SessionUtil.getSession();
        Criteria criteria = session.createCriteria(Exam.class);
        List<Exam> exams = criteria.list();
        List<Student> students = new ArrayList<>();
        for(Exam e: exams) students.add(e.getStudent());
        session.close();
        return students;
    }

    @Override
    public void addStudent(Student student) {
        Session session = SessionUtil.getSession();
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Exam.class);
//            criteria.add(Restrictions.eq("userID", user.getUserID()));
//            Exam exam = (Exam) criteria.uniqueResult();
            Exam exam = new Exam(student);
            session.save(exam);
            tx.commit();
//            user.setUserID(user1.getUserID());
//            session.clear();
//            session.beginTransaction();
//            session.update(user);
//            tx.commit();
        } catch (HibernateException he) {
            System.out.println(he);
            System.err.println("Hibernate Exception FOUND!! ->  " + he);
        }

        session.close();
    }
}
