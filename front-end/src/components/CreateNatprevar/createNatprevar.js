import React, {Component} from 'react';
import Zapisnik from "./Zapisnik/zapisnik";
import Turniri from "../../service/turniriService";
import Ligi from "../../service/ligiService";
import Sali from "../../service/saliService";
import Gradovi from "../../service/gradoviService";

class CreateNatprevar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showZapisnik: false
        }

    }

    render() {

        // sezoni

        Turniri.getAllSezoni().then().catch();

        // site ligi (od sezonata)

        Ligi.getAllLigi(idSezona).then().catch();

        // timovi od taa liga i sezona (posle izborot na liga i sezona)

        Ligi.getAllTimoviInLiga(idSezona, idLiga).then().catch();

        // site sali

        Sali.getAllSali().then().catch();

        // site gradovi

        Gradovi.getAllGradovi().then().catch();



        let zapisnik = null;
        if(this.state.showZapisnik)
            zapisnik = <Zapisnik/>;

        return (
            <div className="container-fluid bg-dark text-primary text-left pt-5 pb-5">

                <h1 className="text-center">ЗАПИСНИК</h1>
                <br/>
                <div className="row">
                    <div className="col-sm-6 text-center">
                        <div className="col">
                            <div>од одиграниот натпревар како дел од
                                <input type="text" className="form-control text-center"
                                       placeholder="Prva liga/Prijatelski"/>
                                натпревар помеѓу:
                                <br/>
                                <input type="text" className="form-control text-center"
                                       placeholder="Избери го домаќинот"/>
                                и
                                <input type="text" className="form-control text-center"
                                       placeholder="Избери го гостинот"/>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-6">
                        <div className="row">
                            <div className="col-sm-6">
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Сезона:
                                        <input className="form-control" type="text" placeholder="asdf"/>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Лига:
                                        <input type="text" className="form-control" placeholder="asdf"/>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Град:
                                        <input type="text" className="form-control" placeholder="asdf"/>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6">
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Сала:
                                        <input type="text" className="form-control" placeholder="asdf"/>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Датум:
                                        <input type="text" className="form-control" placeholder="asdf"/>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col-sm text-center">
                                        Коло:
                                        <input type="text" className="form-control" placeholder="asdf"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br/><br/>
                <div className="row">
                    <div className="col-sm-11"/>
                    <div className="col-sm-1 text-right">
                        <button className="btn btn-success btn-block">Продолжи</button>
                    </div>
                </div>
                <br/><br/>
                {zapisnik}
            </div>
        );
    }
}

export default CreateNatprevar;