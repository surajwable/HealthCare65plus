
import "./user.css"
import React from 'react';
import { Container, Row, Col, Card, CardImg, CardBody, CardTitle, CardSubtitle, Button } from 'reactstrap';

const User = () => {

  //get all event types 
  const events = localStorage.getItem("event");

  //convert parse the object
  const obj = JSON.parse(events)
  //console.log(obj)

  //get all events type 
  const Event = obj.map((val, index) => { return val.eventtype })
  console.log(Event)

  let v1=Event.filter((val,index)=>{if(index==0)return val});
  let v2=Event.filter((val,index)=>{if(index==1)return val});
  let v3=Event.filter((val,index)=>{if(index==2)return val});
  let v4=Event.filter((val,index)=>{if(index==3)return val});
  let v5=Event.filter((val,index)=>{if(index==4)return val});
  let v6=Event.filter((val,index)=>{if(index==5)return val});
  let v7=Event.filter((val,index)=>{if(index==6)return val});
  let v8=Event.filter((val,index)=>{if(index==7)return val});
  let v9=Event.filter((val,index)=>{if(index==8)return val});
  let v10=Event.filter((val,index)=>{if(index==9)return val});
  let v11=Event.filter((val,index)=>{if(index==10)return val});
  console.log(v1)
  console.log(v2)
  console.log(v3)
  console.log(v4)

  return (
    
    <div >
    <div className="services">
      <Container>
        <Row>
          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://www.slideteam.net/media/catalog/product/cache/1280x720/w/e/wedding_event_planning_proposal_powerpoint_presentation_slides_slide01.jpg"  />
              <CardBody>
                <CardTitle tag="h5">{v1}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/Wedding">{v1}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2axnLbPt_3a2fHW2NwSRV-pLxOgJrF5ELSg&usqp=CAU" />
              <CardBody>
                <CardTitle tag="h5">{v2}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 2</CardSubtitle>
                <h2><a href="/Birthday">{v2}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://blog.savaari.com/wp-content/uploads/2019/11/DJ-Snake-600.jpg" />
              <CardBody>
                <CardTitle tag="h5">{v3}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 3</CardSubtitle>
                <h2><a href="/Party">{v3}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-Z1DEIzk0Jmk-5OVsh-yDU96IbCj_XuVHcQ&usqp=CAU"  />
              <CardBody>
                <CardTitle tag="h5">{v4}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/Concert">{v4}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYEjQGpX11elwIzB69BCrgkdmtVSO_5wXsBg&usqp=CAU" />
              <CardBody>
                <CardTitle tag="h5">{v5}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/Business">{v5}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://www.eventfaqs.com/Uploads/News/Content/whatsapp-image-2022-03-17-at-7.09.42-pm.jpg" />
              <CardBody>
                <CardTitle tag="h5">{v6}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/Festival">{v6}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0Yu50NxX9IfYSIDgARIHzwSn4AmN0f3b8cg&usqp=CAU"/>
              <CardBody>
                <CardTitle tag="h5">{v7}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/Exhibition">{v7}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSB9eNwXcb7z0umEdSvZLQd9B7v0ULugubiCA&usqp=CAU" />
              <CardBody>
                <CardTitle tag="h5">{v8}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 2</CardSubtitle>
                <h2><a href="/Convention">{v8}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeVVjzSRGIfMRmd4rQSabCxSOkr3g4NzjAlA&usqp=CAU"  />
              <CardBody>
                <CardTitle tag="h5">{v9}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 3</CardSubtitle>
                <h2><a href="/Seminar">{v9}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://thumbs.dreamstime.com/z/bengali-community-gathered-wedding-purpose-kolkata-india-56517932.jpg" />
              <CardBody>
                <CardTitle tag="h5">{v10}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/FamilyFunction">{v10}</a></h2>
              </CardBody>
            </Card>
          </Col>

          <Col md="4">
            <Card>
              <CardImg top width="100%" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9g5IcdGPUdU4xYLqySDy3gzK5sfsEn5o8CkZX301tI4UmNRVI9gQqY-3zEXXV76KvcB4&usqp=CAU"  />
              <CardBody>
                <CardTitle tag="h5">{v11}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">Description of Service 1</CardSubtitle>
                <h2><a href="/HybridEvent">{v11}</a></h2>
              </CardBody>
            </Card>
          </Col>

        </Row>
      </Container>
    </div>
    </div>
  );
};

export default User;