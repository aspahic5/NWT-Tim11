import React, { Component } from 'react';
import { Form, ListGroup} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class MlijecForm extends Component{

    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: [],
            user: "",
            pass: "",
            id: -1,
            prijavljen: false,
            km_kg: 0,
            kolicina:0,
            ukupno:-1
        }
    }

    dodajUnos(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        var Unos = "{ \n" + 
        "\"kolicina\":" + this.state.kolicina + ", \n" + 
        "\"date\":" + "\" nebitno \"" +  " \n" +
        "}";
        formData.append("json", Unos);
        const options = {
            method: "POST",
            body: formData
        }
        fetch("/ms_proizvodnja/Unos/" + this.state.id, options).
            then((response) => response.json()).
                then((responseJson) =>{
                    alert(JSON.stringify(responseJson));
                });
    }

    dodajMlijec(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        var Maticna = "{ \n" + 
            "\"km_kg\":" + this.state.km_kg + ", \n" + 
            "\"kolicina\":" + this.state.kolicina + " \n" +
        "}";
        formData.append("json", Maticna);
        const options = {
            method: "POST",
            body: formData
        }
        fetch("/ms_proizvodnja/Maticna/" + this.state.id, options).
            then((response) => response.json()).
                then((responseJson) =>{
                    alert(JSON.stringify(responseJson));
                });
    }

    componentDidMount() {
        this.setState({
            user: localStorage.getItem('username'),
            pass: localStorage.getItem('password'),
            prijavljen: localStorage.getItem('prijavljen'),
        })
        var data = new FormData();
        data.append("username",localStorage.getItem('username'));
        data.append("password",localStorage.getItem('password'));
        const options = {
            method: "OPTIONS",
            body: data
        }
        if(localStorage.getItem('prijavljen')){
            fetch("/ms_proizvodnja/DajSveKosnice", options).then((response) => response.json())
                .then((responseJson) => {
                    var o=Object.keys(responseJson).length
                    this.setState({
                      ukupno: o
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
    render(){
        const ids = this.state.Kosnice.map((kosnica) => {
            return (
              <option>{kosnica.id}</option>
            )
          })

        return(
            <div>
            <Form>
                    <Form.Row>
                    <Form className="listaProizvodnjaForma">
                        <Form.Control as="select" onChange={(val)=>this.setState({id:val.target.value})}>
                        <option>Odaberite košnicu...</option>
                        {ids}
                      </Form.Control>
                    </Form>

                    <Form className="proizvodnjaForma">

                        
                            <Form.Control
                            onChange={(val)=>{this.setState({kolicina:val.target.value})}}
                            type = "number"
                            placeholder="Količina"
                            />
                            <Form.Control
                            onChange={(val)=>{this.setState({km_kg:val.target.value})}}
                            type = "number"
                            placeholder="Cijena"
                            />     
                            
                                   
                        
                        
                    </Form>
                    </Form.Row>
                </Form>
                <button className="unoS" onClick = {() => {this.dodajMlijec();
                                                            this.dodajUnos();}}>
                    UNESI
                </button>   
                </div>
        );
    }
}

export default MlijecForm;