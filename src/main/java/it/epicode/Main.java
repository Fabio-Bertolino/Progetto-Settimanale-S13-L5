package it.epicode;

import it.epicode.catalogo.libri.Genere;
import it.epicode.catalogo.libri.Libro;
import it.epicode.catalogo.libri.autori.Autore;
import it.epicode.catalogo.libri.autori.AutoreDAO;
import it.epicode.catalogo.FascicoloDAO;
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
        Libro libro2 = new Libro(null, "Il Signore degli Anelli 2: la Vendetta di Sauron", 1955, 1235, autore1, Genere.FANTASY);
        Libro libro3 = new Libro(null, "Java: Da Barista a Programmatore", 2025, 250, autore2, Genere.SAGGIO);
        Libro libro4 = new Libro(null, "Via col Javascript", 2025, 1120, autore3, Genere.ROSA);
        Libro libro5 = new Libro(null, "Il Codice Da Vite", 2025, 510, autore4, Genere.THRILLER);
        Libro libro6 = new Libro(null, "Il Signore degli Anelli 3: Tolkien Colpisce Ancora", 2025, 510, autore1, Genere.FANTASY);
        Rivista rivista1 = new Rivista(null, "Sloth Life", 2024, 2, Periodicita.ANNUALE);
        Rivista rivista2 = new Rivista(null, "Code Wars", 2025, 30, Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista(null, "Lo Smanettone", 1999, 30, Periodicita.MENSILE);

        Utente utente1 = new Utente(null, "Fabio", "Bertolino", LocalDate.of(1997, 12, 5));
        Utente utente2 = new Utente(null, "Gaia", "Martinetto", LocalDate.of(1999, 2, 11));
        Utente utente3 = new Utente(null, "Simone", "Vecchio", LocalDate.of(1997, 9, 30));
        Utente utente4 = new Utente(null, "Valentina", "Pescetto", LocalDate.of(1999, 11, 1));
        Utente utente5 = new Utente(null, "Mattia", "Giacchetto", LocalDate.of(1998, 7, 22));
        Utente utente6 = new Utente(null, "Marianne", "Colarusso", LocalDate.of(1993, 3, 22));
        Utente utente7 = new Utente(null, "Anna", "Camoletto", LocalDate.of(1997, 3, 27));

        Prestito prestito1 = new Prestito(null, utente1, libro3, LocalDate.of(2025, 2, 10), null);
        Prestito prestito2 = new Prestito(null, utente2, libro6, LocalDate.of(2024, 5, 12), LocalDate.of(2024, 6, 7));
        Prestito prestito3 = new Prestito(null, utente5, rivista3, LocalDate.of(2023, 6, 3), null);
        Prestito prestito4 = new Prestito(null, utente1, libro4, LocalDate.of(2024, 11, 25), LocalDate.of(2024, 12, 23));
        Prestito prestito5 = new Prestito(null, utente1, libro5, LocalDate.of(2025, 1, 7), LocalDate.of(2025, 2, 28));
        Prestito prestito6 = new Prestito(null, utente7, rivista3, LocalDate.of(2025, 3, 28), null);
        Prestito prestito7 = new Prestito(null, utente3, rivista1, LocalDate.of(2022, 4, 20), null);

        autoreDAO.insert(autore1);
        autoreDAO.insert(autore2);
        autoreDAO.insert(autore3);
        autoreDAO.insert(autore4);

        fascicoloDAO.insert(libro1);
        fascicoloDAO.insert(libro2);
        fascicoloDAO.insert(libro3);
        fascicoloDAO.insert(libro4);
        fascicoloDAO.insert(libro5);
        fascicoloDAO.insert(libro6);
        fascicoloDAO.insert(rivista1);
        fascicoloDAO.insert(rivista2);
        fascicoloDAO.insert(rivista3);
        fascicoloDAO.delete(libro2.getId());

        utenteDAO.insert(utente1);
        utenteDAO.insert(utente2);
        utenteDAO.insert(utente3);
        utenteDAO.insert(utente4);
        utenteDAO.insert(utente5);
        utenteDAO.insert(utente6);
        utenteDAO.insert(utente7);

        prestitoDAO.insert(prestito1);
        prestitoDAO.insert(prestito2);
        prestitoDAO.insert(prestito3);
        prestitoDAO.insert(prestito4);
        prestitoDAO.insert(prestito5);
        prestitoDAO.insert(prestito6);
        prestitoDAO.insert(prestito7);

        em.getTransaction().commit();

        //TESTING
//        for (Autore autore : autoriKing) {
//            System.out.println(autore.getCognome() + " " + autore.getNome());
//        }
        System.out.println("------------------------------------------------------------");
        System.out.println("RICERCA PER ANNO DI PUBLIZZAZIONE: ");
        //fascicoloDAO.cercaFascicoliPerAnnoPubblicazione(2025).forEach(System.out::println);
        fascicoloDAO.cercaFascicoliPerAnnoPubblicazione(2025).forEach(e -> System.out.println(e.getTitolo()));
        System.out.println("------------------------------------------------------------");
        System.out.println("RICERCA PER AUTORE: ");
        //fascicoloDAO.cercaLibriPerAutore(autore1).forEach(System.out::println);
        fascicoloDAO.cercaLibriPerAutore(autore1).forEach(e -> System.out.println(e.getTitolo() + " - " + e.getAutore().getCognome() + " " + e.getAutore().getNome()));
        System.out.println("RICERCA PER AUTORE: ");
        //fascicoloDAO.cercaLibriPerAutore(autore2).forEach(System.out::println);
        fascicoloDAO.cercaLibriPerAutore(autore2).forEach(e -> System.out.println(e.getTitolo() + " - " + e.getAutore().getCognome() + " " + e.getAutore().getNome()));
        System.out.println("RICERCA PER AUTORE: ");
        //fascicoloDAO.cercaLibriPerAutore(autore3).forEach(System.out::println);
        fascicoloDAO.cercaLibriPerAutore(autore3).forEach(e -> System.out.println(e.getTitolo() + " - " + e.getAutore().getCognome() + " " + e.getAutore().getNome()));
        System.out.println("------------------------------------------------------------");
        System.out.println("RICERCA PER TITOLO PARZIALE: ");
        //fascicoloDAO.cercaFascicoliPerTitoloParziale("Java").forEach(System.out::println);
        fascicoloDAO.cercaFascicoliPerTitoloParziale("Java").forEach(e -> System.out.println("Contains 'Java': " + e.getTitolo()));
        System.out.println("RICERCA PER TITOLO PARZIALE: ");
        //fascicoloDAO.cercaFascicoliPerTitoloParziale("TopoGigio").forEach(System.out::println);
        fascicoloDAO.cercaFascicoliPerTitoloParziale("TopoGigio").forEach(e -> System.out.println("Contains 'TopoGigio': " + e.getTitolo()));
        System.out.println("------------------------------------------------------------");
        System.out.println("RICERCA PRESTITI PER TESSERA UTENTE: ");
        //prestitoDAO.ricercaPrestitiPerIdTessera(utente1.getId()).forEach(System.out::println);
        System.out.println("Utente " + utente1.getNome() + " " + utente1.getCognome() + ": ");
        prestitoDAO.ricercaPrestitiPerIdTessera(utente1.getId()).forEach(e -> System.out.println(e.getElementoPrestato().getTitolo()));
        System.out.println("------------------------------------------------------------");
        System.out.println("PRESTITI OLTRE DEADLINE NON RESTITUITI: ");
        //prestitoDAO.libriOltreDeadlineNonRestituiti().forEach(System.out::println);
        prestitoDAO.libriOltreDeadlineNonRestituiti().forEach(e -> {
            System.out.println(e.getElementoPrestato().getTitolo() + " - Prestito avvenuto il: " + e.getDataInizioPrestito() + ", Restituzione prevista il: " + e.getDataRestituzionePrevista() + ", Giornata corrente: " + LocalDate.now());
            System.out.println("PRESTITO NON RESTITUITO: UTENTE " + e.getUtente().getNome() + " " + e.getUtente().getCognome() + " BANNATO/A DALLA BIBLIOTECA!");
        });

        em.close();
        emf.close();
    }
}
