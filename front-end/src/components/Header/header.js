import React from "react";
import {Link} from "react-router-dom";
import mkflag from '../../images/mkflag.png'

const Header = () => {

    return(
        <nav className="navbar navbar-expand-lg bg-dark text-uppercase">

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
                    <li className="nav-item"><Link className="nav-link" to={"/turniri"}>Турнири</Link></li>
                    <li className="nav-item"><Link className="nav-link" to={"/natprevari"}>Натпревари</Link></li>
                    <li className="nav-item"><Link className="nav-link" to={"/registriraniLica"}>Регистрирани лица</Link></li>
                </ul>
            </div>

        </nav>
    )
}

export default Header;