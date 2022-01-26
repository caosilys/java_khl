
let ajaxService = (function(){
  //contaxtPath 설정

  function setContextPath(contextPath){
		this.contextPath = contextPath;
	}

  function parseAjax(_type, _data, _url, _funcion){
    $.ajax({
        async : false,
        type : _type,
        data : JSON.stringify(_data),
        url : this.contextPath + _url,
        dataType:"json",
        contentType:"application/json; charset=UTF-8",
        success : function(res){
          if(_funcion != null) _funcion(res);
        }
    });
  };


  return {
		name : 'ajaxService',
		contextPath : '',
		setContextPath : setContextPath,
    parseAjax : parseAjax
	}
})();