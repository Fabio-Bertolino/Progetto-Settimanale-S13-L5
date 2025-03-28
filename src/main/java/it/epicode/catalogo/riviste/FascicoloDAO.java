package it.epicode.catalogo.riviste;

import it.epicode.catalogo.Fascicolo;
import it.epicode.catalogo.libri.autori.Autore;
import jakarta.persistence.EntityManager;

import java.util.List;
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
            System.out.println( e + ": Fascicolo rimosso");
        }
    }

    public Fascicolo findById(UUID id) {
        return em.find(Fascicolo.class, id);
    }

    public List<Fascicolo> findFascicoliPerAnnoPubblicazione(int anno) {
        return em.createNamedQuery("fascicolo.find.ricerca_per_anno_pubblicazione", Fascicolo.class)
                .setParameter("annoPubblicazione", anno)
                .getResultList();
    }
}
