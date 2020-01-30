package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "timovi",
        uniqueConstraints = @UniqueConstraint(columnNames = "kontakt_email"),
        schema = "project"
)
public class Tim implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tim", unique = true, nullable = false)
    private int idTim;

    @Column(name = "ime_tim", nullable = false, length = 30)
    private String imeTim;

    @Column(name = "godina_osnovan", nullable = false)
    private int godinaOsnovan;

    @Column(name = "kontakt_email", unique = true, nullable = false, length = 50)
    private String kontaktEmail;

    @Column(name = "kontakt_telefon", length = 12)
    private String kontaktTelefon;

    @Column(name = "kontakt_lice", length = 30)
    private String kontaktLice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grad", nullable = false)
    private Grad grad;

    @OneToMany(mappedBy = "tim")
    private List<Igrach> igrachi;

}