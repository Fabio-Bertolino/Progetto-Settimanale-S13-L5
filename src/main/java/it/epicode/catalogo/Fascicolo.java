package it.epicode.catalogo;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "fascicoli")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Fascicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length =200, nullable = false)
    private String titolo;

    private int annoPubblicazione;
    private int numeroPagine;

    public Fascicolo() {
    }

    public Fascicolo(UUID id, String titolo, int annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
