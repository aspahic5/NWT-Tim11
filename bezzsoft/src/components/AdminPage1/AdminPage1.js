import React, { Component } from 'react';
import NavBar from '../AdminNavBar/AdminNavBar';
import Header from '../Header/Header'
import PrijavaForm from './PrijavaFormAdmin';
import {Redirect} from 'react-router-dom';

class AdminPage extends Component {

render(){
    if(localStorage.getItem('role')!='admin'){
        return <Redirect to="/login"></Redirect>
    }
  
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
           
        
            <div className="body">
                <h3 className="naslov">Dodaj korisnika</h3>
                <PrijavaForm></PrijavaForm>
                
        
            </div>
        
        </div>
    
    );
}

}

export default AdminPage;