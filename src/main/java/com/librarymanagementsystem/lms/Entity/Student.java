package com.librarymanagementsystem.lms.Entity;

import com.librarymanagementsystem.lms.Enum.CardStatus;
import com.librarymanagementsystem.lms.Enum.Departement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity               // this ll help me to create student table
@NoArgsConstructor   //this ll help u to create  diff const
@AllArgsConstructor  //this ll help u to create  all arg const
@Getter              //this ll help u to create  getter setter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING) //if you write oridinal then it will give index no to each name in enum
    private Departement departement;

    @Column(unique = true) // this will allow only unique email in db
    private String email;

    //when a student created then it should also generte card
    //relation btw studnet to card
    //student var help to map ------ connect parent class  Student
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)   //cascade help u generate card automatically
    LibraryCard card;

    /*
    * cascading helps to save automatically
    * it also help us to remove extra table in db like auto inc
    *
    * */


}
