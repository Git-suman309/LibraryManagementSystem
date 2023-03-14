package com.librarymanagementsystem.lms.Repository;

import com.librarymanagementsystem.lms.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
