import React, { Component } from 'react';
import { Form, ListGroup} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PropolisForm extends Component{

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
            kolicina:0
        }
    }

    dodajPropolis(){
        var formData = new FormData();
        formData.append("username", this.state.user);
        formData.append("password", this.state.pass);
        var Propolis = "{ \n" + 
            "\"km_kg\":" + this.state.km_kg + ", \n" + 
            "\"kolicina\":" + this.state.kolicina + " \n" +
        "}";
        formData.append("json", Propolis);
        const options = {
            method: "POST",
            body: formData
        }
        fetch("/ms_proizvodnja/Propolis/" + this.state.id, options).
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
                <button className="unoS" onClick = {() => {this.dodajPropolis()}}>
                    UNESI
                </button>   
                </div>
        );
    }
}

export default PropolisForm;