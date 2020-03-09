package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Class Item, an item.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 14.03.2019
 */
public class Item {

    /**
     * An item's id.
     */
    private String id;

    /**
     * An item's name.
     */
    private String name;

    /**
     * An item's description.
     */
    private String desc;

    private Integer userID;
    private Integer categoryID;
    private String comment;

    /**
     * Time when the item was created.
     */
    private LocalDateTime time;

    /**
     * A constructor.
     *
     * @param name, an item's name.
     * @param desc, an item's description.
     * @param time, the current time.
     */
    public Item(String name, String desc, LocalDateTime time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

    /**
     * An alternative constructor with a different set of parameters, it's special for TrackerSQL.
     * @param desc, .
     * @param userID, .
     * @param categoryID, .
     * @param comment, .
     */
    public Item(String desc, Integer userID, Integer categoryID, String comment) {
        this.desc = desc;
        this.userID = userID;
        this.categoryID = categoryID;
        this.comment = comment;
    }

    /**
     * Method getId.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Method setId, to set an ID to an item.
     *
     * @param id, id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method getName.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName, to set a name to an item.
     *
     * @param name, .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method desc.
     *
     * @return description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Method setDesc, to set a description to an item.
     *
     * @param desc, description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Method getTime.
     *
     * @return the item's time.
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Method setTime, to set a new (current) time to an item.
     *
     * @param time, LocalDateTime.now().
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getUserID() {
        return userID;
    }

    /**
     *
     * @param userID, .
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     *
     * @return .
     */
    public Integer getCategoryID() {
        return categoryID;
    }

    /**
     *
     * @param categoryID, .
     */
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     *
     * @return .
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment, .
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * An overridden equals method.
     *
     * @param o, Item object.
     * @return true if Items are equal, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(id, item.id);
    }

    /**
     * An overridden hashCode method.
     *
     * @return hashcode with unique fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

    /**
     * An overridden toString method.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return (String.format(
                "%s, %s, %s, ID: %s%n",
                this.name,
                this.desc,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")),
                this.id));
    }
}