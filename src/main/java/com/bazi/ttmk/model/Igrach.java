package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "igrachi", schema = "project")
public class Igrach extends RegistriranoLice implements java.io.Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_lice_igrach", unique = true, nullable = false)
//    private int idLiceIgrach;

    @Temporal(TemporalType.DATE)
    @Column(name = "posleden_lekarski_pregled", nullable = false, length = 13)
    private Date posledenLekarskiPregled;

    @Column(name = "opis_na_reket", nullable = false, length = 100)
    private String opisNaReket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tim")
    @JsonIgnore
    private Tim tim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategorija")
    private Kategorija kategorija;
}