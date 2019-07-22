function getXMLHttpRequest(){
	if(window.ActiveXObject){	// internet explore
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");	//신버전 서버와 통신할 수 있는 js 객체
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");	//구버전 서버와 통신할 수 있는 js 객체
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){	// ! internet explore & 11버전 이상
		return new XMLHttpRequest();	//서버와 통신할 수 있는 js 객체
	}else{
		return null;
	}
}

var httpRequest = null;

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;	//get방식일 때 
	}
	
	//alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " + httpParams);
	httpRequest.open(httpMethod, httpUrl, true);	//true: 비동기방식 , false: 동기방식
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	//alert(httpMethod == 'POST' ? httpParams : null);
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);	//post 방식일 때
}