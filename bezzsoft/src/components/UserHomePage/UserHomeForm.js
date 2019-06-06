import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';
import {Nav, Container, Row, Col, Table, Form} from 'react-bootstrap';
class UserHomeForm extends Component {

    constructor(props) {
        super(props);
    
          this.state = {

          };
      }

      componentDidMount(){
        
      }
    
    
      render() {
  
    
        return (
         
          <div className="userforma">
            <Container>
              <Row>
                <Col>
                  <Table striped bordered hover>
                    <tr>
                      <th colspan = "5" ><p className="naslovaktivnost" >Preostale aktivnosti</p></th>
                    </tr>
                    <tr>
                       <th>ID</th>
                       <th>AKTIVNOST</th>
                       <th>MJESEC</th>
                       <th>URAĐENO</th>
                       <th>KOŠNICA(ID)</th>
                     </tr>
                        <tbody>
                          <tr>
                           <td>1</td>
                           <td><Form.Control readOnly = {true} as="textarea" defaultValue="3" /></td>
                           <td>Januar</td>
                           <td><Form.Check type="checkbox" /></td>
                           <td>4</td>
                         </tr>
                         <tr>
                          <td>2</td>
                           <td><Form.Control as="textarea" readOnly = {true} defaultValue="3" /></td>
                           <td>Januar</td>
                           <td><Form.Check type="checkbox"/></td>
                           <td>5</td>
                          </tr>
                        </tbody>
                  </Table>
                  <h3 clasName="textlink" >Ukupan broj košnica: 12</h3>
                  <Nav.Link href = "/dodajkosnicu" ><button className="submittable">
                     DODAJ KOŠNICU
                   </button> </Nav.Link>
                </Col> 
                 <Col>
                    <Nav.Link href = "/proizvodnjaMed" ><button className="submittable" onClick={this.onProizvodnja} >
                      PROIZVODNJA
                     </button> </Nav.Link> 
                    
                </Col>
              </Row>
           </Container>
          </div>
        ) 
      }

} 

export default UserHomeForm;