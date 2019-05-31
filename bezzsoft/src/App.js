import React from 'react';
import {BrowserRouter ,Route,Switch} from 'react-router-dom';
import LoginPage from './components/LoginPage/LoginPage';
import HomePage from './components/HomePage/HomePage';
import PrijavaPage from './components/PrijavaPage/PrijavaPage';
import AdminPage from './components/AdminPage/AdminPage';
import AdminPage1 from './components/AdminPage1/AdminPage1';
import UserHomePage from './components/UserHomePage/UserHomePage';
import Kalendar from './components/KalendarPage/KalendarPage';
import PregledKosnica from './components/PregledKosnica/PregledKosnica';
import Kosnica from './components/Kosnica/Kosnica';


import './App.css';

function App() {
  return (
    <BrowserRouter>
        <Switch>
        
          <Route exact path="/" component={HomePage} />
          <Route exact path="/login" component={LoginPage} />
          <Route exact path="/prijava" component={PrijavaPage} />
          <Route exact path="/pregledkorisnika" component={AdminPage} />
          <Route exact path="/dodajkorisnika" component={AdminPage1} />
          <Route exact path="/home" component={UserHomePage} />
          <Route exact path="/kalendar" component={Kalendar} />
          <Route exact path="/pregledkosnica" component={PregledKosnica} />
          <Route exact path="/kosnica" componenet={Kosnica}/>
          
        </Switch>
      </BrowserRouter>
      
  );
}

export default App;
