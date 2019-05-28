import React, { Component } from 'react';
import NavBar from '../NavBar/NavBar';
import Header from '../Header/Header'
import PrijavaForm from './PrijavaForm';

class PrijavaPage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Prijava </h3>

                <PrijavaForm></PrijavaForm>
                
        
            </div>
        
        </div>
    
    );
}

}

export default PrijavaPage;