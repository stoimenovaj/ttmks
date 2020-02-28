import apiUtils from "../util/apiUtils";

const Kategorii = {

    getAllKategorii: () => {
        return apiUtils.get(`/kategorii`);
    }
    
};

export default Kategorii;