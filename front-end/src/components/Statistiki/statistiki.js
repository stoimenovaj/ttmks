import React, {Component} from 'react';
import IzborStatistiki from "./IzborStatistiki/izborStatistiki";
import {Route, Switch} from "react-router";
import SrekjnaSala from "./SrekjnaSala/srekjnaSala";
import StatsNatprevarZaTim from "./StatsNatprevariZaTim/statsNatprevarZaTim";
import DomakjinTim from "./DomakinTim/domakjinTim";
import NajdobraFaza from "./NajdobraFaza/najdobraFaza";

class Statistiki extends Component {
    render() {
        return (
            <div className="row" style={{height: "100%", marginTop: "-16px"}}>
                <IzborStatistiki/>
                <Switch>
                    <Route path={"/statistiki/srekjna-sala"} exact>
                        <SrekjnaSala />
                    </Route>
                    <Route path={"/statistiki/tim-natprevari-stats"} exact>
                        <StatsNatprevarZaTim />
                    </Route>
                    <Route path={"/statistiki/tim-domakjin"} exact>
                        <DomakjinTim />
                    </Route>
                    <Route path={"/statistiki/najdobra-faza"} exact>
                        <NajdobraFaza />
                    </Route>
                </Switch>
            </div>
        );
    }
}

export default Statistiki;