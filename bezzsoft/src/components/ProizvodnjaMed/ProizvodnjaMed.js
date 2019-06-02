import React, { Component } from 'react';
import NavBar from '../ProizvodnjaNavBar/ProizvodnjaNavBar';
import Header from '../Header/Header'
import {ListGroup, Form} from 'react-bootstrap';

class ProizvodnjaMed extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: []
        }
    }

    componentDidMount() {
        
    }
render(){
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Proizvodnja</h3>
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
            </div>
        
        </div>
    
    );
}

}

export default ProizvodnjaMed;