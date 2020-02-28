import apiUtils from "../util/apiUtils";


const Igrachi = {

    getAllIgrachi: () => {
        return apiUtils.get(`/igrachi`);
    }
};

export default Igrachi;