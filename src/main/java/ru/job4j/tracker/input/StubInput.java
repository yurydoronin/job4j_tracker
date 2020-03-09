package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

import java.util.List;

/**
 * Class StubInput, the imitation of user actions.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class StubInput implements Input {

    /**
     * A storage of answers.
     */
    private List<String> answers;

    /**
     * A pointer of the next answer.
     */
    private int position;

    /**
     * A constructor.
     *
     * @param answers, a storage of answers.
     */
    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    /**
     * Asks a user of the following action.
     *
     * @param question, the question.
     * @return an answer.
     */
    @Override
    public String ask(String question) {
        return this.answers.get(position++);
    }

    /**
     *
     *
     * @param question, the question.
     * @param range,    a collection of the existing keys of the menu.
     * @return the menu key.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean found = false;
        int key = Integer.parseInt(this.answers.get(position++));
        for (int number : range) {
            if (key == number) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new MenuOutException("the key is not found");
        }
        return key;
    }
}