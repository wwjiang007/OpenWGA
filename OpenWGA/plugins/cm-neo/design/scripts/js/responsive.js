define(["jquery"], function($){

	var width = $("#app-responsive a.phone").data("width");
		
	function setWidth(){
		$("#app-responsive a").removeClass("selected");
		var selected;
		if(width){
			$(".sitepanel-wrapper").css("width", width);
			selected = $("#app-responsive a[data-width=" + width +"]");
		}
		else {
			$(".sitepanel-wrapper").css("width", "");
			selected = $("#app-responsive a.desktop");
		}
		selected.addClass("selected");
		$("#appnav a[data-view=responsive] i").prop("className", selected.find("i").prop("className"))
	}

	function init(portletkey){
	
		setWidth();

		$("#app-responsive a").click(function(ev){
			ev.preventDefault();
			
			width = $(this).data("width");
			setWidth();
		})

		WGA.portlet.registerObject(portletkey, {
			destroy: function(){
				$(".sitepanel-wrapper").css("width", "").data("width", "");
			}
		})

	}

	return {
		init: init
	}

})