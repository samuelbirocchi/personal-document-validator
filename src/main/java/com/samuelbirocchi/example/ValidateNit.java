package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;
import com.samuelbirocchi.validator.Validator;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public class ValidateNit {

    public static void main(String[] args) {
        Validator validator = Validator.getInstance(Document.NIT);
        System.out.println(validator.validate("15.759.88152/7"));
    }
}
