/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bad_color = "#ff6666";
var ok_color = "#66cc66";

function checkPassword1()
{
    var pass_elem = document.getElementById("id_regform:id_pass1");
    var patt = new RegExp(/((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,12})/);
    var msg_elem = document.getElementById("id_pass1_msg");

    if (patt.test(pass_elem.value))
    {
	pass_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "Pasword is fine";
	msg_elem.style.color = ok_color;
    }
    else
    {
	pass_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "Pasword must containt at least one small letter, one big letter and one number";
	msg_elem.style.color = bad_color;
    }

}

function checkPassword2()
{
    var pass1 = document.getElementById("id_regform:id_pass1").value;
    var pass2_elem = document.getElementById("id_regform:id_pass2");
    var pass2 = pass2_elem.value;
    var msg_elem = document.getElementById("id_pass2_msg");

    if (pass1 === pass2)
    {
	pass2_elem.style.backgroundColor = ok_color;
	msg_elem.innerHTML = "Password matches original";
	msg_elem.style.color = ok_color;
    }
    else
    {
	pass2_elem.style.backgroundColor = bad_color;
	msg_elem.innerHTML = "Password doesnt match original";
	msg_elem.style.color = bad_color;
    }
}