import React from "react";
import repo from "../../../repository/testRepository"
import Accordion from 'react-bootstrap/Accordion'
import Card from "react-bootstrap/Card";
import {useAccordionToggle} from "react-bootstrap";
import {withRouter} from "react-router";


const Sezoni = (props) => {

    const showTurniri = (e) =>{
        console.log(e.target);
        // let idTurnir = e.target.idturnir;
        let idTurnir = e.target.attributes.getNamedItem('idturnir').value;
        let idKategorija = e.target.attributes.getNamedItem('idkategorija').value;
            //= e.target.idkategorija;
        props.prikazhiTurnir(idTurnir, idKategorija);
    };

    let sezoni = props.sezoniTurniri;
    let sezoniHtml;
    if(sezoni){
        sezoniHtml = sezoni.map((sez,index) => {
            if(sez.turniri.length <=0) return <span />;
            let ind = index;
            let itemsHtml = sez.turniri.map((turnir,index) => {
                let radio;
                radio =  <input onClick={showTurniri} idkategorija={turnir.idKategorija} idturnir={turnir.idTurnir} id={ind + "" + index} type="radio" name="item" />;
                let label =  <label htmlFor={ind + "" + index}>{turnir.imeTurnir} - {turnir.dataNaOdrzhuvanje}</label>;
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
        <div className="col-sm-3 bg-dark text-primary text-left pt-5 pb-5"
             style={{ borderRight: "1px black solid",
                 maxHeight: "80vh",
                 overflow: "auto",
                 opacity: ".9"}}>
            <Accordion defaultActiveKey={0}>
                {sezoniHtml}
            </Accordion>

        </div>
    )
};

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

export default withRouter(Sezoni)