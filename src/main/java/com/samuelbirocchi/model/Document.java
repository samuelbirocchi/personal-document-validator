package com.samuelbirocchi.model;

import com.samuelbirocchi.validator.CnpjValidator;
import com.samuelbirocchi.validator.CpfValidator;
import com.samuelbirocchi.validator.DniValidator;
import com.samuelbirocchi.validator.NitValidator;
import com.samuelbirocchi.validator.Validator;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public enum Document {

    CPF(Country.BRAZIL, CpfValidator.class),
    CNPJ(Country.BRAZIL, CnpjValidator.class),
    NIT(Country.COLOMBIA, NitValidator.class),
    DNI(Country.ARGENTINA, DniValidator.class);

    private Country country;
    private Class<? extends Validator> validatorClass;

    Document(Country country, Class<? extends Validator> validatorClass) {
        this.country = country;
        this.validatorClass = validatorClass;
    }

    public Country getCountry() {
        return country;
    }

    public Boolean validate(String document) {
        try {
            return this.validatorClass.getConstructor().newInstance().validate(document);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
