import React from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../CustomDropdown/customDropdown";

const Sali = (props) => {

    let saliHtml = props.sali.map((sala, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            props.saveSala(
                parseInt(e.target.attributes.getNamedItem('idsala').value),
                e.target.attributes.getNamedItem('imesala').value
            );
        }} idsala={sala.idSala} imesala={sala.imeSala}>{sala.imeSala}</Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {props.selectedSala.imeSala}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {saliHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Sali;