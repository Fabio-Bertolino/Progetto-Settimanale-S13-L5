package it.epicode.utenti;

import it.epicode.catalogo.libri.autori.Autore;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Utente e) {
        em.persist(e);
    }

    public void update(Utente e) {
        em.merge(e);
    }

    public void delete(UUID id) {
        Utente e = findById(id);
        if (e != null) {
            em.remove(e);
        }
    }

    public Utente findById(UUID id) {
        return em.find(Utente.class, id);
    }
}
