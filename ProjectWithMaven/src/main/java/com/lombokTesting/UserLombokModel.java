package com.lombokTesting;

import lombok.Data;
import java.time.LocalDate;


@Data
public class UserLombokModel {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String gender;
}
