import React from 'react';

const Mech = (props) => {

    let {mech} = props;

    let disabled = mech !== null;

    return (
        <tr>
            <td colSpan="3" className="text-center">
                <div className="row">
                    <div className="col-sm-1">
                        <b>A</b>
                    </div>
                    <div className="col-sm">
                        <input className="form-control" type="text" disabled={disabled}/>
                    </div>
                </div>
            </td>
            <td colSpan="3" className="text-center">
                <div className="row">
                    <div className="col-sm-1">
                        <b>B</b>
                    </div>
                    <div className="col-sm">
                        <input className="form-control" type="text" disabled={disabled}/>
                    </div>
                </div>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                       min="0" max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                       min="0" max="1000" disabled={disabled}/>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                       min="0" max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                       min="0" max="1000" disabled={disabled}/>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0" max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0" max="1000" disabled={disabled}/>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>
            </td>
            <td className="text-center">
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>:
                <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="1000" disabled={disabled}/>
            </td>
            <td className="text-center"><input type="checkbox" disabled={disabled}/>edit</td>
        </tr>
    );
};

export default Mech;