package com.librarymanagementsystem.lms.Repository;

import com.librarymanagementsystem.lms.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}
