import React from "react";
import Sezoni from "./Sezoni/sezoni";
import Turnir from "./Turnir/turnir";
import TurniriService from "../../service/turniriService";
import {generateGracketMech, getPrevMech, noMoreFazi} from "../../util/gracketUtils";



class Turniri extends React.Component {

    constructor (props){
        super(props);

        this.state = {};
        this.state.idKategorija = -1;
        this.state.idTurnir = -1;
        this.state.currentTurnir = {};
        this.state.fazi = [];
    }

    prikazhiTurnir = (idTurnir, idKategoirja) => {
        // TO DO: HERE
        TurniriService.getFaziForTurnir(idTurnir, idKategoirja)
            .then(response => {
                this.setState({
                    fazi: response.data
                });
            }).catch();
    };

    componentDidMount = () => {
        let final = [];

        TurniriService.getAllSezoni()
            .then(response => {
                let sez = response.data;
                for (let i = 0; i < sez.length; ++i) {
                    TurniriService.getTurniriForSezona(sez[i].idSezona)
                        .then(response2 => {
                            let allTurniri = response2.data;
                            let obj = {
                                sezona: sez[i],
                                turniri: allTurniri
                            };
                            final.push(obj);
                            this.setState({sezoniTurniri: final});
                        })
                        .catch();
                }
            }).catch();
    };

    render() {
        return (
            <div className="row" style={{height: "100%", marginTop: "-16px"}}>
                <Sezoni sezoniTurniri={this.state.sezoniTurniri} prikazhiTurnir={this.prikazhiTurnir} />
                <Turnir fazi={this.state.fazi} />
            </div>
        )   
    }
};

export default Turniri