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
function sendIp() {
	$.ajax({
		type : "GET",
		url : "sendIp",
		success : function(response) {
			var obj = JSON.parse(response);
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
function validateForm(){
	var data=document.getElementById('bankIfsc').value;
	if(data==null || data==""){
		document.getElementById('errordiv').innerHTML="This field is mandatory";
		return false;
	}
	document.getElementById('errordiv').innerHTML="";
	return true;
}
function showTime(){
    var date = new Date();
    var h = date.getHours(); // 0 - 23
    var m = date.getMinutes(); // 0 - 59
    var s = date.getSeconds(); // 0 - 59
    var session = "AM";
    
    if(h == 0){
        h = 12;
    }
    
    if(h > 12){
        h = h - 12;
        session = "PM";
    }
    
    h = (h < 10) ? "0" + h : h;
    m = (m < 10) ? "0" + m : m;
    s = (s < 10) ? "0" + s : s;
    
    var time = h + ":" + m + ":" + s + " " + session;
    document.getElementById("MyClockDisplay").innerText = time;
    document.getElementById("MyClockDisplay").textContent = time;
    
    setTimeout(showTime, 1000);
    
}
function showTime() {
	var date = new Date();
	var h = date.getHours(); // 0 - 23
	var m = date.getMinutes(); // 0 - 59
	var s = date.getSeconds(); // 0 - 59
	var session = "AM";

	if (h == 0) {
		h = 12;
	}

	if (h > 12) {
		h = h - 12;
		session = "PM";
	}

	h = (h < 10) ? "0" + h : h;
	m = (m < 10) ? "0" + m : m;
	s = (s < 10) ? "0" + s : s;

	var time = h + ":" + m + ":" + s + " " + session;
	document.getElementById("MyClockDisplay").innerText = time;
	document.getElementById("MyClockDisplay").textContent = time;

	setTimeout(showTime, 1000);

}

showTime();
