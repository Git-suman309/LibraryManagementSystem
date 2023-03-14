package com.librarymanagementsystem.lms.Repository;

import com.librarymanagementsystem.lms.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
