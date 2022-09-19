package com.dinusha.springbootfirstproject.controller;


import com.dinusha.springbootfirstproject.entity.Student;
import com.dinusha.springbootfirstproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public List<Student> listallstudents(){
        return studentService.selectAllStudents();
    }

    @GetMapping("/insert")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>( studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return new ResponseEntity<Student>( studentService.getStudentByID(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable("id") int id ,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){

        // delete employee from DB
        studentService.deleteStudent(id);

        return new ResponseEntity<String>("Student deleted successfully!.", HttpStatus.OK);
    }
}
