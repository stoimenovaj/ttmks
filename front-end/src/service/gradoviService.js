import apiUtils from "../util/apiUtils";


const Gradovi = {

    getAllGradovi: () => {
        return apiUtils.get("/gradovi");
    }

};

export default Gradovi;

