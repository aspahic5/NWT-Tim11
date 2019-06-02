import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';

class UserHomeForm extends Component {

    constructor(props) {
        super(props);
    
          this.state = {redirect: false};
          this.onProizvodnja = this.onProizvodnja.bind(this)
      }
    
        
      onProizvodnja() {
        this.setState(
          ()=>({
            redirect:true
          })
        )
      }
    
      
    
      render() {
    
        if(this.state.redirect === true){
          return <Redirect to="/proizvodnjaMed"></Redirect>
        }
    
        return (
         
          <div className="userforma">
    
          
          <button className="submit" onClick={this.onProizvodnja} >
          PROIZVODNJA
          </button>
          </div>
        )
      }

}

export default UserHomeForm;