package com.librarymanagementsystem.lms.Entity;

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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL) // it means one author can have many books so we need to store in single list so  u can access  in db easily
    List<Book> books = new ArrayList<>();  // this is not gona creat any table //child

    //intitilize new arrayList here only -- as empty --coz author can hv same base details latter he can add his books
    //& also backend dev cant deside which book authore going to write


}
