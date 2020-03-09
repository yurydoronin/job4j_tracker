package ru.job4j.pseudo;

/**
 * Class Paint, .
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class Paint {

    /**
     *
     */
    private Shape shape;

    /**
     * @param shape, .
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     *
     */
    public void draw() {
        System.out.println(this.shape.draw());
    }

    /**
     * @param args, .
     */
    public static void main(String[] args) {
        new Paint(new Triangle()).draw();
        new Paint(new Square()).draw();
    }
}
