import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'

class UserHomePage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Kontrolna ploča</h3>
        
                
        
            </div>
        
        </div>
    
    );
}

}

export default UserHomePage;