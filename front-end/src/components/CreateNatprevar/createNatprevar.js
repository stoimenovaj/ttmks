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

        // Ligi.getAllLigi(idSezona).then().catch();

        // timovi od taa liga i sezona (posle izborot na liga i sezona)

        // Ligi.getAllTimoviInLiga(idSezona, idLiga).then().catch();

        // site sali

        Sali.getAllSali().then().catch();

        // site gradovi

        Gradovi.getAllGradovi().then().catch();



        let zapisnik = null;
        if(this.state.showZapisnik)
            zapisnik = <Zapisnik/>;

        return (
            <div className="container bg-dark text-primary text-left pt-5 pb-5" style={{opacity: ".9"}}>

                <h1 className="text-center">ЗАПИСНИК</h1>
                <hr/>
                <div className="row">

                    <div className="col-sm-3" />
                    <div className="col-sm-6 text-center">
                        Сезона:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        Лига:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        Град:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        Сала:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        Датум:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        Коло:
                        <input className="form-control text-center" type="text" placeholder="asdf"/>
                        <br/>
                        <div className="row">
                            <div className="col-sm-6">
                                <input type="text" className="form-control text-center" placeholder="Избери го домаќинот"/>
                            </div>
                            <div className="col-sm-6">
                                <input type="text" className="form-control text-center" placeholder="Избери го гостинот"/>
                            </div>
                        </div>
                    </div>
                </div>
                <br/><br/>
                <div className="row">
                    <div className="col-sm-3"/>
                    <div className="col-sm-6">
                        <button className="btn btn-primary text-white btn-block">Продолжи</button>
                    </div>
                </div>
                <br/><br/>
                {zapisnik}
            </div>
        );
    }
}

export default CreateNatprevar;