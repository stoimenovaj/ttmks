package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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