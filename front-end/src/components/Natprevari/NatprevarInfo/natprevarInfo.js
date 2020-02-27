import React from 'react';
import TopLista from "./TopLista/topLista";
import Kola from "./Kola/kola";

const NatprevarInfo = (props) => {

    console.log(props.natprevari);

    return (
        <div className="col-sm-9 mt-5"
             style={{opacity: ".9", maxHeight: "80vh"}}>
            <TopLista topLista={props.topLista}/>
            <Kola natprevari={props.natprevari}/>
        </div>
    );
};

export default NatprevarInfo;