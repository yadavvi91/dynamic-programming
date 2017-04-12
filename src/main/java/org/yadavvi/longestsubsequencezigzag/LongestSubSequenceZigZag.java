package org.yadavvi.longestsubsequencezigzag;

/**
 * This questions is from https://community.topcoder.com/tc?module=ProblemDetail&rd=4493&pm=1259
 */
public class LongestSubSequenceZigZag {

    public int longestZigZag(int[] sequence) {
        int[] solution = new int[sequence.length];
        solution[0] = 1;
        if (sequence.length == 1) return solution[sequence.length - 1];

        if (sequence[0] == sequence[1]) {
            solution[1] = 1;
        } else {
            solution[1] = 2;
        }
        if (sequence.length == 2) return solution[sequence.length - 1];

        for (int i = 2; i < sequence.length; i++) {
            solution[i] = 1;
            for (int j = 0; j < i - 1; j++) {
                if ((sequence[j] < sequence[j + 1] && sequence[j + 1] > sequence[i])
                        || (sequence[j] > sequence[j + 1] && sequence[j + 1] < sequence[i])) {
                    solution[i] = solution[j + 1] + 1;
                } else {
                    solution[i] = solution[j + 1];
                }
            }
        }
        return solution[sequence.length - 1];
    }

    public int longestZigZagDP(int[] sequence) {
        int[] solution = new int[sequence.length];
        solution[0] = 1;
        if (sequence.length == 1) return solution[sequence.length - 1];

        boolean increased = false;
        if (sequence[0] == sequence[1]) {
            solution[1] = 1;
        } else if (sequence[0] > sequence[1]) {
            solution[1] = 2;
            increased = false;
        } else {
            solution[1] = 2;
            increased = true;
        }

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i - 2] > sequence[i - 1] && sequence[i - 1] > sequence[i]) {
                solution[i] = solution[i - 1];
            } else if (sequence[i - 2] > sequence[i - 1] && sequence[i - 1] < sequence[i]) {
                solution[i] = solution[i - 1] + 1;
                increased = true;
            } else if (sequence[i - 2] > sequence[i - 1] && sequence[i - 1] == sequence[i]) {
                solution[i] = solution[i - 1];
            } else if (sequence[i - 2] < sequence[i - 1] && sequence[i - 1] > sequence[i]) {
                solution[i] = solution[i - 1] + 1;
                increased = false;
            } else if (sequence[i - 2] < sequence[i - 1] && sequence[i - 1] < sequence[i]) {
                solution[i] = solution[i - 1];
            } else if (sequence[i - 2] < sequence[i - 1] && sequence[i - 1] == sequence[i]) {
                solution[i] = solution[i - 1];
            } else if (sequence[i - 2] == sequence[i - 1] && sequence[i - 1] > sequence[i]) {
                if (increased) {
                    solution[i] = solution[i - 1] + 1;
                    increased = false;
                } else {
                    solution[i] = solution[i - 1];
                }
            } else if (sequence[i - 2] == sequence[i - 1] && sequence[i - 1] < sequence[i]) {
                if (!increased) {
                    solution[i] = solution[i - 1] + 1;
                    increased = true;
                } else {
                    solution[i] = solution[i - 1];
                }
            } else if (sequence[i - 2] == sequence[i - 1] && sequence[i - 1] == sequence[i]) {
                solution[i] = solution[i - 1];
            }
        }

        return solution[sequence.length - 1];
    }
}
