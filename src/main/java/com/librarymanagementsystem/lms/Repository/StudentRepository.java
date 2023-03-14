package com.librarymanagementsystem.lms.Repository;

import com.librarymanagementsystem.lms.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //CUSTOME FINDBY------------------------------------------------------------
    //Email Return Type  ---findByEmail -E should capital ( pass variable)
    Student findByEmail(String email);
    List<Student> findByAge(int age); // by age it will return multipal student


}
