import apiUtils from "../util/apiUtils";


const Stats = {

    getSrekjnaSala: (idTim) => {
        return apiUtils.get("/timovi/"+idTim+"/srekjna-sala");
    }

};

export default Stats;