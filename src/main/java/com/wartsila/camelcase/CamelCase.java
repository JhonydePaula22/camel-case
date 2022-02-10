package com.wartsila.camelcase;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CamelCase {

    public static final String DELIMITERS_REGEX = "[-_]";
    public static final String STARTS_WITH_DELIMITERS_REGEX = "^[-_]";
    public static final String EMPTY_STRING = "";

    static String toCamelCase(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            return EMPTY_STRING;
        }

        return getCamelCaseString(input);
    }

    private static String getCamelCaseString(String input) {
        input = checkStartsWithDelimiter(input);

        String response;

        String[] words = input.split(DELIMITERS_REGEX);

        response = Stream.of(words)
                .skip(1)
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(EMPTY_STRING));

        return words[0].concat(response);
    }

    private static String checkStartsWithDelimiter(String input) {
        Pattern pattern = Pattern.compile(STARTS_WITH_DELIMITERS_REGEX);
        boolean startsWithDelimiter = pattern.matcher(input).find();

        while (startsWithDelimiter) {
            input = input.substring(1);
            startsWithDelimiter = pattern.matcher(input).find();
        }

        return input;
    }
}