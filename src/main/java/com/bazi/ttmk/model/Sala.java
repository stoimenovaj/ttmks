package com.bazi.ttmk.model;
// Generated Jan 29, 2020, 7:04:22 PM by Hibernate Tools 4.3.5.Final


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "sali",
        uniqueConstraints = @UniqueConstraint(columnNames = "ime_sala"),
        schema = "project"
)
public class Sala implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala", unique = true, nullable = false)
    private int idSala;

    @Column(name = "ime_sala", unique = true, nullable = false, length = 50)
    private String imeSala;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grad")
    private Gradovi grad;

}


