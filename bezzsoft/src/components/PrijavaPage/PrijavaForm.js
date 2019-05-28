import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'





class PrijavaForm extends Component {

  
  constructor(props) {
    super(props);

      this.state = {redirect: false};
      this.onLogin = this.onLogin.bind(this)
  }

    
  onLogin() {
    this.setState(
      ()=>({
        redirect:true
      })
    )
  }

  

  render() {

    if(this.state.redirect === true){
      return <Redirect to="/"></Redirect>
    }

    return (
     
      <div className="prijavaforma">

      <Form >

          <Form.Group>
            
            <Form.Control type="username" placeholder="Ime" />
          </Form.Group>

          <Form.Group>
            
            <Form.Control type="username" placeholder="Prezime" />
          </Form.Group>
          <Form.Group>
            
            <Form.Control type="username" placeholder="Username" />

          </Form.Group>

          <Form.Group controlId="formBasicPassword">

            <Form.Control type="password" placeholder="Password" />

          </Form.Group>

          <Form.Group controlId="formBasicPassword">

            <Form.Control type="password" placeholder="Ponovite Password" />

          </Form.Group>


          <Form.Group controlId="formBasicPassword">

            <Form.Control type="username" placeholder="Broj telefona 06x/xxx-xxx" />

          </Form.Group>
          
          
          
      </Form>
      <button className="submit" onClick={this.onLogin} >
      PIRJAVI SE
      </button>
      </div>
    )
  }
}

export default PrijavaForm;