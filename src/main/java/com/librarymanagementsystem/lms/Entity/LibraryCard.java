package com.librarymanagementsystem.lms.Entity;

import com.librarymanagementsystem.lms.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity               // this ll help me to create student table
@NoArgsConstructor   //this ll help u to create  diff const
@AllArgsConstructor  //this ll help u to create  all arg const
@Getter              //this ll help u to create  getter setter
@Setter
public class LibraryCard {
    @Id   //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment id
    private int cardNo;
    private String validTill;
    @Enumerated(EnumType.STRING)  //in what data type it ll store else it ll set as index
    private CardStatus cardStatus;

    @OneToOne  //relation of card to student
    @JoinColumn  //fk
    Student student; //this variable help u to connect student class -------student var going to map all the thing

}
