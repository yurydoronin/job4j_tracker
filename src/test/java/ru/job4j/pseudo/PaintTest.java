package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class PaintTest {

    /**
     * The default output to the console.
     */
    PrintStream stdout = System.out;
    /**
     * The buffer for the result.
     */
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Executes the method before running the test.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Executes the method after running the test.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test square.
     */
    @Test
    public void whenDrawSquare() {
        new Paint(new Square()).draw();
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is(
                        new StringBuilder()
                                .append("+++++++")
                                .append(ln)
                                .append("+     +")
                                .append(ln)
                                .append("+     +")
                                .append(ln)
                                .append("+++++++")
                                .append(ln)
                                .toString())
        );
    }

    /**
     * Test triangle.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint(new Triangle()).draw();
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is(
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
                                .append(ln)
                                .toString())
        );
    }
}