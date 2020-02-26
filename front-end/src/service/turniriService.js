import apiUtils from "../util/apiUtils";


const Turniri = {

    getAllSezoni: () => {
        return apiUtils.get("/sezoni");
    },

    getTurniriForSezona: (idSezona) => {
        return apiUtils.get("/sezoni/"+idSezona+"/turniri")
    }

};

export default Turniri;