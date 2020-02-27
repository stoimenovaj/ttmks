import React from 'react';
import Mech from "../Mech/mech";

const Faza = (props) => {

    console.log(props.faza);

    let mecheviHtml = props.faza.mechevi.map(mech => {
        return <Mech mech={mech}/>;
    });

    return (
        <table id="natprevar_data" className="table table-bordered text-primary table-dark">
            <thead>
            <tr>
                <th colSpan="6" className="">{props.faza.opis}</th>
                <th colSpan="5" className="text-center">РЕЗУЛТАТ ПО СЕТОВИ</th>
                <th colSpan="2" className="invisible"/>
            </tr>
            <tr>
                <th colSpan="3" className="text-center">Играч 1</th>
                <th colSpan="3" className="text-center">Играч 2</th>
                <td className="text-center">I</td>
                <td className="text-center">II</td>
                <td className="text-center">III</td>
                <td className="text-center">IV</td>
                <td className="text-center">V</td>
                <th colSpan="" rowSpan="2" className="text-center">КОНЕЧЕН</th>
            </tr>
            </thead>
            <tbody>
                {mecheviHtml}
            </tbody>
        </table>
    );
};

export default Faza;