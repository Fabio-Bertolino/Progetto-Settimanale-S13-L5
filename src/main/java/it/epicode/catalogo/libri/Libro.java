package it.epicode.catalogo.libri;

import it.epicode.catalogo.Fascicolo;
import it.epicode.catalogo.libri.autori.Autore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

@Entity
public class Libro extends Fascicolo {
    private Autore autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {
    }

    public Libro(UUID id, String titolo, int annoPubblicazione, int numeroPagine, Autore autore, Genere genere) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}

