import React, {useEffect, useState} from 'react'
import Timovi from "./Timovi/timovi";
import Sala from "./Sala/sala";
import Stats from "../../../service/statsService";

class SrekjnaSala extends React.Component {

    constructor(props) {
        super(props);

        this.state = {sali: [], ima:-1};

    }

    showSrekjnaSala = (idTim) => {
        Stats.getSrekjnaSala(idTim)
            .then(response => {
                this.setState({sali : response.data, ima: 0});
            })
            .catch();
    };


    render(){
        return (
            <div className="col-sm-9 text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     maxHeight: "93vh",
                     opacity: ".9"}}>
                    <Timovi showSali={this.showSrekjnaSala}/>
                <div className="bg-dark">
                    <Sala showSali={this.state.sali} ima={this.state.ima}/>
                </div>

            </div>
        );
    }
};

export default SrekjnaSala;