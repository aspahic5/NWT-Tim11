import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {ListGroup, Accordion, Card, Button} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PregledKosnica extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: [],
            redirect: false,
            user: "",
            pass: "",
            id: -1,
            kosnice:  [],
            kosnicaId: -1,
            prijavljen: false,
            temp: 0
        }
    }


    componentDidMount() {
        this.setState({
            user: localStorage.getItem('username'),
            pass: localStorage.getItem('password'),
            prijavljen: localStorage.getItem('prijavljen'),
        })
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "PATCH",
            body: data
        }
        if(localStorage.getItem('prijavljen')){
            fetch("/ms_upravljanje/Kosnica/" + localStorage.getItem('id'), options).then((response) => response.json())
                .then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    var l=[]
                    for( var i=0;i<o;i++){
                        l.push(responseJson[i])
                    }
                    this.setState({
                        kosnice:l
                    })
                })
        }
    }
render(){

    if(this.state.redirect) {
        return (<Redirect to={{
            pathname: "/kosnica",
            state: { id: '123' }
        }}/>);
    }

    const kosnica = this.state.kosnice.map(function(kosnica1, i=-1){
        i++;
        return (
            <Card>
                <Card.Header>
                    <Accordion.Toggle as={Button} variant="link" eventKey= {i}>
                        Košnica: {kosnica1.id}
                    </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey= {i}>
                    <Card.Body>
                        Komentar
                        <br></br>
                        {kosnica1.komentar}
                        <br></br>
                        <button className="submit" onClick = {(props) => {this.setState({ redirect: true })}}> Detalji </button> 
                    </Card.Body>
                    </Accordion.Collapse>
                </Card>
        );
    }.bind(this));
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled Košnica</h3>
                <Accordion>
                    {kosnica}
                </Accordion>
 
            </div>
        
        </div>
    
    );
}

}

export default PregledKosnica;