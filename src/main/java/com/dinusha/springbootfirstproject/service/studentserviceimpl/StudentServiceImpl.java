package com.dinusha.springbootfirstproject.service.studentserviceimpl;

import com.dinusha.springbootfirstproject.entity.Student;
import com.dinusha.springbootfirstproject.repository.StudentRepository;
import com.dinusha.springbootfirstproject.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByID(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
            return studentRepository.save(student);
    }


    @Override
    public void deleteStudent(int id) {
        studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        studentRepository.deleteById(id);
    }
}
