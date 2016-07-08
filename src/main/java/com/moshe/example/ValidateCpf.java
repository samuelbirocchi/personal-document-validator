package com.moshe.example;

import com.moshe.model.Document;
import com.moshe.validator.Validator;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public class ValidateCpf {

    public static void main(String[] args) {
        System.out.println(Validator.getInstance(Document.CPF).validate("587.732.536-18"));
    }
}
