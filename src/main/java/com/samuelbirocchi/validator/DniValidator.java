package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class DniValidator extends Validator {

    @Override
    public Boolean validate(String document) {
        return document.matches("^(\\d{8})$");
    }
}
