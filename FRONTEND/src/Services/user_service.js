
import { myAxios } from "./helper";

//registration url for registering users
export const register=(user)=>{

    return myAxios
    .post('/patient/register',user)
    .then((response)=>response.data);
};

//for login user 
export const login=(userlogin)=>{

    return myAxios
    .post('/api/user/login',userlogin)
    .then((response)=>response.data);
}

//for login user 
export const getallevents=()=>{

    return myAxios
    .get('/api/event/events')
    .then((response)=>response.data);
};

//get hall api call
export const getService=()=>{

    return myAxios
    .get('/api/service/services')
    .then((response)=>response.data);
};

//for login user 
export const getallservices=()=>{

    return myAxios
    .get('/api/service/services')
    .then((response)=>response.data);
};


// export const ForgotPassword=(ForgotPassword)=>{

//     return myAxios
//     .post('/forgot-password',ForgotPassword)
//     .then((response)=>response.data)
//     .catch(error => {
//         if (error.response) {
//           // The request was made and the server responded with a status code
//           // that falls out of the range of 2xx
//           console.log(error.response.data);
//           console.log(error.response.status);
//           console.log(error.response.headers);
//         } else if (error.request) {
//           // The request was made but no response was received
//           // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
//           // http.ClientRequest in node.js
//           console.log(error.request);
//         } else {
//           // Something happened in setting up the request that triggered an Error
//           console.log('Error', error.message);
//         }
//         console.log(error.config);
//       });
// }