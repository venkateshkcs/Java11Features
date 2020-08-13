package edu.venk.string;

import java.util.stream.Collectors;

public class NumberOfLinesDemo {
    public static void main(String[] args) {
        // String.lines() is an alternate for split("\n");
        String demoString = "A\nB\r\nCDEF\nXY\rZ";
        // Note: if run on windows, XY will not be printed as \r brings cursor to beginning of line and Z replaces XY
        System.out.println(demoString);
        // Note: while lines() method splits on either of \n or \r or both.
        System.out.println(demoString.lines().collect(Collectors.toList()));
    }
}
