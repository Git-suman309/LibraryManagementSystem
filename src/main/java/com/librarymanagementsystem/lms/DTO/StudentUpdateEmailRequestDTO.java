package com.librarymanagementsystem.lms.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUpdateEmailRequestDTO {
    private int id;
    private  String email;
}
