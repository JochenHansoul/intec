package be.jochenhansoul;

import be.jochenhansoul.data.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJochen");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        Person person = new Person();
        person.setPersonId(1);
        person.setFirstName("first1");
        person.setLastname("last1");
        person.setBirthDate(LocalDate.of(2001, 1, 1));

        et.begin();
        em.persist(person);
        et.commit();
    }
}
