import apiUtils from "../util/apiUtils";


const Ligi = {

    getAllLigi: (idSezona) => {
        return apiUtils.get(`/sezoni/${idSezona}/ligi`);
    },

    getAllLigiWithTimovi: (idSezona) => {
        return apiUtils.get(`/sezoni/${idSezona}/ligiWithTimovi`);
    },

    getAllTimoviInLiga: (idSezona, idLiga) => {
        return apiUtils.get(`/ligi/${idSezona}/${idLiga}/timovi`);
    }
};

export default Ligi;