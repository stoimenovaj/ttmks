import React from 'react';

const Pobedi = (props) => {

    if (props.ima === -1) return <span />;

    return (
        <div className="mt-5 text-center"
             style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
            <h1 className="text-center display-4">
                Овој тим во градот во кој е основан има вкупно <b className="display-1">{props.pobedi}</b> pobedi
            </h1>
        </div>
    );
};

export default Pobedi;