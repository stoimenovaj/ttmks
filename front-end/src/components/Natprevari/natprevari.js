import React, {Component} from 'react';
import Turnirii from "../../service/turniriService";
import Sezona from "../Natprevari/Sezona/sezona"
import NatprevarInfo from "./NatprevarInfo/natprevarInfo";
import NS from "../../service/natprevariService"


class Natprevari extends Component {

    constructor(props){
        super(props);

        this.state = {
            sezoni : [],
            sezona : 0,
            liga : 0,
            natprevari : [],
            topLista : []
        }
    }

    componentDidMount = () => {
        let final = [];

        Turnirii.getAllSezoni()
            .then(response => {
                let sezoni = response.data;
                for(let i = 0; i < sezoni.length; ++i){
                    Turnirii.getLigiForSezona(sezoni[i].idSezona)
                        .then(response2 => {
                            let ligi = response2.data;
                            final.push({sezona: sezoni[i], ligi: ligi});
                            this.setState({sezoni : final})
                        })
                        .catch();
                }
            })
            .catch();
    };

    showNatprevarInfo = (idSezona, idLiga) => {

        NS.getAllSezoni(idSezona, idLiga)
            .then(response => {
                this.setState({natprevari : response.data});
            })
            .catch();

        NS.gettopLista(idSezona, idLiga)
            .then(response => {
                this.setState({topLista : response.data});
            })
            .catch();
    };


    render() {
        return (
            <div className="row" style={{height: "100%", marginTop: "-16px"}}>
                <Sezona getSezoni={this.state.sezoni} showInfo={this.showNatprevarInfo}/>
                <NatprevarInfo natprevari={this.state.natprevari} topLista={this.state.topLista} />
            </div>
        );
    }
}

export default Natprevari;