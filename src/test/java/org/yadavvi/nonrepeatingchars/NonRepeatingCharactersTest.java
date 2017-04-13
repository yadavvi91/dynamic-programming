package org.yadavvi.nonrepeatingchars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by vishal on 12/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class NonRepeatingCharactersTest {

    private NonRepeatingCharacters nonRepeatingCharacters;

    public Object[] inputStringNonRepeatingString() {
        return new Object[]{
                new Object[]{null, null},
                new Object[]{"", ""},
                new Object[]{"a", "a"},
                new Object[]{"aa", ""},
                new Object[]{"aaaaaa", ""},
                new Object[]{"ab", "ab"},
                new Object[]{"abba", ""},
                new Object[]{"aabcccdee", "bd"},
                new Object[]{"abcdeedcbfgf", "afgf"},
                new Object[]{"abbabba", "a"}
        };
    }

    @Before
    public void setUp() throws Exception {
        nonRepeatingCharacters = new NonRepeatingCharacters();
    }

    @Test
    @Parameters(method = "inputStringNonRepeatingString")
    public void nonRepeatingCharString(String input, String output) throws Exception {
        long before = System.nanoTime();
        String nonRepeatingString = nonRepeatingCharacters.nonRepeatingCharString(input);
        long after = System.nanoTime();

        assertThat(nonRepeatingString, is(output));
        System.out.printf("input: %20s, output: %8s, diff: %10o \n", input, output, after - before);
    }

    @Test
    @Parameters(method = "inputStringNonRepeatingString")
    public void nonRepeatingCharStringWORecursion(String input, String output) throws Exception {
        long before = System.nanoTime();
        String nonRepeatingString = nonRepeatingCharacters.nonRepeatingCharStringWORecursion(input);
        long after = System.nanoTime();

        assertThat(nonRepeatingString, is(output));
        System.out.printf("input: %20s, output: %8s, diff: %10o \n", input, output, after - before);
    }


}