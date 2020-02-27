import React, {Component} from 'react';
import Sezoni from "../Timovi/Sezoni/sezoni";
import Turnirii from "../../service/turniriService";
import LS from "../../service/ligiService"
import T from "../../service/timoviService";
import Igrachi from "./Igrachi/igrachi";

class Timovi extends Component {

    constructor(props){
        super(props)
        this.state = {
            ligiWithTimovi : [],
            sezoni : [],
            sezona : 0,
            liga : 0,
            igrachi : []
        }
    }

    componentDidMount = () => {
        let final = [];

        Turnirii.getAllSezoni()
            .then(response => {
                this.setState({sezoni: response.data});
            })
            .catch();
    };

    showSezona = (idSezona) => {
        LS.getAllLigiWithTimovi(idSezona)
            .then(response => {
                this.setState({
                    ligiWithTimovi : response.data,
                    sezona : idSezona
                })
            })
            .catch();
    };

    showIgrachiMechevi = (idTim, idSezona, idLiga) =>{
        T.getIgrachiMechevi(idTim, idSezona, idLiga)
            .then(response => {
                this.setState({igrachi : response.data})
            })
            .catch();
    };

    render() {
        return (
            <div className="row" style={{height: "100%", marginTop: "-16px"}}>
                <Sezoni idsezona={this.state.sezona} showIgrachiMechevi={this.showIgrachiMechevi} showSezona={this.showSezona} getSezoni={this.state.sezoni} ligi={this.state.ligiWithTimovi}/>
                <Igrachi igrachi={this.state.igrachi}/>
            </div>
        );
    }
}

export default Timovi;