import React, {useEffect, useState} from 'react';
import IS from "../../../../service/igrachiService"
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../../CreateNatprevar/CustomDropdown/customDropdown";

const Igrachi = (props) => {

    let [iState, setIState] = useState([])
    let [imeState, setImeState] = useState("Селектирај играч за кој сакаш да дознаеш до каде најмногу стигнал на некој турнир!")
    useEffect(() =>{
        IS.getAllIgrachi()
            .then(response => {
                setIState(response.data);
            })
            .catch();
    },[]);

    const uspehNaTurniriZaIgrach = (e) => {
        let idIgrach = e.target.attributes.getNamedItem("idigrach").value;
        let igrach = e.target.attributes.getNamedItem("ime").value + " " + e.target.attributes.getNamedItem("prezime").value;
        setImeState(igrach);
        props.setIgrach(idIgrach);
    };

    let items = iState.map((igrach, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={uspehNaTurniriZaIgrach} idigrach={igrach.idLice} ime={igrach.lice.imeLice} prezime={igrach.lice.prezimeLice}>
            {igrach.lice.imeLice} {igrach.lice.prezimeLice} - {igrach.lice.gradRaganje.imeGrad}
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

    if(!iState) return <span />

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Igrachi;