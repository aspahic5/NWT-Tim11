import React, { Component } from 'react';
import { Form, ListGroup} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class MedForm extends Component{
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: [],
            user: "",
            pass: "",
            id: -1,
            prijavljen: false
        }
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
            method: "PATCH",
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
              <option>{kosnica}</option>
            )
          })

        const nesto = this.state.ukupno;
        return(
            
            <Form>
                    <Form.Row>
                    <Form className="listaProizvodnjaForma">
                        <Form.Control as="select">
                        <option>Odaberite košnicu...</option>
                        {nesto}
                      </Form.Control>
                    </Form>

                    <Form className="proizvodnjaForma">

                        
                            <Form.Control
                            type = "number"
                            placeholder="Količina"
                            />
                            <Form.Control
                            type = "number"
                            placeholder="Cijena"
                            />     
                            <button className="submit">
                            UNESI
                            </button>           
                        
                        
                    </Form>
                    </Form.Row>
                </Form>
        );
    }

}

export default MedForm;