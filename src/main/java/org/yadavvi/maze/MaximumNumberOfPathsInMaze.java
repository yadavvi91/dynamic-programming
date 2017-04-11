package org.yadavvi.maze;

/**
 * Created by vishal on 11/4/17.
 */
public class MaximumNumberOfPathsInMaze {

    public int getMaximumNumberOfPaths(int[][] maze) {
        int[][] maxPaths = new int[maze.length][maze.length];
        int pathFromLeft, pathFromTop, pathFromDiagonalElem;
        int x, y;

        // Initial Value for maxPath[0][0]
        maxPaths[0][0] = 1;
        for (int i = 1; i < maxPaths.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    x = i;
                    y = j;
                    if (maze[x][y] == 0) {
                        maxPaths[x][y] = 0;
                    } else {
                        pathFromLeft = getMaxPaths(maze, maxPaths, x, y - 1);
                        pathFromTop = getMaxPaths(maze, maxPaths, x - 1, y);
                        pathFromDiagonalElem = getMaxPaths(maze, maxPaths, x - 1, y - 1);
                        maxPaths[x][y] = sumOf(pathFromLeft, pathFromTop, pathFromDiagonalElem, 0);
                    }
                } else {
                    x = i;
                    y = j;
                    if (maze[x][y] == 0) {
                        maxPaths[x][y] = 0;
                    } else {
                        pathFromLeft = getMaxPaths(maze, maxPaths, x, y - 1);
                        pathFromTop = getMaxPaths(maze, maxPaths, x - 1, y);
                        pathFromDiagonalElem = getMaxPaths(maze, maxPaths, x - 1, y - 1);
                        maxPaths[x][y] = sumOf(pathFromLeft, pathFromTop, pathFromDiagonalElem, 0);
                    }

                    x = j;
                    y = i;
                    if (maze[x][y] == 0) {
                        maxPaths[x][y] = 0;
                    } else {
                        pathFromLeft = getMaxPaths(maze, maxPaths, x, y - 1);
                        pathFromTop = getMaxPaths(maze, maxPaths, x - 1, y);
                        pathFromDiagonalElem = getMaxPaths(maze, maxPaths, x - 1, y - 1);
                        maxPaths[x][y] = sumOf(pathFromLeft, pathFromTop, pathFromDiagonalElem, 0);
                    }
                }
            }
        }
        // printMazeAndResult(maze, maxPaths, maxPaths[maxPaths.length - 1][maxPaths.length - 1]);
        printMazeAndResultSeparately(maze, maxPaths, maxPaths[maxPaths.length - 1][maxPaths.length - 1]);
        return maxPaths[maxPaths.length - 1][maxPaths.length - 1];
    }

    private int sumOf(int pathFromLeft, int pathFromTop, int pathFromDiagonalElem, int defaultValue) {
        int sum = 0;
        if (pathFromLeft > 0) sum += pathFromLeft;
        if (pathFromTop > 0) sum += pathFromTop;
        if (pathFromDiagonalElem > 0) sum += pathFromDiagonalElem;
        if (sum == 0) sum += defaultValue;
        return sum;
    }

    private void printMazeAndResult(int[][] maze, int[][] maxPaths, int result) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maze.length; i++) {
            builder.append("[");
            for (int j = 0; j < maze.length; j++) {
                builder.append("<").append(maze[i][j]).append(",").append(maxPaths[i][j]).append(">").append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
            builder.append("]\n");
        }
        builder.append("Max: ").append(result).append("\n");
        System.out.println(builder.toString());
    }

    private void printMazeAndResultSeparately(int[][] maze, int[][] maxPaths, int result) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maze.length; i++) {
            builder.append("[");
            for (int j = 0; j < maze.length; j++) {
                builder.append(maze[i][j]).append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
            builder.append("]    [");
            for (int j = 0; j < maze.length; j++) {
                builder.append(maxPaths[i][j]).append(", ");
            }
            builder.delete(builder.length() - 2, builder.length());
            builder.append("]\n");
        }
        builder.append("Max: ").append(result).append("\n");
        System.out.println(builder.toString());
    }

    private int getMaxPaths(int[][] maze, int[][] maxPaths, int x, int y) {
        if (x < 0 || y < 0 || x > maxPaths.length - 1 || y > maxPaths.length - 1 || maze[x][y] == 0) {
            return -1;
        }
        return maxPaths[x][y];
    }

}
