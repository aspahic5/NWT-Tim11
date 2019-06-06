import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Table, Form} from 'react-bootstrap';

class Aktivnost extends Component {
    constructor(props){
        super(props);
        this.state = {
            kosnicaId: localStorage.getItem("idKosnice"),
            Aktivnost: "",
            mjesec: "",
            uradjeno: -1
        }
    }

    componentDidMount(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);

    }
render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled Aktivnosti</h3>
                <Container>
                    <Row>
                        <Col>
                        <Table striped bordered hover>
                            <tr>
                                <th>ID</th>
                                <th>AKTIVNOST</th>
                                <th>MJESEC</th>
                                <th>URAĐENO</th>
                            </tr>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td><Form.Control readOnly = {true} as="textarea" defaultValue="3" /></td>
                                <td>Januar</td>
                                <td><Form.Check type="checkbox" /></td>
                            </tr>
                                <tr>
                                <td>2</td>
                                <td><Form.Control as="textarea" readOnly = {true} defaultValue="3" /></td>
                                <td>Januar</td>
                                <td><Form.Check type="checkbox"/></td>
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

export default Aktivnost;