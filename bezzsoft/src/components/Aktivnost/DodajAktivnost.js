import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form} from 'react-bootstrap';

class Aktivnost extends Component {
    constructor(props){
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            aktivnost: "",
            mjesec: "",
            user: localStorage.getItem("username"),
            pass: localStorage.getItem("password")
        }
    }

    dodajAktivnost(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        var Aktivnost = "{ \n" + 
            "\"aktivnost\":" + "\"" + this.state.aktivnost + "\"" + ", \n" + 
            "\"mjesec\":" + "\"" + this.state.mjesec + "\"" + ", \n" +
            "\"uradjeno\":" + "0" + "\n" +
        "}";
        formData.append("Aktivnost", Aktivnost);
        const options = {
            method: "POST",
            body: formData
        }
        fetch("/ms_upravljanje/Aktivnost/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson) =>{
                    alert(JSON.stringify(responseJson));
                });
    }

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
                                <Form.Control as="textarea" rows="3" value={this.state.aktivnost} onChange={(e)=>{this.setState({aktivnost:e.target.value})}} placeholder="Unesite aktivnost..." />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Mjesec</Form.Label>
                                <Form.Control value={this.state.mjesec} onChange={(e)=>{this.setState({mjesec:e.target.value})}} placeholder="Npr. Januar/Sječanj..." />
                            </Form.Group>
                            </Form>
                            <button className="submittable" onClick = {() => {this.dodajAktivnost()}}> Dodaj aktivnost </button>
                        </Col>
                    </Row>
                </Container>
            </div>
        
        </div>
    
    );
}

}

export default Aktivnost;