package com.librarymanagementsystem.lms.Controller;

import com.librarymanagementsystem.lms.Entity.Author;
import com.librarymanagementsystem.lms.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public  String addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return "New Author added Successfully";
    }
    @GetMapping("/get_authors")
    public List<Author> getAuthor(){
        return authorService.getAuthors();
    }

    //make api to get all the books written a author
    //make api to get author name  by just book name
    //return a list of author whose nake = "xyz"

}
