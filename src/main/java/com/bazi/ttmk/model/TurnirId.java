package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TurnirId implements java.io.Serializable {

    @Column(name = "id_turnir", nullable = false, columnDefinition="serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project.turniri_id_turnir_seq")
    private int idTurnir;

    @Column(name = "id_kategorija", nullable = false)
    private int idKategorija;

}