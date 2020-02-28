import React, {Component} from 'react';
import Zapisnik from "./Zapisnik/zapisnik";
import Turniri from "../../service/turniriService";
import Ligi from "../../service/ligiService";
import Sali from "../../service/saliService";
import Gradovi from "../../service/gradoviService";
import Dropdown from "react-bootstrap/Dropdown";
import {CustomMenu, CustomToggle} from "./CustomDropdown/customDropdown";

class CreateNatprevar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showZapisnik: false,
            generalInfo: false, // da se klade na site kontroli
            sezoni: []
        }

    }

    prodolzi = () => {

        // validacii

        this.setState({
            showZapisnik: true
        });

    };

    componentDidMount() {

        Turniri.getAllSezoni().then(response => {
            this.setState({
                sezoni: response.data
            });
        }).catch();

    }

    sezoniDropdown = () => {
        return <Dropdown>
            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
                Избери сезона
            </Dropdown.Toggle>

            <Dropdown.Menu as={CustomMenu}>
                <Dropdown.Item eventKey="1">Red</Dropdown.Item>
                <Dropdown.Item eventKey="2">Blue</Dropdown.Item>
                <Dropdown.Item eventKey="3" active>
                    Orange
                </Dropdown.Item>
                <Dropdown.Item eventKey="1">Red-Orange</Dropdown.Item>
            </Dropdown.Menu>
        </Dropdown>
    };

    render() {

        // sezoni

        //

        // site ligi (od sezonata)

        // Ligi.getAllLigi(idSezona).then().catch();

        // timovi od taa liga i sezona (posle izborot na liga i sezona)

        //Ligi.getAllTimoviInLiga(idSezona, idLiga).then().catch();

        // site sali

        //Sali.getAllSali().then().catch();

        // site gradovi

        //Gradovi.getAllGradovi().then().catch();


        let zapisnik = null;
        if(this.state.showZapisnik)
            zapisnik = <Zapisnik mechevi={[]}/>;

        return (
            <div className="container bg-dark text-primary text-left pt-5 pb-5" style={{opacity: ".9"}}>

                <h1 className="text-center">ЗАПИСНИК</h1>
                <hr/>
                <div className="row">

                    <div className="col-sm-3" />
                    <div className="col-sm-6 text-center">
                        Сезона:
                        {this.sezoniDropdown()}
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
                <br/>
                <div className="row">
                    <div className="col-sm-3"/>
                    <div className="col-sm-6">
                        <button className="btn btn-primary text-white btn-block" onClick={this.prodolzi}>Продолжи</button>
                    </div>
                </div>
                <br/><br/>
                {zapisnik}
            </div>
        );
    }
}

export default CreateNatprevar;