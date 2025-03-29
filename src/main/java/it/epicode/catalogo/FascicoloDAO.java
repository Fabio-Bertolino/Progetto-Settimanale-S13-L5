package it.epicode.catalogo;

import it.epicode.catalogo.libri.Libro;
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

    public List<Fascicolo> cercaFascicoliPerAnnoPubblicazione(int anno) {
        return em.createNamedQuery("fascicolo.find.ricerca_per_anno_pubblicazione", Fascicolo.class)
                .setParameter("annoPubblicazione", anno)
                .getResultList();
    }

    public List<Libro> cercaLibriPerAutore(Autore autore) {
        return em.createNamedQuery("libro.find.ricerca_per_autore", Libro.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    public List<Fascicolo> cercaFascicoliPerTitoloParziale(String titolo) {
        List<Fascicolo> results =em.createNamedQuery("fascicolo.find.ricerca_per_titolo_o_parte_di_esso", Fascicolo.class)
                                   .setParameter("titolo", "%" + titolo + "%")
                                   .getResultList();
        if (results.isEmpty()) {
            System.out.println("Nessun fascicolo trovato per il titolo: " + titolo);
        }
        return results;
    }
}
