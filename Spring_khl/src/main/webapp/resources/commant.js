
let commantService = (function(){
  //contaxtPath 설정

  function setContextPath(contextPath){
		this.contextPath = contextPath;
	}

  function submitAjax(_type, _data, _url, _funcion){
    $.ajax({
        async : false,
        type : _type,
        data : JSON.stringify(_data),
        url : this.contextPath + _url ,
        contentType:"application/json; charset=UTF-8",
        success : function(res){
        	console.log(res);
          if(_funcion != null) _funcion(res);
        }
    });
  };


  return {
		name : 'commantService',
		contextPath : '',
		setContextPath : setContextPath,
    parseAjax : submitAjax
	}
})();