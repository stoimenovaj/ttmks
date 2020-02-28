import React, {Component} from 'react';
import IzborStatistiki from "./IzborStatistiki/izborStatistiki";
import {Route, Switch} from "react-router";
import SrekjnaSala from "./SrekjnaSala/srekjnaSala";
import StatsNatprevarZaTim from "./StatsNatprevariZaTim/statsNatprevarZaTim";

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
                </Switch>
            </div>
        );
    }
}

export default Statistiki;