import React, {useEffect} from "react";
import Faza from "./Faza/faza";


const Turnir = (props) => {

    let faziHtml = props.fazi.map(faza => {
         return <Faza faza={faza}/>;
    });

    if(faziHtml.length === 0) return <span/>;

    return (
        <div className="col-sm-9 text-primary text-left pt-5 pb-5"
             style={{ borderRight: "1px black solid",
                        maxHeight: "93vh",
                        overflow: "auto",
                        opacity: ".9"}}>
            {faziHtml}
        </div>
);


};

export default Turnir