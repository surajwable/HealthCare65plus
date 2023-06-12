import axios from "axios";
export const BASE_URL='http://localhost:8181';

//without axios default used so create own variable
export const myAxios=axios.create({

    baseURL:BASE_URL
});