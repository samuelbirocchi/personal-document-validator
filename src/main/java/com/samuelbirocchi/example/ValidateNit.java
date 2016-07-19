package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class ValidateNit {

    public static void main(String[] args) {
        System.out.println(Document.NIT.validate("15.759.88152/7"));
    }
}
