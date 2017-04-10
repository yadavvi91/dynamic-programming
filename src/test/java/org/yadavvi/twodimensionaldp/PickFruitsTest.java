package org.yadavvi.twodimensionaldp;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vishal on 10/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class PickFruitsTest {

    private PickFruits pickFruits;

    public Object[] fruitMatrixAndMaxFruits() {
        return new Object[][]{{
                new int[][]{
                        {1, 0, 3, 1, 0},
                        {2, 5, 4, 0, 3},
                        {3, 0, 4, 2, 3},
                        {0, 8, 1, 2, 4}},
                25}};
    }

    @Before
    public void setUp() throws Exception {
        pickFruits = new PickFruits();
    }

    @Test
    @Parameters(method = "fruitMatrixAndMaxFruits")
    public void maxFruits(int[][] matrix, int max) throws Exception {
        assertThat(pickFruits.maxFruits(matrix), is(max));
    }

}