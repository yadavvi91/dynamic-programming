package org.yadavvi.coinchange.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 10/4/17.
 */
public class Sum {
    private List<Coin> coins;
    private int value;
    private int minCoins;

    public Sum(int value, int[] coins) {
        this.value = value;
        this.coins = new ArrayList<>(coins.length);
        for (int i = 0; i < coins.length; i++) {
            this.coins.add(i, new Coin(coins[i], 0));
        }
        if (value == 0) {
            minCoins = 0;
        } else {
            minCoins = Integer.MAX_VALUE;
        }
    }

    public int getValue() {
        return value;
    }

    public int getMinCoins() {
        return minCoins;
    }

    public void setMinCoins(int minCoins) {
        this.minCoins = minCoins;
    }

    public List<Coin> getCoins() {
        return coins;
    }

}
