import React from 'react';
import Table from "react-bootstrap/Table";

const TopLista = (props) => {
    console.log(props.topLista);

    const timoviHtml = props.topLista.map((tim, index) => {
        return <tr>
            <td>{index+1}</td>
            <td>{tim.imeTim}</td>
            <td>{tim.odigraniNatprevari}</td>
            <td>{tim.pobedi}</td>
            <td>{tim.porazi}</td>
            <td>{tim.dobieniMechevi}</td>
            <td>{tim.izgubeniMechevi}</td>
            <td>{tim.bodovi}</td>
        </tr>
    });

    if(props.topLista.length <=0) return <span />

    return (
        <div
             style={{opacity: ".9", maxHeight: "80vh"}}>

            <Table striped bordered hover variant="dark">
                <thead className="fixed">
                <tr className=""><td colSpan="7" className=" col-sm-12 text-center" style={{fontSize: "20px"}}>ТОП ЛИСТА</td></tr>
                <tr className="text-primary">
                    <th>#</th>
                    <th>Име</th>
                    <th>Одиграни натпревари</th>
                    <th>победи</th>
                    <th>порази</th>
                    <th>добиени мечеви</th>
                    <th>изгубени мечеви</th>
                    <th>бодови</th>
                </tr>
                </thead>
                <tbody>
                {timoviHtml}
                </tbody>
            </Table>

        </div>
    );
};

export default TopLista;