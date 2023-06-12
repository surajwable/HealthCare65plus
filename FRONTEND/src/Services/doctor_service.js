import { myAxios } from "./helper";

// Register a doctor
export const registerDoctor = (doctor) => {
  return myAxios
    .post('/doctor/register', doctor)
    .then((response) => response.data);
};

// Login doctor
export const loginDoctor = (doctorLogin) => {
  return myAxios
    .post('/api/doctor/login', doctorLogin)
    .then((response) => response.data);
};

// Get doctor appointments
export const getDoctorAppointments = (doctorId) => {
  return myAxios
    .get(`/api/doctor/${doctorId}/appointments`)
    .then((response) => response.data);
};

// Update patient health history
export const updateHealthHistory = (patientId, healthHistory) => {
  return myAxios
    .put(`/api/patient/${patientId}/health-history`, { healthHistory })
    .then((response) => response.data);
};

// Get patient health history
export const getPatientHealthHistory = (patientId) => {
  return myAxios
    .get(`/api/patient/${patientId}/health-history`)
    .then((response) => response.data);
};

// You can add more functions for other API calls if needed
