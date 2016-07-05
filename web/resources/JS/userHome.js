var dropOpened = false;

$(document).ready(function ()
{
    $(".flatTable tr").click(function (e)
    {
	$(".dropDown").css("display", "none");
	
	var menu = jQuery(this).find("div[class='dropDown']");
	menu.css("display", "block");
	menu.css("top", e.clientY);
	menu.css("left", e.clientX);

	dropOpened = true;

    });
});

window.onclick = function()
{
	if (!dropOpened)
	    $(".dropDown").css("display", "none");
	dropOpened = false;
};