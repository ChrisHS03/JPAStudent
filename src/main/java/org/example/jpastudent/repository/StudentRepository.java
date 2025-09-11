package org.example.jpastudent.repository;

import org.example.jpastudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
