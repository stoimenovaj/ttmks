import React from 'react';

const IgrachUspeh = (props) => {

    if (props.ima === -1) return <span />
    else if (props.turniri.length <= 0) return <div className="mt-5 text-center"
                                                     style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
        <h1 className="display-4 text-white">
            Овој играч никогаш не бил во првите 64 играчи! ((:
        </h1>
    </div>;

    let turniriHtml = props.turniri.map((turnir, index) => {
        return <h1 className="display-4 text-white">
            <b>{turnir[1]}</b> - {turnir[0]}
        </h1>
    });

    return (
        <div className="mt-5 text-center"
             style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
            {turniriHtml}
        </div>
    );
};

export default IgrachUspeh;