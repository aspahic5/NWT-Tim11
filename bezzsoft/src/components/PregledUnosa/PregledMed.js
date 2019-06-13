import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Container, Row, Col, Table, Form, Nav, Card} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PregledMed extends Component {
    constructor(props) {
        super(props);
        this.state = {
            Unosi:[],
            pocetak: "",
            Prvi:[1],
            KosnicaId: localStorage.getItem("idOdabrane"),
            Kosnica: {  
                        id: -1,
            },
            redirect: false,
            koja:"",
            i:-1, 
            ukupno:-1
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
        fetch("/ms_proizvodnja/Vrcanje/" + this.state.KosnicaId, options).
            then((response) => response.json()).
                then((responseJson)=>{
                    var o=Object.keys(responseJson).length
                    this.setState({
                      ukupno: o
                    });
                    this.state.koja = "Pregled vrcanja meda za košnicu - " + this.state.KosnicaId + " -";
                    var l=[];
                    if(o == 0){
                        this.state.pocetak = "Za košnicu nema unosa...";
                    }
                    else this.state.pocetak = "Odaberite datum...";
                    for( var i=0;i<o;i++){
                        l.push(responseJson[i])
                    }
                    this.setState({
                        Unosi:l
                    })
                })
    }

    
render(){
        const koja = this.state.koja;
        const pocetak = this.state.pocetak;
        const datumi = this.state.Unosi.map((unos) => {
            return (
            <option>{unos.date}</option>
            )
        });
        const kolicine = this.state.Unosi.map((unos) => {
            return (
            <option>{unos.kolicina}</option>
            )
        });

        const cijene = this.state.Unosi.map((unos) => {
            return (
            <option>{unos.kmkg}</option>
            )
        });
    
    if(this.state.redirect) {
        return <Redirect to="/pregledkosnica"></Redirect>
    }
    if(this.state.KosnicaId == "Odaberite košnicu...")
            return <Redirect to="/home"></Redirect>

    return(
        <div className="mainpage">
            <NavBar></NavBar>
        
            <Header></Header>
            <div className="body">
            <h3 className="naslov">{koja}</h3>
            <div>
                    <div className="listaProizvodnjaForma">
                        <Form.Control as="select" onChange={(val)=>this.setState({i:val.target.selectedIndex})}>
                        <option>{pocetak}</option>
                        {datumi}
                      </Form.Control>
                    </div>

                    <div className="ispis">

                    <p>Količina vrcanja(kg): {kolicine[this.state.i - 1]} Cijena vrcanja(KM): {cijene[this.state.i - 1]}</p>                                
                        
                        
                    </div>
            </div>
            </div>  
        </div>
    
    );
}

}

export default PregledMed;