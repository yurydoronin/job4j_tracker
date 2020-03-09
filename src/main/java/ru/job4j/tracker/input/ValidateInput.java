package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

import java.util.List;

/**
 * Class ValidateInput, to do the validation of the user's actions,
 * and process the exceptions.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 24.03.2019
 */
public class ValidateInput implements Input {

    /**
     * Getting the data from a user.
     */
    private final Input input;

    /**
     * A constructor.
     *
     * @param input, Input object.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Asks a user of the following action.
     *
     * @param question, the question.
     * @return a user's answer.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Does the validation of the user's actions,
     * and process the exceptions.
     *
     * @param question, the question.
     * @param range,    a collection of the existing keys of the menu.
     * @return the menu key.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select the key from the menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter the correct key");
            }
        } while (invalid);
        return value;
    }
}


