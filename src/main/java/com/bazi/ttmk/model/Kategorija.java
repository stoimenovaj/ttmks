package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kategorii",
        uniqueConstraints = @UniqueConstraint(columnNames = "ime_kategorija"),
        schema = "project")
public class Kategorija implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategorija", unique = true, nullable = false)
    private int idKategorija;

    @Column(name = "ime_kategorija", unique = true, nullable = false, length = 40)
    private String imeKategorija;

}