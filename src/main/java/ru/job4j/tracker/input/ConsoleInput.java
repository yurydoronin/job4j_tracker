package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Class ConsoleInput, requires user actions.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.03.2019
 */
public class ConsoleInput implements Input {

    /**
     * Asks a user of the following action.
     *
     * @param question, the question.
     * @return a user's answer.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        String answer = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            answer = reader.readLine();
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
        return answer;
    }

    /**
     * Compares the user's key with the collection of the existing menu keys.
     *
     * @param question, the question.
     * @param range,    a collection of the existing keys of the menu.
     * @return the menu key.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean found = false;
        int key = Integer.parseInt(this.ask(question));
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