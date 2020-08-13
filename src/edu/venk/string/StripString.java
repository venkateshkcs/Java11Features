package edu.venk.string;

public class StripString {
    // strip() is evolution to trim() as it is unicode aware and checks each code point while trim just compares
    // if given character is less than whitespace code point while trimming.
    public static void main(String[] args) {
        String demoString = "      Hello     \t    ";
        System.out.println("Actual length of the string with leading and trailing spaces is "+demoString.length());
        // demoString.trim();
        String strippedLeadingCharString = demoString.stripLeading();
        System.out.println(strippedLeadingCharString.length());

        String strippedTrailingCharString = demoString.stripTrailing();
        System.out.println(strippedTrailingCharString.length());

        String strippedString = demoString.strip();
        System.out.println(strippedString.length());

    }
}
