import React from 'react';
import './App.css';
import Header from "../Header/header";
import Login from "../Login/login"
import bg1 from "../../images/bg.jpg"
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'

function App() {

  const routing = (
      <Router>
        <Header />

        <main role="main" className="mt-3">

          <div className="container">
            <Route path={"/turniri"}>
            </Route>
            <Route path={"/natprevari"}>
            </Route>
            <Route path={"/registriraniLica"}>
            </Route>
            <Redirect to={"/turniri"}/>
          </div>
        </main>
      </Router>
  )




  return (
    <div className="App " style={{background: "url("+ bg1 +")", width: "100%",
      height: "100vh",backgroundPosition: "center center", backgroundSize: "cover", backgroundAttachment: "fixed"}}>
      {routing}
    </div>
  );
}

function nesto() {
  var acc = document.getElementsByClassName("accordion");
  var i;

  for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
      this.classList.toggle("active");
      var panel = this.nextElementSibling;
      if (panel.style.display === "block") {
        panel.style.display = "none";
      } else {
        panel.style.display = "block";
      }
    });
  }
}

export default App;
