import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form, Nav} from 'react-bootstrap';

class DodajKosnicu extends Component {
    constructor(props) {
        super(props);
        this.state = {
        } 
    }
render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Nova košnica</h3>
                <Container>
                    <Row>
                      <Col>
                      <Form>
                        <Form.Group>
                            <Form.Control type="number" placeholder="Broj ramova" />
                        </Form.Group>
                        <Form.Group>
                        <Form.Control type="number" placeholder="Broj nastavaka" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text" placeholder="Godište matice (dd/mm/yyyy)" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="number" placeholder="Broj hanemanki" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text" placeholder="Količina stimulansa (kg)" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text"  placeholder="Tip stimulansa" />
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="number"  placeholder="Nastala od košnice ID" />
                        </Form.Group>
                        </Form>
                      </Col>  
                      <Col>
                        <Form.Group>
                            <Form.Control as="textarea" rows="5" placeholder="Komentar na košnicu" />
                        </Form.Group>
                        <Form.Group>
                            <button className="submittable"  > Dodaj </button>
                        </Form.Group>
                        <Form.Group>
                        <Nav.Link href = "/home" >
                            <button className="submit">
                                Otkaži
                            </button> </Nav.Link>
                        </Form.Group>
                      </Col>
                    </Row>
                    <Row>
                    </Row>
                </Container>
                
        
            </div>
        
        </div>
    
    );
}

}

export default DodajKosnicu;