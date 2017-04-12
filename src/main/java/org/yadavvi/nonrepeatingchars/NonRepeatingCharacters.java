package org.yadavvi.nonrepeatingchars;

/**
 * Created by vishal on 12/4/17.
 */
public class NonRepeatingCharacters {

    public String nonRepeatingCharString(String input) {
        if (input == null) return null;
        if (input.length() == 0 || input.length() == 1) return input;
        if (input.length() == 2) {
            if (input.charAt(0) == input.charAt(1)) return "";
            else return input;
        }

        StringBuilder workingCopy = new StringBuilder(input.length());
        workingCopy.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                if (i + 1 >= input.length()) break;

                workingCopy.deleteCharAt(workingCopy.length() - 1);
                workingCopy.append(input.substring(i + 1, input.length()));
                return nonRepeatingCharString(workingCopy.toString());
            } else {
                workingCopy.append(input.charAt(i));
            }
        }
        return workingCopy.toString();
    }

}
