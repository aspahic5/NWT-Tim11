import React, { Component } from 'react';
import NavBar from '../AdminNavBar/AdminNavBar';
import Header from '../Header/Header'

class AdminPage extends Component {

render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled korisnika</h3>
        
                
        
            </div>
        
        </div>
    
    );
}

}

export default AdminPage;