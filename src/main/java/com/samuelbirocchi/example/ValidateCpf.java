package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;
import com.samuelbirocchi.validator.Validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class ValidateCpf {

    public static void main(String[] args) {
        System.out.println(Validator.getInstance(Document.CPF).validate("587.732.536-18"));
    }
}
