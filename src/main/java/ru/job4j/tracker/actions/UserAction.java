package ru.job4j.tracker.actions;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.input.Input;

/**
 * Interface UserAction.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public interface UserAction {

    /**
     * Method returns the option's key.
     *
     * @return the key.
     */
    int key();

    /**
     * The basic method.
     *
     * @param input,   Input object.
     * @param tracker, Tracker object.
     */
    void execute(Input input, ITracker tracker);

    /**
     * Method info, returns information of the current menu item.
     *
     * @return menu String.
     */
    String info();
}
