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
public class LigaId implements java.io.Serializable {

    @Column(name = "id_liga", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiga;

    @Column(name = "id_sezona", nullable = false)
    private int idSezona;
}