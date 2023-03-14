package com.librarymanagementsystem.lms.Controller;

import com.librarymanagementsystem.lms.DTO.StudentRequestDto;
import com.librarymanagementsystem.lms.DTO.StudentResponceDTO;
import com.librarymanagementsystem.lms.DTO.StudentUpdateEmailRequestDTO;
import com.librarymanagementsystem.lms.Entity.Student;
import com.librarymanagementsystem.lms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
    studentService.addStudent(studentRequestDto);
    return "Student Has Been Added.";
    }

    @GetMapping("find_by_email")
    public String FindByEmail(@RequestParam("email") String email){
       return studentService.FindByEmail(email);
    }

    //get student of particular age

    @PutMapping("/update_email")
    public StudentResponceDTO updateEmail(@RequestBody StudentUpdateEmailRequestDTO studentUpdateEmailRequestDTO){
        return studentService.updateEmail(studentUpdateEmailRequestDTO);
    }


}
