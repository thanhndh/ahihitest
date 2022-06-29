package com.example.ahihi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/")
    public List<Student> getStudents(){
        System.out.println("ahihi");
        return (List<Student>) studentRepository.findAll();
    }
    //    @GetMapping("/name")
//    public ResponseEntity<Optional<Student>> getStudent(@RequestParam("name") String name){
//        System.out.println("ahihi");
//        Optional<Student> student = Optional.ofNullable(studentRepository.findByUsername(name));
//        if (student == null){
//            return (ResponseEntity<Optional<Student>>) ResponseEntity.notFound();
//        }
//        //return ResponseEntity.ok(student);
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
    @PostMapping
    public void postStudent(@RequestBody Student dto) {
        studentRepository.save(dto);
    }
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable(required = true) long id) {
        return studentRepository.findById(id);
    }
}