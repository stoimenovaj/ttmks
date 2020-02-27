import React from 'react';
import Table from "react-bootstrap/Table";

const Kola = (props) => {

    const tabeliHtml = props.natprevari.map((kolo, index) => {
        let thead = <thead className="fixed">
        <tr className=""><td colSpan="7" className=" col-sm-12 text-center" style={{fontSize: "20px"}}>{kolo.kolo}</td></tr>
        <tr className="text-primary">
            <th>#</th>
            <th>Домаќин</th>
            <th>Поени домаќин</th>
            <th>Поени гостин</th>
            <th>Гостин</th>
        </tr>
        </thead>

        let tbody = kolo.natprevari.map((n, index) => {
            return <tr>
                <td>{index+1}</td>
                <td>{n.imeDomakjin}</td>
                <td>{n.domakjinMechevi}</td>
                <td>{n.gostinMechevi}</td>
                <td>{n.imeGostin}</td>
            </tr>
        });

        return <Table striped bordered hover variant="dark">
            {thead}
            {tbody}
        </Table>
    });

    if(props.natprevari.length <=0) return <span />

    return (
        <div
            style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
            {tabeliHtml}
        </div>
    );
};

export default Kola;