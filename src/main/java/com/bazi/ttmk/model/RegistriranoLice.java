package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(
        name = "registrirani_lica",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ime_lice", "prezime_lice", "godini_lice"}),
        schema = "project"
)
public class RegistriranoLice  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lice", unique = true, nullable = false)
    private int idLice;

    @Column(name = "ime_lice", nullable = false, length = 20)
    private String imeLice;

    @Column(name = "prezime_lice", nullable = false, length = 20)
    private String prezimeLice;

    @Column(name = "godini_lice", nullable = false)
    private int godiniLice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grad", nullable = false)
    private Grad gradRaganje;

}