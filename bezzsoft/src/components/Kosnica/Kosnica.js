import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class UserHomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            Kosnica: this.props.location.state.id,
            redirectA: false,
            redirectR: false,
            redirectV: false,
            redirectDA: false,
            redirectDR: false,
            redirectVR: false
        }
    }
render(){
    if(this.state.redirectA) {
        return (<Redirect to={{
            pathname: "/aktivnost",
            state: { id: '123' }
        }}/>);
    }
    else if(this.state.redirectR) {
        return (<Redirect to={{
            pathname: "/rojenje",
            state: { id: '123' }
        }}/>);
    }
    else if(this.state.redirectDA) {
        return (<Redirect to={{
            pathname: "/dodajaktivnost",
            state: { id: '123' }
        }}/>);
    }
    else if(this.state.redirectDR) {
        return (<Redirect to={{
            pathname: "/dodajrojenje",
            state: { id: '123' }
        }}/>);
    }
    else if(this.state.redirectVR) {
        return (<Redirect to={{
            pathname: "/proizvodnjaMed",
            state: { id: '123' }
        }}/>);
    }
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
            <div className="body">
                <h3 className="naslov">Detalji košnice</h3>
                <Container>
                    <Row>
                      <Col>
                      <Table striped bordered hover>
                        <tbody> 
                            <tr>
                                <th>ID</th>
                                <td><Form.Control type="number"  readOnly = {true} defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>BROJ HANEMANKI</th>
                                <td><Form.Control type="number" defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>BROJ NASTAVAKA</th>
                                <td><Form.Control type="number" defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>BROJ RAMOVA</th>
                                <td><Form.Control type="number" defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>STIMULANS</th>
                                <td><Form.Control type="number" defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>KOLIČINA STIMULANSA</th>
                                <td><Form.Control type="number" defaultValue = "4"/> </td>
                            </tr>
                            <tr>
                                <th>GODIŠTE MATICE</th>
                                <td><Form.Control defaultValue = "05/12/2019" placeholder = "DD/MM/YYYY" /> </td>
                            </tr>
                            <tr>
                               <th>NASTALA ROJENJEM</th>
                                <td><Form.Control defaultValue="Košnice 2"/> </td>
                            </tr>
                            <tr>
                                <th>KOMENTAR</th>
                                <td><Form.Control as="textarea" defaultValue="3" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"> <button className="submittable"  > Ažuriraj košnicu </button> </td>
                            </tr>
                        </tbody>
                        </Table>
                      </Col> 
                      <Col>
                      <Table striped bordered hover>
                            <tbody> 
                                <tr>
                                    <th colspan="2" >UNOS</th>
                                </tr>
                                <tr>
                                    <th>DATUM</th>
                                    <td><Form.Control type="date" /></td>
                                </tr>
                                <tr>
                                    <th>KOLIČINA</th>
                                    <td><Form.Control type="float" placeholder = "kg"/> </td>
                                </tr>
                                <tr>
                                    <td colspan="2"> <button className="submittable"  > Dodaj Unos </button> </td>
                                </tr>
                            </tbody>
                            </Table>
                            <Table className="table" striped bordered hover>
                            <tbody className="table"> 
                                <tr>
                                    <th> <button className="submittable"   onClick = {() => {this.setState({ redirectDA: true})}}> Dodaj aktivnost </button></th>
                                    <td> <button className="submittable"   onClick = {() => {this.setState({ redirectA: true})}} > Pregled aktivnosti </button></td>
                                </tr>
                                <tr>
                                    <th> <button className="submittable"  onClick = {() => {this.setState({ redirectDR: true})}}> Dodaj rojenje </button></th>
                                    <td><button className="submittable"    onClick = {() => {this.setState({ redirectR: true})}} >  Trenutno rojenje </button> </td>
                                </tr>
                                <tr>
                                    <td> <button className="submittable" onClick = {() => {this.setState({ redirectVR: true})}} > Dodaj vrcanje </button> </td>
                                    <td> <button className="submittable"  > Povijest vrcanja </button></td>
                                </tr>
                                <tr>
                                    <td colspan = "2"> <button className="submittable"  > Obriši košnicu </button></td>
                                </tr>
                            </tbody>
                            </Table>

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

export default UserHomePage;