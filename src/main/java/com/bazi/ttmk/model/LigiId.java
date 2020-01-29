package com.bazi.ttmk.model;
// Generated Jan 29, 2020, 7:04:22 PM by Hibernate Tools 4.3.5.Final


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * LigiId generated by hbm2java
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LigiId implements java.io.Serializable {

    @Column(name = "id_liga", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiga;

    @Column(name = "id_sezona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSezona;
}


