package org.yadavvi.coinchange;

import org.yadavvi.coinchange.model.Coin;
import org.yadavvi.coinchange.model.Sum;

import java.util.List;

/**
 * Created by vishal on 10/4/17.
 */
public class CoinChange {

    public int computeMinimumNumberOfCoins(int[] coins, int finalSum) {
        Sum[] sums = new Sum[finalSum + 1];
        for (int i = 0; i <= finalSum; i++) {
            sums[i] = new Sum(i, coins);
        }

        for (int i = 1; i <= finalSum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (sums[i - coins[j]].getMinCoins() + 1 < sums[i].getMinCoins()) {
                        changeMinCoins(sums[i - coins[j]], sums[i]);
                        changeCoinCount(sums[i - coins[j]], sums[i], coins[j]);
                    }
                }
            }
        }
        System.out.printf("Sum: %3d, MinCoins: %2d, coins: %s\n", finalSum, sums[finalSum].getMinCoins(), sums[finalSum].getCoins());
        return sums[finalSum].getMinCoins();
    }

    private void changeCoinCount(Sum from, Sum to, int coin) {
        List<Coin> fromCoins = from.getCoins();
        List<Coin> toCoins = to.getCoins();
        for (int i = 0; i < fromCoins.size(); i++) {
            Coin fromCoin = fromCoins.get(i);
            Coin toCoin = toCoins.get(i);
            if (toCoin.getValue() == coin) {
                toCoin.setCount(fromCoin.getCount() + 1);
            } else {
                toCoin.setCount(fromCoin.getCount());
            }
        }
    }

    private void changeMinCoins(Sum from, Sum to) {
        to.setMinCoins(from.getMinCoins() + 1);
    }
}
