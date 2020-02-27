import apiUtils from "../util/apiUtils";


const Sali = {

    getAllSali: () => {
        return apiUtils.get("/sali");
    }

};

export default Sali;