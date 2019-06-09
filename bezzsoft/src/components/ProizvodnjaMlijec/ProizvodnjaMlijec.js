import React, { Component } from 'react';
import NavBar from '../ProizvodnjaNavBar/ProizvodnjaNavBar';
import Header from '../Header/Header'
import {ListGroup, Form} from 'react-bootstrap';
import MlijecForm from './MlijecForm';

class ProizvodnjaMlijec extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: []
        }
    }

    componentDidMount() {
        
    }
render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Matična mliječ</h3>
                <MlijecForm></MlijecForm>
            </div>
        
        </div>
    
    );
}

}

export default ProizvodnjaMlijec;