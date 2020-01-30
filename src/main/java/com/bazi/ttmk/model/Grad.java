package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gradovi",
        uniqueConstraints = @UniqueConstraint(columnNames = "ime_grad"),
        schema = "project")
public class Grad implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grad", unique = true, nullable = false)
    private int idGrad;

    @Column(name = "ime_grad", unique = true, nullable = false, length = 30)
    private String imeGrad;

}