package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spagja", schema = "project")
public class Spagja implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idLiga", column = @Column(name = "id_liga", nullable = false)),
            @AttributeOverride(name = "idSezona", column = @Column(name = "id_sezona", nullable = false)),
            @AttributeOverride(name = "idTim", column = @Column(name = "id_tim", nullable = false))})
    private SpagjaId id;

    @Column(name = "tim_poeni", nullable = false)
    private int timPoeni;

}


