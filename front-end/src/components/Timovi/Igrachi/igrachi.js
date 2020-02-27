import React from 'react';
import Table from "react-bootstrap/Table";

const Igrachi = (props) => {
    let igrachi = props.igrachi;

    const igrachiHtml = igrachi.map((igrach, index) => {
        return <tr>
            <td>{index+1}</td>
            <td>{igrach[0]}</td>
            <td>{igrach[1]}</td>
            <td>{igrach[2]}</td>
        </tr>
    });

    if(igrachi.length <= 0) return <span/>

    return (
        <div className="col-sm-9 mt-5"
             style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>

            <Table striped bordered hover variant="dark">
                <thead className="fixed">
                <tr className="text-primary">
                    <th>#</th>
                    <th>Име</th>
                    <th>Презиме</th>
                    <th>Мечеви</th>
                </tr>
                </thead>
                <tbody>
                    {igrachiHtml}
                </tbody>
            </Table>

        </div>
    );
};

export default Igrachi;