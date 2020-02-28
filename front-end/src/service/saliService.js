import apiUtils from "../util/apiUtils";


const Sali = {

    getAllSali: () => {
        return apiUtils.get("/sali");
    },

    getSaliFromGrad: (idGrad) => {
        return apiUtils.get(`/sali/${idGrad}`);
    }

};

export default Sali;