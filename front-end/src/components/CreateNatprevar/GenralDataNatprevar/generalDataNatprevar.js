import React, {Component} from 'react';
import Sezoni from "./Sezoni/sezoni";
import LigiService from "../../../service/ligiService";
import Ligi from "./Ligi/ligi";
import Gradovi from "./Gradovi/gradovi";
import SaliService from "../../../service/saliService";
import Sali from "./Sali/sali";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Tim from "./Tim/tim";
import Timovi from "../../../service/timoviService";
import Natprevari from "../../../service/natprevariService";
import bootbox from 'bootbox';

class GeneralDataNatprevar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            selectedSezona: -1,
            ligi: [],
            selectedLiga: {imeLiga: 'Избери лига', idLiga: -1},
            selectedGrad: -1,
            sali: [],
            selectedSala: {imeSala: 'Избери сала', idSala: -1},
            kolo: -1,
            selectedDate: new Date(),
            timovi: [],
            domakjin: -1,
            gostin: -1
        }

    }

    saveSezona = (idSezona) => {
        LigiService.getAllLigi(idSezona)
            .then(response => {
                this.setState({
                    ligi: response.data,
                    selectedSezona: idSezona,
                    selectedLiga: {imeLiga: 'Избери лига', idLiga: -1}
                })
            }).catch();
    };

    saveLiga = (idLiga, imeLiga) => {
        this.setState({
            selectedLiga: {imeLiga: imeLiga, idLiga: idLiga}
        });
    };

    saveGrad = (idGrad) => {
        SaliService.getSaliFromGrad(idGrad)
            .then(response => {
                this.setState({
                    selectedGrad: idGrad,
                    sali: response.data,
                    selectedSala: {imeSala: 'Избери сала', idSala: -1}
                });
            });
    };

    saveSala = (idSala, imeSala) => {
        this.setState({
            selectedSala: {imeSala: imeSala, idSala: idSala}
        })
    };

    saveKolo = (e) => {
        this.setState({
            kolo: e.target.value
        });
    };

    saveDate = (date) => {
        this.setState({
            selectedDate: date
        })
    };

    saveDomakjin = (idTim) => {
        this.setState({
            domakjin: idTim
        })
    };

    saveGostin = (idTim) => {
        this.setState({
            gostin: idTim
        });
    };

    componentDidMount() {
        Timovi.getAllTimoviDto()
            .then(response => {
                this.setState({
                    timovi: response.data
                });
            });
    }

    prodolzi = () => {

        // validacija

        if(this.state.selectedSezona === -1){
            bootbox.alert('Внесете сезона');
            return;
        }

        if(this.state.selectedLiga.idLiga === -1){
            bootbox.alert('Внесете лига');
            return;
        }

        if(this.state.selectedSala.idSala === -1){
            bootbox.alert('Внесете сала');
            return;
        }

        if(this.state.kolo === -1){
            bootbox.alert('Внесете коло');
            return;
        }

        if(this.state.domakjin === -1){
            bootbox.alert('Внесете домаќин тим');
            return;
        }

        if(this.state.gostin === -1){
            bootbox.alert('Внесете гостин тим');
            return;
        }

        if(this.state.selectedDate >= new Date()){
            bootbox.alert('Внесете валиден датум');
            return;
        }

        if(this.state.domakjin === this.state.gostin){
            bootbox.alert('Внесете различни натпреварувачи');
            return;
        }

        let natprevar = {
            idSezona: this.state.selectedSezona,
            idLiga: this.state.selectedLiga.idLiga,
            dataOdigran: this.state.selectedDate,
            kolo: this.state.kolo,
            idTimDomakjin: this.state.domakjin,
            idTimGostin: this.state.gostin,
            idSalaOdrzuvanje: this.state.selectedSala.idSala
        };


        Natprevari.createNatprevar(natprevar)
            .then(response => {
                this.props.showZapisnik(this.state.domakjin, this.state.gostin, response.data.idNatprevar);
            })
            .catch();

    };


    render() {
        return (
            <div>
                <div className="row">

                    <div className="col-sm-3"/>
                    <div className="col-sm-6 text-center">
                        Сезона:
                        <Sezoni selectSezona={this.saveSezona} disabled={this.props.disable}/>
                        Лига (од селектираната сезона):
                        <Ligi ligi={this.state.ligi} changeLiga={this.saveLiga} selectedLiga={this.state.selectedLiga} disabled={this.props.disable}/>
                        Град:
                        <Gradovi selectGrad={this.saveGrad} disabled={this.props.disable}/>
                        Сала (од селектираниот град):
                        <Sali sali={this.state.sali} selectedSala={this.state.selectedSala} saveSala={this.saveSala} disabled={this.props.disable}/>
                        Датум:<br/>
                        <DatePicker selected={this.state.selectedDate} onChange={this.saveDate}
                                    className={"form-control"} disabled={this.props.disable}/><br/>
                        Коло:
                        <input className="form-control text-center" type="number" placeholder="Внесете коло"
                               onChange={this.saveKolo} disabled={this.props.disable}/>
                        <br/>
                        <div className="row">
                            <div className="col-sm-6">
                                <Tim timovi={this.state.timovi} saveTim={this.saveDomakjin}
                                     placeholder={"Избери домаќин тим"} disabled={this.props.disable}/>
                            </div>
                            <div className="col-sm-6">
                                <Tim timovi={this.state.timovi} saveTim={this.saveGostin}
                                     placeholder={"Избери Гостин тим"} disabled={this.props.disable}/>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm-3"/>
                    <div className="col-sm-6">
                        <button className="btn btn-primary text-white btn-block mt-2" onClick={this.prodolzi} disabled={this.props.disable}>Продолжи
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default GeneralDataNatprevar;