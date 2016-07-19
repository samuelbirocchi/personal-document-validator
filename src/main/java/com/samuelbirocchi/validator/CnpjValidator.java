package com.samuelbirocchi.validator;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public class CnpjValidator extends Validator {

    @Override
    public Boolean validate(String document) {
        Boolean valid;

        String cleanDocument = document.replaceAll("[^\\d]+", "");
        valid = !cleanDocument.replaceAll(String.valueOf(cleanDocument.charAt(0)), "").isEmpty();

        if(cleanDocument.isEmpty() || cleanDocument.length() != 14) {
            valid = false;
        }

        valid &= validateFirstDigit(cleanDocument) && validateSecondDigit(cleanDocument);

        return valid;
    }

    private Boolean validateFirstDigit(String cleanDocument) {
        int size, sum, pos, result;
        String numbers, digits;
        size = cleanDocument.length() - 2;
        numbers = cleanDocument.substring(0,size);
        digits = cleanDocument.substring(size);
        sum = 0;
        pos = size - 7;
        for (int i = size; i >= 1; i--) {
            sum += Character.getNumericValue(numbers.charAt(size - i)) * pos--;
            if (pos < 2)
                pos = 9;
        }
        result = sum % 11 < 2 ? 0 : 11 - sum % 11;
        return result == Character.getNumericValue(digits.charAt(0));
    }

    private Boolean validateSecondDigit(String cleanDocument) {
        int size, sum, pos, result;
        String numbers, digits;
        size = cleanDocument.length() - 1;
        numbers = cleanDocument.substring(0,size);
        digits = cleanDocument.substring(size - 1);
        sum = 0;
        pos = size - 7;
        for (int i = size; i >= 1; i--) {
            sum += Character.getNumericValue(numbers.charAt(size - i)) * pos--;
            if (pos < 2)
                pos = 9;
        }
        result = sum % 11 < 2 ? 0 : 11 - sum % 11;
        return result == Character.getNumericValue(digits.charAt(1));
    }
}
