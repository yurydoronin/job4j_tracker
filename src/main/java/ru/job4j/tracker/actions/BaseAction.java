package ru.job4j.tracker.actions;

/**
 * Class BaseAction.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 21.03.2019
 */
public abstract class BaseAction implements UserAction {

    /**
     * A menu key.
     */
    private final int key;

    /**
     * The information about the current action of the menu key.
     */
    private final String name;

    /**
     * A constructor.
     * @param key, .
     * @param name, .
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Method returns the option's key.
     *
     * @return the key.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Method info.
     *
     * @return the information about the current action of the menu key.
     */
    @Override
    public String info() {
        return String.format("%s", this.name);
    }
}
