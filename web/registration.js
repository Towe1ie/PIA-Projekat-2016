/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bad_color = "#ff6666";
var ok_color = "#ffffff";

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

function checkPassword1()
{
    var pass_elem = document.getElementById("id_regform:id_pass1");
    var patt = new RegExp(/((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,12})/);
    var msg_elem = document.getElementById("id_pass1_msg");

    if (patt.test(pass_elem.value))
    {
	pass_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "";
	msg_elem.style.color = ok_color;
	pass1_ok = true;
    }
    else
    {
	pass_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "Pasword must containt at least one small letter, one big letter and one number";
	msg_elem.style.color = bad_color;
	pass1_ok = false;
    }

}

function checkPassword2()
{
    var pass1 = document.getElementById("id_regform:id_pass1").value;
    var pass2_elem = document.getElementById("id_regform:id_pass2");
    var pass2 = pass2_elem.value;
    var msg_elem = document.getElementById("id_pass2_msg");

    if (pass1 === pass2 && pass1_ok)
    {
	pass2_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "";
	msg_elem.style.color = ok_color;
	pass2_ok = true;
    }
    else
    {
	pass2_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "Password doesnt match original";
	msg_elem.style.color = bad_color;
	pass2_ok = false;
    }
}

function checkFirstName()
{
    var name_elem = document.getElementById("id_regform:id_firstName");
    var patt = new RegExp(/([^a-zA-Z])/);
    var msg_elem = document.getElementById("id_firstName_msg");

    var len = name_elem.value.toString().length;

    if (!patt.test(name_elem.value) && len >= 2)
    {
	name_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "";
	msg_elem.style.color = ok_color;
	firstName_ok = true;
    }
    else
    {
	name_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "First name must be at least two characters and can containt only letters";
	msg_elem.style.color = bad_color;
	firstName_ok = false;
    }
}

function checkLastName()
{
    var name_elem = document.getElementById("id_regform:id_lastName");
    var patt = new RegExp(/([^a-zA-Z])/);
    var msg_elem = document.getElementById("id_lastName_msg");

    var len = name_elem.value.toString().length;

    if (!patt.test(name_elem.value) && len >= 2)
    {
	name_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "";
	msg_elem.style.color = ok_color;
	lastName_ok = true;
    }
    else
    {
	name_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "Last name must be at least two characters and can containt only letters";
	msg_elem.style.color = bad_color;
	lastName_ok = false;
    }
}

function checkPhone()
{
    var phone_elem = document.getElementById("id_regform:id_phone");
    var patt = new RegExp(/[^0-9]/);
    var phone_msg = document.getElementById("id_phone_msg");

    if (!patt.test(phone_elem.value) && phone_elem.value.length >= 9)
    {
	phone_elem.style.backgroundColor = ok_color;
	phone_msg.innerHTML = "";
	phone_msg.style.color = ok_color;
	phone_ok = true;
    }
    else
    {
	phone_elem.style.backgroundColor = bad_color;
	phone_msg.innerHTML = "Invalid number";
	phone_msg.style.color = bad_color;
	phone_ok = false;
    }
}

function checkEmail()
{
    var email_elem = document.getElementById("id_regform:id_email");
    var patt = new RegExp(/\S+@\S+(\.\S+)$/);

    var email_msg = document.getElementById("id_email_msg");

    if (patt.test(email_elem.value))
    {
	email_elem.style.backgroundColor = ok_color;
	email_msg.innerHTML = "";
	email_msg.style.color = ok_color;
	email_ok = true;
    }
    else
    {
	email_elem.style.backgroundColor = bad_color;
	email_msg.innerHTML = "Invalid email";
	email_msg.style.color = bad_color;
	email_ok = false;
    }
}