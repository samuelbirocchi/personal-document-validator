package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public class CpfValidator extends Validator {

    @Override
    public Boolean validate(String document) {
        Boolean valid;

        String cleanDocument = document.replaceAll("\\D", "");
        valid = cleanDocument.matches("\\d{11}");
        valid &= !cleanDocument.replaceAll(String.valueOf(cleanDocument.charAt(0)), "").isEmpty();

        if (valid) {
            valid = verifyFirstDigit(cleanDocument);
            valid &= verifySecondDigit(cleanDocument);
        }

        return valid;
    }

    private Boolean verifyFirstDigit(String cleanDocument) {
        int total = 0;
        for (int i = 0; i < cleanDocument.length()-2;i++) {
            total += Character.getNumericValue(cleanDocument.charAt(i)) * (10 - i);
        }
        int rest = 11 - (total % 11);
        if (rest >= 10) rest = 0;
        return rest == Character.getNumericValue(cleanDocument.charAt(cleanDocument.length() - 2));
    }

    private Boolean verifySecondDigit(String cleanDocument) {
        int total;
        int rest;

        total = 0;
        for (int i = 0; i < cleanDocument.length()-1;i++) {
            total += Character.getNumericValue(cleanDocument.charAt(i)) * (11 - i);
        }
        rest = 11 - (total % 11);
        if (rest >= 10) rest = 0;
        return rest == Character.getNumericValue(cleanDocument.charAt(cleanDocument.length() - 1));
    }
}
