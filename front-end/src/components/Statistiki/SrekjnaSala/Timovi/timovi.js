import React, {useEffect, useState} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../../CreateNatprevar/CustomDropdown/customDropdown";
import TS from "../../../../service/timoviService";

const Timovi = (props) => {

    let [tState, setTState] = useState([]);
    let [imeState, setImeState] = useState("Селектирај тим за кој што сакаш да се прикажат среќните сали!");

    useEffect(() => {
        TS.getAllTimovi()
            .then(response => {
                setTState(response.data);
            })
            .catch();
    }, []);

    const prikazhiSrekjniSali = (e) => {
        let idTim = e.target.attributes.getNamedItem("idtim").value;
        setImeState(e.target.attributes.getNamedItem("imetim").value);
        props.showSali(idTim);
    };

    let items = tState.map((tim, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={prikazhiSrekjniSali} imetim={tim.imeTim} idtim={tim.idTim}>{tim.imeTim} - {tim.grad.imeGrad}</Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
            {imeState}
        </Dropdown.Toggle>
        <Dropdown.Menu as={CustomMenu}>
            {items}
        </Dropdown.Menu>
    </Dropdown>;

    if(!tState) return <span />

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Timovi;