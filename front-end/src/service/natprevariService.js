import apiUtils from "../util/apiUtils";


const Natprevari = {

    getAllSezoni: (idSezona,idLiga) => {
        return apiUtils.get(`/ligi/${idLiga}/natprevari?idSezona=`+idSezona);
    },

    gettopLista: (idSezona, idLiga) => {
        return apiUtils.get(`/ligi/top-lista?idSezona=` + idSezona + `&idLiga=` + idLiga);
    },

    createNatprevar: (natprevar) => {
        return apiUtils.post("/natprevari", natprevar);
    },

    createMech: (mech, natprevarId) => {
        mech['natprevarId'] = natprevarId;
        return apiUtils.post("/mechevi/natprevar", mech);
    }

};

export default Natprevari;