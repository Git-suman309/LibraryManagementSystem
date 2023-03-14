package com.librarymanagementsystem.lms.Service;

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
    public void addStudent(Student student) {
        //how to set card value at time of student creation
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("03/2025");
        card.setStudent(student);

        //set the card attribute in student
        student.setCard(card);

        //this will save both card n student
        //when parent is saving student automatice saving
        studentRepository.save(student);
    }
}
