import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form} from 'react-bootstrap';

class DodajRojenje extends Component {
    constructor(props){
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            brojmaticnjaka: 0,
            komentar: "",
            starostmaticnjaka: "",
            tipmaticnjaka: "",
        }
    }

    dodajRojenje(){
        var Rojenje = "{" + 
            "\"brojmaticnjaka\":"  + this.state.brojmaticnjaka  + ", \n" + 
            "\"komentar\":" + "\"" + this.state.komentar + "\"" + ", \n" +
            "\"starostmaticnjaka\":" +  "\"" +this.state.starostmaticnjaka  + "\"" + ", \n" +
            "\"tipmaticnjaka\":" +  "\"" + this.state.tipmaticnjaka + "\"" + ", \n"+
            "\"kosnica_id\":" + this.state.KosnicaId + " \n" +
        "}";
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        data.append("Rojenje", Rojenje);
        const options = {
            method: "POST",
            body: data
        }
        fetch("/ms_upravljanje/Rojenje/" + localStorage.getItem("idKosnice"), options).
            then((response) => response.json()).
                then((responseJson) => {
                    alert(JSON.stringify(responseJson));
                }).catch((a)=>{alert(a)})
    }

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
                                <Form.Control type="number" placeholder="0"  onChange = {(e) => { this.setState({brojmaticnjaka: e.target.value}) }}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Starost matičnjaka</Form.Label>
                                <Form.Control placeholder="Unesite format dd/mm/yyyy" onChange = {(e) => { this.setState({starostmaticnjaka: e.target.value}) }} />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Tip matičnjaka</Form.Label>
                                <Form.Control  placeholder="Neki tip"  value = {this.state.tipmaticnjaka} onChange = {(e) => { this.setState({tipmaticnjaka: e.target.value}) }} />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Komentar</Form.Label>
                                <Form.Control as="textarea" rows="3" placeholder="Komentar..." value = {this.state.komentar} onChange = {(e) => { this.setState({komentar: e.target.value}) }} />
                            </Form.Group>
                            </Form>
                            <button className="submittable" onClick = {() => {this.dodajRojenje()}}> Dodaj rojenje </button>
                        </Col>
                    </Row>
                </Container>
            </div>
        
        </div>
    
    );
}

}

export default DodajRojenje;