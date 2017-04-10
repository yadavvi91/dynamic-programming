package org.yadavvi.coinchange.model;

/**
 * Created by vishal on 10/4/17.
 */
public class Coin {
    private int value;
    private int count;

    Coin(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Value: " + value + ", count: " + count;
    }
}
