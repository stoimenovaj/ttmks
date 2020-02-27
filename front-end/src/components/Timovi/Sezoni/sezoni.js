import React, {useState} from 'react';
import Accordion from "react-bootstrap/Accordion";
import Dropdown from "react-bootstrap/Dropdown";
import Card from "react-bootstrap/Card";
import {useAccordionToggle} from "react-bootstrap/esm";

function CustomToggle({ children, eventKey }) {
    const decoratedOnClick = useAccordionToggle(eventKey, () =>
        console.log('totally custom!'),
    );

    return (
        <button
            type="button"
            className="btn btn-block btn-light"
            onClick={decoratedOnClick}
        >
            {children}
        </button>
    );
}

const Sezoni = (props) => {

    let sezoni = props.getSezoni;
    let ligi = props.ligi;

    let [aState, setAState] = useState({imeSezona : "Избери сезона"})

    // so hooks za da se promeni sezonata
    const clickHandler = (e) => {
        let idSezona = e.target.attributes.getNamedItem('idsezona').value;
        setAState({imeSezona : e.target.attributes.getNamedItem('imesezona').value});
        props.showSezona(idSezona);
    };

    const showIgrachiMechevi = (e) => {
        let idTim = e.target.attributes.getNamedItem('idtim').value;
        let idLiga = e.target.attributes.getNamedItem('idliga').value;
        props.showIgrachiMechevi(idTim, props.idsezona, idLiga);
    };

    if(sezoni && ligi){
        const sezoniHtml = sezoni.map((sez) => {
            return <Dropdown.Item onClick={clickHandler} idsezona={sez.idSezona} imesezona={sez.godina}>{sez.godina}</Dropdown.Item>
        });

        const ligiHtml = ligi.map((liga, index) => {
            let ind = index;
            let timoviHtml = liga.timovi.map((tim, index) => {
                let radio;
                radio =  <input id={ind + "" + index} type="radio" name="item" />;
                let label =  <label onClick={showIgrachiMechevi} htmlFor={ind + "" + index} idliga={liga.idLiga} idtim={tim.idTim}>{tim.imeTim} - {tim.grad}</label>;
                return <div key={index}>{radio}{label}</div>;
            });

            let card = <Card>
                <Card.Header  variant="link" eventKey={index}>
                    <CustomToggle as={"btn"} variant="link" eventKey={index}>
                        {liga.imeLiga}
                    </CustomToggle>
                </Card.Header>
                <Accordion.Collapse eventKey={index}>
                    <Card.Body>{timoviHtml}</Card.Body>
                </Accordion.Collapse>
            </Card>;
            return <div key={index}>{card}</div>;
        });

        return (
            <div className="col-sm-3 bg-dark text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     minHeight: "50vh",
                     maxHeight: "93vh",
                     overflow: "auto",
                     opacity: ".9"}}>
                <Dropdown>
                    <Dropdown.Toggle variant="light btn-block" id="dropdown-basic">
                        <b className="text-primary" style={{fontSize :"20px"}}>{aState.imeSezona}</b>
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        {sezoniHtml}
                    </Dropdown.Menu>

                </Dropdown>
                <Accordion defaultActiveKey={0}>
                    {ligiHtml}
                </Accordion>

            </div>
        );
    } else return <span/>
};

export default Sezoni;