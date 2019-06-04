import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Form, Nav} from 'react-bootstrap';

class DodajKosnicu extends Component {
    constructor(props) {
        super(props);
        this.state = {
            brojramova: 0,
            brojnastavaka: 0,
            godistematice: "",
            brojhanemanki: 0,
            kolicinastimulansa: "0",
            tipstimulansa: "",
            komentar: "",
            user: "",
            pass: ""
        } 
    }

dodajKosnicu() {
    var vlasnik = localStorage.getItem('id');
    var Kosnica = "{ \n" + 
        "\"kolstimulansa\":"  + this.state.kolicinastimulansa  + ", \n" + 
        "\"maticagod\":" + "\"" + this.state.godistematice + "\"" + ", \n" +
        "\"tipstimulansa\":" +  "\"" +this.state.tipstimulansa  + "\"" + ", \n" +
        "\"vlasnik_id\":" + vlasnik + ", \n"+
        "\"brojhanemanki\":" + this.state.brojhanemanki + ", \n" +
        "\"brojramova\":" + this.state.brojramova  + ", \n" +
        "\"komentar\":" +  "\"" + this.state.komentar +  "\"" + ", \n" +
        "\"brojnastavaka\":" + this.state.brojnastavaka + " \n" +
    "}";
    var data = new FormData();
    alert(Kosnica)
    data.append("username",this.state.user);
    data.append("password",this.state.pass);
    data.append("Kosnica", Kosnica);
    const options = {
        method: "POST",
        body: data
    }
    fetch("/ms_upravljanje/Kosnica", options).then((response) => response.json())
        .then((responseJson) => {
            var string = JSON.stringify(responseJson);
            alert(string)
        })
}

componentDidMount() {
    this.setState({
        user: localStorage.getItem('username'),
        pass: localStorage.getItem('password')
    })
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
                            <Form.Control type="number" placeholder="Broj ramova" value={this.state.brojramova} onChange={(e)=>{this.setState({brojramova:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                        <Form.Control type="number" placeholder="Broj nastavaka" value={this.state.brojnastavaka} onChange={(e)=>{this.setState({brojnastavaka:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text" placeholder="Godište matice (dd/mm/yyyy)" value={this.state.godistematice} onChange={(e)=>{this.setState({godistematice:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="number" placeholder="Broj hanemanki" value={this.state.brojhanemanki} onChange={(e)=>{this.setState({brojhanemanki:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text" placeholder="Količina stimulansa (kg)" value={this.state.kolicinastimulansa} onChange={(e)=>{this.setState({kolicinastimulansa:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Control type="text"  placeholder="Tip stimulansa" value={this.state.tipstimulansa} onChange={(e)=>{this.setState({tipstimulansa:e.target.value})}}/>
                        </Form.Group>
                        </Form>
                      </Col>  
                      <Col>
                        <Form.Group>
                            <Form.Control as="textarea" rows="5" placeholder="Komentar na košnicu" value={this.state.komentar} onChange={(e)=>{this.setState({komentar:e.target.value})}}/>
                        </Form.Group>
                        <Form.Group>
                            <button className="submittable"  onClick = {this.dodajKosnicu.bind(this)}> Dodaj </button>
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