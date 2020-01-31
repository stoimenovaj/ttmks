package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "sudii", schema = "project")
public class Sudija extends RegistriranoLice implements java.io.Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_lice_sudija", unique = true, nullable = false)
//    private int idLiceSudija;

    @Column(name = "titula", nullable = false, length = 30)
    private String titula;

}