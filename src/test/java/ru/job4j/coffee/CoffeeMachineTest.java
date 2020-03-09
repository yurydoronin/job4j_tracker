package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void whenNote50AndPrice35ThenChange15() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] result = coffee.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenNote100AndPrice35ThenChange65() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] result = coffee.changes(100, 35);
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        assertThat(result, is(expected));
    }
}