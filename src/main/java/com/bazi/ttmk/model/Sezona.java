package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sezoni", schema = "project")
public class Sezona implements java.io.Serializable {

    @Id
    @Column(name = "id_sezona", unique = true, nullable = false)
    private int idSezona;

    @Column(name = "pretsedatel", nullable = false, length = 30)
    private String pretsedatel;

    @Column(name = "godina", nullable = false, length = 9)
    private String godina;

    @OneToMany(mappedBy = "sezona")
    private List<Turnir> turniri;

    @OneToMany
    @JoinColumn(name = "sezona_id")
    private List<Liga> ligi;
}