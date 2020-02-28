import React from 'react';

const Pobednici = (props) => {

    if (props.ima === -1) return <span />
    else if (props.igrachi.length <= 0) return <div className="mt-5 text-center"
                                                    style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
        <h1 className="display-4 text-white">
            Од оваа категорија нема победници!
        </h1>
    </div>;

    let igrachiHtml = props.igrachi.map((info, index) => {
        return <h1 className="display-4 text-white">
            <b>{info[1]} {info[2]}</b> - {info[0]}
        </h1>
    });

    return (
        <div className="mt-5 text-center"
             style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
            {igrachiHtml}
        </div>
    );
};

export default Pobednici;