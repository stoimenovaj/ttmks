import React, {useState} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../CustomDropdown/customDropdown";

const Ligi = (props) => {

    let ligiHtml = props.ligi.map((liga, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            props.changeLiga(parseInt(e.target.attributes.getNamedItem('idliga').value),
                e.target.attributes.getNamedItem('imeliga').value);
        }} idliga={liga.idLiga} imeliga={liga.imeLiga}>{liga.imeLiga}</Dropdown.Item>;
    });

    let dropdown = <Dropdown >
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {props.selectedLiga.imeLiga}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {ligiHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Ligi;