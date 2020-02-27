import React from 'react';

const Zapisnik = (props) => {

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
                <tr>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>A</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>B</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center"><input type="checkbox"/>edit</td>
                </tr>
                <tr>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>C</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>D</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center"><input type="checkbox"/>edit</td>
                </tr>
                <tr>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>E</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>F</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>

                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center"><input type="checkbox"/>edit</td>
                </tr>
                <tr>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>G</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td colSpan="3" className="text-center">
                        <div className="row">
                            <div className="col-sm-1">
                                <b>H</b>
                            </div>
                            <div className="col-sm">
                                <input className="form-control" type="text"/>
                            </div>
                        </div>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                               min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0" max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>

                    <td className="text-center">
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}}
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center">
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>:
                        <input type="number" style={{width: "44%"}} disabled="true"
                               className="form-control d-inline-block" min="0"
                               max="1000"/>
                    </td>
                    <td className="text-center"><input type="checkbox"/>edit</td>
                </tr>
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