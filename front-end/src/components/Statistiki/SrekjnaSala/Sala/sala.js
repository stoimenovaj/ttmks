import React from 'react';

const Sala = (props) => {

    if (props.ima === -1) return <span />
    else if (props.showSali.length <= 0) return <div className="mt-5 text-center"
                                                     style={{opacity: ".9", maxHeight: "80vh", overflow: "auto"}}>
        <h1 className="display-4 text-white">
            Овој тим нема среќни сали!
        </h1>
    </div>

    let saliHtml = props.showSali.map((sala, index) => {
        return <h1 className="display-4 text-white">
            {sala[0]} - {sala[1]}
        </h1>
    });

    return (
        <div className="mt-5 text-center"
             style={{opacity: ".9", maxHeight: "80vh"}}>
            {saliHtml}
        </div>
    );
};

export default Sala;