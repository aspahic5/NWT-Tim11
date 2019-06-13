import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';
import {Nav, Container, Row, Col, Table, Form} from 'react-bootstrap';
class UserHomeForm extends Component {

  constructor(props){
    super(props);
    this.state = {
        isLoading: true,
        Kosnice: [],
        user: "",
        pass: "",
        id: -1,
        kosnicaId: -1,
        prijavljen: false,
        aktivnosti: [],
        ukupanBroj: -1,
        redirect: false,
    }
}

componentDidMount() {
  localStorage.setItem("idOdabrane", "Odaberite košnicu...");
    this.setState({
        user: localStorage.getItem('username'),
        pass: localStorage.getItem('password'),
        prijavljen: localStorage.getItem('prijavljen'),
    })
    var data = new FormData();
    data.append("username",localStorage.getItem('username'));
    data.append("password",localStorage.getItem('password'));
    const options = {
        method: "PATCH",
        body: data
    }
    var data2 = new FormData();
        data2.append("username",localStorage.getItem('username'));
        data2.append("password",localStorage.getItem('password'));
        const options2 = {
            method: "POST",
            body: data
        }
    fetch("/ms_upravljanje/DajSveKosnice", options2);
    if(localStorage.getItem('prijavljen')){
        fetch("/ms_upravljanje/Kosnica/" + localStorage.getItem('id'), options).then((response) => response.json())
            .then((responseJson) => {
                var o=Object.keys(responseJson).length
                this.setState({
                  ukupanBroj: o
                })
                var l=[]
                for( var i=0;i<o;i++){
                    l.push(responseJson[i])
                }
                this.setState({
                    Kosnice:l
                })
            })
    }
}
yourChangeHandler(event){
  localStorage.setItem("idOdabrane", event.target.value);
  if(event.target.value === "Odaberite košnicu...") return null;
  var formData = new FormData();
  formData.append("username", this.state.user);
  formData.append("password", this.state.pass);
  const options = {
    method: "PATCH",
    body: formData
  }
  fetch("ms_upravljanje/Aktivnost/" + event.target.value, options).
    then((response) => response.json()).
      then((responseJson) => { 
        var o=Object.keys(responseJson).length
        var l=[]
        for( var i=0;i<o;i++){
          l.push(responseJson[i]);
        }
        this.setState({
          aktivnosti:l
        })
      });
}
    
      render() {

        var dugmence="";
        
        const ids = this.state.Kosnice.map((kosnica) => {
          return (
            <option>{kosnica.id}</option>
          )
        })

        const aktivnost1 = this.state.aktivnosti.map((aktivnost) =>{
          if(aktivnost.uradjeno === 0)
            return (
                    <tr>
                        <td>{aktivnost.id}</td>
                        <td><Form.Control as="textarea" readOnly={true} defaultValue = {aktivnost.aktivnost} /></td>
                        <td>{aktivnost.mjesec}</td>
                        <td> <input type="checkbox" checked={aktivnost.uradjeno} defaultChecked={aktivnost.uradjeno} /></td>
                    </tr>
            
            );
          else return null
      })
    
        return (
          
          <div className="userforma">
            <Container>
              <Row>
                <Col>
                  <Table striped bordered hover>
                    <tr>
                      <th colspan = "5" ><p className="naslovaktivnost" >Preostale aktivnosti za košnicu: </p> 
                      <Form.Control as="select" onChange={this.yourChangeHandler.bind(this)}>
                        <option>Odaberite košnicu...</option>
                        {ids}
                      </Form.Control>
                    </th>
                    </tr>
                    <tr>
                       <th>ID</th>
                       <th>AKTIVNOST</th>
                       <th>MJESEC</th>
                       <th>URAĐENO</th>
                     </tr>
                        <tbody>
                          {aktivnost1}
                        </tbody>
                  </Table>
                  <br></br>
                  <br></br>
                  <h3 clasName="textlink" >Ukupan broj košnica: {this.state.ukupanBroj}</h3>
                  <br></br>
                </Col> 
                 <Col>
                   <Table className="table" striped bordered hover>
                            <tbody className="table"> 
                                <tr>
                                    <th> <Nav.Link href = "/proizvodnjaMed" ><button className="submittableBigger" onClick={this.onProizvodnja} >
                                      Proizvodnja
                                    </button> </Nav.Link></th>
                                    <td> <Nav.Link href =  "/pregledMed" ><button className="submittableBigger"> Pregled vrcanja</button> </Nav.Link></td>
                                </tr>
                                <tr>
                                    <th> <Nav.Link href = "/pregledPropolis" > <button className="submittableBigger" > Pregled propolisa </button></Nav.Link></th>
                                    <td><Nav.Link href =  "/pregledMaticna" ><button className="submittableBigger">Pregled matične mliječi</button></Nav.Link></td>
                                </tr>
                                <tr>
                                <td colSpan="2"><Nav.Link href = "/dodajkosnicu" ><button className="submittable">
                                      DODAJ KOŠNICU
                                    </button> </Nav.Link>
                                    </td>
                                </tr>
                            </tbody>
                      </Table>
                    
                </Col>
              </Row>
           </Container>
          </div>
        ) 
      }

} 

export default UserHomeForm;