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
import Rojenje from './components/Rojenje/Rojenje';
import Aktivnost from './components/Aktivnost/Aktivnost';
import DodajRojenje from './components/Rojenje/DodajRojenje';
import DodajAktivnost from './components/Aktivnost/DodajAktivnost';
import ProizvodnjaMed from './components/ProizvodnjaMed/ProizvodnjaMed';
import ProizvodnjaMlijec from './components/ProizvodnjaMlijec/ProizvodnjaMlijec';
import ProizvodnjaPropolis from './components/ProizvodnjaPropolis/ProizvodnjaPropolis';
import DodajKosnicu from './components/DodajKosnicu/DodajKosnicu';
import PregledBiljaka from './components/PregledBiljaka/PregledBiljaka';
import PregledUnosa from './components/PregledUnosa/PregledUnosa';
import Selidba from './components/Selidba/Selidba';
import PregledSelidbi from './components/Selidba/pregledSelidbi';
import PregledMed from './components/PregledUnosa/PregledMed';
import PregledMaticna from './components/PregledUnosa/PregledMaticna';
import PregledPropolis from './components/PregledUnosa/PregledPropolis';



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
          <Route exact path="/kosnica" component={Kosnica} />
          <Route exact path="/rojenje" component={Rojenje} />
          <Route exact path="/Aktivnost" component={Aktivnost} />
          <Route exact path="/dodajaktivnost" component={DodajAktivnost} />
          <Route exact path="/dodajrojenje" component={DodajRojenje} />
          <Route exact path="/kosnica" componenet={Kosnica}/>
          <Route exact path="/proizvodnjaMed" component={ProizvodnjaMed}/>
          <Route exact path="/proizvodnjaMlijec" component={ProizvodnjaMlijec}/>
          <Route exact path="/proizvodnjaPropolis" component={ProizvodnjaPropolis}/>
          <Route exact path="/pregledbiljaka" component={PregledBiljaka} />
          <Route exact path="/dodajkosnicu" component={DodajKosnicu} />
          <Route exact path="/pregledUnosa" component={PregledUnosa} />
          <Route exact path="/selidba" component={Selidba} />
          <Route exact path="/pregledSelidbe" component={PregledSelidbi} />
          <Route exact path="/pregledMed" component={PregledMed} />
          <Route exact path="/pregledMaticna" component={PregledMaticna} />
          <Route exact path="/pregledPropolis" component={PregledPropolis} />
          
        </Switch>
      </BrowserRouter>
      
  );
}

export default App;
