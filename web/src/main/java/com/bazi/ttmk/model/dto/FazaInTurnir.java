package com.bazi.ttmk.model.dto;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.model.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FazaInTurnir {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MechInFaza{

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class SetInMech{

            private int domakjinPoeni;

            private int gostinPoeni;

        }

        private IgrachInMech domakjin;

        private IgrachInMech gostin;

        private List<SetInMech> setovi;

    }

    private int broj;

    private String opis;

    private List<MechInFaza> mechevi;

}
