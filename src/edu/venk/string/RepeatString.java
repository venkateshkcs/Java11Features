package edu.venk.string;

import org.junit.platform.commons.util.StringUtils;

public class RepeatString {
    public static void main(String[] args) {
        String toRepeat = "Java is evolving\n";
        System.out.println(toRepeat.repeat(5));
        // throws NPE
        /*String x = null;
        System.out.println(x.repeat(5));*/
        String x = "";
        // throws argument is negative for repeat()
        try {
            System.out.println(x.repeat(-5));
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }
}
