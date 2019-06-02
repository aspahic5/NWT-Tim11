import React, { Component } from 'react';
import {Navbar,Nav} from 'react-bootstrap';

class ProizvodnjaNavBar extends Component {

render(){
    return(
     <div className="navbar"> 
      <Navbar  expand="lg">
      <Navbar.Brand href="/"></Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
       <Nav className="mr-auto"></Nav>
      
        <Nav.Link href="/home"><p className="textlink">Kontrolna ploča</p> </Nav.Link>
        <Nav.Link href="/proizvodnjaMed"><p className="textlink">Med</p> </Nav.Link>
        <Nav.Link href="/proizvodnjaMlijec"><p className="textlink">Matična mliječ</p> </Nav.Link>
        <Nav.Link href="/proizvodnjaPropolis"><p className="textlink">Propolis</p> </Nav.Link>
        <Nav.Link href="/"><p className="textlink">Logout</p> </Nav.Link>
       
      </Navbar.Collapse>
      </Navbar>
    </div>  
    );
}

}

export default ProizvodnjaNavBar;