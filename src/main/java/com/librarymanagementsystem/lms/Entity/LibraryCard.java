package com.librarymanagementsystem.lms.Entity;

import com.librarymanagementsystem.lms.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity               // this ll help me to create student table
@NoArgsConstructor   //this ll help u to create  diff const
@AllArgsConstructor  //this ll help u to create  all arg const
@Getter              //this ll help u to create  getter setter
@Setter
public class LibraryCard {
    @Id   //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment id
    private int cardNo;
//    private String validTill;
    @Enumerated(EnumType.STRING)  //in what data type it ll store else it ll set as index
    private CardStatus cardStatus;

    @CreationTimestamp   // it will automatically give a creation date
    private Date creationDate;
    @UpdateTimestamp  //when u do updation in db then it should update
    private Date updationDate;


    @OneToOne  //relation of card to student
    @JoinColumn  //fk
    Student student; //this variable help u to connect student class -------student var going to map all the thing

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    //initially when u make a card there is no txn so u need to give empty list
    List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    //initially no book is issued so just give a empty list
    List<Book> bookIssued = new ArrayList<>();


}
