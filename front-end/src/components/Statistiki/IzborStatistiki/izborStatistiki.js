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
                <hr/>
                <Link to={"/statistiki/tim-natprevari-stats"}>Статистики за тим</Link>
                <hr />
                <Link to={"/statistiki/tim-domakjin"}>Одиграни натпревари во градот на основање</Link>
                <hr />
                <Link to={"/statistiki/najdobra-faza"}>Најголем успех на турнир за играч</Link>
                <hr />
                <Link to={"/statistiki/kategorija-pobednici"}>Победници од турнири во категорија</Link>
            </div>
        </div>
    );
};

export default IzborStatistiki;