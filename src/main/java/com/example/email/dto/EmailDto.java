package com.example.email.dto;

import com.example.email.validation.EmailValidation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class EmailDto {

    @EmailValidation
    private String[] to;

    @NonNull
    @NotBlank
    private String subject;

    @NonNull
    @NotBlank
    private String messageBody;
}
