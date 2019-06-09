import React, { Component } from 'react';
import { Form, ListGroup} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PropolisForm extends Component{

    render(){
        return(
            <Form>
                    <Form.Row>
                    <Form className="listaProizvodnjaForma">
                        <ListGroup>
                            <ListGroup.Item action >Košnica 1</ListGroup.Item>
                            <ListGroup.Item action >Košnica 2</ListGroup.Item>
                            <ListGroup.Item action >Košnica 3</ListGroup.Item>
                            <ListGroup.Item action >Košnica 4</ListGroup.Item>
                            <ListGroup.Item action >Košnica 5</ListGroup.Item>
                        </ListGroup>
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

export default PropolisForm;