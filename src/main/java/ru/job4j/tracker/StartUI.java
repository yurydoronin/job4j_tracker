package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;

import java.util.List;
import java.util.function.Consumer;

/**
 * Class StartUI, to start the app.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 16.03.2019
 */
public class StartUI {

    private final Consumer<String> output;

    /**
     * Flag for init method to continue or stop the app.
     */
    private boolean working = true;

    /**
     * Getting the data from a user.
     */
    private final Input input;

    /**
     * A repository of items.
     */
    private final ITracker tracker;

    /**
     * The app's menu.
     */
    private MenuTracker menu;

    /**
     * A constructor.
     *
     * @param input,   Input object.
     * @param tracker, Tracker object.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        this.menu = new MenuTracker(this.input, this.tracker, this.output);

    }

    /**
     * The main loop of the application.
     */
    public void init() {
        menu.fillActions(this);
        List<Integer> keys = menu.range();
        do {
            menu.showMenu();
            int ask = this.input.ask("Please, select the menu item: ", keys);
            if (ask != -1) {
                menu.select(ask);
            }
        } while (this.working);
    }

    /**
     * Method stop, to stop the app when user choose the key to exit the program.
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Start the application.
     *
     * @param args, args.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
