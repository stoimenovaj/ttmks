package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(SetId.class)
@Table(name = "setovi", schema = "project")
public class Set implements java.io.Serializable {

    @Id
    @Column(name = "reden_broj", nullable = false, columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project.setovi_reden_broj_seq")
    private int redenBroj;

    @Id
    @Column(name = "id_mech", nullable = false)
    private int idMech;

    @Column(name = "poeni_gostin", nullable = false)
    private int poeniGostin;

    @Column(name = "poeni_domakjin", nullable = false)
    private int poeniDomakjin;

}