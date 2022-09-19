package com.dinusha.springbootfirstproject.repository;

import com.dinusha.springbootfirstproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {
}
