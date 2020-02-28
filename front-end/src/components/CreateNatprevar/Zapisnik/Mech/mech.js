import React, {useState} from 'react';
import Igrachi from "./Igrach/Igrachi";
import bootbox from 'bootbox'

const Mech = (props) => {

    let [newMech, setNewMech] = useState({
        domakjinId: -1,
        gostinId: -1,
        set1: {
            domakjin: -1,
            gostin: -1
        },
        set2: {
            domakjin: -1,
            gostin: -1
        },
        set3: {
            domakjin: -1,
            gostin: -1
        },
        set4: {
            domakjin: -1,
            gostin: -1
        },
        set5: {
            domakjin: -1,
            gostin: -1
        },
        domakjinSetovi: -1,
        gostinSetovi: -1
    });

    const handlePotvrdi = () => {
        // validacii

        let setovi = [newMech.set1, newMech.set2, newMech.set3, newMech.set4, newMech.set5];
        setovi = setovi.filter(set => set.domakjin === 11 || set.gostin === 11);
        let pobediDomakjin = setovi.filter(set => set.domakjin > set.gostin).length;
        let pobediGostin = setovi.filter(set => set.gostin > set.domakjin).length;

        if(setovi.length < 3){
            bootbox.alert('Не се внесени доволно мечеви');
            return;
        }

        if(newMech.domakjinId === -1){
            bootbox.alert('Не е избран домаќин');
            return;
        }

        if(newMech.gostinId === -1){
            bootbox.alert('Не се избран гостин');
            return;
        }

        if(pobediDomakjin !== 3 && pobediGostin !== 3){
            bootbox.alert('Не се внесени доволно мечеви');
            return;
        }


        let mech = {
            domakjinId: newMech.domakjinId,
            gostinId: newMech.gostinId,
            setovi: setovi,
            domakjinSetovi: pobediDomakjin,
            gostinSetovi: pobediGostin
        };

        props.addMech(mech);
    };

    const addDomakjin = (domakjinId) => {
        setNewMech(prevState => {
            let obj = prevState;
            obj['domakjinId'] = domakjinId;
            return obj;
        });
    };

    const addGostin = (gostinId) => {
        setNewMech(prevState => {
            let obj = prevState;
            obj['gostinId'] = gostinId;
            return obj;
        });
    };

    const set1d = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set1'].domakjin = parseInt(e.target.value);
            return obj;
        });
    };

    const set2d = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set2'].domakjin = parseInt(e.target.value);
            return obj;
        });
    };

    const set3d = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set3'].domakjin = parseInt(e.target.value);
            return obj;
        });
    };

    const set4d = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set4'].domakjin = parseInt(e.target.value);
            return obj;
        });
    };

    const set5d = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set5'].domakjin = parseInt(e.target.value);
            return obj;
        });
    };

    const set1g = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set1'].gostin = parseInt(e.target.value);
            return obj;
        });
    };

    const set2g = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set2'].gostin = parseInt(e.target.value);
            return obj;
        });
    };

    const set3g = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set3'].gostin = parseInt(e.target.value);
            return obj;
        });
    };

    const set4g = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set4'].gostin = parseInt(e.target.value);
            return obj;
        });
    };

    const set5g = (e) => {
        setNewMech((prevState) => {
            let obj = prevState;
            obj['set5'].gostin = parseInt(e.target.value);
            return obj;
        });
    };


    let {mech} = props;

    let disabled = mech !== null;

    let input1;
    let input2;
    if(disabled){
        input1 = <input type="number" style={{width: "44%"}} value={mech.domakjinSetovi}
                            className="form-control d-inline-block" min="0"
                            max="11" disabled={true}/>;
        input2 = <input type="number" style={{width: "44%"}} value={mech.gostinSetovi}
                            className="form-control d-inline-block" min="0"
                            max="11" disabled={true}/>
    }else{
        input1 = <input type="number" style={{width: "44%"}}
                       className="form-control d-inline-block" min="0"
                       max="11" disabled={true}/>;
        input2 = <input type="number" style={{width: "44%"}}
                        className="form-control d-inline-block" min="0"
                        max="11" disabled={true}/>;
    }

    return (

            <tr>
                <td colSpan="3" className="text-center">
                    <div className="row">
                        <div className="col-sm-1">
                            <b>A</b>
                        </div>
                        <div className="col-sm">
                            <Igrachi disabled={disabled} igrachi={props.domakjini} addIgrach={addDomakjin}/>
                        </div>
                    </div>
                </td>
                <td colSpan="3" className="text-center">
                    <div className="row">
                        <div className="col-sm-1">
                            <b>B</b>
                        </div>
                        <div className="col-sm">
                            <Igrachi disabled={disabled} igrachi={props.gosti} addIgrach={addGostin}/>
                        </div>
                    </div>
                </td>
                <td className="text-center">
                    <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                           min="0" max="11" disabled={disabled} onChange={set1d}/>:
                    <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                           min="0" max="11" disabled={disabled} onChange={set1g}/>
                </td>
                <td className="text-center">
                    <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                           min="0" max="11" disabled={disabled} onChange={set2d}/>:
                    <input type="number" style={{width: "44%"}} className="form-control d-inline-block"
                           min="0" max="11" disabled={disabled} onChange={set2g}/>
                </td>
                <td className="text-center">
                    <input type="number" style={{width: "44%"}} onChange={set3d}
                           className="form-control d-inline-block" min="0" max="11" disabled={disabled}/>:
                    <input type="number" style={{width: "44%"}} onChange={set3g}
                           className="form-control d-inline-block" min="0" max="11" disabled={disabled}/>
                </td>
                <td className="text-center">
                    <input type="number" style={{width: "44%"}} onChange={set4d}
                           className="form-control d-inline-block" min="0"
                           max="11" disabled={disabled}/>:
                    <input type="number" style={{width: "44%"}} onChange={set4g}
                           className="form-control d-inline-block" min="0"
                           max="11" disabled={disabled}/>
                </td>
                <td className="text-center">
                    <input type="number" style={{width: "44%"}} onChange={set5d}
                           className="form-control d-inline-block" min="0"
                           max="11" disabled={disabled}/>:
                    <input type="number" style={{width: "44%"}} onChange={set5g}
                           className="form-control d-inline-block" min="0"
                           max="11" disabled={disabled}/>
                </td>
                <td className="text-center">
                    {input1}:{input2}
                </td>
                <td className="text-center"><button type="button" disabled={disabled}
                                                   className={"form-control"}
                                                    onClick={handlePotvrdi}>потврди</button></td>
            </tr>
    );
};

export default Mech;