import apiUtils from "../util/apiUtils";


const Timovi = {

    getIgrachiMechevi: (idTim, idSezona, idLiga) => {
        return apiUtils.get("/timovi/" + idTim + "/igrachi?idSezona=" + idSezona + "&idLiga=" + idLiga);
    }
    ,

    getAllTimovi: () => {
        return apiUtils.get("/timovi");
    }

};

export default Timovi;