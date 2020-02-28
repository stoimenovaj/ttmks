import React, {useEffect, useState} from 'react';
import GradoviService from "../../../../service/gradoviService";
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../CustomDropdown/customDropdown";

const Gradovi = (props) => {

    let [gradovi, setGradovi] = useState([]);
    let [selectedGrad, setSelectedGrad] = useState('Избери град');

    useEffect(() => {
        GradoviService.getAllGradovi()
            .then(response => {
                setGradovi(response.data);
            }).catch();
    }, []);

    let gradoviHtml = gradovi.map((grad, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            props.selectGrad(parseInt(e.target.attributes.getNamedItem('idgrad').value));
            setSelectedGrad(e.target.attributes.getNamedItem('imegrad').value);
        }} idgrad={grad.idGrad} imegrad={grad.imeGrad}>{grad.imeGrad}</Dropdown.Item>;
    });

    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {selectedGrad}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {gradoviHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
            {dropdown}
        </div>
    );
};

export default Gradovi;