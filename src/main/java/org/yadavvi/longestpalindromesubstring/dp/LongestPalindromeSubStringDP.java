package org.yadavvi.longestpalindromesubstring.dp;

/**
 * Created by vishal on 11/4/17.
 */
public class LongestPalindromeSubStringDP {

    public String longestPalindrome(String s) {
        String string = s;
        int[][] palindrome = new int[string.length()][string.length()];
        int maxLength = 0;
        int maxI = 0, maxJ = 0;

        // This is done by (i == j)
        /*for (int i = 0; i < string.length(); i++) {
            palindrome[i][i] = 1;
        }*/

        for (int j = 0; j < string.length(); j++) {
            for (int i = 0; i < string.length(); i++) {
                if (i == j) {
                    palindrome[i][j] = 1;
                    if (maxLength < palindrome[i][j]) {
                        maxLength = 1;
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    if (i >= j || j <= 0) continue;
                    if (string.charAt(i + 1) == string.charAt(j - 1)) {
                        if (i + 1 == j - 1) palindrome[i][j] = palindrome[i + 1][j - 1] + 1;
                        else palindrome[i][j] = palindrome[i + 1][j - 1] + 2;
                        if (maxLength < palindrome[i][j]) {
                            maxLength = palindrome[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    } else {
                        palindrome[i][j] = 1;
                        if (maxLength < palindrome[i][j]) {
                            maxLength = palindrome[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }
        // Since maxJ is inclusive
        return string.substring(maxI, maxJ + 1);
    }

}
