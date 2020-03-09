package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle4 {

    private TrackerSingle4() {
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }
}
