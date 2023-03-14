package com.librarymanagementsystem.lms.Controller;

import com.librarymanagementsystem.lms.Entity.Author;
import com.librarymanagementsystem.lms.Entity.Book;
import com.librarymanagementsystem.lms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try {
            bookService.addBook(book);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage()+" Book not added");
        }
        return "Book Added Successfully.";
    }

}
