import apiUtils from "../util/apiUtils";


const Ligi = {

    getAllLigi: (idSezona) => {
        return apiUtils.get(`/sezoni/${idSezona}/ligi`);
    },

    getAllLigiWithTimovi: (idSezona) => {
        return apiUtils.get(`/sezoni/${idSezona}/ligiWithTimovi`);
    }
};

export default Ligi;