package com.bard.kursspring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @NotBlank(message = "Name can't be null")
    @Size(min = 2, message = "Name should be at least 2 character long")
    private String name;

    @Min(2000)
    @Max(2030)
    private int year;

    @Email
    @NotBlank(message = "Email can't be null")
    private String reportersMail;
}
