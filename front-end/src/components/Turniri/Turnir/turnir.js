import React from "react";

const Turnir = (props) => {

    let turnir = props.turnir;
    // proveruvame turnir.kategorija bidejkji pochetniot state e prazen objekt i samo so 'turnir' bi pominalo
    if(turnir.kategorija){
        console.log(turnir.imeTurnir)
        return (
            <div className="col-sm-9">
                <h1>{turnir.imeTurnir}
                {/*{turnir.kategorija.idKategorija}*/}
                </h1>

            </div>
        )
    }
    return <span/>


};

export default Turnir