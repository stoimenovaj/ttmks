import React, {useEffect, useState} from 'react';
import KS from  "../../../../service/kategoriiService"
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../../CreateNatprevar/CustomDropdown/customDropdown";

const Kategorii = (props) => {

    let [kState, setKState] = useState([]);
    let [imeState, setImeState] = useState("Селектирај категорија за да дознаеш кои биле први во неа!")

    useEffect(() =>{
        KS.getAllKategorii()
            .then(response => {
                setKState(response.data);
            })
            .catch();
    },[]);

    const pobednici = (e) => {
        let idKategorija = e.target.attributes.getNamedItem("kategorija").value;
        let imeKategorija = e.target.attributes.getNamedItem("ime").value;
        setImeState(imeKategorija);
        props.pobednici(idKategorija);
    };

    let items = kState.map((kat, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={pobednici} kategorija={kat.idKategorija} ime={kat.imeKategorija}>
            {kat.imeKategorija}
        </Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
            {imeState}
        </Dropdown.Toggle>
        <Dropdown.Menu as={CustomMenu}>
            {items}
        </Dropdown.Menu>
    </Dropdown>;

    if(!kState) return <span />

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Kategorii;