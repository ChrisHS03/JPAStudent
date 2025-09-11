package org.example.jpastudent.restcontroller;

import org.example.jpastudent.model.Student;
import org.example.jpastudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public String detteErRoden(){
        return "du er i roden :)";
    }

    @GetMapping("/students")
    public List<Student> showStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/addStudents")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addStudent(){
        Student student1 = new Student();
        student1.setName("john");
        student1.setBornDate(LocalDate.now());
        student1.setBornTime(LocalTime.now());
        studentRepository.save(student1);
        return studentRepository.findAll();
    }

//    @PutMapping("/addStudent")
//    public Student changeStudent(@RequestBody Student student){
//
//        System.out.println(student);
//        return studentRepository.save(student);
//    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> changeStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()){
            student.setId(orgStudent.get().getId());
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
