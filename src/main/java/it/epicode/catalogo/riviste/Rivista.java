package it.epicode.catalogo.riviste;

import it.epicode.catalogo.Fascicolo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

@Entity
public class Rivista extends Fascicolo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {
    }
    public Rivista(UUID id, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
