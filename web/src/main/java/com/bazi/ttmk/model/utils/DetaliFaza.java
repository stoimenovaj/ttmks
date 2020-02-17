package com.bazi.ttmk.model.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetaliFaza {

    FINALE("ФИНАЛЕ", 1),
    POLU_FINALE("ПОЛУ-ФИНАЛЕ", 2),
    CETVRT_FINALE("ЧЕТВРТИНА-ФИНАЛЕ", 3),
    OSMINA_FINALE ("ОСМИНА-ФИНАЛЕ", 4),
    SESNAESETINA_FINALE("ШЕСНАЕСЕТИНА-ФИНАЛЕ", 5);

    private String opis;
    private int broj;

}
