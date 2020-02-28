import React, {useState} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../CustomDropdown/customDropdown";
import Button from "react-bootstrap/Button";

const Tim = (props) => {

    let [selectedTim, setSelectedTim] = useState(props.placeholder.toString());

    let timoviHtml = props.timovi.map((tim, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            props.saveTim(
                parseInt(e.target.attributes.getNamedItem('idtim').value),
            );
            setSelectedTim(e.target.attributes.getNamedItem('imetim').value);
        }} idtim={tim.id} imetim={tim.ime}>{tim.ime}</Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {selectedTim}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {timoviHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Tim;