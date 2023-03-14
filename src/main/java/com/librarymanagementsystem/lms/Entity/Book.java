package com.librarymanagementsystem.lms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagementsystem.lms.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne // relation of book to author
    @JoinColumn // it will join to author id / pk of parent
    @JsonIgnore //help to fix null error brakpoint //------------finall()- find parent child author-book -- it goes infinite so just ignore it
    Author author;  // just introduce variable // passed by fronted user




}
