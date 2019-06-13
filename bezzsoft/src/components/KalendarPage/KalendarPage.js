import React, { Component } from 'react';
import NavBar from '../UserNavBar/UserNavBar';
import Header from '../Header/Header';
import {Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'



class KalendarPage extends Component {
constructor(props){
super(props);
this.state ={ 
isLoading: true,
lokacije:[],
grad:"Zenica",
redirect:false,
}
}
componentDidMount(){
fetch('/ms_kalendar/lokacije')
.then((response) => response.json())
.then((responseJson) => {
var o=Object.keys(responseJson).length
var l=[]
for( var i=0;i<o;i++){
l.push(responseJson[i].lokcaija)
}
this.setState({
isLoading: false,
lokacije:l
}
)
})


}

prikazibiljke(){
this.setState({
redirect:true,
})
}
yourChangeHandler(event){
this.setState({
grad:event.target.value
})
}


render(){



if(this.state.redirect === true){
return <Redirect to={{
    pathname: '/pregledbiljaka',
    state: { grad: this.state.grad }
}}></Redirect>
}

if(this.state.isLoading){
return(
<div>Loading</div>
)
}

if(!localStorage.getItem('prijavljen')){
    return <Redirect to="/login"></Redirect>
}

const lokacije = this.state.lokacije.map(function(lokacija){
return <option> {lokacija} </option>;
});

return(
<div className="mainpage">
<NavBar></NavBar>
<Header></Header>
<div className="body">
<h3 className="naslov">Kalendar</h3>
<div className="loginforma">
<Form.Group controlId="exampleForm.ControlSelect1">
<Form.Label>Lokacije </Form.Label>
<Form.Control as="select" onChange={this.yourChangeHandler.bind(this)}>
{lokacije}
</Form.Control>
</Form.Group>
<button className="submit" onClick={this.prikazibiljke.bind(this)} >
Dohvati biljke
</button> 
</div>
</div>
</div>
)
}

}

export default KalendarPage;
