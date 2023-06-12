import React from 'react';
import { Container, Row, Col } from 'reactstrap';
import Map from './GoogleMaps';

const Contactus = () => {
  return (
    <div style={{ 
      backgroundImage: "url('https://png.pngtree.com/back_origin_pic/00/05/32/01a10a5a084276e717a716e9f6b0c1ba.jpg')",
      backgroundSize: 'cover',
      backgroundPosition: 'center',
      height: '100vh',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center'
    }}>
      <Container style={{ 
        backgroundColor: 'rgba(255, 255, 255, 0.8)',
        padding: '50px',
        borderRadius: '10px',
        textAlign: 'center'
      }}>
        <h1 style={{ marginBottom: '50px' }}>Contact Us</h1>
        <Row>
          <Col>
            <img src="https://www.nicepng.com/png/full/455-4555073_facebook-logo-png-circle.png" style={{ width: '50px', marginBottom: '20px' }} />
            <p><a href="https://www.facebook.com/">Facebook</a></p>
          </Col>
          <Col>
            <img src="https://webstockreview.net/images/instagram-clipart-full-hd.png" alt="Instagram Logo" style={{ width: '50px', marginBottom: '20px' }} />
            <p><a href="https://www.instagram.com/">Instagram</a></p>
          </Col>
          <Col>
            <img src="https://library.kissclipart.com/20190422/ioe/kissclipart-logo-symbol-clip-art-linkedin-font-70b9f463107d9159.png" alt="LinkedIn Logo" style={{ width: '50px', marginBottom: '20px' }} />
            <p><a href="https://www.linkedin.com/">LinkedIn</a></p>
          </Col>
        </Row>
        <Row>
          <Col>
            <img src="https://clipartcraft.com/images/youtube-logo-transparent-5.png" alt="YouTube Logo" style={{ width: '50px', marginBottom: '20px' }} />
            <p><a href="https://www.youtube.com/">YouTube</a></p>
          </Col>
          <Col>
            <img src="https://clipground.com/images/gmail-icon-transparent-clipart-3.png" alt="Email Logo" style={{ width: '50px', marginBottom: '20px' }} />
            
           <div>Email: suraj.wable13@gmail.com  </div> 
            
          </Col>
          <Col>
            <img src="https://clipground.com/images/github-icon-clipart-7.png" alt="GitHub Logo" style={{ width: '50px', marginBottom: '20px' }} />
            <p><a href="https://github.com/">GitHub</a></p>
          </Col>
        </Row>
        <p style={{ marginTop: '50px' }}>Janwadi,Gokhale Nagar,Pune,Maharashtra,India</p>
      </Container>
      <Map></Map>
     
    </div>

  );
};
  
export default Contactus;