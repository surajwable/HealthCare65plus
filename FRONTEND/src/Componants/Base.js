import CustomNavbar from "./CustomNavbar";
const Base = ({title ="welcome to EMP",user}) =>{
    return(
        <div className="container-fluid p-0 m-0">
            <CustomNavbar></CustomNavbar>
          {user}
        </div>
    );
};
export default Base