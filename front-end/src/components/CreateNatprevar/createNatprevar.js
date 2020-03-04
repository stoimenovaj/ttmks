import React, {Component} from 'react';
import Zapisnik from "./Zapisnik/zapisnik";
import GeneralDataNatprevar from "./GenralDataNatprevar/generalDataNatprevar";
import TimoviService from "../../service/timoviService";
import Natprevari from "../../service/natprevariService";
import {withRouter} from "react-router";

class CreateNatprevar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showZapisnik: false,
            domakjini: [],
            gosti: [],
            natprevarId: -1,
            mechevi: []
        }

    }

    showZapisnik = (domakjinId, gostinId, natprevarId) => {

        // get igrachi of timovi

        TimoviService.getIgrachiFromTim(domakjinId)
            .then(response => {
                this.setState({
                    domakjini: response.data
                })
            });

        TimoviService.getIgrachiFromTim(gostinId)
            .then(response => {
                this.setState({
                    gosti: response.data
                })
            });

        this.setState({
            showZapisnik: true,
            natprevarId: natprevarId
        });
    };

    addMech = (mech) => {
        this.setState((prevState) => {
            return {
                mechevi: [...prevState.mechevi, mech]
            }
        });
    };

    sendMechevi = () => {
        // validacii



        // sent to API
        for(let i=0; i<this.state.mechevi.length; i++){
            console.log(this.state.natprevarId);
            Natprevari.createMech(this.state.mechevi[i], this.state.natprevarId)
                .then(response => {
                    console.log(response.data);
                }).catch(err => {
            })
        }

        this.props.history.push("/turniri");
    };

    render() {

        let zapisnik = null;
        if(this.state.showZapisnik)
            zapisnik = <Zapisnik mechevi={this.state.mechevi}
                                 domakjini={this.state.domakjini}
                                 gosti={this.state.gosti}
                                 addMech={this.addMech}
                                 sendMechevi={this.sendMechevi}/>;

        return (
            <div className="container-fluid bg-dark text-primary text-left pt-5 pb-5" style={{opacity: ".9"}}>
                <h1 className="text-center">ЗАПИСНИК</h1>
                <hr/>
                <GeneralDataNatprevar showZapisnik={this.showZapisnik} disable={this.state.showZapisnik}/>
                <br/>
                <br/>
                <br/>
                {zapisnik}
            </div>
        );
    }
}

export default withRouter(CreateNatprevar);