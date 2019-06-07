import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Table, Form, Button} from 'react-bootstrap';

class Aktivnost extends Component {
    constructor(props){
        super(props);
        this.state = {
            kosnicaId: localStorage.getItem("idKosnice"),
            aktivnosti: [],
            user: localStorage.getItem('username'),
            pass: localStorage.getItem('password'),
            stanje: false
        }
    }

    componentDidMount(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        const options = {
            method: "PATCH",
            body: formData
        }
        fetch("ms_upravljanje/Aktivnost/" + this.state.kosnicaId, options).
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
    azuriraj(aktivnos) {
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        var uradjenov = -1;
        if(this.state.stanje === true) {
            uradjenov = 1
        } else uradjenov = 0
        var Aktivnost = "{ \n" + 
            "\"aktivnost\":" + "\"" + aktivnos.aktivnost + "\"" + ", \n" + 
            "\"mjesec\":" + "\"" + aktivnos.mjesec + "\"" + ", \n" +
            "\"uradjeno\":" + uradjenov + "\n" +
        "}";
        formData.append("Aktivnost", Aktivnost);
        const options = {
            method: "PUT",
            body: formData
        }
        fetch("ms_upravljanje/Aktivnost/" + aktivnos.id, options).
            then((response) => response.json()).
                then((responseJson) => {
                    alert(JSON.stringify(responseJson))
                })
        
    }
render(){

    const aktivnost1 = this.state.aktivnosti.map((aktivnost) =>{
        return (
                <tr>
                    <td>{aktivnost.id}</td>
                    <td><Form.Control as="textarea" onChange = {(e) =>  { aktivnost.aktivnost = e.target.value} } defaultValue = {aktivnost.aktivnost} /></td>
                    <td>{aktivnost.mjesec}</td>
                    <td> <input type="checkbox" defaultChecked={aktivnost.uradjeno} onChange={(e) => { this.setState({stanje: e.target.checked})}} /></td>
                    <td> <button className="submittable" onClick = {function(){this.azuriraj(aktivnost)}.bind(this)}>Ažuriraj</button> </td>
                </tr>
        
        );
    })
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled Aktivnosti</h3>
                <Container>
                    <Row>
                        <Col>
                        <Table striped bordered hover>
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
                        </Col>
                    </Row>
                </Container>
                
        
            </div>
        
        </div>
    
    );
}

}

export default Aktivnost;