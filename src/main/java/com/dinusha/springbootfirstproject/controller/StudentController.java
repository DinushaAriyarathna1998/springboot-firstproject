package com.dinusha.springbootfirstproject.controller;


import com.dinusha.springbootfirstproject.entity.Student;
import com.dinusha.springbootfirstproject.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value="/api" )
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public ModelAndView listallstudents(Model model){
        ModelAndView mv = new ModelAndView(  );
        mv.addObject("student",studentService.selectAllStudents());
        mv.setViewName("list.html");
        return mv;
    }

    @GetMapping("/save")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return new ModelAndView("redirect:/api/list");
    }

    @GetMapping("/new")
    public ModelAndView createStudentForm(Model model){
        Student student = new Student();
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName( "newstudent.html" );
        return mv;
        //create page
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editStudentForm(@PathVariable int id, Model model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", studentService.getStudentByID(id));
        mv.setViewName( "editstudent.html" );
        return mv;
        //create page
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {

        Student existingStudent = studentService.getStudentByID(id);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());

        studentService.updateStudent(student);
        ModelAndView mv = new ModelAndView(  );
        return new ModelAndView("redirect:/api/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ModelAndView("redirect:/api/list");
    }

}
