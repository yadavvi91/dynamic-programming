package org.yadavvi.longestsubsequence;

/**
 * Created by vishal on 10/4/17.
 */
public class LongestSubSequence {

    public int longestNonDecreasingSubSequence(int[] sequence) {
        int[] solution = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            solution[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] <= sequence[i]) {
                    solution[i] = solution[j] + 1;
                    break;
                } else if (solution[j] > solution[i]) {
                    solution[i] = solution[j];
                }
            }
        }
        return solution[sequence.length - 1];
    }
}
