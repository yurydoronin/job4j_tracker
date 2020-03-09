package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle3 {

    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }
}
