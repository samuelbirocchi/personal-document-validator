package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class DniValidator extends Validator {

    protected DniValidator() {

    }

    @Override
    public Boolean validate(String document) {

        if (!document.matches("^(\\d{8})([A-Z])$")) {
            return false;
        } else {
            String dniLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
            Integer documentNumber = Integer.parseInt(document.substring(0, document.length() - 1));
            char lastChar = dniLetters.charAt((documentNumber) % 23);

            return lastChar == document.charAt(document.length() - 1);
        }
    }
}
