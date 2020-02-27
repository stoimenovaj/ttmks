package com.bazi.ttmk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LigiWithTimovi {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TimInfo{

        private int idTim;

        private String imeTim;

        private String grad;

    }

    private Integer idLiga;

    private String imeLiga;

    List<TimInfo> timovi;

}
