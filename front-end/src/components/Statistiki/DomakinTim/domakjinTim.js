import React, {Component} from 'react';
import SS from "../../../service/statsService";
import Timovi from "./Timovi/timovi";
import Pobedi from "./Pobedi/pobedi";

class DomakjinTim extends Component {

    constructor(props){
        super(props);

        this.state = {pobedi: [], ima:-1};
    }

    showPobediVoGradOsnovan = (idTim) => {
        SS.pobediVoGradOsnovan(idTim)
            .then(response => {
                this.setState({pobedi : response.data, ima: 0});
            })
            .catch();
    };

    render() {
        return (
            <div className="col-sm-9 text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     maxHeight: "93vh",
                     opacity: ".9"}}>
                <Timovi pobedi={this.showPobediVoGradOsnovan} />
                <div className="bg-dark">
                    <Pobedi pobedi={this.state.pobedi} ima={this.state.ima} />
                </div>
            </div>
        );
    }
}

export default DomakjinTim;