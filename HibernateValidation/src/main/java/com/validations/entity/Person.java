package com.validations.entity;

/**
 * @Author - Digvijay Bakare
 **/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Person {
    @NotNull(message = "Invalid ID. Please enter your ID.")
    @Id
    private int id;

    @Size(max = 20, min = 3, message = "Invalid name. Size should be between 3 to 20.")
    @NotEmpty(message = "Please enter your name.")
    private String name;

    @Email(message = "Invalid email address. Please enter a proper email ID.")
    @NotEmpty(message = "Please enter your email ID.")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number. It must be exactly 10 digits removing country code!")
    private String mobileNo;

    @NotEmpty(message = "Please enter your address.")
    private String address;
}
