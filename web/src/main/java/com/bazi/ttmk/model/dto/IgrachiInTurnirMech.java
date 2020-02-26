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

    // igrach1

    private int id1;

    private String ime1;

    // igrach2

    private int id2;

    private String ime2;

    // rezultat

    private int poeni1;

    private  int poeni2;

    // faza

    private int brFaza;

    private boolean more;

}
