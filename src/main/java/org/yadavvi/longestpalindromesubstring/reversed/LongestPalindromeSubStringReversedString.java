package org.yadavvi.longestpalindromesubstring.reversed;

/**
 * Created by vishal on 11/4/17.
 */
public class LongestPalindromeSubStringReversedString {

    public String longestPalindrome(String s) {
        String string = s;
        String reverse = new StringBuilder(string).reverse().toString();
        String[] subStringArrays = new String[string.length()];

        String maxLengthPalindrome = "";
        StringBuilder computedPalindrome = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i++) {
            computedPalindrome.setLength(0);
            String palindrome = subStringArrays[i];
            if (palindrome == null) {
                subStringArrays[i] = "";
                palindrome = subStringArrays[i];
            }
            for (int j = 0, k = i; j < reverse.length() && k < string.length(); ) {
                char charAtK = string.charAt(k);
                char charAtJ = reverse.charAt(j);
                if (charAtK == charAtJ) {
                    computedPalindrome.append(charAtJ);
                    j++; k++;
                    if (isPalindrome(computedPalindrome.toString())) {
                        if (palindrome.length() < computedPalindrome.length()) {
                            subStringArrays[i] = computedPalindrome.toString();
                            palindrome = subStringArrays[i];
                            if (maxLengthPalindrome.length() < subStringArrays[i].length()) {
                                maxLengthPalindrome = subStringArrays[i];
                            }
                        }
                    }
                } else {
                    if (k == i) {
                        j++;
                    } else {
                        k = i;
                    }
                    computedPalindrome.setLength(0);
                }
            }
        }

        System.out.printf("String: %s, palindrome: %s\n", s, maxLengthPalindrome);
        return maxLengthPalindrome;
    }

    private boolean isPalindrome(String s) {
        String string = s;
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < string.length(); i++) {
            if (!(string.charAt(i) == reverse.charAt(i))) return false;
        }
        return true;
    }

}
