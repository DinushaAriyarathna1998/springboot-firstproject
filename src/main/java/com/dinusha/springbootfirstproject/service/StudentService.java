package com.dinusha.springbootfirstproject.service;

import com.dinusha.springbootfirstproject.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAllStudents();
    Student saveStudent(Student student);
    Student getStudentByID(int id);
    Student updateStudent(Student student, int id);
    void deleteStudent(int id);
}
