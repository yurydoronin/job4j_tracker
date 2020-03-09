package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingle {

    INSTANCE;

    public Item add(Item item) {
        return item;
    }

//    public static void main(String[] args) {
//        TrackerSingle tracker1 = TrackerSingle.INSTANCE;
//        TrackerSingle tracker2 = TrackerSingle.INSTANCE;
//        System.out.println(String.format("%s, %s", tracker1.hashCode(), tracker2.hashCode()));
//    }
}
