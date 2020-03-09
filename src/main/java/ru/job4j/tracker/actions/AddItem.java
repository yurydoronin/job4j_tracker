package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ITracker;

import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * Class AddItem, implements the creation and addition of the item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class AddItem extends BaseAction {

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
    public AddItem(int key, String name, Consumer<String> output) {
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
        output.accept("------------ Adding new item ------------");
        String name = input.ask("Please, provide the item's name: ");
        String desc = input.ask("Please, provide the item's description: ");
        Item item = new Item(name, desc, LocalDateTime.now());
        tracker.add(item);
        System.out.println("------------ New Item with ID : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDesc());
    }
}
