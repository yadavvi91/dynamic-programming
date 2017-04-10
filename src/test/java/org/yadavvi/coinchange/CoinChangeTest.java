package org.yadavvi.coinchange;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by vishal on 10/4/17.
 */
@RunWith(JUnitParamsRunner.class)
public class CoinChangeTest {

    CoinChange coinChange;

    private Object[] coinChangeValues() {
        return new Object[]{
                new Object[]{new int[]{5, 10, 25}, 30, 2},
                new Object[]{new int[]{9, 6, 5, 1}, 11, 2},
                new Object[]{new int[]{1, 2, 3}, 5, 2},
                new Object[]{new int[]{1, 3, 5}, 11, 3},
                new Object[]{new int[]{1, 5, 10, 20, 25}, 40, 2},
                new Object[]{new int[]{5, 10, 20, 25, 50}, 90, 3}
        };
    }

    @Before
    public void setUp() throws Exception {
        coinChange = new CoinChange();
    }

    @Test
    @Parameters(method = "coinChangeValues")
    public void computeMinimumNumberOfCoins(int[] coins, int sum, int count) throws Exception {
        assertThat(coinChange.computeMinimumNumberOfCoins(coins, sum), is(count));
    }

}