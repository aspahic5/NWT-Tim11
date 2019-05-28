import React, { Component } from 'react';
import NavBar from '../NavBar/NavBar';
import Header from '../Header/Header';
import LoginForm from './LoginForm';

class LoginPage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Login </h3>
        
                <LoginForm></LoginForm>
                
        
            </div>
        
        </div>
    
    );
}

}

export default LoginPage;