package org.yadavvi.longestpalindromesubstring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yadavvi.longestpalindromesubstring.dp.LongestPalindromeSubStringDP;
import org.yadavvi.longestpalindromesubstring.nondp.LongestPalindromeSubStringNonDP;
import org.yadavvi.longestpalindromesubstring.reversed.LongestPalindromeSubStringReversedString;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by vishal on 11/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class LongestPalindromeSubStringTest {

    private LongestPalindromeSubStringNonDP longestPalindromeSubStringNonDP;
    private LongestPalindromeSubStringDP longestPalindromeSubStringDP;
    private LongestPalindromeSubStringReversedString longestPalindromeSubStringReversedString;

    public Object[] stringAndPalindrome() {
        return new Object[]{
                new Object[]{"BABCBAB", "BABCBAB"},
                new Object[]{"ABCBABA", "ABCBA"},
                new Object[]{"ABBA", "ABBA"},
                new Object[]{"ABACDFGDCABA", "ABA"}
        };
    }

    @Before
    public void setUp() throws Exception {
        longestPalindromeSubStringNonDP = new LongestPalindromeSubStringNonDP();
        longestPalindromeSubStringDP = new LongestPalindromeSubStringDP();
        longestPalindromeSubStringReversedString = new LongestPalindromeSubStringReversedString();
    }

    @Test
    @Parameters(method = "stringAndPalindrome")
    public void longestPalindromeNonDP(String string, String palindrome) throws Exception {
        assertThat(longestPalindromeSubStringNonDP.longestPalindrome(string), is(palindrome));
    }

    /*@Test
    @Parameters(method = "stringAndPalindrome")
    public void longestPalindromeDP(String string, String palindrome) throws Exception {
        assertThat(longestPalindromeSubStringDP.longestPalindrome(string), is(palindrome));
    }*/

    @Test
    @Parameters(method = "stringAndPalindrome")
    public void longestPalindromeReversedString(String string, String palindrome) throws Exception {
        assertThat(longestPalindromeSubStringReversedString.longestPalindrome(string), is(palindrome));
    }

}