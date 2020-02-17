package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(SpagjaId.class)
@Table(name = "spagja", schema = "project")
public class Spagja implements java.io.Serializable {

    @Id
    @Column(name = "id_liga", nullable = false)
    private int idLiga;

    @Id
    @Column(name = "id_sezona", nullable = false)
    private int idSezona;

    @Id
    @Column(name = "id_tim", nullable = false)
    private int idTim;

    @Column(name = "tim_poeni", nullable = false)
    private int timPoeni;

}