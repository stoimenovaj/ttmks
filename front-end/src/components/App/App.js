import React from 'react';
import './App.css';
import Header from "../Header/header";
import Login from "../Login/login"
import bg1 from "../../images/bg.jpg"
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Auth from "../../service/authService";
import {ACCESS_TOKEN} from "../../constants";
import Turniri from "../Turniri/turniri";
import {withRouter} from "react-router";
import Timovi from "../Timovi/timovi";
import Natprevari from "../Natprevari/natprevari";
import CreateNatprevar from "../CreateNatprevar/createNatprevar";
import Statistiki from "../Statistiki/statistiki";

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
                    currentUser: response.data,
                    isAuthenticated: true,
                    isLoading: false
                });
            }).catch(error => {
            this.setState({
                isLoading: false
            });
        });
    };

    handleLogin = (request) => {
        return Auth.login(request);
    };

    handleLogout = (redirectTo="/turniri") => {
        localStorage.removeItem(ACCESS_TOKEN);

        this.setState({
            currentUser: null,
            isAuthenticated: false
        });

    };

    componentDidMount() {
        this.loadCurrentUser();
    }

    render() {

        const routing = (
            <Router>
                <Header currentUser={this.state.currentUser} logout={this.handleLogout}  {...this.props}/>
                <main role="main" className="mt-3">
                    <div className="container-fluid">
                        <Route path={"/turniri"} exact>
                            <Turniri />
                        </Route>
                        <Route path={"/natprevari"} exact>
                            <Natprevari />
                        </Route>
                        <Route path={"/timovi"} exact>
                            <Timovi />
                        </Route>
                        <Route path={"/register"} exact>
                            <h1>Register</h1>
                        </Route>
                        <Route path={"/login"} exact>
                            <Login onLogin={this.handleLogin} getUser={this.loadCurrentUser} {...this.props}/>
                        </Route>
                        <Route path={"/statistiki"}>
                            <Statistiki />
                        </Route>
                        <Route path={"/create-natprevar"}>
                            <CreateNatprevar/>
                        </Route>
                        {/*<Route path={"/logout"}>*/}
                        {/*    <h1>Logout</h1>*/}
                        {/*</Route>*/}
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
                overflow: "auto",
                backgroundSize: "cover",
                backgroundAttachment: "fixed"
            }}>
                {routing}
            </div>
        );

    }

}

export default withRouter(App);
