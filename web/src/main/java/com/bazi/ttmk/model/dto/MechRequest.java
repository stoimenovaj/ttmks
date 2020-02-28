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
public class MechRequest {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SetRequest{

        private int domakjin;

        private int gostin;

    }

    private int natprevarId;

    private int domakjinId;

    private int gostinId;

    private List<SetRequest> setovi;

    private int domakjinSetovi;

    private int gostinSetovi;

}
