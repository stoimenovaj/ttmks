package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(FazaId.class)
@Table(name = "fazi",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_turnir", "id_kategorija", "opis_faza"}),
        schema = "project")
public class Faza implements java.io.Serializable {

//    @EmbeddedId
//    @AttributeOverrides({
//            @AttributeOverride(name = "redenBroj", column = @Column(name = "reden_broj", nullable = false)),
//            @AttributeOverride(name = "idTurnir", column = @Column(name = "id_turnir", nullable = false)),
//            @AttributeOverride(name = "idKategorija", column = @Column(name = "id_kategorija", nullable = false))
//    })
//    private FazaId id;

    @Id
    @Column(name = "reden_broj", nullable = false, columnDefinition="serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project.fazi_reden_broj_seq")
    private int redenBroj;

    @Id
    @Column(name = "id_turnir", nullable = false)
    private int idTurnir;

    @Id
    @Column(name = "id_kategorija", nullable = false)
    private int idKategorija;

    @Column(name = "opis_faza", nullable = false, length = 28)
    private String opisFaza;

    @Column(name = "broj_faza")
    private int brojFaza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "id_turnir", referencedColumnName = "id_turnir", insertable = false, updatable = false),
            @JoinColumn(name = "id_kategorija", referencedColumnName = "id_kategorija", insertable = false, updatable = false)
    })
    @JsonIgnore
    private Turnir turnir;

    @OneToMany(mappedBy = "faza")
    private List<Mech> mechevi;

}