package com.bazi.ttmk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NatprevarRequest {

    private int idSezona;

    private int idLiga;

    private Date dataOdigran;

    private Integer kolo;

    private int idTimDomakjin;

    private int idTimGostin;

    private int idSalaOdrzuvanje;

}
