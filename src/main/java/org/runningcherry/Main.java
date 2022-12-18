package org.runningcherry;

import org.hibernate.Session;
import org.runningcherry.entity.User;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        addRandomUserToDB(session);

        session.close();
        HibernateUtil.close();
    }

    public static void addRandomUserToDB(Session session) {
        session.getTransaction().begin();

        User user = new User();
        user.setUsername("simple_username");

        session.persist(user);

        session.getTransaction().commit();
    }
}