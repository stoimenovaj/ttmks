package com.bazi.ttmk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NatprevarInLiga {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NatprevarInfo{

        private int idNatprevar;

        private int idDomakjin;

        private String imeDomakjin;

        private int idGostin;

        private String imeGostin;

        private int domakjinMechevi;

        private int gostinMechevi;

    }

    private int kolo;

    private List<NatprevarInfo> natprevari;

}
