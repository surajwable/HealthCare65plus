import React, { useEffect, useState } from 'react';
import { register } from "../Services/user_service";
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from 'reactstrap';
import { toast } from 'react-toastify';

const RegisterPatient = () => {
  const [data, setData] = useState({
    name: '',
    email: '',
    dob: '',
    contactnumber: '',
    password: '',
    address: '',
    role: '',
  });

  useEffect(() => {
    console.log(data);
  }, [data]);

  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };

  const resetData = () => {
    setData({
      name: '',
      email: '',
      dob: '',
      contactnumber: '',
      password: '',
      address: '',
      role: '',
    });
  };

  const submitForm = (event) => {
    event.preventDefault();
    console.log(data);

    // Perform data validation

    register(data)
      .then((response) => {
        console.log(response);
        toast.success("Registration done successfully");
        resetData();
      })
      .catch((error) => {
        console.log(error);
        toast.error("Registration failed");
      });
  };

  return (
    <div>
      <Container>
        <Row className='mt-4'>
          <Col sm={{ size: 8, offset: 2 }}>
            <Card color='dark' outline>
              <CardHeader>
                <h3>Fill information for registration!</h3>
              </CardHeader>
              <CardBody>
                <Form onSubmit={submitForm}>
                  <FormGroup>
                    <Label for='name'>Enter Name:</Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='name'
                      onChange={(e) => handleChange(e, 'name')}
                      value={data.name}
                    />
                  </FormGroup>

                  <FormGroup>
                    <Label for='contactnumber'>Enter Contact Number:</Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='contactnumber'
                      onChange={(e) => handleChange(e, 'contactnumber')}
                      value={data.contactnumber}
                    />
                  </FormGroup>

                  <FormGroup>
                    <Label for='email'>Enter Email:</Label>
                    <Input
                      type='email'
                      placeholder='Enter here'
                      id='email'
                      onChange={(e) => handleChange(e, 'email')}
                      value={data.email}
                    />
                  </FormGroup>

                  <FormGroup>
                    <Label for='dob'>Enter Date of Birth:</Label>
                    <Input
                      type='date'
                      id='dob'
                      onChange={(e) => handleChange(e, 'dob')}
                      value={data.dob}
                      max={new Date().toISOString().split('T')[0]} // Set max date to today's date
                    />
                  </FormGroup>

                  <FormGroup>
                    <Label for='password'>Set Password:</Label>
                    <Input
                      type='password'
                      placeholder='Enter here'
                      id='password'
                      onChange={(e) => handleChange(e, 'password')}
                      value={data.password}
                    />
                  </FormGroup>

                  <FormGroup>
                    <Label for='address'>Enter Address:</Label>
                    <Input
                      type='text'
                      placeholder='Enter here'
                      id='address'
                      onChange={(e) => handleChange(e, 'address')}
                      value={data.address}
                    />
                  </FormGroup>

                  <Container className='text-center'>
                    <Button color='dark' onClick={submitForm} >Register</Button>
                    <Button onClick={resetData} color='secondary' type='reset' className='ms-2'>
                      Reset
                    </Button>
                  </Container>
                </Form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default RegisterPatient;
