package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "natprevari",
        uniqueConstraints = @UniqueConstraint(columnNames = {"data_odigran", "id_tim_domakjin", "id_tim_gostin"}),
        schema = "project"
)
public class Natprevar implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_natprevar", unique = true, nullable = false)
    private int idNatprevar;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_odigran", nullable = false, length = 13)
    private Date dataOdigran;

    @Column(name = "kolo")
    private Integer kolo;

    @Column(name = "dobieni_mechevi_domakjin")
    private int dobieniMecheviDomakjin;

    @Column(name = "dobieni_mechevi_gostin")
    private int dobieniMecheviGostin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tim_domakjin", nullable = false)
    private Tim timDomakjin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tim_gostin", nullable = false)
    private Tim timGostin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala salaOdrzuvanje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "id_liga", referencedColumnName = "id_liga", insertable = false, updatable = false),
            @JoinColumn(name = "id_sezona", referencedColumnName = "id_sezona", insertable = false, updatable = false)
    })
    @JsonIgnore
    private Liga liga;

    @OneToMany(mappedBy = "natprevar", fetch = FetchType.EAGER)
    private List<Mech> mechevi;
}