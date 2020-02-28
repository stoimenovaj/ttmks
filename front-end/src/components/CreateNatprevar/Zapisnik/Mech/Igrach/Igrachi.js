import React, {useState} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../../CustomDropdown/customDropdown";

const Igrachi = (props) => {

    let [selectedIgrach, setSelectedIgrach] = useState('Избери играч');

    let igrachiHtml = props.igrachi.map((igrach, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            setSelectedIgrach(e.target.attributes.getNamedItem('imeprezime').value);
            props.addIgrach(parseInt(e.target.attributes.getNamedItem('idigrach').value));
        }} idigrach={igrach.id} imeprezime={`${igrach.ime} ${igrach.prezime}`}>{igrach.ime} {igrach.prezime}</Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {selectedIgrach}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {igrachiHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Igrachi;