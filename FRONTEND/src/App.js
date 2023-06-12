
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home'
import About from './pages/About';
import Login from './pages/Login';
import RegisterPatient from './pages/RegisterPatient';
import RegisterDoctor from './pages/RegisterDoctor';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import PrivateRoutes from './Componants/PrivateRoutes';
import Profileinfo from './pages/User_Routes/Profileinfo';
import Contactus from './pages/Contactus';
import Admin from './Admin/admin';
import User from './User/user';
import Base from './Componants/Base';
import ServicesPage from './pages/Services';
import { ForgotPassword } from './pages/ForgotPassword';
import PatientDashboard from './Patient/Patient';
import Doctor from './Doctor/Doctor';


export default function App() {
  return (
    < BrowserRouter>
      <Base></Base>
      <ToastContainer position='bottom-center' />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About></About>} />
        <Route path="/login" element={<Login></Login>} />
        <Route path="/registerPatient" element={<RegisterPatient></RegisterPatient>} />
        <Route path="/registerDoctor" element={<RegisterDoctor></RegisterDoctor>} />
        <Route path="/contactus" element={<Contactus></Contactus>} />
        <Route path="/services" element={<ServicesPage></ServicesPage>} />

        <Route path="/users" element={<PrivateRoutes></PrivateRoutes>} >
        <Route path="profileinfo" element={<Profileinfo></Profileinfo>} />

          {/* for user role wise dispatching */}
          <Route path="admin" element={<Admin></Admin>} />
          <Route path="user" element={<User></User>} />

          <Route path="/doctor" element={<Doctor></Doctor>} />
          <Route path="/patient" element={<PatientDashboard></PatientDashboard>} />
          
        </Route>
        
      {/* it is for forgot password */}
      <Route path="/forgot-Password" element={<ForgotPassword></ForgotPassword>} />

      </Routes>
    </BrowserRouter>
  );
}

