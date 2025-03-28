package it.epicode;

import it.epicode.catalogo.libri.Genere;
import it.epicode.catalogo.libri.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Libro libro = new Libro(null, "Il Signore degli Anelli", 1954, 1234, null, Genere.FANTASY);
        em.persist(libro);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
