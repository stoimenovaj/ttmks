import React, {Component} from 'react';
import Stats from "./Stats/stats";
import Timovi from "./Timovi/timovi"
import SS from "../../../service/statsService"

class StatsNatprevarZaTim extends Component {

    constructor(props){
        super(props);

        this.state = {stats: [], ima:-1};
    }

    showTimStats = (idTim) => {
        SS.statsNatprevariZaTim(idTim)
            .then(response => {
                this.setState({stats : response.data, ima: 0});
            })
            .catch();
    };

    render() {
        return (
            <div className="col-sm-9 text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     maxHeight: "93vh",
                     opacity: ".9"}}>
                <Timovi prikazhiStats={this.showTimStats}/>
                <div className="bg-dark">
                    <Stats timStats={this.state.stats} ima={this.state.ima} />
                </div>
            </div>
        );
    }
}

export default StatsNatprevarZaTim;