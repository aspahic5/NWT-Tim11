import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form, Nav} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class pregledSelidbi extends Component {
    constructor(props){
        super(props);
        this.state = {
            kosnicaId: localStorage.getItem("idKosnice"),
            selidbe: [],
            stanje: false
        }
    }
    componentDidMount(){
        var formData = new FormData();
        formData.append("username", localStorage.getItem("username"));
        formData.append("password", localStorage.getItem("password"));
        const options = {
            method: "PATCH",
            body: formData
        }
        fetch("ms_upravljanje/Selidba/" + this.state.kosnicaId, options).
            then((response) => response.json()).
                then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    var l=[]
                    for( var i=0;i<o;i++){
                        l.push(responseJson[i]);
                    }
                    this.setState({
                        selidbe:l
                    })
                });
    }
render(){
    const selidba1 = this.state.selidbe.map((selidba) =>{
        return (
                <tr>
                    <td>{selidba.id}</td>
                    <td>{selidba.brojkosnica}</td>
                    <td>{selidba.dobit}</td>
                    <td> {selidba.pocetak}</td>
                    <td> {selidba.kraj} </td>
                    <td>{selidba.lokacija}</td>
                </tr>
        
        );
    })
    return(
        <div className="mainpage">
            
        <NavBar></NavBar>
    
        <Header></Header>
    
    

        <div className="body">
            <h3 className="naslov">Pregled Selidbi</h3>
            <Container>
                <Row>
                    <Col>
                    <Table striped bordered hover>
                        <tr>
                            <th>ID</th>
                            <th>BROJ KOŠNICA</th>
                            <th>DOBIT (KM)</th>
                            <th>POČETAK SELIDBE</th>
                            <th>KRAJ SELIDBE</th>
                            <th>LOKACIJA</th>
                        </tr>
                    <tbody>
                        {selidba1}
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

export default pregledSelidbi;