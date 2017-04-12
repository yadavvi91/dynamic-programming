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

        String workingCopy = input;
        StringBuilder reserveCopy = new StringBuilder(input.length());
        for (int i = 0; i < workingCopy.length(); i++) {
            for (int j = i + 1; j < workingCopy.length(); j++) {
                if (workingCopy.charAt(i) == workingCopy.charAt(j)) {
                    while (j < workingCopy.length() && i < workingCopy.length() && workingCopy.charAt(i) == workingCopy.charAt(j)) j++;
                    if (j < workingCopy.length()) i = j;
                    else break;
                } else {
                    reserveCopy.append(workingCopy.charAt(i));
                    break;
                }
            }
        }
        return nonRepeatingCharString(reserveCopy.toString());
    }

}
