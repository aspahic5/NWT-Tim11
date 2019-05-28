import React, { Component } from 'react';
import logo from './logo_transparent.png';


class Header extends Component {

render(){
    return(

        <div className="header">
      
            <img className="logo" src={logo} alt="logo"/>
       
        </div>
    );
}

}

export default Header;