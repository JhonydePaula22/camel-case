package com.wartsila.camelcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCaseTest {

    @Test
    public void camelCase_stringWithUnderscoresLowerStart_success() {
        String input = "digital_Product_Development";
        System.out.println("input: " + input);
        assertEquals("digitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeDashLowerStart_success() {
        String input = "digital-Product-Development";
        System.out.println("input: " + input);
        assertEquals("digitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testUserProvidedEmptyString_returnEmptyString() {
        String input = "";
        System.out.println("input: " + input);
        assertEquals("", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testUserProvidedNullInput_returnEmptyString() {
        String input = null;
        System.out.println("input: " + input);
        assertEquals("", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeDashLowerStart_FirstLetterCapitalized_success() {
        String input = "Digital-Product-Development";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testBothDelimiters_FirstLetterCapitalized_success() {
        String input = "Digital_Product-Development";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeUnderScoreStart_FirstLetterCapitalized_success() {
        String input = "Digital_Product_Development";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testNoDelimitersOnInput_returnUserInput() {
        String input = "Digital";
        System.out.println("input: " + input);
        assertEquals("Digital", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeUnderScoreStart_convertingLowerCaseToUpperCase_success() {
        String input = "Digital_product_development";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeUnderScoreStart_withNumbersAfterDelimiters_success() {
        String input = "Digital_1product_1development";
        System.out.println("input: " + input);
        assertEquals("Digital1product1development", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeUnderScoreStart_startsWithDelimiter_success() {
        String input = "____Digital_product_development____";
        System.out.println("input: " + input);
        assertEquals("DigitalProductDevelopment", CamelCase.toCamelCase(input));
    }

    @Test
    public void camelCase_testSomeDashLowerStart_startsWithDelimiter_success() {
        String input = "----digital-Product-Development-----";
        System.out.println("input: " + input);
        assertEquals("digitalProductDevelopment", CamelCase.toCamelCase(input));
    }
}
