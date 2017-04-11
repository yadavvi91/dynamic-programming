package org.yadavvi.longestpalindromesubstring.dp;

/**
 * Created by vishal on 11/4/17.
 */
public class LongestPalindromeSubStringDP {

    public String longestPalindrome(String s) {
        String string = s;
        int[] palindrome = new int[string.length()];
        int maxlength = 1;
        int maxlengthAt = 0;

        for (int i = 0; i < string.length(); i++) {
            palindrome[i] = 1;
        }

        for (int k = 0; k < string.length(); k++) {
            int iStart, jStart;
            if (string.length() - 1 - k > k) {
                iStart = 0;
                jStart = k + iStart;
            } else {
                jStart = string.length() - 1;
                iStart = k - jStart;
            }
            for (int j = jStart, i = iStart;
                 ((j >= k && i < k) || (j > k && i <= k)) && i < j && i >= 0 && j <= string.length() - 1;
                 i++, j--) {
                if (string.charAt(i) == string.charAt(j)) {
                    palindrome[k] += 2;
                }
            }
        }
        for (int i = 0; i < string.length(); i++) {
            if (palindrome[i] > maxlength) {
                maxlength = palindrome[i];
                maxlengthAt = i;
            }
        }

        return getLongestPalindrome(string, maxlength, maxlengthAt);
    }

    private String getLongestPalindrome(String string, int maxlength, int maxlengthAt) {
        int i = maxlengthAt - 1, j = maxlengthAt + 1;

        for (; i > 0 && j < string.length() - 1 && j - i <= maxlength; i--, j++) {

        }

        if (maxlength == (j - i)) {
            return string.substring(i, j);
        } else {
            return string.substring(i + 1, j);
        }
    }

}
