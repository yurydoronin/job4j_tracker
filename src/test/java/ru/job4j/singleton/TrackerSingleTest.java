package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void whenThen() {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        TrackerSingle tracker2 = TrackerSingle.INSTANCE;
        assertThat(tracker, is(tracker2));
    }
}