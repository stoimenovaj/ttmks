package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SpagjaId implements java.io.Serializable {

    @Column(name = "id_liga", nullable = false)
    private int idLiga;

    @Column(name = "id_sezona", nullable = false)
    private int idSezona;

    @Column(name = "id_tim", nullable = false)
    private int idTim;

}


