import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form} from 'react-bootstrap';

class Aktivnost extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Nova Aktivnost</h3>
                <Container>
                    <Row>
                        <Col>
                            <Form>
                            <Form.Group>
                                <Form.Label>Aktivnost</Form.Label>
                                <Form.Control as="textarea" rows="3" placeholder="Unesite aktivnost..." />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Mjesec</Form.Label>
                                <Form.Control placeholder="Npr. Januar/Sječanj..." />
                            </Form.Group>
                            </Form>
                            <button className="submittable"> Dodaj aktivnost </button>
                        </Col>
                    </Row>
                </Container>
            </div>
        
        </div>
    
    );
}

}

export default Aktivnost;