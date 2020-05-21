package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ITracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

/**
 * Class UpdateItem, implements editing the item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public class UpdateItem extends BaseAction {

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
    public UpdateItem(int key, String name, Consumer<String> output) {
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
        output.accept("------------ Editing the item --------------");
        Item itemOld = tracker.findById(input.ask("Please, provide the item's ID: "));
        String name = input.ask("Please, provide the new name: ");
        String desc = input.ask("Please, provide the new description: ");
//        Item item = new Item(name, desc, LocalDateTime.now());
//        tracker.replace(itemOld.getId(), item);
//        output.accept("------------ The edited item -----------");
//        output.accept(String.format("%s, %s, %s, ID: %s",
//                item.getName(),
//                item.getDesc(),
//                item.getTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")),
//                item.getId()));
    }
}
