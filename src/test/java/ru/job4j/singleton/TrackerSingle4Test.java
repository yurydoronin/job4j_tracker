package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle4Test {

    @Test
    public void whenThen() {
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        TrackerSingle4 tracker2 = TrackerSingle4.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}