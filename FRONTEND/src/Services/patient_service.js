import { myAxios } from "./helper";

// Get doctors by category
export const getDoctorsByCategory = (category) => {
  return myAxios
    .get(`/api/doctors?category=${category}`)
    .then((response) => response.data);
};

// Get patient appointments
export const getPatientAppointments = (patientId) => {
  return myAxios
    .get(`/api/patients/${patientId}/appointments`)
    .then((response) => response.data);
};

// Get patient health history
export const getPatientHealthHistory = (patientId) => {
  return myAxios
    .get(`/api/patients/${patientId}/health-history`)
    .then((response) => response.data);
};

// You can add more functions for other API calls if needed
