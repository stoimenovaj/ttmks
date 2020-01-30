package com.bazi.ttmk.model;

import com.bazi.ttmk.web.FaziController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "turniri",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ime_turnir", "id_sezona", "data_na_odrzhuvanje", "id_kategorija"}),
        schema = "project"
)
public class Turnir implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idTurnir", column = @Column(name = "id_turnir", nullable = false)),
            @AttributeOverride(name = "idKategorija", column = @Column(name = "id_kategorija", nullable = false))
    })
    private TurnirId id;

    @Column(name = "ime_turnir", nullable = false, length = 50)
    private String imeTurnir;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_na_odrzhuvanje", nullable = false, length = 13)
    private Date dataNaOdrzhuvanje;

    @Column(name = "participacija", nullable = false)
    private int participacija;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala salaNaOdrzuvanje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sezona", nullable = false)
    @JsonIgnore
    private Sezona sezona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategorija", nullable = false)
    private Kategorija kategorija;

    @OneToMany(mappedBy = "turnir")
    private List<Faza> fazi;

}