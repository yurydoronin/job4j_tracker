package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class MenuTracker, implements filling the collection with objects,
 * which execute their own behavior and manipulate actions with items.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class MenuTracker {

    /**
     * Getting the data from a user.
     */
    private Input input;

    /**
     * A repository of items.
     */
    private ITracker tracker;

    /**
     * A storage of actions' objects.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * A functional interface, console output.
     */
    private final Consumer<String> output;

    /**
     * A constructor.
     *
     * @param input,   Input object.
     * @param tracker, Tracker object.
     */
    public MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;

    }

    /**
     * Method range, fills the collection with the menu keys.
     *
     * @return a collection with keys.
     */
    public List<Integer> range() {
        List<Integer> numbers = new ArrayList<>(actions.size());
        for (int index = 0; index < actions.size(); index++) {
            numbers.add(index, actions.get(index).key());
        }
        return numbers;
    }

    /**
     * Method fillActions, filling the collection.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(1, "Add item", output));
        this.actions.add(new ShowItems(2, "Show all items", output));
        this.actions.add(new UpdateItem(3, "Edit item", output));
        this.actions.add(new DeleteItem(4, "Delete item", output));
        this.actions.add(new FindById(5, "Find item by ID", output));
        this.actions.add(new FindByName(6, "Find items by name", output));
        this.actions.add(new ExitProgram(7, "Exit Program", ui));
    }

    /**
     * Method select, executes specific actions depending on the key.
     *
     * @param key, a menu item.
     */
    public void select(int key) {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * Method showMenu.
     */
    public void showMenu() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.key() + ". " + action.info());
            }
        }
    }
}
