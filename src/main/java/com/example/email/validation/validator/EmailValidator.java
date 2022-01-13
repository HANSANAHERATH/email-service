package com.example.email.validation.validator;

import com.example.email.validation.EmailValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailValidation, String[]> {
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public boolean isValid(String[] emails, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        System.out.println(isValid + " <<<<<<<<<<<<<<<<<<<<");
        for (String email: emails) {
            if(!Pattern.matches(EMAIL_REGEX, email.toLowerCase())) {
                isValid = false;
                break;
            }
        }
        System.out.println(isValid + " <<<<<<<<<<<<<<<<<<<<");
        return isValid;
    }
}
