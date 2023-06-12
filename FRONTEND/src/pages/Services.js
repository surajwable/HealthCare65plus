import React from "react";
import { Card, CardImg, CardBody, CardTitle, CardSubtitle, Container, Row, Col } from "reactstrap";

const ServicesPage = () => {
  const services = [
    {
      id: 1,
      name: "HealthCare",
      description: "Providing comprehensive medical care for elderlies",
      image: "https://www.brightlysoftware.com/sites/default/files/styles/small/public/image/2022-08/HDR-Industry-Healthcare.png?itok=lC-H7kxc",
      quote: "Caring for your health and well-being"
    },
    {
      id: 2,
      name: "Nutrition",
      description: "Creating personalized nutrition plans for healthy aging",
      image: "https://w0.peakpx.com/wallpaper/654/542/HD-wallpaper-healthy-food-heart-of-fruits-and-vegetables-good-nutrition-diet-slimming-weight-loss.jpg",
      quote: "Fuel your body with the right nutrients"
    },
    {
      id: 3,
      name: "Emotional Support",
      description: "Offering emotional support and counseling services",
      image: "https://wisechoiceihc.com.au/wp-content/uploads/2019/12/emotional-support-for-elderly.png",
      quote: "Supporting your mental and emotional well-being"
    },
    {
      id: 4,
      name: "Caregiver Support",
      description: "Providing assistance and resources for caregivers",
      image: "https://www.mychores.in/Images/Patient-Care.jpg",
      quote: "Supporting and empowering caregivers"
    }
  ];

  return (
    <Container>
      <div>
        <h1>Our Services</h1>
      </div>
      <Row>
        {services.map((service) => (
          <Col key={service.id} lg={3} md={6} className="mb-4">
            <Card>
              <CardImg top width="100%" src={service.image} alt={service.name} />
              <CardBody>
                <CardTitle tag="h5">{service.name}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">{service.description}</CardSubtitle>
                <p>{service.quote}</p>
              </CardBody>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default ServicesPage;
