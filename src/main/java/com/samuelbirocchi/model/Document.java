package com.samuelbirocchi.model;

/**
 * @author Samuel Birocchi (samuelbirocchi@gmail.com)
 */
public enum Document {

    CPF(Country.BRAZIL),
    NIT(Country.COLOMBIA),
    DNI(Country.ARGENTINA);

    private Country country;

    Document(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }
}
