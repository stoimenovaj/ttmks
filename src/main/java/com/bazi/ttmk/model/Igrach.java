package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "igrachi", schema = "project")
public class Igrach implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lice_igrach", unique = true, nullable = false)
    private int idLiceIgrach;

    @Temporal(TemporalType.DATE)
    @Column(name = "posleden_lekarski_pregled", nullable = false, length = 13)
    private Date posledenLekarskiPregled;

    @Column(name = "opis_na_reket", nullable = false, length = 100)
    private String opisNaReket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tim")
    private Tim tim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategorija")
    private Kategorija kategorija;
}