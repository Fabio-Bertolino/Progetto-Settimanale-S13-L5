package it.epicode.catalogo.libri.autori;

import jakarta.persistence.EntityManager;

import java.util.UUID;

public class AutoreDAO {
    private EntityManager em;

    public AutoreDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Autore e) {
        em.persist(e);
    }

    public void update(Autore e) {
        em.merge(e);
    }

    public void delete(UUID id) {
        Autore e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }

    public Autore findById(UUID id) {
        return em.find(Autore.class, id);
    }
}
