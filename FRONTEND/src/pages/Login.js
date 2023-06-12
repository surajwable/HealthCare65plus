
import { Card, CardBody, CardHeader, Container, Form, FormGroup, Input, Label, Row, Col, Button } from 'reactstrap';
import { useState, useEffect } from 'react';
import { getallevents, getallservices, login } from '../Services/user_service';
import { toast } from 'react-toastify';
import { doLogin } from '../Auth';
import { useNavigate } from 'react-router-dom';
import {Link} from 'react-router-dom';

const Login = () => {

  const navigate = useNavigate()

  const [responseData, setResponseData] = useState("");
  // for saving userlogin info state in react data storing
  const [userlogin, setUserlogin] = useState({

    email: '',
    password: '',

  })

  //use effect 
  useEffect(() => {

  }, [userlogin])

  //handle change
  const handleChange = (event, field) => {
    //dynamic change the values
    setUserlogin({ ...userlogin, [field]: event.target.value })
  }

  //submit form
  const submitForm = (event) => {
    event.preventDefault();
    //data validation
    if (userlogin.email.trim() === "" || userlogin.password.trim() === "") {
      toast.error("email and password required")
      return;
    }

    //call server api for sending data
    login(userlogin).then((data) => {
      // console.log(data)
      //save data to local storage

      doLogin(data, () => {
        console.log("logindetails stored in local storage")
        //redirect to user dashbordpage 
        //console.log(data.role)
        //console.log(data.userid)

        // if (data.role === "Admin" || data.role === "admin") {
        //   navigate("/users/admin")
        // }
        if (data.role === "Patient" || data.role === "patient") {
          navigate("/users/Patient")
        }
        else if (data.role === "Doctor" || data.role === "doctor") {
          navigate("/users/vendor")
        }
        else {
          toast.error("role not found ")
        }
      })

      toast.success("login done")
    }).catch((error) => {
      console.log(error)
      if (error.response.status === 400 || error.response.status === 404) {
        toast.error(error.response.data.message)
        toast.error("user credential invalidate")
      } else {
        toast.error("error on server!!")
      }
    })

    // api call to get event list
    getallevents().then((response) => {

      console.log(response)
      setResponseData(response.data)
      //list of events sytored in local storage
      localStorage.setItem("event", JSON.stringify(response))
    })

    // api call to get services list
    getallservices().then((response) => {

      console.log(response)
      setResponseData(response.data)
      //list of events sytored in local storage
      localStorage.setItem("services", JSON.stringify(response))
    })

  }
  //reset form
  const handleReset = () => {
    setUserlogin({
      email: "",
      password: "",
    })
  }
  return (
    <div>
      <Container color='red'>
        <Row className='mt-4'>
          <Col sm={{ size: 6, offset: 3 }}>
            <Card color='dark' outline>
              <CardHeader>
                <h3>LOGIN FORM !!</h3>
              </CardHeader>
              <CardBody>
                <Form onSubmit={submitForm}>
                  {/* for email */}
                  <FormGroup>
                    <Label for="email"> Enter Email : </Label>
                    <Input
                      type='email'
                      placeholder='Enter here'
                      id='email'
                      onChange={(e) => handleChange(e, 'email')}    //listner to accept data from from
                      value={userlogin.email}
                    />
                  </FormGroup>

                  {/* for password */}
                  <FormGroup>
                    <Label for="password"> Enter Password: </Label>
                    <Input
                      type='password'
                      placeholder='Enter here'
                      id='password'
                      onChange={(e) => handleChange(e, 'password')}    //listner to accept data from from
                      value={userlogin.password}
                    />
                  </FormGroup>
                  {/* submit buttons */}
                  <Container className='text-center'>
                    <Button dark>Login</Button>
                    <Button onClick={handleReset} color='secondary' type='reset' className='ms-2'>Reset</Button>
                    <a href='/register' className='ms-2'>register</a>
                  </Container>
                </Form>
                <Link to="/forgot-password">Forgot Password?</Link>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};
export default Login;