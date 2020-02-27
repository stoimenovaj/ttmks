import Turniri from "../service/turniriService";

function generateGracketObject(igrach) {
    return {
        "name": igrach.ime,
        "id": igrach.id,
        "score": igrach.poeni
    };
}

export function generateGracketMech(igrach1, igrach2) {
    return [
        generateGracketObject(igrach1),
        generateGracketObject(igrach2)
    ]
}

export function getPrevMech(fazi, prevBrojFaza, idIgrach) {
    let mechevi = fazi[prevBrojFaza - 1].mechevi;
    console.log('prev');
    console.log(mechevi);
    return mechevi.filter(mech => mech.igrach1.id === idIgrach || mech.igrach2.id === idIgrach)[0];
}

export function noMoreFazi(fazi, brojFaza) {
    console.log("noMOrw?");
    console.log(fazi[brojFaza - 1] === undefined);
    return fazi[brojFaza - 1] === undefined;
}