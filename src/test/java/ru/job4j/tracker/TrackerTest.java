package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 14.02.2019
 */
public class TrackerTest {

    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", LocalDateTime.now());
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", LocalDateTime.now());
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", LocalDateTime.now());
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteItemThenTrue() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Description", LocalDateTime.now());
        Item item2 = new Item("test2", "test2Description", LocalDateTime.now());
        Item item3 = new Item("test3", "test3Description", LocalDateTime.now());
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.delete(item3.getId()), is(true));

    }

    /**
     * Test findAll.
     */
    @Test
    public void whenFindAllThenItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Description", LocalDateTime.now());
        Item item2 = new Item("test2", "test2Description", LocalDateTime.now());
        tracker.add(item1);
        tracker.add(item2);
        List<Item> list = List.of(item1, item2);
        assertThat(tracker.getAll(), is(list));
    }

    /**
     * findByName.
     */
    @Test
    public void whenFindByNameThenItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "test1Description", LocalDateTime.now());
        Item item2 = new Item("test2", "test2Description", LocalDateTime.now());
        Item item3 = new Item("test3", "test3Description", LocalDateTime.now());
        Item item4 = new Item("test3", "test4Description", LocalDateTime.now());
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> list = List.of(item3, item4);
        assertThat(tracker.findByName("test3"), is(list));
    }
}