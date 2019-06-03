import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';






class LoginForm extends Component {

  
  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        username:'',
        password:'',
      };
      this.onLogin = this.onLogin.bind(this)
  }

    
  onLogin() {
    
    var data = new FormData();
    data.append("username",this.state.username)
    data.append("password",this.state.password)
    fetch('/autentifikacija/provjeri',{
      method: "POST",
      body: data

    }).then((response) => response.json())
    .then((responseJson) => {
          if(responseJson.prijavljen){
            global.role=responseJson.role;
            localStorage.setItem('username',this.state.username);
            localStorage.setItem('password',this.state.password);
            localStorage.setItem('id',responseJson.id);
            localStorage.setItem('prijavljen',true);
            localStorage.setItem('role',responseJson.role);
            this.setState(
              ()=>({
                redirect:true,
              })
            ) 
          }
          else{
            alert("Pogrešan username ili password ")
          }
    })
  }

  componentDidMount(){
            localStorage.setItem('username','');
            localStorage.setItem('password','');
            localStorage.setItem('id','-1');
            localStorage.setItem('prijavljen',false);
            localStorage.setItem('role','neprijavljen');

  }

  

  render() {

    if(this.state.redirect === true){
      if(global.role=="user"){
      return <Redirect to="/home"></Redirect>
      }
      else{
        return <Redirect to="/pregledkorisnika"></Redirect>
      }
    }

    return (
     
      <div className="loginforma">

      <Form >
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
          
          
          
      </Form>
      <button className="submit" onClick={this.onLogin} >
      LOGIN
      </button>
      </div>
    )
  }
}

export default LoginForm;