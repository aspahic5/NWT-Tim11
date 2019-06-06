import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form, Nav} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class UserHomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            Kosnica: {  
                        id: -1,
                        brojramova: 0,
                        vlasnik_id: -1,
                        brojnastavaka: 0,
                        godistematice: "",
                        brojhanemanki: 0,
                        kolicinastimulansa: "0",
                        tipstimulansa: "",
                        komentar: ""
            }
        }
    }
    
    componentDidMount(){
        var data = new FormData();
        data.append("username", localStorage.getItem('username'));
        data.append("password", localStorage.getItem('password'));
        const options = {
            method: "OPTIONS",
            body: data
        }
        fetch("/ms_upravljanje/Kosnica/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson)=>{
                    var str = responseJson.maticagod
                    var str2 = str[8] + str[9] + '/' + str[5] + str[6] + '/' + str[0] + str[1] + str[2] + str[3];
                    this.setState({
                        Kosnica: {
                            id: responseJson.id,
                            brojramova: responseJson.brojramova,
                            vlasnik_id: responseJson.vlasnik_id,
                            brojnastavaka: responseJson.brojnastavaka,
                            godistematice: str2,
                            brojhanemanki: responseJson.brojhanemanki,
                            kolicinastimulansa: responseJson.kolstimulansa,
                            tipstimulansa: responseJson.tipstimulansa,
                            komentar: responseJson.komentar
                        }
                    })
                })
    }
    kosnica(Kosnica){
        return(
            <tbody> 
            <tr>
                <th>ID</th>
                <td><Form.Control type="number"  readOnly = {true} value = {Kosnica.id}/> </td>
            </tr>
            <tr>
                <th>BROJ HANEMANKI</th>
                <td><Form.Control type="number" placeholder = {Kosnica.brojhanemanki }/> </td>
            </tr>
            <tr>
                <th>BROJ NASTAVAKA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.brojnastavaka }/> </td>
            </tr>
            <tr>
                <th>BROJ RAMOVA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.brojramova}/> </td>
            </tr>
            <tr>
                <th>STIMULANS</th>
                <td><Form.Control type="text" placeholder = {Kosnica.tipstimulansa}/> </td>
            </tr>
            <tr>
                <th>KOLIČINA STIMULANSA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.kolicinastimulansa}/> </td>
            </tr>
            <tr>
                <th>GODIŠTE MATICE</th>
                <td><Form.Control value = {Kosnica.godistematice} placeholder = "DD/MM/YYYY" /> </td>
            </tr>
            <tr>
                <th>NASTALA ROJENJEM</th>
                <td><Form.Control defaultValue="null"/> </td>
            </tr>
            <tr>
                <th>KOMENTAR</th>
                <td><Form.Control as="textarea" placeholder = {Kosnica.komentar} /></td>
            </tr>
            <tr>
                <td colspan="2"> <button className="submittable"  > Ažuriraj košnicu </button> </td>
            </tr>
        </tbody>
    )}
render(){

    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
            <div className="body">
                <h3 className="naslov">Detalji košnice</h3>
                <Container>
                    <Row>
                      <Col>
                      <Table striped bordered hover>
                          {this.kosnica(this.state.Kosnica)}
                        </Table>
                      </Col> 
                      <Col>
                        <Table className="table" striped bordered hover>
                            <tbody className="table"> 
                                <tr>
                                    <th> <Nav.Link href =  "/dodajaktivnost" > <button className="submittable"   > Dodaj aktivnost </button> </Nav.Link></th>
                                    <td> <Nav.Link href = "/aktivnost" > <button className="submittable"    > Pregled aktivnosti </button></Nav.Link></td>
                                </tr>
                                <tr>
                                    <th> <Nav.Link href = "/dodajrojenje" > <button className="submittable" > Dodaj rojenje </button></Nav.Link></th>
                                    <td> <Nav.Link href = "/rojenje" ><button className="submittable"    >  Trenutno rojenje </button></Nav.Link> </td>
                                </tr>
                                <tr>
                                    <td> <Nav.Link href = "/proizvodnjaMed" > <button className="submittable"  > Dodaj vrcanje </button></Nav.Link> </td>
                                    <td>  <button className="submittable"  > Povijest vrcanja </button></td>
                                </tr>
                                <tr>
                                    <td colspan = "2"> <button className="submittable"  > Obriši košnicu </button></td>
                                </tr>
                            </tbody>
                        </Table>
                      </Col>
                    </Row>
                    <Row>
                    </Row>
                </Container>
                
        
            </div>
        
        </div>
    
    );
}

}

export default UserHomePage;