package it.epicode.catalogo.riviste;

import it.epicode.catalogo.Fascicolo;
import it.epicode.catalogo.libri.autori.Autore;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class FascicoloDAO {
    private EntityManager em;

    public FascicoloDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Fascicolo e) {
        em.persist(e);
    }

    public void update(Fascicolo e) {
        em.merge(e);
    }

    public void delete(UUID id) {
        Fascicolo e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }

    public Fascicolo findById(UUID id) {
        return em.find(Fascicolo.class, id);
    }
}
