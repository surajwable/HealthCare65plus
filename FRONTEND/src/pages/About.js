
import React from 'react';
import { Container, Row, Col, Image } from 'react-bootstrap';

const About = () => {
  return (
    <Container className="my-5">
      <Row>
        <Col md={6}>
          <Image src="https://i.pinimg.com/736x/09/4b/6e/094b6eb15e44a9e6f52f2c6111b7ec5a.jpg" alt="About Us" fluid />
        </Col>
        <Col md={6}>
          <h2 className="mb-4">About Us</h2>
          <p>
            <h4>
            At HealthCare65plus, we are dedicated to delivering top-quality healthcare services 
            tailored specifically for the elderly population. Our mission is to enhance the 
            overall well-being and quality of life for senior citizens through a range of specialized services.
            </h4>
          </p>
          <p>
            <h4>
            Appointments and Nutrition:
We understand the importance of regular appointments and proper nutrition in maintaining 
good health. Our platform offers a seamless appointment booking system, allowing elders 
to easily schedule medical check-ups, consultations, and specialized treatments. 
Additionally, we provide personalized nutrition guidance and meal plans to ensure a balanced diet that meets their unique dietary requirements.
            </h4>
          </p>
          
          <p>
            <h4>
            Medical Care:
Our team of experienced healthcare professionals is committed to providing exceptional 
medical care for elders. We offer a comprehensive range of medical services,
including preventive care, chronic disease management, and post-operative care. Our aim 
is to ensure optimal health outcomes and promote longevity for our senior community.
            </h4>
          </p>

          <p>
            <h4>
            Mental and Emotional Support:
We recognize the significance of mental and emotional well-being in the lives of senior 
citizens. Our platform offers access to professional counselors and therapists who 
specialize in addressing the unique mental health challenges faced by the elderly. 
We provide a supportive environment where individuals can freely express their feelings, seek guidance, and receive the necessary emotional support.
            </h4>
          </p>

          <p>
            <h4>
            Medications and Health History:
Managing medications can be complex for seniors. Our platform simplifies the process 
by providing a centralized system for medication reminders and management. 
Users can easily track their medications, set reminders, and receive notifications to 
ensure timely intake. We also provide a secure digital health record system, allowing 
elders to maintain and access their health history records, including past diagnoses, treatments, and laboratory results.
            </h4>
          </p>
        </Col>
      </Row>
    </Container>
  );
};

export default About;
