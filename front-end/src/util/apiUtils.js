import { API_BASE_URL, ACCESS_TOKEN, AUTHORIZATION_HEADER } from '../constants';
import axios from "../custom-axios/axios";

// const request = (options) => {
//     const headers = new Headers({
//         'Content-Type': 'application/json',
//     });
//
//     if(localStorage.getItem(ACCESS_TOKEN)) {
//         headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
//     }
//
//     const defaults = {headers: headers};
//     options = Object.assign({}, defaults, options);
//
//     return axios.request()
//
//     return fetch(options.url, options)
//         .then(response =>
//             response.json().then(json => {
//                 if(!response.ok) {
//                     return Promise.reject(json);
//                 }
//                 return json;
//             })
//         );
// };

const apiUtils = {
    get: (url) => {
        return axios.get(url, {
            headers: {
                Authorization: token()
            }
        });
    },
    post: (url, body) => {
        const data = JSON.stringify(body);

        return axios.post(url, data, {
            headers: {
                Authorization: token(),
                'content-type': 'application/json'
            }
        });
    }
};

function token() {
    if(localStorage.getItem(ACCESS_TOKEN)) {
        return 'Bearer ' + localStorage.getItem(ACCESS_TOKEN);
    }
    return '';
}

export default apiUtils;



