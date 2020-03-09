package ru.job4j.coffee;

import java.util.Arrays;

/**
 * Class CoffeeMachine.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 05.04.2019
 */
public class CoffeeMachine {

    /**
     * The face value of coins.
     */
    private int[] coins = {10, 5, 2, 1};

    /**
     * Giving change after you've bought a coffee.
     *
     * @param note,  a note.
     * @param price, the price of coffee.
     * @return int[], a change of coins.
     */
    public int[] changes(int note, int price) {
        int change = note > price ? note - price : 0;
        int size = 0;
        int[] result = new int[change];
        for (int index = 0; index < this.coins.length; index++) {
            while (change >= this.coins[index]) {
                change -= this.coins[index];
                result[size++] = this.coins[index];
            }
        }
        return Arrays.copyOf(result, size);
    }
}