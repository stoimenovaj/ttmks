import React, {Component} from 'react';
import Zapisnik from "./Zapisnik/zapisnik";
import GeneralDataNatprevar from "./GenralDataNatprevar/generalDataNatprevar";
import {CustomMenu, CustomToggle} from "./CustomDropdown/customDropdown";

class CreateNatprevar extends Component {

    constructor(props) {
        super(props);

        this.state = {
            showZapisnik: false,
            domakjinId: -1,
            gostinId: -1,
            natprevarId: -1
        }

    }

    showZapisnik = (domakjinId, gostinId, natprevarId) => {
        this.setState({
            showZapisnik: true,
            domakjinId: domakjinId,
            gostinId: gostinId,
            natprevarId: natprevarId
        });
    };

    render() {

        let zapisnik = null;
        if(this.state.showZapisnik)
            zapisnik = <Zapisnik mechevi={[]}/>;

        return (
            <div className="container bg-dark text-primary text-left pt-5 pb-5" style={{opacity: ".9"}}>
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

export default CreateNatprevar;