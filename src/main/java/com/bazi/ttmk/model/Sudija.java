package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sudii", schema = "project")
public class Sudija implements java.io.Serializable {

    @Id
    @Column(name = "id_lice", nullable = false)
    private int idLice;

    @Column(name = "titula", nullable = false, length = 30)
    private String titula;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lice", insertable = false, updatable = false)
    private RegistriranoLice lice;

}