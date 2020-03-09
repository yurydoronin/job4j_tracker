package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class SquareTest {

    /**
     * Test.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ln = System.lineSeparator();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append("+++++++")
                        .append(ln)
                        .append("+     +")
                        .append(ln)
                        .append("+     +")
                        .append(ln)
                        .append("+++++++")
                        .toString()));
    }
}