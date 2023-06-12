import React from 'react';

const Map = () => {
  return (
    <div className="map-container">
      <iframe
        title="map"
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d499.53705567758743!2d73.82367382151868!3d18.530607174687272!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2bfbc2d210b2b%3A0xc466a9a898e54a44!2sDattasadan!5e0!3m2!1sen!2sin!4v1677861397186!5m2!1sen!2sin"
        width="100%"
        height="300"
        style={{ border: 0 }}
        allowFullScreen=""
        loading="lazy"
      ></iframe>
    </div>
  );
};

export default Map;
