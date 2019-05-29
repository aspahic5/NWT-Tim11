import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Form} from 'react-bootstrap';

class KalendarPage extends Component {
    
    constructor(props){
        super(props);
        this.state ={ 
            isLoading: true,
            lokacije:[]
        }
      }
    
     componentDidMount(){
        return fetch('/lokacije')
          .then((response) => response.json())
          .then((responseJson) => {
            var o=Object.keys(responseJson).length
            var l=[]
            for( var i=0;i<o;i++){
                l.push(responseJson[i].lokcaija)
                
            }
            this.setState({
              isLoading: false,
              lokacije:l
            }
          )
          
      })
    }
    

     
    

render(){

    

    if(this.state.isLoading){
        return(
            <div>Loading</div>
        )
    }

    const lokacije = this.state.lokacije.map(function(lokacija){
        return <option> {lokacija} </option>;
      });

    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Kalendar</h3>
                <div className="loginforma">
                <Form.Group controlId="exampleForm.ControlSelect1">
                <Form.Label>Lokacije </Form.Label>
                    <Form.Control as="select" >
                    {lokacije}
                    </Form.Control>
                </Form.Group>
                <button className="submit" >
                    Dohvati biljke
                </button> 
                </div>
                
        
            </div>
        
        </div>
    
    )
    }
    


}

export default KalendarPage;