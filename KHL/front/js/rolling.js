
function rollingToTop(parentSelector, childSelector, moveTime, animationTime){
	var height = $(parentSelector).height();
	return setInterval(function(){
		if(!$(parentSelector + '>' + childSelector).first().is(':animated')){
			$(parentSelector + '>' +  childSelector).first()
				.animate({marginTop : -height}, animationTime ,function(){
				$(this).removeAttr('style').detach().appendTo(parentSelector);
			});
		}
	}, moveTime);
}