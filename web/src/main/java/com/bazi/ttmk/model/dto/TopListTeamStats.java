package com.bazi.ttmk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopListTeamStats implements Serializable {

    private int idTim;

    private String imeTim;

    private int odigraniNatprevari;

    private int pobedi;

    private int porazi;

    private int dobieniMechevi;

    private int izgubeniMechevi;

    private int bodovi;

}
