import apiUtils from "../util/apiUtils";


const Stats = {

    getSrekjnaSala: (idTim) => {
        return apiUtils.get(`/timovi/${idTim}/srekjna-sala`);
    },

    statsNatprevariZaTim: (idTim) => {
        return apiUtils.get(`/timovi/${idTim}/tim-natprevari-stats`);
    },

    pobediVoGradOsnovan: (idTim) => {
        return apiUtils.get(`/timovi/${idTim}/tim-domakjin`);
    },

    najdobraFazaZaIgrach: (idIgrach) => {
        return apiUtils.get(`/timovi/${idIgrach}/najdobra-faza`);
    },

    pobedniciVoKategorija: (idKategorija) => {
        return apiUtils.get(`/timovi/${idKategorija}/pobednici-turniri`);
    }

};

export default Stats;