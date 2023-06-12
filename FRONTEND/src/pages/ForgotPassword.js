import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export function ForgotPassword() {

    const [email, setEmail] = useState("");
    const [user, setUser] = useState("");
    const [newotp, setNewotp] = useState("");
    const navigate = useNavigate();

    function handleEmailChange(e) {
        const { value } = e.target;
        setEmail(value);
    }

    function handleOTPChange(e) {
        const { value } = e.target;
        setNewotp(value);
    }

    function handleGetOTPClick() {
        axios.post("http://localhost:8181/forgot-password/verifyOTP", { email })
            .then(response => {
                localStorage.setItem("key", response.data);
                const result = response.data;
                console.log(result);
                setUser(result);
            });
    }

    function handleOTPSubmit(event) {
        event.preventDefault();

        axios.post("http://localhost:8181/forgot-password/otpvfn", {
            otp: newotp,
            email: user.email
        })
        .then(response => {
            const result = response.data;
            console.log("inside otp verification", response.data);
            localStorage.setItem("user", JSON.stringify(response.data));
            console.log(result);

            if (result != null) {
                navigate("/newpassword");
            }
        });
    }

    return (
        <>
            <div className="form_div">
                <label>Enter Your Email</label>
                <input
                    id="enteremail"
                    className="field_class"
                    name="email"
                    type="email"
                    placeholder="Enter email"
                    value={email}
                    onChange={handleEmailChange}
                />
                <button
                    className="submit_class"
                    type="submit"
                    onClick={handleGetOTPClick}
                >
                    Get-OTP
                </button>
            </div>
            {user && (
                <div>
                    <table id="tbl">
                        <thead>
                            <tr>
                                <th>First-Name</th>
                                <th>Last-Name</th>
                                <th>Enter OTP</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{user.firstName}</td>
                                <td>{user.lastName}</td>
                                <td>
                                    <label>OTP:</label>
                                    <input
                                        id="newotp"
                                        type="number"
                                        name="newotp"
                                        value={newotp}
                                        onChange={handleOTPChange}
                                    />
                                </td>
                                <td>
                                    <button onClick={handleOTPSubmit}>Submit OTP</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            )}
        </>
    );
}
