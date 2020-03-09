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
public class TriangleTest {

    /**
     * Test.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String ln = System.lineSeparator();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                        .append("+     ")
                        .append(ln)
                        .append("++    ")
                        .append(ln)
                        .append("+++   ")
                        .append(ln)
                        .append("+++++ ")
                        .append(ln)
                        .append("++++++")
                        .toString()));
    }
}