package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class NitValidator extends Validator {

    @Override
    public Boolean validate(String document) {
        Boolean valid;

        if (!document.matches("^[0-9]+(-?[0-9kK])?$")) {
            valid = false;
        } else {
            String cleanDocument = document.replaceAll("[\\-./*]", "");

            char verificationDigit = cleanDocument.charAt(cleanDocument.length() - 1);
            Integer total = 0;

            char[] digits = cleanDocument.substring(0, cleanDocument.length() - 1).toCharArray();
            Integer factor = digits.length + 1;
            for (char digit : digits) {
                total += Character.getNumericValue(digit) * factor;
                factor--;
            }

            Integer module = (11 - (total % 11)) % 11;
            String expectedDigit = module == 10 ? "k" : module.toString();

            valid = expectedDigit.charAt(0) == verificationDigit;
        }

        return valid;
    }
}
