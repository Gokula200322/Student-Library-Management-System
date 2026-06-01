package com.example.Student_Library_Managment_System.controller;

import com.example.Student_Library_Managment_System.model.Student;
import com.example.Student_Library_Managment_System.requestdto.StudentRequestDto;
import com.example.Student_Library_Managment_System.service.StudentService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            String response = studentService.saveStudent(studentRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save Operation Failed");
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id) { //we can also use ResponseEntity<Object> where any WRAPPER CLASS IS accepted like here currStudent and e.getMessage ie Object and String
        try {
            Student currStudent = studentService.findStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(currStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> findAllStudents(){
        try{
            List<Student> studentList = studentService.findAllStudents();
            return ResponseEntity.status(HttpStatus.OK).body(studentList);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        try{
            String response = studentService.deleteStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
