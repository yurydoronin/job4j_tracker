package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle2 {

    private static TrackerSingle2 instance;

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }
}
