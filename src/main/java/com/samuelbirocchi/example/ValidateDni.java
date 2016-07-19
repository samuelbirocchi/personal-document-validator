package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;
import com.samuelbirocchi.validator.Validator;

/**
 * Created by rafael on 19/07/16.
 */
public class ValidateDni {

    public static void main(String[] args) {
        Validator validator = Validator.getInstance(Document.DNI);
        System.out.println(validator.validate("48477141H"));
    }
}
