$(document).ready(
		function(){
			//alert("A");
			$("h1").css({"color":"green", "font-size":"40px","text-align":"center"});
			$("#mainMenu>li").css({"color":"red"});
			  $("a").hover(
					function()
					{
						$(this).css({"color":"green","font-size":"20px"})
					},
					function()
					{
						$(this).css({"color":"blue","font-size":"20px"})
					}
					);
		});