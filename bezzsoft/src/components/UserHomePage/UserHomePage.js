import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import UserHomeForm from './UserHomeForm';

class UserHomePage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
         
        
    
            <div className="body">
                <h3 className="naslov">Kontrolna ploča</h3>
                <UserHomeForm></UserHomeForm>
                
        
            </div>
        
        </div>
    
    );
}

}

export default UserHomePage;