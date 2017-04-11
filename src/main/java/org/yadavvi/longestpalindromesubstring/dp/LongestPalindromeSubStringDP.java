package org.yadavvi.longestpalindromesubstring.dp;

/**
 * Created by vishal on 11/4/17.
 */
public class LongestPalindromeSubStringDP {

    public String longestPalindrome(String s) {
        String string = s;
        int[][] palindrome = new int[string.length()][string.length()];
        int maxLength = 1;
        int maxI = 0, maxJ = 0;

        for (int i = 0; i < string.length(); i++) {
            palindrome[i][i] = 1;
        }

        for (int k = 0; k < string.length(); k++) {
            for (int i = (k / 2) - 1, j = (k / 2) + 1; i >= 0 && j < string.length(); i++, j--) {
                if (string.charAt(i) == string.charAt(j)) {
                    palindrome[i][j] = palindrome[i + 1][j - 1] + 2;
                    if (maxLength < palindrome[i][j]) {
                        maxLength = palindrome[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    break;
                }
            }
            for (int i = (k / 2), j = (k / 2) + 1; i >= 0 && j < string.length(); i++, j--) {
                if (string.charAt(i) == string.charAt(j)) {
                    palindrome[i][j] = palindrome[i + 1][j - 1] + 2;
                    if (maxLength < palindrome[i][j]) {
                        maxLength = palindrome[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    break;
                }
            }
        }

        // Since maxJ is inclusive
        return string.substring(maxI, maxJ + 1);
    }

}
