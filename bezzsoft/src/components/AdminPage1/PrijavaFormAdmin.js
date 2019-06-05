import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'





class PrijavaFormAdmin extends Component {

  
  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        ime:'',
        prezime:'',
        username:'',
        password:'',
        repeatpassword:'',
        broj:'',
        rola:'admin'
      };
      this.onLogin = this.onLogin.bind(this)
  }

    
  onLogin() {

    var adminusername = 'amar';
    var adminpassword = 'amar';
    var korisnik = "{ \n" + 
        "\"ime\":"  + this.state.ime  + ", \n" + 
        "\"prezime\":" + "\"" + this.state.prezime + "\"" + ", \n" +
        "\"username\":" +  "\"" +this.state.username  + "\"" + ", \n" +
        "\"broj_telefona\":" +  "\"" +this.state.broj  + "\"" + ", \n" +
        "\"password\":" + this.state.password + " \n"+
    "}";
    var i=1;
    if(this.state.rola==="admin"){
      i="1"
    }
    else{
      i="2"
    }
    var role="{ \n" + 
    "\"role\":"  + this.state.rola  + ", \n" + 
    "\"id\":" + "\"" + i + "\"" + " \n" +
"}";
    var data = new FormData();
    data.append("username",adminusername);
    data.append("password",adminpassword);
    data.append("korisnik", korisnik);
    data.append("role", role);
    fetch('/autentifikacija/Korisnik',{
      method: "PUT",
      body: data

    }).then((response) => response.json()).then((responseJson) => {
      if(responseJson.message==="Korisnik saved"){
          alert("Uspješno ste prijavljeni, sada se možete logovati sa svojim korisničkim podacima");
          this.setState(
        
            ()=>({
              redirect:true
            })
          )
      }
      else{
        alert("Neispravni uneseni podaci")
      }
      
    })
    
   
  }

  

  render() {

    if(this.state.redirect === true){
      return <Redirect to="/login"></Redirect>
    }

    return (
     
      <div className="prijavaformaadmin">

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
            }} />

          </Form.Group>


          <Form.Group controlId="formBasicPassword">

            <Form.Control type="username" placeholder="Broj telefona 06x/xxx-xxx" value={this.state.broj} onChange={(e)=>{
              this.setState({
                broj:e.target.value
              })
            }}/>

          </Form.Group>
          
          <Form.Group controlId="exampleForm.ControlSelect1">
          <Form.Label>Rola </Form.Label>
            <Form.Control as="select" onChange={(e)=>{
              this.setState({
                rola:e.target.value
              })
            }}>
              <option>admin</option>
              <option>user</option>
             
            </Form.Control>
        </Form.Group>
          
          
      </Form>
      <button className="submit" onClick={this.onLogin} >
      DODAJ KORISNIKA
      </button>
      </div>
    )
  }
}

export default PrijavaFormAdmin;