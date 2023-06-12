import React, { useEffect, useState } from 'react';
import { getDoctorAppointments, updateHealthHistory, getPatientHealthHistory } from '../Services/doctor_service';
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from 'reactstrap';

const Doctor = ({ doctorId }) => {
  const [appointments, setAppointments] = useState([]);
  const [selectedAppointment, setSelectedAppointment] = useState(null);
  const [healthHistory, setHealthHistory] = useState('');

  useEffect(() => {
    loadAppointments();
  }, []);

  const loadAppointments = () => {
    getDoctorAppointments(doctorId)
      .then((response) => {
        setAppointments(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const viewPatientHealthHistory = (patientId) => {
    getPatientHealthHistory(patientId)
      .then((response) => {
        console.log(response);
        // Handle the retrieved health history data as required
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const updatePatientHealthHistory = () => {
    if (selectedAppointment && healthHistory) {
      const { patientId } = selectedAppointment;
      updateHealthHistory(patientId, healthHistory)
        .then((response) => {
          console.log(response);
          // Handle successful health history update
        })
        .catch((error) => {
          console.log(error);
          // Handle error during health history update
        });
    }
  };

  const selectAppointment = (appointment) => {
    setSelectedAppointment(appointment);
    setHealthHistory('');
    // Load the health history of the selected patient, if required
    viewPatientHealthHistory(appointment.patientId);
  };

  return (
    <div>
      <Container>
        <Row className='mt-4'>
          <Col sm={{ size: 8, offset: 2 }}>
            <Card color='dark' outline>
              <CardHeader>
                <h3>Doctor Appointments</h3>
              </CardHeader>
              <CardBody>
                <h4>Appointments:</h4>
                {appointments.map((appointment) => (
                  <div key={appointment.id}>
                    <p>Patient: {appointment.patientName}</p>
                    <p>Date: {appointment.date}</p>
                    <p>Time: {appointment.time}</p>
                    <Button color='secondary' onClick={() => selectAppointment(appointment)}>
                      Select
                    </Button>
                    <hr />
                  </div>
                ))}

                {selectedAppointment && (
                  <>
                    <h4>Selected Appointment:</h4>
                    <p>Patient: {selectedAppointment.patientName}</p>
                    <p>Date: {selectedAppointment.date}</p>
                    <p>Time: {selectedAppointment.time}</p>
                    <FormGroup>
                      <Label for='healthHistory'>Health History:</Label>
                      <Input
                        type='textarea'
                        placeholder='Enter health history here'
                        id='healthHistory'
                        onChange={(e) => setHealthHistory(e.target.value)}
                        value={healthHistory}
                      />
                    </FormGroup>
                    <Button color='primary' onClick={updatePatientHealthHistory}>
                      Update Health History
                    </Button>
                  </>
                )}
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Doctor;
