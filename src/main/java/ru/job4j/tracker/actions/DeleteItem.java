package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.ITracker;

import java.util.function.Consumer;

/**
 * Class DeleteItem, implements the remove the item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class DeleteItem extends BaseAction {

    /**
     *
     */
    private final Consumer<String> output;

     /**
     * A constructor.
     *
     * @param key,  the key.
     * @param name, the key's information.
     */
    public DeleteItem(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    /**
     * Method execute, implements the action of the menu key.
     *
     * @param input,   Input object.
     * @param tracker, Tracker object.
     */
    @Override
    public void execute(Input input, ITracker tracker) {
        if (tracker.delete(input.ask("Please, provide the item's ID: "))) {
            output.accept("------------ The item has been removed ------------");
        } else {
            output.accept("------------ The item has NOT been removed ------------");
        }
    }
}
