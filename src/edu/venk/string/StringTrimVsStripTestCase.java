package edu.venk.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTrimVsStripTestCase {
    // Note that \u2000 is above \u0020 and not considered whitespace by trim()
    @Test
    public void testSame() {
        String s = "\t abc \n";

        assertEquals("abc", s.trim());
        assertEquals("abc", s.strip());
    }

    @Test
    public void testDifferent() {
        Character c = '\u2000';
        String s = c + "abc" + c;

        assertTrue(Character.isWhitespace(c));
        System.out.println(s +" and its length is "+s.length());
        assertEquals(s, s.trim());
        assertEquals("abc", s.strip());
    }
}
