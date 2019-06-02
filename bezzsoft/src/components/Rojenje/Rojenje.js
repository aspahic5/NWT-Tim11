import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Table, Form} from 'react-bootstrap';

class Rojenje extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Trenutno rojenje</h3>
                <Container>
                    <Row>
                        <Col>
                        <Table striped bordered hover>
                            <tr>
                                <th>ID</th>
                                <th>BROJ MATIČNJAKA</th>
                                <th>STAROST MATIČNJAKA</th>
                                <th>TIP MATIČNJAKA</th>
                                <th>KOMENTAR</th>
                            </tr>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td><Form.Control type="number"  readOnly = {true} defaultValue = "4"/> </td>
                                <td><Form.Control defaultValue = "05/12/2019" placeholder = "DD/MM/YYYY" /> </td>
                                <td><Form.Control defaultValue="Košnice 2"/> </td>
                                <td><Form.Control readOnly = {true} as="textarea" defaultValue="3" /></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td><Form.Control type="number"  readOnly = {true} defaultValue = "4"/> </td>
                                <td><Form.Control defaultValue = "05/12/2019" placeholder = "DD/MM/YYYY" /> </td>
                                <td><Form.Control defaultValue="Košnice 2"/> </td>
                                <td><Form.Control readOnly = {true} as="textarea" defaultValue="3" /></td>
                            </tr>
                        </tbody>
                        </Table>
                        </Col>
                    </Row>
                </Container>
                
        
            </div>
        
        </div>
    
    );
}

}

export default Rojenje;