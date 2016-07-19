package com.samuelbirocchi.example;

import com.samuelbirocchi.model.Document;

/**
 * Created by rafael on 19/07/16.
 */
public class ValidateDni {

    public static void main(String[] args) {
        System.out.println(Document.DNI.validate("48477141H"));
    }
}
