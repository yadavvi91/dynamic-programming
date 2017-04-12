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
        assertThat(nonRepeatingCharacters.nonRepeatingCharString(input), is(output));
    }

}