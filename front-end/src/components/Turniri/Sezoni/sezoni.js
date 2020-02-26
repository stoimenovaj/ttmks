import React from "react";
import repo from "../../../repository/testRepository"
import Accordion from 'react-bootstrap/Accordion'
import Card from "react-bootstrap/Card";
import {useAccordionToggle} from "react-bootstrap";

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

    const showTurniri = (e) =>{
        let idTurnir = e.idturnir;
        let idSezona = e.idsezona;
        // props.prikazhiTurnir(idTurnir, idSezona);
    };




    let sezoni = props.sezoniTurniri;
    let sezoniHtml;
    if(sezoni){
        sezoniHtml = sezoni.map((sez,index) => {
            let btn = <button className="btn btn-light btn-block mb-3" >{sez.sezona.godina}</button>;
            let ind = index;
            let itemsHtml = sez.turniri.map((turnir,index) => {
                let radio;
                radio =  <input onClick={showTurniri} idsezona={sez.sezona.idSezona} idturnir={turnir.idTurnir} id={ind + "" + index} type="radio" name="item" />;
                let label =  <label onClick={showTurniri} htmlFor={ind + "" + index}>{turnir.imeTurnir} - {turnir.dataNaOdrzhuvanje}</label>;
                return <div key={index}>{radio}{label}</div>;
            });

            let card = <Card>
                <Card.Header  variant="link" eventKey={index}>
                    <CustomToggle as={"btn"} variant="link" eventKey={index}>
                        {sez.sezona.godina}
                    </CustomToggle>
                </Card.Header>
                <Accordion.Collapse eventKey={index}>
                    <Card.Body>{itemsHtml}</Card.Body>
                </Accordion.Collapse>
            </Card>;
            return <div key={index}>{card}</div>;
        });
    }


    return(
        <div className="col-sm-3 bg-dark text-primary text-left pl-5 pt-4"
             style={{ borderRight: "1px black solid",
                 minHeight: "100%",
                 maxHeight: "93vh",
                 overflow: "auto",
                 opacity: ".9"}}>
            <Accordion defaultActiveKey="0">
                {sezoniHtml}
            </Accordion>

        </div>
    )
};

export default Sezoni