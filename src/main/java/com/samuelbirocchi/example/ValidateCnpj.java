package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public class ValidateCnpj {

    public static void main(String[] args) {
        System.out.println(Document.CNPJ.validate("78.757.801/0001-93"));
    }
}
