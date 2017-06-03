package org.yadavvi.decbinary;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by vishal on 3/6/17.
 */
public class NumberOfDecBinariesDP implements NumberOfDecBinaries {

    private List<Stack<String>> decBinaries;

    public NumberOfDecBinariesDP() {
        decBinaries = new LinkedList<>();
        Stack<String> forZero = new Stack<>();
        forZero.push("0");
        Stack<String> forOne = new Stack<>();
        forOne.push("1");
        decBinaries.add(forZero);
        decBinaries.add(forOne);
    }


    public static void main(String[] args) {
        NumberOfDecBinaries numberOfDecBinaries = new NumberOfDecBinariesDP();
        numberOfDecBinaries.decBinaryStringForPosition(10);
    }

    @Override
    public String decBinaryStringForPosition(int position) {
        if (position == 1) return decBinaries.get(0).peek();
        if (position == 2) return decBinaries.get(1).peek();

        int sum = 2; // 0 has 1 decbinary representation - <0>, 1 has 1 decbinary representation - <1>
        int value = 2;
        while (sum < position) {
            // <111001, 57> <decbinary, decimal> (here <binary, decimal> because a binary is also a valid decbinary)
            String binaryOfValue = getBinaryForDecimal(value);
            // Get all the combinations possible for <1_____, 57>, <0_____, 57>, <00____, 57>, <000___, 57>,
            // <0000__, 57>, <00000_, 57>, <000000, 57>. Of this (<0000__, 57>, <00000_, 57>, <000000, 57>) wouldn't
            // exist because the largest value that can be formed using __ characters or less in DecBinary is <99, 27>
            decBinaries.add(getDecBinariesCombForADecNumber(value, binaryOfValue));

            // Add the number of combinations for "value" to sum
            sum = sum + decBinaries.get(value).size(); value++;
        }

        System.out.println(decBinaries);
        if (sum == position) {

        } else if (sum > position) {

        }
        return null;
    }

    private Stack<String> getDecBinariesCombForADecNumber(int value, String binaryOfValue) {
        Stack<String> decBinariesForValue = new Stack<>();
        int valOfMaxPosition = getValueForIndexOfBinaryNumber(binaryOfValue.length() - 1);
        int remainingValue = value - valOfMaxPosition;
        for (String decBinary : decBinaries.get(remainingValue)) {
            decBinariesForValue.push("1" + decBinary);
        }

        String newDecBinaryForValue = reducedPower(value, binaryOfValue.length());

        return decBinariesForValue;
    }

    private String reducedPower(int value, int length) {
        return null;
    }

    private int getValueForIndexOfBinaryNumber(int length) {
        int decimal = 1;
        for (int i = 0; i < length; i++) {
            decimal *= 2;
        }
        return decimal;
    }

    private String getBinaryForDecimal(int value) {
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % 2);
            value = value / 2;
        }
        return builder.reverse().toString();
    }

}
