package ru.job4j.tracker;

import java.util.List;

/**
 * Interface ITracker.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 07.03.2019
 */
public interface ITracker {

    /**
     * Implements addition of an item to the storage.
     *
     * @param item, a new item.
     */
    Item add(Item item);

    /**
     * Replaces the item with the new item.
     *
     * @param id,   an item's id.
     * @param item, the new item.
     * @return true if the replace has been implemented, otherwise false.
     */
    boolean replace(String id, Item item);

    /**
     * Removes the item.
     *
     * @param id, an item's id.
     * @return true if the item has been removed, otherwise false.
     */
    boolean delete(String id);

    /**
     * Gets all the items.
     *
     * @return the array with items.
     */
    List<Item> getAll();

    /**
     * Finds an item by name.
     *
     * @param name, an item's name.
     * @return the array with the found item.
     */
    List<Item> findByName(String name);

    /**
     * Finds an item by id.
     *
     * @param id, an item's id.
     * @return the found item.
     */
    Item findById(String id);
}
