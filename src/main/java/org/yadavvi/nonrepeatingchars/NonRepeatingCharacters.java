package org.yadavvi.nonrepeatingchars;

/**
 * Created by vishal on 12/4/17.
 */
public class NonRepeatingCharacters {

    public String nonRepeatingCharString(String input) {
        if (input == null) return null;
        if (input.length() == 0 || input.length() == 1) return input;

        StringBuilder builder = new StringBuilder(input.length());

        // Find the first repeated element
        int i = 1;
        while (i < input.length()) {
            if (input.charAt(i) != input.charAt(i - 1)) i++;
            else break;
        }

        // If the repeated element was found i.e. (i < input.length()) is TRUE
        // append the string till the repeated element in the finalString to be.
        // ((We will compute nonRepeatingCharString of this finalString.))
        // Otherwise, since NO repeated element was found, the input string
        // is good enough an answer, hence return the input string itself
        if (i < input.length()) {
            builder.append(input.substring(0, i - 1));
        } else {
            return input;
        }

        // If a repeated element was found, skip till all the repeated elements are exhausted.
        while (i < input.length()) {
            if (input.charAt(i) == input.charAt(i - 1)) i++;
            else break;
        }
        // Append the remaining elements to the finalString to be.
        // We will compute nonRepeatingCharString of this finalString.
        if (i < input.length()) {
            builder.append(input.substring(i, input.length()));
        }

        return nonRepeatingCharString(builder.toString());
    }

}
