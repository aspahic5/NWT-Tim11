import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header'
import {ListGroup} from 'react-bootstrap';
import {Redirect} from 'react-router-dom';

class PregledKosnica extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            Kosnice: [],
            redirect: false
        }
    }


    componentDidMount() {
        
    }
render(){

    if(this.state.redirect) {
        return (<Redirect to={{
            pathname: "/kosnica",
            state: { id: '123' }
        }}/>);
    }
    return(
        <div className="mainpage">
            
            <NavBar></NavBar>
        
            <Header></Header>
        
        
    
            <div className="body">
                <h3 className="naslov">Pregled Košnica</h3>
                <ListGroup>
                    <ListGroup.Item action onClick = {() => {this.setState({ redirect: true })}}>Košnica 1</ListGroup.Item>
                    <ListGroup.Item action onClick = {() => {this.setState({ redirect: true })}} >Košnica 2</ListGroup.Item>
                    <ListGroup.Item action onClick = {() => {this.setState({ redirect: true })}} >Košnica 3</ListGroup.Item>
                    <ListGroup.Item action onClick = {() => {this.setState({ redirect: true })}} >Košnica 4</ListGroup.Item>
                    <ListGroup.Item action onClick = {() => {this.setState({ redirect: true })}} >Košnica 5</ListGroup.Item>
                </ListGroup>
            </div>
        
        </div>
    
    );
}

}

export default PregledKosnica;