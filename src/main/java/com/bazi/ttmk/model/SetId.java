package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SetId implements java.io.Serializable {

    @Column(name = "reden_broj", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int redenBroj;

    @Column(name = "id_mech", nullable = false)
    private int idMech;

}