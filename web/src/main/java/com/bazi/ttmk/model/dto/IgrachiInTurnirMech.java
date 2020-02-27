package com.bazi.ttmk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IgrachiInTurnirMech {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IgrachInTurnir{

        private int id;

        private String ime;

        private int poeni;

    }

    IgrachInTurnir igrach1;

    IgrachInTurnir igrach2;

    private int brFaza;

    private boolean more;

}
