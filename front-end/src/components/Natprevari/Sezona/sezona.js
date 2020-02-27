import React from 'react';
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";
import {useAccordionToggle} from "react-bootstrap/esm";

function CustomToggle({children, eventKey}) {
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

const Sezona = (props) => {

    const showInfo = (e) => {
        let idSezona = e.target.attributes.getNamedItem("idSezona").value;
        let idLiga = e.target.attributes.getNamedItem("idliga").value;
        props.showInfo(idSezona, idLiga);
    };

    let sezoni = props.getSezoni;
    let sezoniHtml;
    if (sezoni) {

        sezoniHtml = sezoni.map((sez, index) => {
            if (sez.ligi <= 0) return <span/>;
            let ind = index;
            let itemsHtml = sez.ligi.map((liga, index) => {
                let radio;
                radio =
                    <input onClick={showInfo} idliga={liga.idLiga} idsezona={sez.sezona.idSezona} id={ind + "" + index}
                           type="radio" name="item"/>;
                let label = <label htmlFor={ind + "" + index}>{liga.imeLiga}</label>;
                return <div key={index}>{radio}{label}</div>;
            });

            let card = <Card>
                <Card.Header variant="link" eventKey={index}>
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

    }
    return <span/>

};

export default Sezona;