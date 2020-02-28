import React, {Component} from 'react';
import Stats from "../../../service/statsService"
import Kategorii from "./Kategorii/kategorii";
import Pobednici from "./Pobednici/pobednici";

class KategorijaPobednici extends Component {

    constructor(props){
        super(props);

        this.state = {};
         this.state = {igrachi : [], ima : -1};

    }

    showKategorija = (idKategorija) => {
        Stats.pobedniciVoKategorija(idKategorija)
            .then(response => {
                this.setState({igrachi : response.data, ima : 0});
            })
            .catch();
    };

    render() {
        return (
            <div className="col-sm-9 text-primary text-left pt-5 pb-5"
                 style={{ borderRight: "1px black solid",
                     maxHeight: "93vh",
                     opacity: ".9"}}>
                <Kategorii pobednici={this.showKategorija}/>
                <div className="bg-dark">
                    <Pobednici igrachi={this.state.igrachi} ima={this.state.ima} />
                </div>
            </div>
        );
    }
}

export default KategorijaPobednici;