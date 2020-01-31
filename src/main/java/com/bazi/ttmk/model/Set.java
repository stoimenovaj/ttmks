package com.bazi.ttmk.model;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "setovi", schema = "project")
public class Set implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "redenBroj", column = @Column(name = "reden_broj", nullable = false)),
            @AttributeOverride(name = "idMech", column = @Column(name = "id_mech", nullable = false))
    })
    private SetId id;

    @Column(name = "poeni_gostin", nullable = false)
    private int poeniGostin;

    @Column(name = "poeni_domakjin", nullable = false)
    private int poeniDomakjin;

}