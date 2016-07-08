package com.samuelbirocchi.model;

/**
 * @author Samuel Birocchi (samuel.birocchi@ifood.com.br)
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
