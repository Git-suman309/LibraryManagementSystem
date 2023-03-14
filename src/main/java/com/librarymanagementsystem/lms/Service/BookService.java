package com.librarymanagementsystem.lms.Service;

import com.librarymanagementsystem.lms.DTO.BookRequestDto;
import com.librarymanagementsystem.lms.DTO.BookResponceDto;
import com.librarymanagementsystem.lms.Entity.Author;
import com.librarymanagementsystem.lms.Entity.Book;
import com.librarymanagementsystem.lms.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository; // used author repo coz i m going to save author and book ll automatica save coz of cascading

    public BookResponceDto addBook(BookRequestDto bookRequestDto) throws Exception {
//        Author author; //deceliring out side so latter we can acces it
//        try {
//             author = authorRepository.findById(book.getAuthor().getId()).get(); //book me author hoga us id get krga
//            //the return type of findbyid is optional may db dont hv that id or author so we need to to doi try catch & .get()
//        }
//        catch (Exception e){
//            throw new Exception(e+" Author Not Present");
//        }
//        List<Book> booksWritten = author.getBooks(); // writing a new  book a author
//        booksWritten.add(book);
//        //save it as well
//        authorRepository.save(author); //this ll save both author and book in one go
//        //coz we cascaded & we wriiten mappedby author in author(parent) so when it run it ll also save list of books
//------------------------------------------------------------------------------
//i hv to save book so i need to creak book obj first

        //logically think when u creating a book author should also hv
          Author author =authorRepository.findById(bookRequestDto.getAuthorId()).get(); //getting author id
          Book book = new Book();
          book.setTitle(bookRequestDto.getTitle());
          book.setGenre(bookRequestDto.getGenre());
          book.setPrice(bookRequestDto.getPrice());
          book.setIssued(false); //by default it is false

          book.setAuthor(author);

          author.getBooks().add(book);
          authorRepository.save(author); //author is parerent and casced opration there so it ll save both

        //creating responce dto--------------------
        BookResponceDto bookResponceDto = new BookResponceDto();
        bookResponceDto.setTitle(book.getTitle());
        bookResponceDto.setPrice(book.getPrice());
        return bookResponceDto;
    }


}
