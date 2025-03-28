package it.epicode;

import it.epicode.catalogo.libri.Genere;
import it.epicode.catalogo.libri.Libro;
import it.epicode.catalogo.libri.autori.Autore;
import it.epicode.catalogo.libri.autori.AutoreDAO;
import it.epicode.catalogo.riviste.FascicoloDAO;
import it.epicode.catalogo.riviste.Periodicita;
import it.epicode.catalogo.riviste.Rivista;
import it.epicode.prestiti.Prestito;
import it.epicode.prestiti.PrestitoDAO;
import it.epicode.utenti.Utente;
import it.epicode.utenti.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        AutoreDAO autoreDAO = new AutoreDAO(em);
        FascicoloDAO fascicoloDAO = new FascicoloDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        em.getTransaction().begin();

        Autore autore1 = new Autore(null, "JRR Tolkien", "Tolkien");
        Autore autore2 = new Autore(null, "Mauro", "Larese");
        Autore autore3 = new Autore(null, "Emanuele", "Umberto");
        Autore autore4 = new Autore(null, "Stefano", "Miceli");

        Libro libro1 = new Libro(null, "Il Signore degli Anelli", 1954, 1234, autore1, Genere.FANTASY);
        Libro libro2 = new Libro(null, "Il Signore degli Anelli 2", 1955, 1235, autore1, Genere.FANTASY);
        Libro libro3 = new Libro(null, "Java: Da Barista a Programmatore", 2025, 250, autore2, Genere.SAGGIO);
        Libro libro4 = new Libro(null, "Via col Javascript", 2025, 1120, autore3, Genere.ROSA);
        Libro libro5 = new Libro(null, "Il Codice Da Vite", 2025, 510, autore4, Genere.THRILLER);
        Rivista rivista1 = new Rivista(null, "Sloth Life", 2024, 2, Periodicita.ANNUALE);
        Rivista rivista2 = new Rivista(null, "Code Wars", 2025, 30, Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista(null, "Lo Smanettone", 1999, 30, Periodicita.MENSILE);

        Utente utente1 = new Utente(null, "Fabio", "Bertolino", LocalDate.of(1997, 12, 5));

        Prestito prestito1 = new Prestito(null, utente1, libro3, LocalDate.of(2023, 7, 5), null);

        autoreDAO.insert(autore1);
        autoreDAO.insert(autore2);
        autoreDAO.insert(autore3);
        autoreDAO.insert(autore4);

        fascicoloDAO.insert(libro1);
        fascicoloDAO.insert(libro2);
        fascicoloDAO.insert(libro3);
        fascicoloDAO.insert(libro4);
        fascicoloDAO.insert(libro5);
        fascicoloDAO.insert(rivista1);
        fascicoloDAO.insert(rivista2);
        fascicoloDAO.insert(rivista3);
        fascicoloDAO.delete(libro2.getId());

        utenteDAO.insert(utente1);

        prestitoDAO.insert(prestito1);

        em.getTransaction().commit();

        //TESTING
        System.out.println("Ricerca per anno pubblicazione: ");
        fascicoloDAO.findFascicoliPerAnnoPubblicazione(2025).forEach(System.out::println);

        em.close();
        emf.close();
    }
}
