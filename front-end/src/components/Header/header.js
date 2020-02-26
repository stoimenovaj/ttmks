import React from "react";
import {Link} from "react-router-dom";
import mkFlag from '../../images/mkflag.png'
import {ROLE_ADMIN} from "../../constants";
import {withRouter} from "react-router";

const Header = (props) => {

    let items = [];

    const handleLogout = () => {
        props.history.push('/turniri');
        props.logout();
    };

    if (props.currentUser) {
        console.log(props.currentUser);
        if (props.currentUser.role === ROLE_ADMIN) {
            items = [
                <li className="nav-item"><Link className="nav-link" to={"/register"}>Регистрирај лице</Link></li>
            ];
        }
        items.push(
            <li className="nav-item"><Link className="nav-link" to={"#"} onClick={handleLogout}>Одјава</Link></li>
        );
    } else {
        items = [
            <li className="nav-item"><Link className="nav-link" to={"/login"}>Логирај се</Link></li>
        ];
    }

    return (
        <nav className="navbar navbar-expand-lg bg-dark text-uppercase">

            <button className="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"/>
            </button>

            <Link className="navbar-brand font-weight-bold" to="/turniri">
                <img src={mkFlag} width="30" height="30" className="d-inline-block align-top" alt=""/>
                TTMK
            </Link>

            <div className="navbar-collapse collapse" id="navbarSupportedContent">
                <ul className="nav navbar-nav mr-auto">
                    <li className="nav-item"><Link className="nav-link" to={"/turniri"}>Турнири</Link></li>
                    <li className="nav-item"><Link className="nav-link" to={"/natprevari"}>Натпревари</Link></li>
                    <li className="nav-item"><Link className="nav-link" to={"/registriraniLica"}>Регистрирани
                        лица</Link></li>
                    {items}
                </ul>
            </div>

        </nav>
    )
};

export default withRouter(Header);