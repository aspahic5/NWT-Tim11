import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form, Nav} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class Selidba extends Component {
    constructor(props){
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            brojkosnica: -1,
            pocetak: "",
            kraj: null,
            dobit: -1,
            lokacija: "",
            redirect: false
        }
    }

    dodajSelidbu(){
        var data = new FormData();
        data.append("username", localStorage.getItem('username'));
        data.append("password", localStorage.getItem('password'));
        var Selidba = "{ \n" + 
            "\"brojkosnica\":"  + this.state.brojkosnica  + ", \n" + 
            "\"dobit\":" + "\"" + this.state.dobit + "\"" + ", \n" +
            "\"kraj\":" + "\"" + this.state.krajselidbe + "\"" + ", \n" +
            "\"lokacija\":" + "\"" + this.state.lokacija + "\"" + ", \n"+
            "\"pocetak\":" +  "\"" + this.state.pocetakselidbe +  "\"" + " \n" +
        "}";
        data.append("Selidba", Selidba);
        const options = {
            method: "POST",
            body: data
        }
        fetch("/ms_upravljanje/Selidba/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson) => {
                    alert(JSON.stringify(responseJson));
                    this.setState({
                        redirect: true
                    })
                }).catch((e)=> alert(e)) 
    }

    render(){

        if(this.state.redirect) {
            return <Redirect to= "/kosnica"> </Redirect>
        }
        return(
            <div className="mainpage">
                
                <NavBar></NavBar>
            
                <Header></Header>
            
            
        
                <div className="body">
                    <h3 className="naslov">Dodaj selidbu</h3>
                    <Container>
                        <Row>
                            <Col>
                                <Form.Group>
                                    <Form.Label>Broj košnica</Form.Label>
                                    <Form.Control type="number" placeholder="0" onChange={(e)=>{this.setState({brojkosnica:e.target.value})}}/>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Pocetak selidbe</Form.Label>
                                    <Form.Control type="text" placeholder="dd/mm/yyyy" onChange={(e)=>{this.setState({pocetakselidbe:e.target.value})}}/>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Kraj selidbe</Form.Label>
                                    <Form.Control type="text" placeholder="dd/mm/yyyy" onChange={(e)=>{this.setState({krajselidbe:e.target.value})}}/>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Dobit</Form.Label>
                                    <Form.Control type="text" placeholder="0.00KM" onChange={(e)=>{this.setState({dobit:e.target.value})}}/>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Lokacija</Form.Label>
                                    <Form.Control type="text" placeholder="Zenica" onChange={(e)=>{this.setState({lokacija:e.target.value})}}/>
                                </Form.Group>
                                <button className="submittable"  onClick = {() => {this.dodajSelidbu()}}> Dodaj selidbu </button>
                            </Col>
                        </Row>
                    </Container>
            
                </div>
            
            </div>
        
        );
    }

}

export default Selidba;