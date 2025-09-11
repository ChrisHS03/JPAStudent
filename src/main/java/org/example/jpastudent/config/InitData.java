package org.example.jpastudent.config;

import org.example.jpastudent.model.Student;
import org.example.jpastudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student();
        student1.setName("John");
        student1.setBornDate(LocalDate.of(2020,10,26));
        student1.setBornTime(LocalTime.of(18,30,26));

        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("aieugb");
        student2.setBornDate(LocalDate.of(2000,2,5));
        student2.setBornTime(LocalTime.of(2,3,50));

        studentRepository.save(student2);



    }
}
