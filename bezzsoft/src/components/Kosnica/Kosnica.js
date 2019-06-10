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
            },
            redirect: false
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
    azuriraj() {
        var data = new FormData();
        data.append("username", localStorage.getItem('username'));
        data.append("password", localStorage.getItem('password'));
        var str = this.state.Kosnica.godistematice;
        var Kosnica = "{ \n" + 
            "\"kolstimulansa\":"  + this.state.Kosnica.kolicinastimulansa  + ", \n" + 
            "\"maticagod\":" + "\"" + str + "\"" + ", \n" +
            "\"tipstimulansa\":" +  "\"" +this.state.Kosnica.tipstimulansa  + "\"" + ", \n" +
            "\"vlasnik_id\":" + this.state.Kosnica.vlasnik_id + ", \n"+
            "\"brojhanemanki\":" + this.state.Kosnica.brojhanemanki + ", \n" +
            "\"brojramova\":" + this.state.Kosnica.brojramova  + ", \n" +
            "\"komentar\":" +  "\"" + this.state.Kosnica.komentar +  "\"" + ", \n" +
            "\"brojnastavaka\":" + this.state.Kosnica.brojnastavaka + " \n" +
        "}";
        data.append("Kosnica", Kosnica);
        const options = {
            method: "PUT",
            body: data
        }
        fetch("/ms_upravljanje/Kosnica/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson)=>{
                    alert(JSON.stringify(responseJson));
                })
    }
    obrisi(){
        var data = new FormData();
        data.append("username", localStorage.getItem('username'));
        data.append("password", localStorage.getItem('password'));
        const options = {
            method: "DELETE",
            body: data
        }
        fetch("/ms_upravljanje/Kosnica/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson)=>{
                    alert(JSON.stringify(responseJson));
                    this.setState({
                        redirect: true
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
                <td><Form.Control type="number"  value={this.state.Kosnica.brojhanemanki } onChange={(e)=>{
                    var b = this.state.Kosnica.brojramova;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bn = this.state.Kosnica.brojnastavaka;
                    var godimat = this.state.Kosnica.godistematice;
                    var koltim = this.state.Kosnica.kolicinastimulansa;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova: b,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: godimat,
                            brojhanemanki: e.target.value,
                            kolicinastimulansa: koltim,
                            tipstimulansa: tips,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>BROJ NASTAVAKA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.brojnastavaka } onChange={(e)=>{
                    var b = this.state.Kosnica.brojramova;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var godimat = this.state.Kosnica.godistematice;
                    var koltim = this.state.Kosnica.kolicinastimulansa;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova: b,
                            vlasnik_id: vl,
                            brojnastavaka: e.target.value,
                            godistematice: godimat,
                            brojhanemanki: bh,
                            kolicinastimulansa: koltim,
                            tipstimulansa: tips,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>BROJ RAMOVA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.brojramova} onChange={(e)=>{
                    var bn = this.state.Kosnica.brojnastavaka;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var godimat = this.state.Kosnica.godistematice;
                    var koltim = this.state.Kosnica.kolicinastimulansa;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova:  e.target.value,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: godimat,
                            brojhanemanki: bh,
                            kolicinastimulansa: koltim,
                            tipstimulansa: tips,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>STIMULANS</th>
                <td><Form.Control type="text" placeholder = {Kosnica.tipstimulansa} onChange={(e)=>{
                    var bn = this.state.Kosnica.brojnastavaka;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var godimat = this.state.Kosnica.godistematice;
                    var koltim = this.state.Kosnica.kolicinastimulansa;
                    var b = this.state.Kosnica.brojramova;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova:  b,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: godimat,
                            brojhanemanki: bh,
                            kolicinastimulansa: koltim,
                            tipstimulansa: e.target.value,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>KOLIČINA STIMULANSA</th>
                <td><Form.Control type="number" placeholder = {Kosnica.kolicinastimulansa} onChange={(e)=>{
                    var bn = this.state.Kosnica.brojnastavaka;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var godimat = this.state.Kosnica.godistematice;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var b = this.state.Kosnica.brojramova;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova:  b,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: godimat,
                            brojhanemanki: bh,
                            kolicinastimulansa: e.target.value,
                            tipstimulansa: tips,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>GODIŠTE MATICE</th>
                <td><Form.Control value = {Kosnica.godistematice} placeholder = "DD/MM/YYYY" onChange={(e)=>{
                    var bn = this.state.Kosnica.brojnastavaka;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var kols = this.state.Kosnica.kolicinastimulansa;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var b = this.state.Kosnica.brojramova;
                    var kom = this.state.Kosnica.komentar;
                    this.setState({ 
                        Kosnica: { 
                            brojramova:  b,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: e.target.value,
                            brojhanemanki: bh,
                            kolicinastimulansa: kols,
                            tipstimulansa: tips,
                            komentar: kom
                        }
                    })
                }}/> </td>
            </tr>
            <tr>
                <th>KOMENTAR</th>
                <td><Form.Control as="textarea" placeholder = {Kosnica.komentar} onChange={(e)=>{
                    var bn = this.state.Kosnica.brojnastavaka;
                    var vl = this.state.Kosnica.vlasnik_id;
                    var bh = this.state.Kosnica.brojhanemanki
                    var kols = this.state.Kosnica.kolicinastimulansa;
                    var tips = this.state.Kosnica.tipstimulansa;
                    var b = this.state.Kosnica.brojramova;
                    var godm = this.state.Kosnica.godistematice;
                    this.setState({ 
                        Kosnica: { 
                            brojramova:  b,
                            vlasnik_id: vl,
                            brojnastavaka: bn,
                            godistematice: godm,
                            brojhanemanki: bh,
                            kolicinastimulansa: kols,
                            tipstimulansa: tips,
                            komentar: e.target.value
                        }
                    })
                }}/></td>
            </tr>
        </tbody>
    )}

render(){

    if(this.state.redirect) {
        return <Redirect to="/pregledkosnica"></Redirect>
    }

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
                        <tr>
                            <td colspan="2"> <button className="submittable"  onClick = {() => {this.azuriraj()}}> Ažuriraj košnicu </button> </td>
                        </tr>
                       
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
                                    <td> <Nav.Link href = "/pregledUnosa" >  <button className="submittable"  > Povijest vrcanja </button></Nav.Link></td>
                                </tr>
                                <tr>
                                    <td> <Nav.Link href = "/selidba" > <button className="submittable"  > Dodaj selidbu </button> </Nav.Link> </td>
                                    <td> <Nav.Link href = "/pregledSelidbe" >  <button className="submittable"  > Pregled selidbe </button></Nav.Link> </td>
                                </tr>
                                <tr>
                                    <td colspan = "2"> <button className="submittable" onClick = {() => this.obrisi()} > Obriši košnicu </button></td>
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