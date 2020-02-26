import React from 'react';
import './App.css';
import Header from "../Header/header";
import Login from "../Login/login"
import bg1 from "../../images/bg.jpg"
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Auth from "../../service/authService";
import {ACCESS_TOKEN} from "../../constants";
import Turniri from "../Turniri/turniri";

class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            currentUser: null,
            isAuthenticated: false,
            isLoading: false
        }

    }

    loadCurrentUser = () => {
        this.setState({
            isLoading: true
        });
        Auth.getCurrentUser()
            .then(response => {
                this.setState({
                    currentUser: response,
                    isAuthenticated: true,
                    isLoading: false
                });
                console.log("Success!");
            }).catch(error => {
            this.setState({
                isLoading: false
            });
        });
    };

    handleLogin = (request) => {
        return Auth.login(request)
            .then((response) => {
                localStorage.setItem(ACCESS_TOKEN, response.data.accessToken);
                console.log(localStorage.getItem(ACCESS_TOKEN));
                this.loadCurrentUser();
            });
    };

    render() {

        const routing = (
            <Router>
                <Header currentUser={this.state.currentUser}/>
                <main role="main" className="mt-3">
                    <div className="container-fluid">
                        <Route path={"/turniri"}>
                            <Turniri />
                        </Route>
                        <Route path={"/natprevari"}>
                            <h1>Natprevari</h1>
                        </Route>
                        <Route path={"/registriraniLica"}>
                            <h1>Registrirani lica</h1>
                        </Route>
                        <Route path={"/register"}>
                            <h1>Register</h1>
                        </Route>
                        <Route path={"/login"}>
                            <Login onLogin={this.handleLogin}/>
                        </Route>
                        <Route path={"/logout"}>
                            <h1>Logout</h1>
                        </Route>
                        <Redirect to={"/turniri"}/>
                    </div>
                </main>
            </Router>
        );

        return (
            <div className="App " style={{
                background: "url(" + bg1 + ")",
                width: "100%",
                height: "100vh",
                backgroundPosition: "center center",
                backgroundSize: "cover",
                backgroundAttachment: "fixed"
            }}>
                {routing}
            </div>
        );

    }

}

export default App;
