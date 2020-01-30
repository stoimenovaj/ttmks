package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sudii", schema = "project")
public class Sudija implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lice_sudija", unique = true, nullable = false)
    private int idLiceSudija;

    @Column(name = "titula", nullable = false, length = 30)
    private String titula;

}