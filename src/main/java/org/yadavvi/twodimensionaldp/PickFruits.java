package org.yadavvi.twodimensionaldp;

/**
 * Two dimensional DP problem as described here -
 * https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
 */
public class PickFruits {

    public int maxFruits(int[][] fruitMatrix) {
        int N = fruitMatrix.length;
        int M = fruitMatrix[0].length;
        int[][] maxFruit = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (fruitMatrix[i][j] == 0) continue;
                int left = (i - 1) >= 0 ? maxFruit[i - 1][j] : 0;
                int top = (j - 1) >= 0 ? maxFruit[i][j - 1] : 0;
                maxFruit[i][j] = fruitMatrix[i][j] + max(left, top, 0);
            }
        }
        return maxFruit[N - 1][M - 1];
    }

    private int max(int left, int top, int defaultValue) {
        if ((left >= top) && (top >= defaultValue)) {
            return left;
        }
        if ((top >= left) && (left >= defaultValue)) {
            return top;
        }
        return defaultValue;
    }
}
