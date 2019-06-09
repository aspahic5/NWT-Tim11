import React, { Component } from 'react';
import NavBar from '../ProizvodnjaNavBar/ProizvodnjaNavBar';
import Header from '../Header/Header'
import {ListGroup, Form} from 'react-bootstrap';
import MedForm from './MedForm';

class ProizvodnjaMed extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true
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
                <h3 className="naslov">Med</h3>
                <MedForm></MedForm>
            </div>
        
        </div>
    
    );
}

}

export default ProizvodnjaMed;