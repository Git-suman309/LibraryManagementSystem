package com.librarymanagementsystem.lms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagementsystem.lms.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private  int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private  boolean isIssued; // set diffult value as false in db

    @ManyToOne // relation of book to author
    @JoinColumn // it will join to author id / pk of parent
  //  @JsonIgnore //help to fix null error brakpoint //------------finall()- find parent child author-book -- it goes infinite so just ignore it
    Author author;  // just introduce variable // passed by fronted user

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    //one book can hv many txn so txn txn wont work make list
    List<Transaction> transactionList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;






}
