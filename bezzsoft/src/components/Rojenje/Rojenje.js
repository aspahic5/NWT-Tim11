import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {Container, Row, Col, Table, Form, Nav} from 'react-bootstrap';

class Rojenje extends Component {
    constructor(props){
        super(props);
        this.state = {
            KosnicaId: localStorage.getItem("idKosnice"),
            Rojenje: []
        }
    }

    componentDidMount(){
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "PATCH",
            body: data
        }
        fetch("/ms_upravljanje/Rojenje/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    var l=[]
                    for( var i=0;i<o;i++){
                      l.push(responseJson[i]);
                    }
                    this.setState({
                        Rojenje:l
                    })
                })

    }

    obrisi(id){
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "DELETE",
            body: data
        }
        fetch("/ms_upravljanje/Rojenje/" + id, options).
            then((response) => response.json()).
                then((responseJson) => {
                    alert(JSON.stringify(responseJson));
                    this.setState({
                        redirect: true
                    })
                })
    }

render(){

    const roj = this.state.Rojenje.map((Jedno) => {
        return (
            <tr>
                <td>{Jedno.id}</td>
                <td><Form.Control type="number"  readOnly = {true} defaultValue = {Jedno.brojmaticnjaka}/> </td>
                <td><Form.Control defaultValue = {Jedno.starostmaticnjaka} /> </td>
                <td><Form.Control defaultValue= {Jedno.tipmaticnjaka}/> </td>
                <td><Form.Control readOnly = {true} as="textarea" defaultValue={Jedno.komentar} /></td>
                <td> <Nav.Link href = "/rojenje" > <button className="submittable" onClick = {function(){ this.obrisi(Jedno.id); }.bind(this)} >Obriši </button> </Nav.Link></td>
            </tr>
        )
    });
    
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Trenutno rojenje</h3>
                <Container>
                    <Row>
                        <Col>
                        <Table striped bordered hover>
                            <tr>
                                <th>ID</th>
                                <th>BROJ MATIČNJAKA</th>
                                <th>STAROST MATIČNJAKA</th>
                                <th>TIP MATIČNJAKA</th>
                                <th>KOMENTAR</th>
                                <th>           </th>
                            </tr>
                        <tbody>
                            {roj}
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

export default Rojenje;