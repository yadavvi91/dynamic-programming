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
            decBinaries.add(getDecBinariesCombForADecNumber(value, binaryOfValue, new Stack<>()));

            // Add the number of combinations for "value" to sum
            sum = sum + decBinaries.get(value).size();
            value++;
        }

        System.out.println(decBinaries);
        if (sum == position) {

        } else if (sum > position) {

        }
        return null;
    }

    private Stack<String> getDecBinariesCombForADecNumber(int value, String decBinary,
                                                          Stack<String> decBinariesForValue) {
        char[] decBinArrChar = new StringBuilder(decBinary).reverse().toString().toCharArray();
        int[] decBinArr = new int[decBinArrChar.length];
        for (int i = 0; i < decBinArr.length; i++) {
            decBinArr[i] = decBinArrChar[i] - '0';
        }
        int max = decBinArr.length - 1;

        int powOf2ForMaxPos = getPowerOf2ForPosInBinaryNumber(max);
        int remainingValue = value - powOf2ForMaxPos;
        if (remainingValue < 0) return decBinariesForValue;
        for (String decBinaryValues : decBinaries.get(remainingValue)) {
            // 32(5 or less); so if <100000, 32> is encountered, it breaks because the numbers are sorted
            // i.e. for 5 the numbers would be [[5], [1, 3], [2, 1], [1, 0, 1]] thus 2 char decBinaries [1, 3], [2, 1]
            // occur before 3 char decBinary [1, 0, 1].
            if (decBinariesForValue.size() > max) break;
            decBinariesForValue.push(decBinArrChar[max] + decBinaryValues);
        }

        if (max - 1 >= 0 && decBinArr[max - 1] + 2 > 9) {
            String decBinString = getTheMinimumRep(remainingValue);
            if (decBinString.equalsIgnoreCase(decBinary.substring(1))) {
                return decBinariesForValue;
            } else {
                decBinString = getTheRep(remainingValue, max - 1);
                if (decBinString == null) return decBinariesForValue;
                if (decBinArr[max] > 1) {
                    decBinString = (decBinArr[max] - 1) + decBinString;
                }
                return getDecBinariesCombForADecNumber(remainingValue, decBinString, decBinariesForValue);
            }
        } else {
            if (max - 1 < 0) return decBinariesForValue;

            StringBuilder builder = new StringBuilder();
            decBinArr[max - 1] += 2;
            for (int i = 0; i < decBinArr.length - 1; i++) {
                builder.append(decBinArr[i]);
            }
            String decBinString = builder.reverse().toString();
            System.out.println("DecBinString: " + decBinString);
            if (decBinArr[max] > 1) {
                decBinString = (decBinArr[max] - 1) + decBinString;
            }
            getDecBinariesCombForADecNumber(remainingValue, decBinString, decBinariesForValue);
        }

        return decBinariesForValue;
    }

    private String getTheRep(int remainingValue, int length) {
        for (String string : decBinaries.get(remainingValue)) {
            if (string.length() == length) return string;
        }
        return null;
    }

    private String getTheMinimumRep(int remainingValue) {
        return decBinaries.get(remainingValue).peek();
    }

    private int getPowerOf2ForPosInBinaryNumber(int length) {
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
