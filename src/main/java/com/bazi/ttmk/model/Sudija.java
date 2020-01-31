package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sudii", schema = "project")
public class Sudija extends RegistriranoLice implements java.io.Serializable {

    @Column(name = "titula", nullable = false, length = 30)
    private String titula;

}