package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker, the class for accounting items.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 14.03.2019
 */
public class Tracker implements ITracker {

    /**
     * An array for storing the items.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Method add, implements addition of an item to the storage.
     *
     * @param item, a new item.
     */
    public Item add(Item item) {
//        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Method generateId, generates the unique key for the item.
     *
     * @return the unique key.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextInt(100));
    }

    /**
     * Method replace, replaces the item with the new item.
     *
     * @param id,   an item's id.
     * @param item, the new item.
     * @return true if the replace has been implemented, otherwise false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
//                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method delete, removes the item.
     *
     * @param id, an item's id.
     * @return true if the item has been removed, otherwise false.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method getAll.
     *
     * @return the array with items.
     */
    public List<Item> getAll() {
        int count = 0;
        List<Item> result = new ArrayList<>(items.size());
        for (int index = 0; index != items.size(); index++) {
            result.add(count++, this.items.get(index));

        }
        return result;
    }

    /**
     * Method findByName.
     *
     * @param name, an item's name.
     * @return the collection with the found item(s).
     */
    public List<Item> findByName(String name) {
        int count = 0;
        List<Item> result = new ArrayList<>(items.size());
        for (int index = 0; index != items.size(); index++) {
            if (this.items.get(index).getName().equals(name)) {
                result.add(count++, this.items.get(index));
            }
        }
        return result;
    }

    /**
     * Method findById.
     *
     * @param id, an item's id.
     * @return the found item.
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                result = items.get(index);
                break;
            }
        }
        return result;
    }
}