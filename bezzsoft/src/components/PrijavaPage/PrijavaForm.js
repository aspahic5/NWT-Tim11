import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'





class PrijavaForm extends Component {

  
  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        ime:'',
        prezime:'',
        username:'',
        password:'',
        repeatpassword:'',
        broj:''
      };
      this.onLogin = this.onLogin.bind(this)
  }

    
  onLogin() {

    var data = new FormData();
    data.append("username",this.state.username)
    data.append("password",this.state.password)
    fetch('/autentifikacija/provjeri',{
      method: "PUT",
      body: data

    }).then((response) => response.json())
    /*this.setState(
      ()=>({
        redirect:true
      })
    )*/
   
  }

  

  render() {

    if(this.state.redirect === true){
      return <Redirect to="/pregledkorisnika"></Redirect>
    }

    return (
     
      <div className="prijavaforma">

      <Form >

          <Form.Group>
            
            <Form.Control type="username" placeholder="Ime" value={this.state.ime} onChange={(e)=>{
              this.setState({
                ime:e.target.value
              })
            }} />
          </Form.Group>

          <Form.Group>
            
            <Form.Control type="username" placeholder="Prezime" value={this.state.prezime} onChange={(e)=>{
              this.setState({
                prezime:e.target.value
              })
            }}/>
          </Form.Group>
          <Form.Group>
            
            <Form.Control type="username" placeholder="Username" value={this.state.username} onChange={(e)=>{
              this.setState({
                username:e.target.value
              })
            }}/>

          </Form.Group>

          <Form.Group controlId="formBasicPassword">

            <Form.Control type="password" placeholder="Password" value={this.state.password} onChange={(e)=>{
              this.setState({
                password:e.target.value
              })
            }}/>

          </Form.Group>

          <Form.Group controlId="formBasicPassword">

            <Form.Control type="password" placeholder="Ponovite Password" value={this.state.repeatpassword} onChange={(e)=>{
              this.setState({
                repeatpassword:e.target.value
              })
            }}/>

          </Form.Group>


          <Form.Group controlId="formBasicPassword">

            <Form.Control type="username" placeholder="Broj telefona 06x/xxx-xxx" value={this.state.broj} onChange={(e)=>{
              this.setState({
                broj:e.target.value
              })
            }}/>

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