import React from "react";

const Login = () => {

    const validate = () => {
        let mail = document.getElementById("address")
        let pass = document.getElementById("password")
        let message = document.getElementById("message")

        if(mail.value==="" || pass.value.length <= 6){
            message.hidden = false
        } else {
            message.hidden = true
        }
    };

    return (
        <div>
            <div className="col-sm-4 ml-auto mr-auto border rounded p-5 mt-5 bg-dark text-primary" style={{opacity: "0.9"}}>
                <label htmlFor="address">Email адреса:</label>
                <input id="address" className="form-control text-center" autoFocus type="text" placeholder="example@example.com" />
                <br/>
                <label htmlFor="password">Password</label>
                <input id="password" className="form-control text-center" type="password" placeholder="******" />
                <hr />
                <div id="message" hidden>
                    <p className="text-danger"><b>Invalid email or password</b></p>
                </div>
                <br />
                <div className="col-sm-8 ml-auto mr-auto">
                    <button onClick={validate} className="btn btn-primary btn-block">Login</button>
                </div>
            </div>
        </div>


)
};

export default Login