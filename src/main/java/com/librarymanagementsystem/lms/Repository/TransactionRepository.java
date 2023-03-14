package com.librarymanagementsystem.lms.Repository;

import com.librarymanagementsystem.lms.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
