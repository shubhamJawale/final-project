import { useState } from "react";
import axios from "axios";
import { baseurl } from "../resources/baseurl";
import swal from 'sweetalert';
import { toast, ToastContainer } from "react-toastify";

function Register() {
    let [username, setusername] = useState();
    let [emailid, setemailid] = useState();
    let [mobileno, setmobileno] = useState();
    let [address, setaddress] = useState();
    let [pincode, setpincodes] = useState();
    let [password, setpassword] = useState();
    let [cpassword, setcpassword] = useState();
    let [role, setrole] = useState();

    let usernameinput = (e) => setusername(e.target.value);
    let emailidinput = (e) => setemailid(e.target.value);
    let mobilenoinput = (e) => setmobileno(e.target.value);
    let addressinput = (e) => setaddress(e.target.value);
    let pincodeinput = (e) => setpincodes(e.target.value);
    let passwordinput = (e) => setpassword(e.target.value);
    let cpasswordinput = (e) => setcpassword(e.target.value);
    let roleinput = (e) => {

        setrole(e.target.value);

    };

    const nameRgx = /^[a-zA-Z\s]+$/;
    const emailRgx = /^[a-zA-Z0-9._]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    const mobilenoRgx = /^[789][0-9]{9}$/;
    const passwordRgx = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
    const pincodeRgx = /^[0-9\s]{6}$/;
    //axios
    let register = () => {

        let user = {

            userName: username,
            emailId: emailid,
            mobileNo: mobileno,
            address: address,
            pincode: pincode,
            password: password,
            role: role
        }

        axios.post(`${baseurl}/register`, user).then(

            (response) => {

                swal("User Registered", `Registered as : ${role}`, "success");

                console.log(response.status);
                setusername("");
                setaddress("");
                setemailid("");
                setmobileno("");
                setpassword("");
                setcpassword("")
                setpincodes("");
                setrole("");


            },

            (error) => {

                swal("Error Occured", "Please Try Again", "error");


            }
        )


    }

    let validate = () => {

        if (username === "" || emailid === "" || mobileno === "" || pincode === "" || address === "" || password === "" || role === "") {
            swal("Error", "Please fill up details", "error");
        } else if (!nameRgx.test(username)) {
            swal("Invalid name", "Name should contain 1st letter capital, it must include 2 letters and it should not exclude 40 letters", "error");
            setusername("");
        } else if (!emailRgx.test(emailid)) {
            swal("Invalid Email Id", "Please Enter valid email", "error");
            setemailid("");
        } else if (!mobilenoRgx.test(mobileno)) {
            swal("Invalid MObileNO", "Please Enter valid mobileno", "error");
            setmobileno("");
        } else if (!pincodeRgx.test(pincode)) {
            swal("Invalid Pincode", "Pincode should contain only digits and length must be 6", "error");
            setpincodes("");
        }
        else if (!passwordRgx.test(password)) {
            swal("Invalid Password ", "Password should contain minimum 8 characcters, it must include 1 special character, 1 digit and One capital letter", "error");
            setpassword("");
            setcpassword("");
        } else if (!password.match(cpassword)) {
            swal("Password doesn't Match", "", "error");
            setcpassword("");
        } else {
            register();


        }
    }






    return (
        <div>
            <ToastContainer />
            <div className="col-4 offset-4 justify-content-center my-5">

                <form className="form-control">
                    <lable htmlFor="UserName"> Enter Name</lable>
                    <input className="form-control" type="text" name="UserName" id="UserName" onChange={usernameinput} value={username}></input>
                    <lable htmlFor="EmailId"> Enter EmailId</lable>
                    <input className="form-control" type="email" name="EmailId" id="EmailId" onChange={emailidinput} value={emailid}></input>
                    <lable htmlFor="MobileNo"> Enter Mobile No</lable>
                    <input className="form-control" type="tel" name="MobileNo" id="MobileNo" onChange={mobilenoinput} value={mobileno}></input>
                    <lable htmlFor="Adress"> Enter Address</lable>
                    <textarea className="form-control" name="Address" id="Address" onChange={addressinput} value={address}></textarea>
                    <lable htmlFor="PinCode"> Enter Pincode</lable>
                    <input className="form-control" type="text" name="PinCode" id="PinCode" onChange={pincodeinput} value={pincode}></input>
                    <lable htmlFor="Password"> Enter Password</lable>
                    <input type="password" className="form-control" name="Password" id="Password" onChange={passwordinput} value={password}></input>
                    <lable htmlFor="CPassword"> Confirm Password</lable>
                    <input type="password" className="form-control" name="CPassword" id="CPassword" onChange={cpasswordinput} value={cpassword}></input>
                    <label htmlFor="Role">Select Role</label>
                    <select value={role} onChange={roleinput} className="form-control" name="Role" id="Role">
                        <option selected value="">Select Role</option>
                        <option value="USER">USER</option>
                        <option value="CONTRACTOR">CONTRACTOR</option>
                        <option value="LABOUR">LABOUR</option>
                    </select>
                    <br />
                    <input type="button" className="form-control" onClick={validate} value="Register" />
                </form>
            </div >
        </div>
    );
}
export default Register;

