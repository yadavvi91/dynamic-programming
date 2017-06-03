package org.yadavvi.decbinary;

import org.yadavvi.util.ReverseIterable;

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
        System.out.println("For: " + 88 + " - " + numberOfDecBinaries.decBinaryStringForPosition(88));
    }

    @Override
    public String decBinaryStringForPosition(int position) {
        if (position == 1) return decBinaries.get(0).peek();
        if (position == 2) return decBinaries.get(1).peek();

        int sum = 2; // 0 has 1 decbinary representation - <0>, 1 has 1 decbinary representation - <1>
        int value = 2;
        while (sum < position) {
            String binaryOfValue = getBinaryForDecimal(value);
            Stack<String> stack = new Stack<>();
            getDecBinariesCombForADecNumber(value, binaryOfValue, stack);
            Stack<String> reversedStack = new Stack<>();
            while (!stack.empty()) {
                reversedStack.push(stack.pop());
            }
            decBinaries.add(reversedStack);

            sum = sum + decBinaries.get(value).size();
            value++;
        }

        for (int i = 0; i < decBinaries.size(); i++) {
            System.out.printf("%3d: %s%n", i, decBinaries.get(i));
        }
        if (sum == position) {
            return decBinaries.get(value - 1).peek();
        } else if (sum > position) {
            /*int extra = sum - decBinaries.get(value - 1).size();
            Stack<String> stack = decBinaries.get(value - 1);
            for (int i = 0; i < extra - 1; i++) {
                stack.pop();
            }
            return stack.pop();*/
        }
        return null;
    }

    private Stack<String> getDecBinariesCombForADecNumber(int value, String decBinary,
                                                          Stack<String> decBinariesForValue) {
        if (decBinary.isEmpty()) return decBinariesForValue;
        if (decBinary.length() == 1) {
            decBinariesForValue.push(decBinary);
            return decBinariesForValue;
        }

        char[] decBinArrChar = new StringBuilder(decBinary).reverse().toString().toCharArray();
        int[] decBinArr = new int[decBinArrChar.length];
        for (int i = 0; i < decBinArr.length; i++) {
            decBinArr[i] = decBinArrChar[i] - '0';
        }
        int max = decBinArr.length - 1;

        int powOf2ForMaxPos = getPowerOf2ForPosInBinaryNumber(max);
        int remainingValue = value - powOf2ForMaxPos * decBinArr[max];
        if (remainingValue < 0) return decBinariesForValue;

        boolean isMaxMinusOneFound = false;
        String maxMinusOneString = "";
        for (String decBinaryValue : ReverseIterable.reversed(decBinaries.get(remainingValue))) {
            if (!isMaxMinusOneFound && decBinaryValue.length() == decBinary.length() - 1) {
                maxMinusOneString = decBinaryValue;
                isMaxMinusOneFound = true;
            }
            if (decBinaryValue.length() > decBinary.length() - 1) continue;
            StringBuilder decBinaryValueBuilder = new StringBuilder(decBinaryValue);
            while (decBinaryValueBuilder.length() < decBinary.length() - 1) {
                decBinaryValueBuilder.insert(0, "0");
            }
            decBinaryValue = decBinaryValueBuilder.toString();
            decBinariesForValue.push(decBinArrChar[max] + decBinaryValue);
        }

        String nextDecBinaryString;
        if (decBinArr[max - 1] + 2 > 9) {
            char[] decBinArrChar2 = maxMinusOneString.toCharArray();
            int[] decBinArr2 = new int[decBinArrChar.length];
            for (int i = 0; i < decBinArrChar2.length; i++) {
                decBinArr2[i] = decBinArrChar2[i] - '0';
            }

            StringBuilder builder = new StringBuilder();
            decBinArr2[max - 1] += 2;
            decBinArr2[max] -= 1;
            for (int i = 0; i < decBinArr2.length - 1; i++) {
                builder.append(decBinArr2[i]);
            }
            nextDecBinaryString = builder.toString();
            nextDecBinaryString = decBinArr[max] == 0 ? nextDecBinaryString : decBinArr[max] + nextDecBinaryString;

            // System.out.println("When > 9 - DecBinString: " + nextDecBinaryString);
        } else {
            StringBuilder builder = new StringBuilder();
            decBinArr[max - 1] += 2;
            decBinArr[max] -= 1;
            for (int i = 0; i < decBinArr.length - 1; i++) {
                builder.append(decBinArr[i]);
            }
            nextDecBinaryString = builder.reverse().toString();
            nextDecBinaryString = decBinArr[max] == 0 ? nextDecBinaryString : decBinArr[max] + nextDecBinaryString;

            // System.out.println("When !> 9 - DecBinString: " + nextDecBinaryString);
        }
        return getDecBinariesCombForADecNumber(value, nextDecBinaryString, decBinariesForValue);
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
