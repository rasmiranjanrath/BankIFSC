function getState(bankName) {
	$.ajax({
		type : "GET",
		url : "getStates?bankName=" + bankName,
		success : function(response) {
			var obj = JSON.parse(response);
			// remove the previous option from element
			document.getElementById('bankState').options.length = 0;
			
			//create select option
			var selectOption = document.createElement("option");
			selectOption.innerHTML = "...Select...";
			selectOption.value = "";
			$("#bankState").append(selectOption);
			var data = obj;
			
			for(var i=0; i<data.length; i++) {
				var state = data[i];
				
				var newOption = document.createElement("option");
				newOption.value = data[i];
				newOption.innerHTML = state;
				
				$("#bankState").append(newOption);
			}
		},
		failure : function(e) {
		}

	});
}
function getCity(bankstate) {
	$.ajax({
		type : "GET",
		url : "getCity?bankstate=" + bankstate,
		success : function(response) {
			var obj = JSON.parse(response);
			// remove the previous option from element
			document.getElementById('bankCity').options.length = 0;
			
			//create select option
			var selectOption = document.createElement("option");
			selectOption.innerHTML = "...Select...";
			selectOption.value = "";
			$("#bankCity").append(selectOption);
			var data = obj;
			
			for(var i=0; i<data.length; i++) {
				var state = data[i];
				
				var newOption = document.createElement("option");
				newOption.value = data[i];
				newOption.innerHTML = state;
				
				$("#bankCity").append(newOption);
			}
		},
		failure : function(e) {
		}

	});
	
}
function getBranch(bankCity) {
	$.ajax({
		type : "GET",
		url : "getBranch?bankCity=" + bankCity,
		success : function(response) {
			var obj = JSON.parse(response);
			// remove the previous option from element
			document.getElementById('bankBranch').options.length = 0;
			
			//create select option
			var selectOption = document.createElement("option");
			selectOption.innerHTML = "...Select...";
			selectOption.value = "";
			$("#bankBranch").append(selectOption);
			var data = obj;
			
			for(var i=0; i<data.length; i++) {
				var state = data[i];
				
				var newOption = document.createElement("option");
				newOption.value = data[i];
				newOption.innerHTML = state;
				
				$("#bankBranch").append(newOption);
			}
		},
		failure : function(e) {
		}

	});
	
}
function getIfsc(bankBranch) {
	$.ajax({
		type : "GET",
		url : "getIfsc?bankBranch=" + bankBranch,
		success : function(response) {
			var obj = JSON.parse(response);
			// remove the previous option from element
			document.getElementById('ifsc').innerHTML=obj[0];
			document.getElementById('address').innerHTML= obj[1];

		},
		failure : function(e) {
		}

	});
	
}
function resetValues(){
	document.getElementById('bankName').selectedIndex=0;
	removeAndAppend('bankState');
	removeAndAppend('bankCity');
	removeAndAppend('bankBranch');
	document.getElementById('ifsc').innerHTML="";
	document.getElementById('address').innerHTML="";
}
function removeAndAppend(id){
	document.getElementById(id).options.length = 0;
	var selectOption = document.createElement("option");
	selectOption.innerHTML = "...Select...";
	selectOption.value = "";
}
