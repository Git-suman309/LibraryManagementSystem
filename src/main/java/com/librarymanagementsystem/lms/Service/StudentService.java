package com.librarymanagementsystem.lms.Service;

import com.librarymanagementsystem.lms.DTO.StudentRequestDto;
import com.librarymanagementsystem.lms.DTO.StudentResponceDTO;
import com.librarymanagementsystem.lms.DTO.StudentUpdateEmailRequestDTO;
import com.librarymanagementsystem.lms.Entity.LibraryCard;
import com.librarymanagementsystem.lms.Entity.Student;
import com.librarymanagementsystem.lms.Enum.CardStatus;
import com.librarymanagementsystem.lms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto) {
        //how to set card value at time of student creation
       /* LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("03/2025");
        card.setStudent(student);

        //set the card attribute in student
        student.setCard(card);

        //this will save both card n student
        //when parent is saving student automatice saving
        studentRepository.save(student);  */

        //creating student obj ---new method using dto
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartement(studentRequestDto.getDepartement());
        student.setEmail(studentRequestDto.getEmail());

        //creat a library card obj
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student); //set current student
        //rest r automatically gen
        student.setCard(card);

        //save
        studentRepository.save(student);


    }

    public String FindByEmail(String email) {
        Student student= studentRepository.findByEmail(email); //find by email will return whole obj of studnet
        return student.getName(); // i want to get name by email
    }

    public StudentResponceDTO updateEmail(StudentUpdateEmailRequestDTO studentUpdateEmailRequestDTO) {
        Student student =studentRepository.findById(studentUpdateEmailRequestDTO .getId()).get();
        student.setEmail(studentUpdateEmailRequestDTO.getEmail());

        //update step-----------
        Student updateedStudent = studentRepository.save(student);

        //now convert update student responce return type
        StudentResponceDTO studentResponceDTO = new StudentResponceDTO();
        studentResponceDTO.setId(updateedStudent.getId());
        studentResponceDTO.setName(updateedStudent.getName());
        studentResponceDTO.setEmail(updateedStudent.getEmail());

        return  studentResponceDTO;
    }
}
