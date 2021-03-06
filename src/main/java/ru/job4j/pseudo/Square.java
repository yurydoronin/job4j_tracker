package ru.job4j.pseudo;

/**
 * Class Square, .
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class Square implements Shape {

    /**
     * @return .
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("+++++++");
        pic.append(ln);
        pic.append("+     +");
        pic.append(ln);
        pic.append("+     +");
        pic.append(ln);
        pic.append("+++++++");
        return pic.toString();
    }
}
