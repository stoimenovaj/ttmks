import React from "react";
import getData from "../../repository/testRepository";

const Sezona = () => {
    let sezoni = getData();

    let sezoniHtml = sezoni.map((sez,index) => {
        let btn = <button className={"accordion"}>{sez.name}</button>;
        let itemsHtml = sez.items.map((item,index) => {
            let radio;
            if(index === 0)
                radio =  <input type="radio" name="item" checked={"checked"}/>;
            else
               radio =  <input type="radio" name="item"/>;
            let label =  <label>{item}</label>;
            return <div key={index}>{radio}{label}</div>;
        });
        return <div key={index}>{btn}{itemsHtml}</div>;
    });

    return(

        <div className="col-sm-12 col-md-3 position-fixed  mt-2">
            {sezoniHtml}
        </div>


    )

};

export default Sezona;