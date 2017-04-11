package org.yadavvi.maze;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by vishal on 11/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class MaximumNumberOfPathsInMazeTest {

    private MaximumNumberOfPathsInMaze pathsInMaze;

    public Object[] getMazeAndMaxPaths() {
        return new Object[]{
                new Object[]{new int[][]{{1, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 6},
                new Object[]{new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}}, 2},
                new Object[]{new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 1},
                new Object[]{new int[][]{{1, 0, 1, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}}, 2}
        };
    }

    @Before
    public void setUp() throws Exception {
        pathsInMaze = new MaximumNumberOfPathsInMaze();
    }

    @Test
    @Parameters(method = "getMazeAndMaxPaths")
    public void getMaximumNumberOfPaths(int[][] maze, int maxPaths) throws Exception {
        assertThat(pathsInMaze.getMaximumNumberOfPaths(maze), is(maxPaths));
    }

}