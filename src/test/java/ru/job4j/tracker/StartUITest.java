package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 20.02.2019
 */
public class StartUITest {

    /**
     * A constant.
     */
    private static final String MENU = StartUITest.menu();

    /**
     * A storage of items.
     */
    private Tracker tracker = new Tracker();

    /**
     * The default output to the console.
     */
    private final PrintStream stdout = System.out;

    /**
     * The buffer for the result.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     *
     */
    private final Consumer<String> output = new Consumer<>() {

        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

//    /**
//     * Executes the method before running the test.
//     */
//    @Before
//    public void loadOutput() {
//        output.accept("execute before method");
//        System.setOut(new PrintStream(this.out));
//    }

    /**
     * Executes the method after running the test.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        output.accept("execute after method");
    }

    /**
     * Method menu, creates the menu.
     *
     * @return the menu.
     */
    public static String menu() {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        builder.append("1. Add item");
        builder.append(ln);
        builder.append("2. Show all items");
        builder.append(ln);
        builder.append("3. Edit item");
        builder.append(ln);
        builder.append("4. Delete item");
        builder.append(ln);
        builder.append("5. Find item by ID");
        builder.append(ln);
        builder.append("6. Find items by name");
        builder.append(ln);
        builder.append("7. Exit Program");
        builder.append(ln);
        return builder.toString();
    }

    /**
     * Test 1, show all items.
     */
    @Test
    public void whenUserChoseOneThenShowItems() {
        StringBuilder builder = new StringBuilder();
        Item item1 = this.tracker.add(new Item("test name1", "desc1", LocalDateTime.now()));
        List<String> list = List.of("2", "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        builder.append(MENU);
        builder.append(item1.toString());
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }

    /**
     * Test 2, edit item.
     */
    @Test
    public void whenEditItemThenUpdatedItem() {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        Item updated = this.tracker.add(new Item("test replace", "updated", LocalDateTime.now()));
        List<String> list = List.of("3", item.getId(), "test replace", "updated", "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        updated.setId(item.getId());
        builder.append(MENU);
        builder.append("------------ Editing the item --------------");
        builder.append(ln);
        builder.append("------------ The edited item -----------");
        builder.append(ln);
        builder.append(updated.toString());
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }

    /**
     * Test 3, search item by ID.
     */
    @Test
    public void whenSearchByIdThenShowItem() {
        StringBuilder builder = new StringBuilder();
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        List<String> list = List.of("5", item.getId(), "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        builder.append(MENU);
        builder.append(item.toString());
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }

    /**
     * Test 3, search item by name.
     */
    @Test
    @Ignore
    public void whenSearchByNameThenShowItems() {
        StringBuilder builder = new StringBuilder();
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        List<String> list = List.of("6", item.getName(), "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        builder.append(MENU);
        builder.append(item.toString());
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }

    /**
     * Test creat.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        List<String> list = List.of("1", "test name", "desc", "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        assertThat(this.tracker.getAll().get(0).getName(), is("test name"));
    }

    /**
     * Test edit.
     */
    @Test
    public void whenUserEditItemThenTrackerHasUpdatedItem() {
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        List<String> list = List.of("3", item.getId(), "test replace", "updated", "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        assertThat(this.tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test remove.
     */
    @Test
    public void whenUserRemoveItemThenTrackerHasNotItem() {
        Item item1 = this.tracker.add(new Item("test1 name", "desc1", LocalDateTime.now()));
        Item item2 = this.tracker.add(new Item("test2 name", "desc2", LocalDateTime.now()));
        Item item3 = this.tracker.add(new Item("test3 name", "desc3", LocalDateTime.now()));
        List<String> list = List.of("4", item1.getId(), "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        List<Item> items = List.of(item2, item3);
        assertThat(this.tracker.getAll(), is(items));
    }

    /**
     * Test searchByID.
     */
    @Test
    public void whenUserSearchByIdThenTrackerFoundItem() {
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        List<String> list = List.of("5", item.getId(), "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        assertThat(this.tracker.findById(item.getId()), is(item));
    }

    /**
     * Test searchByName.
     */
    @Test
    public void whenUserSearchByNameThenTrackerFoundItems() {
        Item item = this.tracker.add(new Item("test name", "desc", LocalDateTime.now()));
        List<String> list = List.of("6", item.getName(), "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(this.tracker.findByName(item.getName()), is(items));
    }

    /**
     * Test showAll.
     */
    @Test
    public void whenUserShowAllThenTrackerWithAllItems() {
        Item item1 = this.tracker.add(new Item("test1 name", "desc1", LocalDateTime.now()));
        Item item2 = this.tracker.add(new Item("test2 name", "desc2", LocalDateTime.now()));
        Item item3 = this.tracker.add(new Item("test3 name", "desc3", LocalDateTime.now()));
        List<String> list = List.of("2", "7");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        List<Item> items = List.of(item1, item2, item3);
        assertThat(this.tracker.getAll(), is(items));
    }
}