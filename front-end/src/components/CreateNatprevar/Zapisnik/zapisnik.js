import React from 'react';
import Mech from "./Mech/mech";

const Zapisnik = (props) => {

    let {howMany} = props;
    let {mechevi} = props;

    let mecheviHtml = [];
    for(let i=0; i<mechevi.length; i++){
        mecheviHtml.push(<Mech mech={mechevi[i]}/>);
    }

    mecheviHtml.push(<Mech mech={null}/>);


    return (
        <div>
            <table id="natprevar_data" className="table table-bordered">
                <thead>
                <tr>
                    <th colSpan="3" className="text-center">Екипа 1 - Домаќин</th>
                    <th colSpan="3" className="text-center">Екипа 2 - Гостин</th>
                    <th colSpan="5" className="text-center">РЕЗУЛТАТ ПО СЕТОВИ</th>
                    <th colSpan="" rowSpan="2" className="text-center">КОНЕЧЕН</th>
                    <th className="invisible"/>
                </tr>
                <tr>
                    <td colSpan="3" className="text-center">ABC</td>
                    <td colSpan="3" className="text-center">XYZ</td>
                    <td className="text-center">I</td>
                    <td className="text-center">II</td>
                    <td className="text-center">III</td>
                    <td className="text-center">IV</td>
                    <td className="text-center">V</td>
                    <td className="invisible"/>
                    <td className="invisible"/>
                </tr>
                </thead>
                <tbody>
                {mecheviHtml}
                </tbody>
            </table>
            <div className="row">
                <div className="col-sm-11"/>
                <div className="col-sm text-right">
                    <button className="btn btn-success btn-block">Внеси</button>
                </div>
            </div>
        </div>
    );
};

export default Zapisnik;