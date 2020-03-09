package ru.job4j.tracker.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 24.03.2019
 */
public class ValidateInputTest {

    /**
     * The buffer for the result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * The default output to the console.
     */
    private final PrintStream stdout = System.out;

    /**
     * Executes the method before running the test.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Executes the method after running the test.
     */
    @After
    public void loadSys() {
        System.setOut(this.stdout);
    }

    /**
     * Test MenuOutException.
     */
    @Test
    public void whenInvalidThenEnterOne() {
        List<String> list = List.of("-1", "1");
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        ValidateInput input = new ValidateInput(new StubInput(list));
        input.ask("Please, select the menu item: ", listInt);
        assertThat(this.out.toString(), is(String.format("Please select the key from the menu%n")));
    }

    /**
     * Test NumberFormatException.
     */
    @Test
    public void whenInvalidThenCorrectInput() {
        List<String> list = List.of("q", "1");
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        ValidateInput input = new ValidateInput(new StubInput(list));
        input.ask("Please, select the menu item: ", listInt);
        assertThat(this.out.toString(), is(String.format("Please enter the correct key%n")));
    }
}