'use strict'
$(function() {
	
	var Element = document.getElementById("selectyear");
	for (var i = 1920; i <= 2022; i++) {
		var option = document.createElement("option");
		option.value = i;
		option.innerText = i;
		Element.appendChild(option);
	}
	
	var Element = document.getElementById("selectmonth");
	for (var i = 1; i <= 12; i++) {
		var option = document.createElement("option");
		option.value = i;
		option.innerText = i;
		Element.appendChild(option);
	}
	
	var Element = document.getElementById("selectday");
	for (var i = 1; i <= 31; i++) {
		var option = document.createElement("option");
		option.value = i;
		option.innerText = i;
		Element.appendChild(option);
	}
	
	
	
	
	
	
	
	
});