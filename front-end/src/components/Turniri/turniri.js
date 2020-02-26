import React from "react";
import Sezoni from "./Sezoni/sezoni";
import Turnir from "./Turnir/turnir";
import Turnirii from "../../service/turniriService";


class Turniri extends React.Component {

    constructor (props){
        super(props);

        this.state = {};
        this.state.idKategorija = -1;
        this.state.idTurnir = -1;
    }

    componentDidMount = () => {
        let final = [];

        Turnirii.getAllSezoni()
            .then(response => {
                let sez = response.data;
                for (let i = 0; i < sez.length; ++i) {
                    Turnirii.getTurniriForSezona(sez[i].idSezona)
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
                <Sezoni sezoniTurniri={this.state.sezoniTurniri}  />
                <Turnir />
            </div>
        )   
    }
};

export default Turniri