import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form, Nav} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PregledUnosa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            Kosnica: {  
                        id: -1,
            },
            redirect: false
        }
    }
    
    componentDidMount(){
        var data = new FormData();
        data.append("username", localStorage.getItem('username'));
        data.append("password", localStorage.getItem('password'));
        const options = {
            method: "OPTIONS",
            body: data
        }
        fetch("/ms_proizvodnja/Kosnica/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson)=>{
                    
                })
    }

    
render(){

    if(this.state.redirect) {
        return <Redirect to="/pregledkosnica"></Redirect>
    }

    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
            <div className="body">
                <h3 className="naslov">Pregled unosa za košnicu</h3>
                
                
        
            </div>
        
        </div>
    
    );
}

}

export default PregledUnosa;