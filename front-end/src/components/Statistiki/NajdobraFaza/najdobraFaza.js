import React, {Component} from 'react';
import Stats from "../../../service/statsService";
import Igrachi from "./Igrachi/igrachi";
import IgrachUspeh from "./IgrachUspeh/igrachUspeh";

class NajdobraFaza extends Component {

    constructor(props){
        super(props);
        this.state = {};
        this.state = {turniri : [], ima : -1};
    }

    showFazi = (idIgrach) => {
        Stats.najdobraFazaZaIgrach(idIgrach)
            .then(response => {
                this.setState({turniri : response.data, ima : 0});
            })
            .catch();
    };


    render() {
        return (
            <div className="col-sm-9 text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     maxHeight: "93vh",
                     opacity: ".9"}}>
                <Igrachi setIgrach={this.showFazi}/>
                <div className="bg-dark">
                    <IgrachUspeh turniri={this.state.turniri} ima={this.state.ima}/>
                </div>
            </div>
        );
    }
}

export default NajdobraFaza;