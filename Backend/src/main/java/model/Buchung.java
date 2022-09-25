package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "BUCHUNG")
public class Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime Datum;

    @Column(nullable = false)
    private Boolean Halbtag;

    @ManyToOne
    @JoinColumn(name="mitglied_id", nullable=false)
    private Mitglied mitglied;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return Datum;
    }

    public void setDatum(LocalDateTime datum) {
        Datum = datum;
    }

    public Boolean getHalbtag() {
        return Halbtag;
    }

    public void setHalbtag(Boolean halbtag) {
        Halbtag = halbtag;
    }

}
