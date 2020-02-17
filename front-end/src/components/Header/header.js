import React from "react";
import mkflag from '../../images/mkflag.png'

const Header = () => {

    return(
        <nav className="navbar navbar-expand-lg navbar-dark fixed-top bg-dark text-uppercase mb-5">

            <button className="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>

            <a className="navbar-brand font-weight-bold" href="#">
                <img src={mkflag} width="30" height="30" className="d-inline-block align-top" alt=""/>
                    TTMK
            </a>

            <div className="navbar-collapse collapse" id="navbarSupportedContent">
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item"><a href="#" className="nav-link">Турнири</a></li>
                    <li className="nav-item"><a href="#" className="nav-link">Натпревари</a></li>
                    <li className="nav-item"><a href="#" className="nav-link">Регистрирани лица</a></li>
                </ul>
            </div>

        </nav>
    )
}

export default Header;