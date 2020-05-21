package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ITracker;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class FindByName, implements search the item by name.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class FindByName extends BaseAction {

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
    public FindByName(int key, String name, Consumer<String> output) {
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
        List<Item> items = tracker.findByName(input.ask("Please, provide the item's name: "));
        boolean found = false;
//        for (Item item : items) {
//            if (item != null) {
//                output.accept(
//                        String.format("%s, %s, %s, ID: %s",
//                                item.getName(),
//                                item.getDesc(),
//                                item.getTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")),
//                                item.getId()));
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            output.accept("------------ The Item has NOT been found ------------");
//        }
    }
}
