import React from 'react';

const Stats = (props) => {

    if (props.ima === -1) return <span />

    let statsHtml = props.timStats.map((st, index) => {
        return <h1 className="display-4 text-white">
            Овој тим има {st[1]} победени и {st[2]} изгубени натпревари од вкупно {st[0]}
        </h1>
    });

    return (
        <div className="mt-5 text-center"
             style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
            {statsHtml}
        </div>
    );
};

export default Stats;