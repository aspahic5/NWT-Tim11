import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form} from 'react-bootstrap';

class DodajRojenje extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Novo rojenje</h3>
                <Container>
                    <Row>
                        <Col>
                            <Form>
                            <Form.Group>
                                <Form.Label>Broj matičnjaka</Form.Label>
                                <Form.Control type="number" placeholder="0"/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Starost matičnjaka</Form.Label>
                                <Form.Control placeholder="Unesite format dd/mm/yyyy" />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Tip matičnjaka</Form.Label>
                                <Form.Control  placeholder="Neki tip" />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Komentar</Form.Label>
                                <Form.Control as="textarea" rows="3" placeholder="Komentar..." />
                            </Form.Group>
                            </Form>
                            <button className="submittable"> Dodaj rojenje </button>
                        </Col>
                    </Row>
                </Container>
            </div>
        
        </div>
    
    );
}

}

export default DodajRojenje;