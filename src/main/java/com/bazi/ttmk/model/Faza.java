package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fazi",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_turnir", "id_kategorija", "opis_faza"}),
        schema = "project")
public class Faza implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "redenBroj", column = @Column(name = "reden_broj", nullable = false)),
            @AttributeOverride(name = "idTurnir", column = @Column(name = "id_turnir", nullable = false)),
            @AttributeOverride(name = "idKategorija", column = @Column(name = "id_kategorija", nullable = false))
    })
    private FazaId id;

    @Column(name = "opis_faza", nullable = false, length = 4)
    private String opisFaza;

    @Column(name = "broj_faza")
    private int brojFaza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "id_turnir", referencedColumnName = "id_turnir", insertable = false, updatable = false),
            @JoinColumn(name = "id_kategorija", referencedColumnName = "id_kategorija", insertable = false, updatable = false)
    })
    private Turnir turnir;

    @OneToMany(mappedBy = "faza")
    private List<Mech> mechevi;

}