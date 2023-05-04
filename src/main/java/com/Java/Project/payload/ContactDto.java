package com.Java.Project.payload;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private Long id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String city;

    private String postalCode;

}

