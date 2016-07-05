/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bad_color = "rgba(255, 125, 60, 0.7)";
var ok_color = "rgba(255, 125, 60, 0.0)";

var pass1_ok, pass2_ok, firstName_ok, email_ok, phone_ok;

function checkAll()
{
    console.log("CHECK ALL");
    checkPassword1();
    checkPassword2();
    checkFirstName();
    checkLastName();
    checkEmail();
    checkPhone();
    return false;
}

window.onload = checkAll();

function setColors(elem, msg_elem, msg, cond)
{
    if (cond)
    {
	elem.style.borderColor = ok_color;
	msg_elem.innerHTML = "";
	msg_elem.style.color = ok_color;
	return true;
    }
    else
    {
	elem.style.borderColor = bad_color;
	msg_elem.innerHTML = msg;
	msg_elem.style.color = bad_color;
	return false;
    }
}

function checkUsername()
{
    var msg_elem = document.getElementById("id_regform:id_usr_msg");
    console.log(msg_elem.innerHTML);
    msg_elem.style.display = 'none';
}

function checkPassword1()
{
    var pass_elem = document.getElementById("id_regform:id_pass1");
    var patt = new RegExp(/((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,12})/);
    var msg_elem = document.getElementById("id_pass1_msg");

    pass1_ok = setColors(pass_elem,
	    msg_elem,
	    "Pasword must containt at least one small letter, one big letter and one number",
	    patt.test(pass_elem.value));
}

function checkPassword2()
{
    var pass1 = document.getElementById("id_regform:id_pass1").value;
    var pass2_elem = document.getElementById("id_regform:id_pass2");
    var pass2 = pass2_elem.value;
    var msg_elem = document.getElementById("id_pass2_msg");

    pass2_ok = setColors(
	    pass2_elem,
	    msg_elem,
	    "Password doesnt match original",
	    (pass1 === pass2 && pass1_ok));
}

function checkFirstName()
{
    var name_elem = document.getElementById("id_regform:id_firstName");
    var patt = new RegExp(/([^a-zA-Z])/);
    var msg_elem = document.getElementById("id_firstName_msg");

    var len = name_elem.value.toString().length;

    firstName_ok = setColors(
	    name_elem,
	    msg_elem,
	    "First name must be at least two characters and can containt only letters",
	    (!patt.test(name_elem.value) && len >= 2));
}

function checkLastName()
{
    var name_elem = document.getElementById("id_regform:id_lastName");
    var patt = new RegExp(/([^a-zA-Z])/);
    var msg_elem = document.getElementById("id_lastName_msg");

    var len = name_elem.value.toString().length;

    firstName_ok = setColors(
	    name_elem,
	    msg_elem,
	    "Last name must be at least two characters and can containt only letters",
	    (!patt.test(name_elem.value) && len >= 2));
}

function checkPhone()
{
    var phone_elem = document.getElementById("id_regform:id_phone");
    var patt = new RegExp(/[^0-9]/);
    var phone_msg = document.getElementById("id_phone_msg");


    phone_ok = setColors(
	    phone_elem,
	    phone_msg,
	    "Invalid number",
	    (!patt.test(phone_elem.value) && phone_elem.value.length >= 9));
}

function checkEmail()
{
    var email_elem = document.getElementById("id_regform:id_email");
    var patt = new RegExp(/\S+@\S+(\.\S+)$/);

    var email_msg = document.getElementById("id_email_msg");

    email_ok = setColors(
	    email_elem,
	    email_msg,
	    "Invalid email",
	    (patt.test(email_elem.value)));
}