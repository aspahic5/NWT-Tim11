import React, { Component } from 'react';
import NavBar from '../AdminNavBar/AdminNavBar';
import Header from '../Header/Header';
import {ListGroup, Accordion, Card, Button, Nav} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';


class AdminPage extends Component {
    constructor(props){
        super(props);
        this.state = {
            korisnici: [],
            id: localStorage.getItem("id")
        }
    }

    componentDidMount(){
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "OPTIONS",
            body: data
        }
        fetch("/autentifikacija/Korisnik", options).
            then((response) => response.json()).
                then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    var l=[]
                    for( var i=0;i<o;i++){
                        if(parseInt(responseJson[i].id, 10) !== parseInt(this.state.id, 10))
                            l.push(responseJson[i]);
                    }
                    this.setState({
                        korisnici:l
                    })
                })
    }

    obrisi(korisnik) {
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "DELETE",
            body: data
        }
        fetch("/autentifikacija/Korisnik/" + korisnik.id, options).
            then((response) => response.json).
                then((responseJson) => {
                })
    }
render(){
    const korisnici1 = this.state.korisnici.map((korisnik, i=-1) =>{
        i++;
        return (
            <Card>
                <Card.Header>
                    <Accordion.Toggle as={Button} variant="link" eventKey= {i}>
                        <p>Ime i prezime:  {korisnik.ime} {korisnik.prezime}</p>
                    </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey= {i}>
                    <Card.Body>
                        <p>Username:  {korisnik.username}</p>
                        <p>Broj telefona: {korisnik.broj_telefona}</p> 
                        <p>Rola: {korisnik.role.role}</p> 
                        <Nav.Link href = "/pregledkorisnika" > <button className="submittable" onClick = {function(){this.obrisi(korisnik)}.bind(this)}>Obriši</button> </Nav.Link>
                    </Card.Body>
                    </Accordion.Collapse>
                </Card>
        );
    })
    if(localStorage.getItem('role')!='admin'){
        return <Redirect to="/login"></Redirect>
    }
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
            
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled korisnika</h3>
                <Accordion>
                    {korisnici1}
                </Accordion>
                
        
            </div>
        
        </div>
    
    );
}

}

export default AdminPage;