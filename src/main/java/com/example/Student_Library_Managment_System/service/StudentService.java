package com.example.Student_Library_Managment_System.service;

import com.example.Student_Library_Managment_System.model.Card;
import com.example.Student_Library_Managment_System.model.Student;
import com.example.Student_Library_Managment_System.repository.StudentRepository;
import com.example.Student_Library_Managment_System.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto){

        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setMobile(studentRequestDto.getMobile());
        student.setDept(studentRequestDto.getDept());
        student.setSem(studentRequestDto.getSem());
        student.setGender(studentRequestDto.getGender());
        student.setAddress(studentRequestDto.getAddress());

        Card card = new Card();

        card.setCardStatus("Active");
        card.setExpiryDate(LocalDate.now().plusYears(3).toString());
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        // we dont have to save card seperately like for studentRepo bc of cascading effect
        return "Student saved Successfully";

    }

    public Student findStudentById(int id){

       Optional<Student> optionalStudent =  studentRepository.findById(id);

       if(optionalStudent.isPresent()){
            return optionalStudent.get();
       }else{
           throw new RuntimeException("Student with id "+ id + " is not present");
       }
    }

    public List<Student> findAllStudents(){
       List<Student> studentList =  studentRepository.findAll();
       return studentList;
    }

    public String deleteStudentById(int id){

       Student student = findStudentById(id);
        if(student!=null){
            studentRepository.deleteById(id);
            return "Student with id "+id+" is deleted sucessfully.";
        }else{
            throw new RuntimeException("Student with id "+id+" is not present, so cannot delete");
        }

    }


}
