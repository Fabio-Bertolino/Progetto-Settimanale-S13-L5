package it.epicode.prestiti;

import it.epicode.catalogo.libri.autori.Autore;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Prestito e) {
        em.persist(e);
    }

    public void update(Prestito e) {
        em.merge(e);
    }

    public void delete(UUID id) {
        Prestito e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }

    public Prestito findById(UUID id) {
        return em.find(Prestito.class, id);
    }
}
