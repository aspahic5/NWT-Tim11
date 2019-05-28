import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'





class LoginForm extends Component {

  
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
      return <Redirect to="/home"></Redirect>
    }

    return (
     
      <div className="loginforma">

      <Form >
          <Form.Group>
            
            <Form.Control type="username" placeholder="Username" />
          </Form.Group>

          <Form.Group controlId="formBasicPassword">

            <Form.Control type="password" placeholder="Password" />
          </Form.Group>
          
          
          
      </Form>
      <button className="submit" onClick={this.onLogin} >
      LOGIN
      </button>
      </div>
    )
  }
}

export default LoginForm;