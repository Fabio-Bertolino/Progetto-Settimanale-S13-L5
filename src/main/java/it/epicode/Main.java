package it.epicode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
    EntityManager em = emf.createEntityManager();

}
