package ru.job4j.tracker.actions;

import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.input.Input;

/**
 * Class ExitProgram, to exit the program.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class ExitProgram extends BaseAction {

    /**
     * A link to the StartUI object.
     */
    private final StartUI ui;

    /**
     * A constructor.
     *
     * @param key,  the key.
     * @param name, the key's information.
     */
    public ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    /**
     * Method execute, implements the action of the menu key.
     *
     * @param input,   Input object.
     * @param tracker, Tracker object.
     */
    @Override
    public void execute(Input input, ITracker tracker) {
        this.ui.stop();
    }
}

