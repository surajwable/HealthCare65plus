import React, { useEffect, useState } from 'react';
import { getDoctorsByCategory, getPatientAppointments, getPatientHealthHistory } from '../Services/patient_service';
import { Card, CardBody, CardImg, CardText, CardTitle, Col, Container, Row } from 'reactstrap';

const PatientDashboard = ({ patientId }) => {
  const [category, setCategory] = useState('');
  const [doctors, setDoctors] = useState([]);
  const [appointments, setAppointments] = useState([]);
  const [healthHistory, setHealthHistory] = useState('');

  useEffect(() => {
    // Fetch doctors when the category changes
    if (category) {
      loadDoctors();
    }
    // Fetch appointments and health history
    loadAppointments();
    loadHealthHistory();
  }, [category]);

  const loadDoctors = () => {
    getDoctorsByCategory(category)
      .then((response) => {
        setDoctors(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const loadAppointments = () => {
    getPatientAppointments(patientId)
      .then((response) => {
        setAppointments(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const loadHealthHistory = () => {
    getPatientHealthHistory(patientId)
      .then((response) => {
        setHealthHistory(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const selectCategory = (selectedCategory) => {
    setCategory(selectedCategory);
  };

  return (
    <div>
      <Container>
        <h3>Select a category:</h3>
        <Row>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('neurosurgeon')}>
              <CardImg top width='100%' src='neurosurgeon.jpg' alt='Neurosurgeon' />
              <CardBody>
                <CardTitle tag='h5'>Neurosurgeon</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('nutritionist')}>
              <CardImg top width='100%' src='nutritionist.jpg' alt='Nutritionist' />
              <CardBody>
                <CardTitle tag='h5'>Nutritionist</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('orthopedic')}>
              <CardImg top width='100%' src='orthopedic.jpg' alt='Orthopedic' />
              <CardBody>
                <CardTitle tag='h5'>Orthopedic</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('eye doctor')}>
              <CardImg top width='100%' src='eye_doctor.jpg' alt='Eye Doctor' />
              <CardBody>
                <CardTitle tag='h5'>Eye Doctor</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('heart specialist')}>
              <CardImg top width='100%' src='heart_specialist.jpg' alt='Heart Specialist' />
              <CardBody>
                <CardTitle tag='h5'>Heart Specialist</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('dentist')}>
              <CardImg top width='100%' src='dentist.jpg' alt='Dentist' />
              <CardBody>
                <CardTitle tag='h5'>Dentist</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('dermatologist')}>
              <CardImg top width='100%' src='dermatologist.jpg' alt='Dermatologist' />
              <CardBody>
                <CardTitle tag='h5'>Dermatologist</CardTitle>
              </CardBody>
            </Card>
          </Col>
          <Col md={2} sm={6} className='mb-4'>
            <Card onClick={() => selectCategory('oncologist')}>
              <CardImg top width='100%' src='oncologist.jpg' alt='Oncologist' />
              <CardBody>
                <CardTitle tag='h5'>Oncologist</CardTitle>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>

      {appointments.length > 0 && (
        <Container className='mt-4'>
          <h3>Booked Appointments:</h3>
          {appointments.map((appointment) => (
            <Card key={appointment.id} className='mb-3'>
              <CardBody>
                <CardTitle tag='h5'>{appointment.doctorName}</CardTitle>
                <CardText>Date: {appointment.date}</CardText>
                <CardText>Time: {appointment.time}</CardText>
              </CardBody>
            </Card>
          ))}
        </Container>
      )}

      {healthHistory && (
        <Container className='mt-4'>
          <h3>Health History:</h3>
          <Card>
            <CardBody>
              <CardText>{healthHistory}</CardText>
            </CardBody>
          </Card>
        </Container>
      )}
    </div>
  );
};

export default PatientDashboard;

