import React, {useEffect, useState} from 'react';
import Turniri from "../../../../service/turniriService";
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "../../CustomDropdown/customDropdown";

const Sezoni = (props) => {

    let [sezoni, setSezoni] = useState([]);
    let [selectedSezona, setSelectedSezona] = useState({idSezona: -1, imeSezona: 'Избери сезона'});

    useEffect(() => {
        Turniri.getAllSezoni().then(response => {
            setSezoni(response.data);
        }).catch();
    }, []);

    let sezoniHtml = sezoni.map((sez, index) => {
        return <Dropdown.Item eventKey={`${index}`} onClick={(e) => {
            setSelectedSezona({
                idSezona: parseInt(e.target.attributes.getNamedItem('idsez').value),
                imeSezona: e.target.attributes.getNamedItem('namesez').value
            });
            props.selectSezona(parseInt(e.target.attributes.getNamedItem('idsez').value));
        }} idsez={sez.idSezona} namesez={sez.godina}>{sez.godina}</Dropdown.Item>;
    });
    let dropdown = <Dropdown>
        <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components" disabled={props.disabled}>
            {selectedSezona.imeSezona}
        </Dropdown.Toggle>

        <Dropdown.Menu as={CustomMenu}>
            {sezoniHtml}
        </Dropdown.Menu>
    </Dropdown>;

    return (
        <div>
        {dropdown}
        </div>
    );
};

export default Sezoni;