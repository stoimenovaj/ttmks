function getData() {
    let array = []

    let obj1 = {
        name: "Сеозна 2017/2018",
        items: [
            "Супер лига - машки",
            "Супер лига - женски",
            "Прва лига - машки",
            "Втора лига - машки"
        ]
    };

    let obj2 = {
        name: "Сеозна 2017/2018",
        items: [
            "Супер лига - машки",
            "Супер лига - женски",
            "Прва лига - машки",
            "Втора лига - машки"
        ]
    };

    let obj3 = {
        name: "Сеозна 2017/2018",
        items: [
            "Супер лига - машки",
            "Супер лига - женски",
            "Прва лига - машки",
            "Втора лига - машки"
        ]
    };

    array.push(obj1,obj2, obj3);
    return array;
}

export default getData;