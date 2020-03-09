package ru.job4j.tracker.input;

import java.util.List;

/**
 * Interface Input, getting the data from a user.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public interface Input {

    /**
     * Method ask, to ask a user of the following action.
     *
     * @param question, the question.
     * @return an answer.
     */
    String ask(String question);

    /**
     * Method ask.
     *
     * @param question, the question.
     * @param range,    a collection of the existing keys of the menu.
     * @return the menu item.
     */
    int ask(String question, List<Integer> range);
}
