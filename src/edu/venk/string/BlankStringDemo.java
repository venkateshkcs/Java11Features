package edu.venk.string;

public class BlankStringDemo {
    public static void main(String[] args) {
        String valueString = "I have some value";
        String blankString = "       ";
        // previously to identify if a string is blank,
        // we used to trim the string and check it's length is zero or
        // we used to use apache or spring's stringUtils.isBlank() method as below
        if(blankString.trim().isEmpty()){
            System.out.println("blankString is blank / empty");
        }

        // with Java 11
        if(blankString.isBlank()) {
            System.out.println("blankString is blank");
        }

        if(!valueString.isBlank()) {
            System.out.println("valueString is not blank");
        }

    }
}
