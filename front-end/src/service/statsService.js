import apiUtils from "../util/apiUtils";


const Stats = {

    getSrekjnaSala: (idTim) => {
        return apiUtils.get("/timovi/"+idTim+"/srekjna-sala");
    },

    statsNatprevariZaTim: (idTim) => {
        return apiUtils.get("/timovi/"+idTim+"/tim-natprevari-stats");
    }

};

export default Stats;