import React, { Component } from 'react';
import NavBar from '../NavBar/NavBar';
import Header from '../Header/Header'

class HomePage extends Component {

render(){
    localStorage.setItem('username','');
    localStorage.setItem('password','');
    localStorage.setItem('id','-1');
    localStorage.setItem('prijavljen',false);
    localStorage.setItem('role','neprijavljen');
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">O nama</h3>
                <div className="opis">
                    <p>
                    BeeZsoft aplikacija omogućava pčelarima jednostavno vođenje dnevnika dnevnih i mjesečnih aktivnosti, kao i o detaljima za svaku pojedinačnu košnicu. Mogućnost, praćenja troškova i dobiti olakšava pčelaru da efikasno procijeni isplativost svake košnice/društva i da unaprijed predvidi aktivnosti u poboljšanju omjera.
                    </p>
                </div>
        
                
        
            </div>
        
        </div>
    
    );
}

}

export default HomePage;