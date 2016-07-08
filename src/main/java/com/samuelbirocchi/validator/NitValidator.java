package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public class NitValidator extends Validator {

    protected NitValidator(){

    }

    @Override
    public Boolean validate(String document) {
        assert document.matches("^[0-9]+(-?[0-9kK])?$");
        String cleanDocument = document.replaceAll("[\\-./*]", "");

        char verificationDigit = cleanDocument.charAt(cleanDocument.length() - 1);
        Integer total = 0;

        char[] digits = cleanDocument.substring(0, cleanDocument.length()-1).toCharArray();
        Integer factor = digits.length + 1;
        for (char digit : digits) {
            total += Character.getNumericValue(digit) * factor;
            factor--;
        }

        Integer module = (11 - (total%11)) % 11;
        String expectedDigit = module == 10 ? "k" :module.toString();

        return expectedDigit.charAt(0) == verificationDigit;
    }
}
