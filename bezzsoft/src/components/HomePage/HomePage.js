import React, { Component } from 'react';
import NavBar from '../NavBar/NavBar';
import Header from '../Header/Header'

class HomePage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">O nama</h3>
        
                
        
            </div>
        
        </div>
    
    );
}

}

export default HomePage;