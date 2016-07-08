package com.moshe.validator;

import com.moshe.model.Document;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
 */
public abstract class Validator {

    private static final CpfValidator cpfValidator= new CpfValidator();
    private static final NitValidator nitValidator =  new NitValidator();
    private static final DniValidator dniValidator = new DniValidator();

    public static Validator getInstance(Document document) {
        Validator validator = null;
        switch (document) {
            case CPF:
                validator = cpfValidator;
                break;
            case NIT:
                validator = nitValidator;
                break;
            case DNI:
                validator = dniValidator;
                break;
            default:
                break;
        }
        return validator;
    }

    public abstract Boolean validate(String document);

}
