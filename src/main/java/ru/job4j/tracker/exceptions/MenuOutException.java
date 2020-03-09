package ru.job4j.tracker.exceptions;

/**
 * Class MenuOutException.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 24.03.2019
 */
public class MenuOutException extends RuntimeException {

    /**
     * A default constructor.
     */
    public MenuOutException() {

    }

    /**
     * A constructor.
     *
     * @param msg, a message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
