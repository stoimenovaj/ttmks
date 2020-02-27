import React from 'react';

const Mech = (props) => {

    const {mech} = props;

    let setoviHtml = mech.setovi.map(set => {
        return (
            <td className="text-center">{set.domakjinPoeni}:{set.gostinPoeni}</td>
        );
    });

    let brSetovi = setoviHtml.length;

    while(brSetovi < 5){
        setoviHtml.push(<td>/</td>);
        brSetovi++;
    }

    return (
        <tr>
            <td colSpan="3" className="text-center">
                <div className="row">
                    <div className="col-sm-1">
                        <b>A</b>
                    </div>
                    <div className="col-sm">
                        {mech.domakjin.ime} {mech.domakjin.prezime}
                    </div>
                </div>
            </td>
            <td colSpan="3" className="text-center">
                <div className="row">
                    <div className="col-sm-1">
                        <b>B</b>
                    </div>
                    <div className="col-sm">
                        {mech.gostin.ime} {mech.gostin.prezime}
                    </div>
                </div>
            </td>
            {setoviHtml}
            <td className="text-center">{mech.domakjin.poeni}:{mech.gostin.poeni}</td>
        </tr>
    );
};

export default Mech;