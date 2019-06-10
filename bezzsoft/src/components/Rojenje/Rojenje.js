import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Row, Container, Col, Accordion, Card, Button, Nav} from 'react-bootstrap';

class Rojenje extends Component {
    constructor(props){
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            Rojenje: []
        }
    }

    componentDidMount(){
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "PATCH",
            body: data
        }
        fetch("/ms_upravljanje/Rojenje/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    var l=[]
                    for( var i=0;i<o;i++){
                      l.push(responseJson[i]);
                    }
                    this.setState({
                        Rojenje:l
                    })
                })

    }

    obrisi(id){
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "DELETE",
            body: data
        }
        fetch("/ms_upravljanje/Rojenje/" + id, options).
            then((response) => response.json()).
                then((responseJson) => {
                    alert(JSON.stringify(responseJson));
                    this.setState({
                        redirect: true
                    })
                })
    }

render(){

    const roj = this.state.Rojenje.map((Jedno, i=-1) => {
        i++;
        return (
            <Card>
                <Card.Header>
                    <Accordion.Toggle as={Button} variant="link" eventKey= {i}>
                        Rojenje: {Jedno.id}
                    </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey= {i}>
                    <Card.Body>
                        <p>BROJ MATIČNJAKA:     {Jedno.brojmaticnjaka}</p>
                        <br></br>
                        <p>STAROST MATIČNJAKA:     {Jedno.starostmaticnjaka}</p>
                        <br></br>
                        <p>TIP MATIČNJAKA:     {Jedno.tipmaticnjaka}</p>
                        <br></br>
                        <p>KOMENTAR:     {Jedno.komentar}</p>
                        <Nav.Link href = "/rojenje" > <button className="submittable" onClick = {function(){ this.obrisi(Jedno.id); }.bind(this)} >Obriši </button> </Nav.Link>
                    </Card.Body>
                    </Accordion.Collapse>
            </Card> 
        )
    });
    
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Trenutno rojenje</h3>
                <Container>
                    <Row>
                        <Col>
                        <Accordion>
                            {roj}
                        </Accordion>
                        </Col>
                    </Row>
                </Container>
                
        
            </div>
        
        </div>
    
    );
}

}

export default Rojenje;