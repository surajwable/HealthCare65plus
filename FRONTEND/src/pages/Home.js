import React from 'react';
import { Container, Row, Col, Button } from 'reactstrap';
import { useSpring, animated } from 'react-spring';

const Home = () => {
  const bgImgUrl = 'https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-caring-for-the-elderly-public-welfare-design-psd-layering-image_195061.jpg';
  const bgImgStyle = {
    position: 'absolute',
    width: '100%',
    height: '100%',
    backgroundSize: 'cover',
    backgroundPosition: 'center center',
    filter: 'brightness(90%)',
    backgroundImage: `url(${bgImgUrl})`,
  };
  const textAnimStyle = useSpring({
    from: { opacity: 0, transform: 'translateY(50px)' },
    to: { opacity: 0, transform: 'translateY(0px)' },
    config: { mass: 1, tension: 2800, friction: 20, clamp: true },
    delay: 500,
  });
  const btnAnimStyle = useSpring({
    from: { opacity: 0, transform: 'scale(0)' },
    to: { opacity: 1, transform: 'scale(1)' },
    config: { mass: 1, tension: 280, friction: 20, clamp: true },
    delay: 1200,
  });

  return (
    <div style={bgImgStyle}>
      <div className="overlay" />
      <Container className="h-100 d-flex justify-content-center align-items-center">
        <Row>
          <Col md={6}>
            <animated.h1 style={textAnimStyle} className="display-4 text-black mb-4">
              <span className="logo">HealthCare65plus</span>
            </animated.h1>
            <animated.p style={textAnimStyle} className="lead text-black mb-5">
              Live Healthy and Happy
            </animated.p>
            <animated.div style={btnAnimStyle}>
              <Button color="primary" size="lg">Get Started</Button>
            </animated.div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Home;
