import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {ListGroup} from 'react-bootstrap';

class PregledKosnica extends Component {
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
                <h3 className="naslov">Pregled Košnica</h3>
                <ListGroup>
                    <ListGroup.Item action >Košnica 1</ListGroup.Item>
                    <ListGroup.Item action >Košnica 2</ListGroup.Item>
                    <ListGroup.Item action >Košnica 3</ListGroup.Item>
                    <ListGroup.Item action >Košnica 4</ListGroup.Item>
                    <ListGroup.Item action >Košnica 5</ListGroup.Item>
                </ListGroup>
            </div>
        
        </div>
    
    );
}

}

export default PregledKosnica;