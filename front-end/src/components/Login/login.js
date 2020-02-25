import React from "react";

const Login = () => {

    return (
        <div>
            <div>
                <label>Email</label>
                <input type="text" />
                <label>Password</label>
                <input type="password" />
                <button className="btn btn-primary">Login</button>
            </div>
        </div>
)
};

export default Login