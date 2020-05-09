package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Class HibernateRun.
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 09.05.2020
 */
public class HibernateRun {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateRun.class);

    private static SessionFactory sf;

    protected static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void main(String[] args) {
        HibernateRun.setUp();
        Item item = create(new Item("Learn Hibernate"), sf);
        System.out.println(item);
        item.setName("Learn Hibernate 5.");
        update(item, sf);
        System.out.println(item);
        Item rsl = findById(item.getId(), sf);
        System.out.println(rsl);
        delete(rsl.getId(), sf);
        List<Item> list = findAll(sf);
        for (Item it : list) {
            System.out.println(it);
        }
        sf.close();
    }

    public static Item create(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
