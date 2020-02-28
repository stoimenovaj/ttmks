import React from 'react';
import {Link} from "react-router-dom";

const IzborStatistiki = (props) => {

    // let statistikiHtml = <input id={ind + "" + index} type="radio" name="item" />;


    return (
        <div className="col-sm-3 bg-dark text-primary text-left pt-5 pb-5"
             style={{ borderRight: "1px black solid",
                 maxHeight: "80vh",
                 overflow: "auto",
                 opacity: ".9"}}>
            <div className="bg-light p-3 text-center rounded">
                <Link to={"/statistiki/srekjna-sala"}>Среќна сала</Link>
            </div>
        </div>
    );
};

export default IzborStatistiki;