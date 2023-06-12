//is logged in
export const isLoggedIn=()=>{

    let data=localStorage.getItem("user")
    //console.log(data)
    if(data!=null){
        return true
    }else{
        return false
    }
}

//dologin =>data=>set to localstorage
export const doLogin=(data,next)=>{
    localStorage.setItem("user",JSON.stringify(data))
    next();
}

//do log out
export const doLogOut=(next)=>{
    localStorage.removeItem("user");
    next();
}

//get currentuser
export const getCurruntUserDetails=()=>{
    if(isLoggedIn()){
        return JSON.parse(localStorage.getItem("user"));
    }else{
        return undefined;
    }
}
