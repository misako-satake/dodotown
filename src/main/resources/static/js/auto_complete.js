'use strict'
$(function() {
    $.getJSON("http://localhost:8080/showShopResultByKeywords",
	    function(data) {
	        $('#keywords').autocomplete({
	            source : data,
	            autoFocus: true,
	            minLength : 1
	        });
	    });
});