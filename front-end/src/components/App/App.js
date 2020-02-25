import React from 'react';
import './App.css';
import Header from "../Header/header";
import Sezona from "../Sezona/sezona";
import Login from "../Login/login"
import bg1 from "../../images/bg.jpg"
import bg2 from "../../images/bg1.jpg"

function App() {

  let code = <script>{nesto()}</script>;

  return (
    <div className="App " style={{background: "url("+ bg1 +")", width: "100%",
      height: "100vh",backgroundPosition: "center center", backgroundSize: "cover", backgroundAttachment: "fixed"}}>
      <Header />

      <Login />


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
