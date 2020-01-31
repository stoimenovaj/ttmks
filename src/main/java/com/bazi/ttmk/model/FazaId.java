package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FazaId implements java.io.Serializable {

    //@Column(name = "reden_broj", nullable = false)
    private int redenBroj;

    //@Column(name = "id_turnir", nullable = false)
    private int idTurnir;

    //@Column(name = "id_kategorija", nullable = false)
    private int idKategorija;
}
