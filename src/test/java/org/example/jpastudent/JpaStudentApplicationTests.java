package org.example.jpastudent;

import org.example.jpastudent.model.Student;
import org.example.jpastudent.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaStudentApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        Student student1 = new Student();
        student1.setName("John");
        student1.setBornDate(LocalDate.of(2020,10,26));
        student1.setBornTime(LocalTime.of(18,30,26));

        studentRepository.save(student1);
    }

    @Test
    void testOnJens() {
        List<Student> students = studentRepository.findAll();
        assertEquals(1,students.size());
    }

}
