package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sezoni", schema = "project")
public class Sezona implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sezona", unique = true, nullable = false)
    private int idSezona;

    @Column(name = "pretsedatel", nullable = false, length = 30)
    private String pretsedatel;

    @Column(name = "godina", nullable = false, length = 9)
    private String godina;

    @OneToMany(mappedBy = "sezona")
    @JsonIgnore
    private List<Turnir> turniri;

    @OneToMany(mappedBy = "sezona")
    @JsonIgnore
    private List<Liga> ligi;

}