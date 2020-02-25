import React from 'react';
import './App.css';
import Header from "../Header/header";
import Sezona from "../Sezona/sezona";
import Login from "../Login/login"

function App() {

  let code = <script>{nesto()}</script>;

  return (
    <div className="App">
    <Header />
    <Login/>

    <Sezona/>
      <div style={{marginTop: "5%"}} className="container-fluid">
        <div className="row ">
          <div className="col-sm-12 col-md-3 "/>
          {code}
        </div>
      </div>

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
