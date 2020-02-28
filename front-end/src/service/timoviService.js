import apiUtils from "../util/apiUtils";


const Timovi = {

    getIgrachiMechevi: (idTim, idSezona, idLiga) => {
        return apiUtils.get("/timovi/" + idTim + "/igrachi?idSezona=" + idSezona + "&idLiga=" + idLiga);
    }
    ,

    getAllTimovi: () => {
        return apiUtils.get("/timovi");
    },

    getAllTimoviDto: () => {
        return apiUtils.get("/timovi/dto");
    },

    getIgrachiFromTim: (idTim) => {
        return apiUtils.get(`/timovi/${idTim}/current-igrachi`);
    }

};

export default Timovi;