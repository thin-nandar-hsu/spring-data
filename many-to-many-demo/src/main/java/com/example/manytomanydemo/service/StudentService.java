package com.example.manytomanydemo.service;

import com.example.manytomanydemo.dao.StudentDao;
import com.example.manytomanydemo.entity.Student;
import com.example.manytomanydemo.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    // private final SubjectDao subjectDao;

//    public StudentService(SubjectDao subjectDao) {
//        this.subjectDao = subjectDao;
//    }




    @Transactional
    public void createDb(){
        Student s1 = new Student("Re","Dono","re@gmail.com");
        Student s2 = new Student("Mu","Shi","mu@gmail.com");
        Student s3 = new Student("Yo","Yo","yo@gmail.com");

        Subject sub1 = new Subject("Java",3,200000);
        Subject sub2 = new Subject("Python",4,250000);
        Subject sub3 = new Subject("PhP",5,350000);

       s1.addSubj(sub1);
       s1.addSubj(sub2);
       s1.addSubj(sub3);

       s2.addSubj(sub2);
       s3.addSubj(sub3);

       studentDao.save(s1);
       studentDao.save(s2);
       studentDao.save(s3);







    }
}
