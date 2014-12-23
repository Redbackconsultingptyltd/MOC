(function ($) {
 $.fn.centerArea = function () {
		var foo = $(this);
		var centerDiv=$('#centerDiv').offset();		   
	 $('.tree').css('left',0);
	 $('.tree').css('top',0);
	 resetTree(foo,centerDiv);
		
    return this;
};  
}(jQuery));
  
function resetTree(foo,centerDiv)
{
	$('.tree').css('position','absolute');$('.tree').css('top', centerDiv.top-foo.offset().top);$('.tree').css('left',centerDiv.left-foo.offset().left);		
	return true;
} 
(function() {
    var addRule;

    if (typeof document.styleSheets != "undefined" && document.styleSheets) {
        addRule = function(selector, rule) {
            var styleSheets = document.styleSheets, styleSheet;
            if (styleSheets && styleSheets.length) {
                styleSheet = styleSheets[styleSheets.length - 1];
                if (styleSheet.addRule) {
                    styleSheet.addRule(selector, rule)
                } else if (typeof styleSheet.cssText == "string") {
                    styleSheet.cssText = selector + " {" + rule + "}";
                } else if (styleSheet.insertRule && styleSheet.cssRules) {
                    styleSheet.insertRule(selector + " {" + rule + "}", styleSheet.cssRules.length);
                }
            }
        }
    } else {
        addRule = function(selector, rule, el, doc) {
            el.appendChild(doc.createTextNode(selector + " {" + rule + "}"));
        };
    }

    var createCssClass = function(className, cssProps, doc) {
        doc = doc || document;

        var head = doc.getElementsByTagName("head")[0];
        if (head && addRule) {
            var selector = "*." + className;
            var ruleBits = [];
            for (var i in cssProps) {
                if (cssProps.hasOwnProperty(i)) {
                    ruleBits.push(i + ":" + cssProps[i] + ";");
                }
            }
            var rule = ruleBits.join("");
            var styleEl = doc.createElement("style");
            styleEl.type = "text/css";
            styleEl.media = "screen";
            head.appendChild(styleEl);
            addRule(selector, rule, styleEl, doc);
            styleEl = null;
        }
    };

    jQuery.fn.createAndApplyCssClass = function(className, cssProps) {
        createCssClass(className, cssProps, document);
        this.addClass(className);
    };
})();

  function zoomPlus()
	{
	
	if(parseFloat(scale).toFixed(1) < parseFloat(maxScale).toFixed(1))
	{
	var temp=scaleZoom;
	scale=parseFloat(scale)+parseFloat(temp);
	scale=parseFloat(scale).toFixed(2);

	    if(treeOpenName=="V")
		{
		objectCenter(selectedObjectVerticle);
		$('.tree').css({
		"-moz-transform": "scale("+scale+")",
		"-webkit-transform": "scale("+scale+")",
		"-o-transform": "scale("+scale+")",
		"transform":"scale("+scale+")",
		"-ms-transform": "scale("+scale+")"
		});
	   
	   }
	   if(treeOpenName=="H")
	   {
	  	objectCenter(selectedObjectHorizontal);  
	   	$('.htree').css({
		"-moz-transform": "scale("+scale+") rotate(270deg)",
		"-webkit-transform": "scale("+scale+") rotate(270deg)",
		"-o-transform": "scale("+scale+") rotate(270deg)",
		"transform":"scale("+scale+") rotate(270deg)",
		"-ms-transform": "scale("+scale+") rotate(270deg)"
		});
		
	  
	   }
	}
	}
	
	function zoomMinus()
	{
	if(parseFloat(scale).toFixed(1)>parseFloat(minScale).toFixed(1))
	{
	//objectCenter(selectedObjectVerticle);
	if(parseFloat(scale).toFixed(1)<scaleZoom)
	{
	scale=minScale;
	}
	else
	{
	//objectCenter(selectedObjectVerticle);
	var temp=scaleZoom;
	scale=parseFloat(scale).toFixed(1)-parseFloat(temp).toFixed(1);
	}
	scale=parseFloat(scale).toFixed(2);
		if(treeOpenName=="V")
		{
		objectCenter(selectedObjectVerticle);
		$('.tree').css({
		"-moz-transform": "scale("+scale+")",
		"-webkit-transform": "scale("+scale+")",
		"-o-transform": "scale("+scale+")",
		"transform":"scale("+scale+")",
		"-ms-transform": "scale("+scale+")"
		});
	   }
	   if(treeOpenName=="H")
	   {
	    objectCenter(selectedObjectHorizontal);
	   	$('.htree').css({
		"-moz-transform": "scale("+scale+") rotate(270deg)",
		"-webkit-transform": "scale("+scale+" rotate(270deg))",
		"-o-transform": "scale("+scale+") rotate(270deg)",
		"transform":"scale("+scale+") rotate(270deg)",
		"-ms-transform": "scale("+scale+") rotate(270deg)"
		});
	   }
	}
	}
  
		 $(document).ready(function() {
		 $('#foldertreecontainer').hide();
			$('#TreeContainer').mousemove(function(e){
				var $this = $(this);
				var imgLeft = e.pageX - $this.offset().left;
				var imgTop = e.pageY - $this.offset().top;
				var imgBottom = $this.offset().top + $this.height() - e.pageY;
				var imgRight = $this.offset().left + $this.width() - e.pageX;				
			}); 

		 $('.tree li').bind('mouseover', function () {		
		    return false;
		});
	/*Zoom In*/
		$('#plus').bind('click', function () {
			if(treeOpenName!="F")
			{
			zoomPlus();
			}
		/*Zoom Out*/
		return false;
		});
		$('#minus').bind('click', function () {
		if(treeOpenName!="F")
		{
			zoomMinus();
		}
		return false;
		});
		/*Zoom fit*/
		$('#reset').bind('click',function () {
			orgFrameWork.setIsNodeCenter(true);
			
			if(treeOpenName!="F")
			{
				scale=minScale;
				nodeWidthArr = new Array();
		 $.cookie('treeOpenName', null); 
		 }
		if(treeOpenName=="V")
		{
		objectCenter(selectedObjectVerticle);
		$('.tree').css({
		"-moz-transform": "scale("+scale+")",
		"-webkit-transform": "scale("+scale+")",
		"-o-transform": "scale("+scale+")",
		"transform":"scale("+scale+")",
		"-ms-transform": "scale("+scale+")"
		});
	   }
	   if(treeOpenName=="H")
	   {
	   objectCenter(selectedObjectHorizontal);
	   	$('.htree').css({
		"-moz-transform": "scale("+scale+") rotate(270deg)",
		"-webkit-transform": "scale("+scale+" rotate(270deg))",
		"-o-transform": "scale("+scale+") rotate(270deg)",
		"transform":"scale("+scale+") rotate(270deg)",
		"-ms-transform": "scale("+scale+" rotate(270deg))"
		});
	   }
		//objectCenter(2);
		});
		
		$("#searchText").keyup(function(e){
		applyAutoCompleteCSS($(this).val());
		});
		
		$('#verticle').bind('click', function () {
		
		treeOpenName="V";
		clearInterval(timer1);
		timer = setInterval('createBoxTree()', 1000 );
		return false;
		});
		
		$('#horizontal').bind('click', function () {
			
			treeOpenName="H";
			
			clearInterval(timer1);
			timer = setInterval('createBoxTree()', 1000 );
			return false;
		});
		
		$('#foldershow').bind('click', function () {
		
		treeOpenName="F";
		//createBoxTreeforFolder();
		//clearInterval(timer1);
		timer1 = setInterval('createBoxTreeforFolder()', 1000 );
		return false;
		});
			 
		if(treeOpenName=="V")
		{
		$('.tree').css({
		"-moz-transform": "scale("+scale+")",
		"-webkit-transform": "scale("+scale+")",
		"-o-transform": "scale("+scale+")",
		"transform":"scale("+scale+")",
		"-ms-transform": "scale("+scale+")"
		});
	   }
	   if(treeOpenName=="H")
	   {
	   	$('.htree').css({
		"-moz-transform": "scale("+scale+") rotate(270deg)",
		"-webkit-transform": "scale("+scale+" rotate(270deg))",
		"-o-transform": "scale("+scale+") rotate(270deg)",
		"transform":"scale("+scale+") rotate(270deg)",
		"-ms-transform": "scale("+scale+") rotate(270deg)"
		});
	   }
	    
		/*all draggable element here*/
		//  $("#firstdrag").draggable();
		// $("#hdrag").draggable();
		  $("#uidrag").draggable();
		  $("#cloneuidrag").draggable();
		  $("#Fuidrag").draggable();
		 });	 

	/*show hide function*/
		
	$(document).ready(function() {
	
	
	
	
	$("#verticle").click(function() {
		$("#orgNavigation").css('display','block');
	   		$("#TreeContainer").css('display','block');
	   		$("#hdrag").css('display','none');
	   		$("#folderContainer").css('display','none');
	   		uiDragZeroV();
			if(selectedObjectVerticle!=null){
				objectCenter(selectedObjectVerticle);
			}else{
				objectCenter(2);		
			}
			
			createInitialViewForEarchTreeTypes('V');
			objectCenter(orgFrameWork.initialRoot);
	});
	$("#horizontal").click(function() {
		$("#orgNavigation").css('display','block');
	   	 	$("#TreeContainer").css('display','none');
	   		$("#hdrag").css('display','block');
	 		$("#folderContainer").css('display','none');
	 		uiDragZeroH();
			if(selectedObjectHorizontal!=null){
				objectCenter(selectedObjectHorizontal);
			}else{
				objectCenter(2);		
			}
			
			createInitialViewForEarchTreeTypes('H');
			objectCenter(orgFrameWork.initialRoot);
			
			//$("#horizontal").click();
	});
	
	$("#foldershow").click(function() {
		$("#orgNavigation").css('display','none');
		treeOpenName='F';
		$("#TreeContainer").css('display','none');
		$("#hdrag").css('display','none');
		$("#folderContainer").css('display','block');
	
		selectedTreeViewSizeFactor['H'] = parseInt($(".htree").width());
		selectedTreeViewSizeFactor['V'] = parseInt($(".tree").width());
        createInitialViewForEarchTreeTypes('F');
        createBoxTree();
	});  

 $("#dragarea").click(function(ev){
  $("#uidrag").position({
    my: "top right",
    of: ev,
    collision: "fit"
  });
  
  $("#cloneuidrag").position({
    my: "top right",
    of: ev,
    collision: "fit"
  });
});
	});
	
	/*stree node width height manage*/
	
    function sliceNode(){
    var num = openLiCount;
    var width_li = 153/parseInt(num);
	var height_li = 60/parseInt(num);
	var margin = 20/parseInt(num);
	
	$('.stree li a').css('width',parseInt(width_li)+'px');
	$('.stree li a').css('height',parseInt(height_li)+'px');
	$('.stree li a').css('margin',parseInt(margin)+'px');
	}
	
	/*expand collaspe function*/
		function expCols(){
		
	 	/*for folder Tree*/
    $('#ftree').delegate('a', 'click', function () {
		if($(this).closest('li').children('ul').css('display')=='none')
		{
		    $(this).removeClass('folder').addClass('folder_open');
			$(this).closest('li').children('ul').css('display','block');
			
		}
		else
		{
		//alert('in else');
		
		finalarrayCSS=new Array();
						var CSSParentList = new Array();
						var CSSParentArr = new Array();
						for(var i=0;i<parentChild.length;i++)
            			{
            				var str=parentChild[i].split("@")[1];
            				if(str==thisId){
            					CSSParentArr.push(str);
            				}
            			}
            			for(var i=0;i<CSSParentArr.length;i++)
            			{
            				var  arr=new Array();
        					for(var j=0;j<parentChild.length;j++)
        					{
        						if(CSSParentArr[i]==parentChild[j].split("@")[1])
        						{
        							arr.push(parentChild[j].split("@")[0]);
        						}
        					}
        					CSSParentList.push(arr);
            			}
            			for(var i=0;i<CSSParentArr.length;i++)
            			{
            				for(var s=0;s<CSSParentList[i].length;s++)
            				{
            					finalarrayCSS.push(CSSParentArr[i]+","+CSSParentList[i][s]);
            				}
            			}			
			$(this).closest('li').find('ul').css('display','none');
			//alert('in else 1'+ '  '+finalarrayCSS.length);			
			//alert('in else 2');
			//applyCSSMinusToParent(selectedParent);
		    
		}
		createBoxTreeforFolder();
		return;
	});
	
	function applyCSSMinusToParent(selectedParent)
	{
				//alert('hiiiii'+treeOpenName+selectedParent+'  len '+finalarrayCSS.length);
            	for(var d=0;d<finalarrayCSS.length;d++)
            	{
					//alert(finalarrayCSS[d].split(",")[0]+"    "+selectedParent);
            		if(finalarrayCSS[d].split(",")[0]==selectedParent)
            		{
						if(treeOpenName=="V")
		                {
						$('#collapser').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('div').each(function(){				
							if ($(this).hasClass('minus')) {
								$(this).removeClass('minus').addClass('plus');
							}
						});
						applyCSSMinusToParent(finalarrayCSS[d].split(",")[1]);
						}
						if(treeOpenName=="H")
		                {
						$('#htree').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('div').each(function(){				
							if ($(this).hasClass('minus')) {
								$(this).removeClass('minus').addClass('plus');
							}
						});
						applyCSSMinusToParent(finalarrayCSS[d].split(",")[1]);
						}
						
						if(treeOpenName=="F")
		                {
						//alert(treeOpenName);
						$('#ftree').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('a').each(function(){							
							//alert($(this).hasClass('folder_open'));
							if ($(this).hasClass('folder_open')){
								$(this).removeClass('folder_open').addClass('folder');
							}
						});
						applyCSSMinusToParent(finalarrayCSS[d].split(",")[1]);
						}			
                  }				  
				}
		return;
	}
	$('#collapser').find('ul').css('display','none');
	$('#htree').find('ul').css('display','none');
	$('#ftree').find('ul').css('display','none');
}
function createCanvas()
{
	htmlBasePrintOrg();
	return ;
	var svgClass="";
	var popUpId="";
	if(treeOpenName=="V")
	{
		popupHeight = parseInt($('#TreeContainer').css('height')); 
		popupWidth = parseInt($('#TreeContainer').css('width')); 
		$('.printtree').html($('#TreeContainer').html());
		svgClass='printtree';
		popUpId='.printtree';
		$('#collapser').find('a').find('div').each(function(){
	     if(this.id=='boxdata'){
			$(this).css('display','none');
		}
		});
	}
	else if(treeOpenName=="H")
	{
		popupHeight = parseInt($('#horizontalContainer').css('height')); 
		popupWidth = parseInt($('#horizontalContainer').css('width')); 
		$('.printtree').html($('#horizontalContainer').html());
		svgClass='printtree';
		popUpId='.printtree';
		$('#htree').find('a').find('div').each(function(){
	     if(this.id=='boxdata'){
			$(this).css('display','none');
		}
		});
	}
	else if(treeOpenName=="F")
	{
		popupHeight = parseInt($('#folderContainer').css('height')); 
		popupWidth = parseInt($('#folderContainer').css('width')); 
		$('.printftree').html($('#folderContainer').html());
		svgClass='printftree';
		popUpId='.printftree';
		$('#ftree').find('a').find('div').each(function(){
	     if(this.id=='boxdata'){
			$(this).css('display','none');
		}
		});
	}
	$("."+svgClass).dialog({ width: popupWidth,height:'auto',
		
		close: function(event, ui) {
			$('.printtree').css('width',popupWidth);
			$('.printtree').css('height',popupHeight);
			containerWidth=popupWidth;
			containerHeight=popupHeight;
			$('#canvasContainer').empty();
			var foo = document.getElementById("canvasContainer");
			var canvas1 = document.createElement('canvas');
			canvas1.setAttribute("id", "canvas");
			canvas1.setAttribute("width", containerWidth);
			canvas1.setAttribute("height", containerHeight);
			foo.appendChild(canvas1);
			var canvas = document.getElementById("canvas");
			var ctx = canvas.getContext("2d");
			var data = "<svg xmlns='http://www.w3.org/2000/svg' width='"+containerWidth+"' height='"+containerHeight+"'>";
			if(treeOpenName=="V")
			{
			data+="<style type='text/css'><![CDATA[body{font-family:arial;margin:0px;padding:0px; background:#ffffff;}h1{color:#2a2929; font-size:12px; font-weight:bold; font-family:arial;padding:0 0 0 7px; line-height:31px;}.flexi{clear:both;}.wrapper{width:100%;}.topheader{width:99%;height:39px; background:url(../images/hbg.jpg) repeat-x; border:1px #898989 solid;-webkit-border-radius:6px;-moz-border-radius:6px;border-radius:6px; margin:4px auto;}.topheader .logo{background:url(../images/logo.jpg) 18px 2px no-repeat; width:479px; height:37px; float:left;}.searchbx{width:93%; height:28px; background:url(../images/searchbx.jpg) repeat-x; border:solid 1px #c2d4e6; margin:10px 0 0 8px;}.searchbx .searchicon{background:url(../images/searchicon.jpg) 0 3px no-repeat;width:23px; height:26px; float:left; margin:0 0 0 4px;}.searchbx .searchinput{width:85%; height:28px; float:left;}.searchbx .searchinput input{width:100%; height:22px; padding-top:2px;line-height:22px;border:none; background:url(../images/searchbx.jpg) repeat-x;}.midcontain{width:99%; margin:8px auto 0 auto;}.midcontain .leftblock{width:246px; float:left; /*height:540px;*/ background:#fff; margin:0 5px 0 0;}.midcontain .leftdata{width:100%; border:1px solid #898989; margin:7px 0 0 0; font-size: 12px;}.midcontain .b1{height:180px;}.midcontain .b2{height:80px;}.midcontain .b3{height:295px;}.midcontain .scroll{height:80px; overflow:scroll; width:100%;}.midcontain .leftdata .blockgap{margin:2%; width:98%; font-family:arial; color:#040404;}.midcontain .leftdata .blockgap .map{width:83%; float:left;height:136px;}.midcontain .leftdata .blockgap .print{width:15%;float:left;height:136px;}.midcontain .leftdata .searchblk{width:100%; font-family:arial; color:#040404; background:url(../images/search.jpg) no-repeat; height:49px;}.midcontain .title{background:#dedddd; height:31px; width:100%; border-bottom:solid 1px #b5b4b4;}.midcontain .treeheading{background:#dedddd; height:31px; width:100%;border:1px solid #898989; border-bottom:solid 1px #b5b4b4;}.midcontain .leftdata .userinfo{width:90%; margin:0 auto; /*height:497px;*/}.midcontain .leftdata .userinfo table{margin:20px 0;}.midcontain .leftdata .userinfo td{color:#292929; padding:4px;}.midcontain .rightree{width:99.3%; float:left;height:540px; background:#fff;position:relative; margin-left:6px;}.midcontain .rightree .treecontainer{width:100%;height:541px;overflow:scroll;border:1px solid #898989; border-top:none; position:relative;}ul#printtree{}ul#printtree li{float:left; margin:0 1px 0 0;}ul#printtree span{background:#009900;height:3px;margin:0 auto;width: 3px; margin:0 auto; display:block;}ul#child{margin:1px 0 0 0; width:100%; float:left;}ul#child li{float:left; margin:0 1px 0 0;}.stree{width:100%; height:100%;}.stree ul {text-align:center; width:100%;height:100%}.stree li {float:left; text-align: center;}.stree li a{display:inline-block; background:#009933; text-align: center;}.stree li .active{display:inline-block; background:#000;}.printtree{width:100px;}.printtree ul {padding-top: 20px; position: relative;}.printtree li {float: left; text-align: center;list-style-type: none;position: relative;padding: 21px 5px 0 5px;}.printtree li::before, .printtree li::after{content: '';position: absolute; top: 0; right: 50%;border-top: 1px solid #ccc;width: 50%; height: 20px;}.printtree li::after{right: auto; left: 50%;border-left: 1px solid #ccc;}.printtree li:only-child::after, .printtree li:only-child::before {display: none;}.printtree li:only-child{ padding-top: 0;}.printtree li:first-child::before, .printtree li:last-child::after{border: 0 none;}.printtree li:last-child::before{border-right: 1px solid #ccc;border-radius: 0 5px 0 0;-webkit-border-radius: 0 5px 0 0;-moz-border-radius: 0 5px 0 0;}.printtree li:first-child::after{border-radius: 5px 0 0 0;-webkit-border-radius: 5px 0 0 0;-moz-border-radius: 5px 0 0 0;}.printtree ul ul::before{border-left: 1px solid #CCCCCC;content: '';position: absolute; top:-4px; left: 50%;border-left: 1px solid #ccc;width: 0; height: 24px;}.printtree li a{border: 1px solid #ccc;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.printtree li a:hover, .printtree li a:hover+ul li a { border: 1px solid #94a0b4;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .active{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .dcactive{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;-moz-transition: all .4s ease-in;-moz-transform:scale(5);-webkit-transform:scale(5);-o-transform:scale(5);transform:scale(5);-ms-transform:scale(5);position:absolute; z-index:1000; position:absolute; left:0; top:0;}.printtree li a:hover+ul li::after, .printtree li a:hover+ul li::before, .printtree li a:hover+ul::before, .printtree li a:hover+ul ul::before{border-color:  #94a0b4;}.block{width:100%;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;}.block .top_contain{width:100%; height:20px;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;}.block .top_contain .insertid{width:78%; height:20px;/*border-right:#262626 solid 1px;*/ float:left; font-size:90%; line-height:20px; color:#fff;}.block .blue{background:#5081BD;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#609ad3), to(#4f7ebb)); background: -webkit-linear-gradient(top, #609ad3, #4f7ebb); background: -moz-linear-gradient(top, #609ad3, #4f7ebb);background: -ms-linear-gradient(top, #609ad3, #4f7ebb); background: -o-linear-gradient(top, #609ad3, #4f7ebb); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block  .green{background:#659626;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#73a72e), to(#639325)); background: -webkit-linear-gradient(top, #73a72e, #639325); /* Firefox 3.6+ */ background: -moz-linear-gradient(top, #73a72e, #639325);background: -ms-linear-gradient(top, #73a72e, #639325); background: -o-linear-gradient(top, #73a72e, #639325); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block .top_contain .inserticon{width:20%; height:20px;-webkit-border-top-right-radius:4px;border-top-right-radius:4px; float:left; background:#CCC;}.block .top_contain .p{background:url(../images/greenicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .top_contain .s{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .o{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .v{background:url(images/whiteicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .bottom{width:100%; height:37px;-webkit-border-bottom-right-radius: 4px;-webkit-border-bottom-left-radius: 4px;-moz-border-radius-bottomright: 4px;-moz-border-radius-bottomleft: 4px;border-bottom-right-radius: 4px;border-bottom-left-radius: 4px;}.block .bottom .userdata{float:left; width:80%; height:36px; line-height:12px; font-size:90%;}.block .bottom .expandcollsape{float:left; width:20%;height:36px; position:relative;}.block .bottom .expandcollsape .minus{width:18px; height:17px; background:url(images/minus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;}.block .bottom .expandcollsape .plus{width:18px; height:17px; background:url(images/plus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;}/]]></style>"+
			"<foreignObject width='"+containerWidth+"' height='"+containerHeight+"'>"+                  
						 "<div xmlns='http://www.w3.org/1999/xhtml' style='font-size:12px'>" +
							  "<div class='"+svgClass+"' width='"+containerWidth+"' height='"+containerHeight+"'>"+
								"<ul id='collasper' style='width:"+containerWidth+"px;height:"+containerHeight+"px;'>"+
									$('#collapser').html()+							 
								"</ul>"	+							
							 "</div>"+
							"</div>"+ 
						 "</foreignObject>";
			}
			if(treeOpenName=="H")
			{
			data+="<style type='text/css'><![CDATA[body{font-family:arial;margin:0px;padding:0px; background:#ffffff;}h1{color:#2a2929; font-size:12px; font-weight:bold; font-family:arial;padding:0 0 0 7px; line-height:31px;}.flexi{clear:both;}.wrapper{width:100%;}.topheader{width:99%;height:39px; background:url(../images/hbg.jpg) repeat-x; border:1px #898989 solid;-webkit-border-radius:6px;-moz-border-radius:6px;border-radius:6px; margin:4px auto;}.topheader .logo{background:url(../images/logo.jpg) 18px 2px no-repeat; width:479px; height:37px; float:left;}.searchbx{width:93%; height:28px; background:url(../images/searchbx.jpg) repeat-x; border:solid 1px #c2d4e6; margin:10px 0 0 8px;}.searchbx .searchicon{background:url(../images/searchicon.jpg) 0 3px no-repeat;width:23px; height:26px; float:left; margin:0 0 0 4px;}.searchbx .searchinput{width:85%; height:28px; float:left;}.searchbx .searchinput input{width:100%; height:22px; padding-top:2px;line-height:22px;border:none; background:url(../images/searchbx.jpg) repeat-x;}.midcontain{width:99%; margin:8px auto 0 auto;}.midcontain .leftblock{width:246px; float:left; /*height:540px;*/ background:#fff; margin:0 5px 0 0;}.midcontain .leftdata{width:100%; border:1px solid #898989; margin:7px 0 0 0; font-size: 12px;}.midcontain .b1{height:180px;}.midcontain .b2{height:80px;}.midcontain .b3{height:295px;}.midcontain .scroll{height:80px; overflow:scroll; width:100%;}.midcontain .leftdata .blockgap{margin:2%; width:98%; font-family:arial; color:#040404;}.midcontain .leftdata .blockgap .map{width:83%; float:left;height:136px;}.midcontain .leftdata .blockgap .print{width:15%;float:left;height:136px;}.midcontain .leftdata .searchblk{width:100%; font-family:arial; color:#040404; background:url(../images/search.jpg) no-repeat; height:49px;}.midcontain .title{background:#dedddd; height:31px; width:100%; border-bottom:solid 1px #b5b4b4;}.midcontain .treeheading{background:#dedddd; height:31px; width:100%;border:1px solid #898989; border-bottom:solid 1px #b5b4b4;}.midcontain .leftdata .userinfo{width:90%; margin:0 auto; /*height:497px;*/}.midcontain .leftdata .userinfo table{margin:20px 0;}.midcontain .leftdata .userinfo td{color:#292929; padding:4px;}.midcontain .rightree{width:99.3%; float:left;height:540px; background:#fff;position:relative; margin-left:6px;}.midcontain .rightree .treecontainer{width:100%;height:541px;overflow:scroll;border:1px solid #898989; border-top:none; position:relative;}ul#printtree{}ul#printtree li{float:left; margin:0 1px 0 0;}ul#printtree span{background:#009900;height:3px;margin:0 auto;width: 3px; margin:0 auto; display:block;}ul#child{margin:1px 0 0 0; width:100%; float:left;}ul#child li{float:left; margin:0 1px 0 0;}.stree{width:100%; height:100%;}.stree ul {text-align:center; width:100%;height:100%}.stree li {float:left; text-align: center;}.stree li a{display:inline-block; background:#009933; text-align: center;}.stree li .active{display:inline-block; background:#000;}.printtree{width:100px;}.printtree ul {padding-top: 20px; position: relative;}.printtree li {float: left; text-align: center;list-style-type: none;position: relative;padding: 21px 5px 0 5px;}.printtree li::before, .printtree li::after{content: '';position: absolute; top: 0; right: 50%;border-top: 1px solid #ccc;width: 50%; height: 20px;}.printtree li::after{right: auto; left: 50%;border-left: 1px solid #ccc;}.printtree li:only-child::after, .printtree li:only-child::before {display: none;}.printtree li:only-child{ padding-top: 0;}.printtree li:first-child::before, .printtree li:last-child::after{border: 0 none;}.printtree li:last-child::before{border-right: 1px solid #ccc;border-radius: 0 5px 0 0;-webkit-border-radius: 0 5px 0 0;-moz-border-radius: 0 5px 0 0;}.printtree li:first-child::after{border-radius: 5px 0 0 0;-webkit-border-radius: 5px 0 0 0;-moz-border-radius: 5px 0 0 0;}.printtree ul ul::before{border-left: 1px solid #CCCCCC;content: '';position: absolute; top:-4px; left: 50%;border-left: 1px solid #ccc;width: 0; height: 24px;}.printtree li a{border: 1px solid #ccc;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.printtree li a:hover, .printtree li a:hover+ul li a { border: 1px solid #94a0b4;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .active{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .dcactive{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;-moz-transition: all .4s ease-in;-moz-transform:scale(5);-webkit-transform:scale(5);-o-transform:scale(5);transform:scale(5);-ms-transform:scale(5);position:absolute; z-index:1000; position:absolute; left:0; top:0;}.printtree li a:hover+ul li::after, .printtree li a:hover+ul li::before, .printtree li a:hover+ul::before, .printtree li a:hover+ul ul::before{border-color:  #94a0b4;}.block{width:100%;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;}.block .top_contain{width:100%; height:20px;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;}.block .top_contain .insertid{width:78%; height:20px;/*border-right:#262626 solid 1px;*/ float:left; font-size:90%; line-height:20px; color:#fff;}.block .blue{background:#5081BD;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#609ad3), to(#4f7ebb)); background: -webkit-linear-gradient(top, #609ad3, #4f7ebb); background: -moz-linear-gradient(top, #609ad3, #4f7ebb);background: -ms-linear-gradient(top, #609ad3, #4f7ebb); background: -o-linear-gradient(top, #609ad3, #4f7ebb); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block  .green{background:#659626;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#73a72e), to(#639325)); background: -webkit-linear-gradient(top, #73a72e, #639325); /* Firefox 3.6+ */ background: -moz-linear-gradient(top, #73a72e, #639325);background: -ms-linear-gradient(top, #73a72e, #639325); background: -o-linear-gradient(top, #73a72e, #639325); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block .top_contain .inserticon{width:20%; height:20px;-webkit-border-top-right-radius:4px;border-top-right-radius:4px; float:left; background:#CCC;}.block .top_contain .p{background:url(../images/greenicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .top_contain .s{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .o{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .v{background:url(images/whiteicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .bottom{width:100%; height:37px;-webkit-border-bottom-right-radius: 4px;-webkit-border-bottom-left-radius: 4px;-moz-border-radius-bottomright: 4px;-moz-border-radius-bottomleft: 4px;border-bottom-right-radius: 4px;border-bottom-left-radius: 4px;}.block .bottom .userdata{float:left; width:80%; height:36px; line-height:12px; font-size:90%;}.block .bottom .expandcollsape{float:left; width:20%;height:36px; position:relative;}.block .bottom .expandcollsape .minus{width:18px; height:17px; background:url(images/minus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;}.block .bottom .expandcollsape .plus{width:18px; height:17px; background:url(images/plus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;.htree{-ms-transform: rotate(270deg);-webkit-transform: rotate(270deg);-moz-transform: rotate(270deg); position:absolute; height:100%; width:100px;}.htree ul {padding-top: 20px; position: relative;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.htree li {float: left; text-align: center;list-style-type: none;position: relative;padding: 20px 5px 0 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.htree li::before, .htree li::after{content: '';position: absolute; top: 0; right: 50%;border-top: 1px solid #ccc;width: 50%; height: 22px;}.htree li::after{right: auto; left: 50%;border-left: 1px solid #ccc;}.htree li:only-child::after, .htree li:only-child::before {display: none;}.htree li:only-child{ padding-top: 0;}.htree li:first-child::before, .htree li:last-child::after{border: 0 none;}.htree li:last-child::before{border-right: 1px solid #ccc;border-radius: 0 5px 0 0;-webkit-border-radius: 0 5px 0 0;-moz-border-radius: 0 5px 0 0;}.htree li:first-child::after{border-radius: 5px 0 0 0;-webkit-border-radius: 5px 0 0 0;-moz-border-radius: 5px 0 0 0;}.htree ul ul::before{content: '';position: absolute; top: 0; left: 50%;border-left: 1px solid #ccc;width: 0; height: 20px;}.htree li a{border: 1px solid #ccc;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-ms-transform: rotate(90deg);-moz-transition: all 0.5s;-webkit-transform: rotate(90deg);-moz-transform: rotate(90deg); margin:24px 0 18px;}.htree .active{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.htree li a:hover, .htree li a:hover+ul li a{-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.htree li a:hover+ul li::after, .htree li a:hover+ul li::before, .htree li a:hover+ul::before, .htree li a:hover+ul ul::before{border-color:  #94a0b4;}/]]></style>"+
			"<foreignObject width='"+containerWidth+"' height='"+containerHeight+"'>"+                  
						 "<div xmlns='http://www.w3.org/1999/xhtml' style='font-size:12px'>" +
							  "<div class='"+svgClass+"' width='"+containerWidth+"' height='"+containerHeight+"'>"+
								"<ul id='htree' style='width:"+containerWidth+"px;height:"+containerHeight+"px;'>"+
									$('#htree').html()+							 
								"</ul>"	+							
							 "</div>"+
							"</div>"+ 
						 "</foreignObject>";
			}
			if(treeOpenName=="F")
			{
			data+="<style type='text/css'><![CDATA[body{font-family:arial;margin:0px;padding:0px; background:#ffffff;}h1{color:#2a2929; font-size:12px; font-weight:bold; font-family:arial;padding:0 0 0 7px; line-height:31px;}.flexi{clear:both;}.wrapper{width:100%;}.topheader{width:99%;height:39px; background:url(../images/hbg.jpg) repeat-x; border:1px #898989 solid;-webkit-border-radius:6px;-moz-border-radius:6px;border-radius:6px; margin:4px auto;}.topheader .logo{background:url(../images/logo.jpg) 18px 2px no-repeat; width:479px; height:37px; float:left;}.searchbx{width:93%; height:28px; background:url(../images/searchbx.jpg) repeat-x; border:solid 1px #c2d4e6; margin:10px 0 0 8px;}.searchbx .searchicon{background:url(../images/searchicon.jpg) 0 3px no-repeat;width:23px; height:26px; float:left; margin:0 0 0 4px;}.searchbx .searchinput{width:85%; height:28px; float:left;}.searchbx .searchinput input{width:100%; height:22px; padding-top:2px;line-height:22px;border:none; background:url(../images/searchbx.jpg) repeat-x;}.midcontain{width:99%; margin:8px auto 0 auto;}.midcontain .leftblock{width:246px; float:left; /*height:540px;*/ background:#fff; margin:0 5px 0 0;}.midcontain .leftdata{width:100%; border:1px solid #898989; margin:7px 0 0 0; font-size: 12px;}.midcontain .b1{height:180px;}.midcontain .b2{height:80px;}.midcontain .b3{height:295px;}.midcontain .scroll{height:80px; overflow:scroll; width:100%;}.midcontain .leftdata .blockgap{margin:2%; width:98%; font-family:arial; color:#040404;}.midcontain .leftdata .blockgap .map{width:83%; float:left;height:136px;}.midcontain .leftdata .blockgap .print{width:15%;float:left;height:136px;}.midcontain .leftdata .searchblk{width:100%; font-family:arial; color:#040404; background:url(../images/search.jpg) no-repeat; height:49px;}.midcontain .title{background:#dedddd; height:31px; width:100%; border-bottom:solid 1px #b5b4b4;}.midcontain .treeheading{background:#dedddd; height:31px; width:100%;border:1px solid #898989; border-bottom:solid 1px #b5b4b4;}.midcontain .leftdata .userinfo{width:90%; margin:0 auto; /*height:497px;*/}.midcontain .leftdata .userinfo table{margin:20px 0;}.midcontain .leftdata .userinfo td{color:#292929; padding:4px;}.midcontain .rightree{width:99.3%; float:left;height:540px; background:#fff;position:relative; margin-left:6px;}.midcontain .rightree .treecontainer{width:100%;height:541px;overflow:scroll;border:1px solid #898989; border-top:none; position:relative;}ul#printtree{}ul#printtree li{float:left; margin:0 1px 0 0;}ul#printtree span{background:#009900;height:3px;margin:0 auto;width: 3px; margin:0 auto; display:block;}ul#child{margin:1px 0 0 0; width:100%; float:left;}ul#child li{float:left; margin:0 1px 0 0;}.stree{width:100%; height:100%;}.stree ul {text-align:center; width:100%;height:100%}.stree li {float:left; text-align: center;}.stree li a{display:inline-block; background:#009933; text-align: center;}.stree li .active{display:inline-block; background:#000;}.printtree{width:100px;}.printtree ul {padding-top: 20px; position: relative;}.printtree li {float: left; text-align: center;list-style-type: none;position: relative;padding: 21px 5px 0 5px;}.printtree li::before, .printtree li::after{content: '';position: absolute; top: 0; right: 50%;border-top: 1px solid #ccc;width: 50%; height: 20px;}.printtree li::after{right: auto; left: 50%;border-left: 1px solid #ccc;}.printtree li:only-child::after, .printtree li:only-child::before {display: none;}.printtree li:only-child{ padding-top: 0;}.printtree li:first-child::before, .printtree li:last-child::after{border: 0 none;}.printtree li:last-child::before{border-right: 1px solid #ccc;border-radius: 0 5px 0 0;-webkit-border-radius: 0 5px 0 0;-moz-border-radius: 0 5px 0 0;}.printtree li:first-child::after{border-radius: 5px 0 0 0;-webkit-border-radius: 5px 0 0 0;-moz-border-radius: 5px 0 0 0;}.printtree ul ul::before{border-left: 1px solid #CCCCCC;content: '';position: absolute; top:-4px; left: 50%;border-left: 1px solid #ccc;width: 0; height: 24px;}.printtree li a{border: 1px solid #ccc;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.printtree li a:hover, .printtree li a:hover+ul li a { border: 1px solid #94a0b4;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .active{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.printtree .dcactive{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;-moz-transition: all .4s ease-in;-moz-transform:scale(5);-webkit-transform:scale(5);-o-transform:scale(5);transform:scale(5);-ms-transform:scale(5);position:absolute; z-index:1000; position:absolute; left:0; top:0;}.printtree li a:hover+ul li::after, .printtree li a:hover+ul li::before, .printtree li a:hover+ul::before, .printtree li a:hover+ul ul::before{border-color:  #94a0b4;}.block{width:100%;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;}.block .top_contain{width:100%; height:20px;-webkit-border-top-left-radius: 4px;-webkit-border-top-right-radius: 4px;-moz-border-radius-topleft: 4px;-moz-border-radius-topright: 4px;border-top-left-radius: 4px;border-top-right-radius: 4px;}.block .top_contain .insertid{width:78%; height:20px;/*border-right:#262626 solid 1px;*/ float:left; font-size:90%; line-height:20px; color:#fff;}.block .blue{background:#5081BD;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#609ad3), to(#4f7ebb)); background: -webkit-linear-gradient(top, #609ad3, #4f7ebb); background: -moz-linear-gradient(top, #609ad3, #4f7ebb);background: -ms-linear-gradient(top, #609ad3, #4f7ebb); background: -o-linear-gradient(top, #609ad3, #4f7ebb); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block  .green{background:#659626;background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#73a72e), to(#639325)); background: -webkit-linear-gradient(top, #73a72e, #639325); /* Firefox 3.6+ */ background: -moz-linear-gradient(top, #73a72e, #639325);background: -ms-linear-gradient(top, #73a72e, #639325); background: -o-linear-gradient(top, #73a72e, #639325); -webkit-border-top-left-radius: 4px;-moz-border-radius-topleft: 4px;border-top-left-radius: 4px;}.block .top_contain .inserticon{width:20%; height:20px;-webkit-border-top-right-radius:4px;border-top-right-radius:4px; float:left; background:#CCC;}.block .top_contain .p{background:url(../images/greenicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .top_contain .s{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .o{background:url(../images/icon.png) 2px 1px no-repeat;-moz-background-size:18px 19px;background-size:18px 19px;}.block .top_contain .v{background:url(images/whiteicon.png) 2px 1px no-repeat;-moz-background-size:14px 18px;background-size:14px 18px;}.block .bottom{width:100%; height:37px;-webkit-border-bottom-right-radius: 4px;-webkit-border-bottom-left-radius: 4px;-moz-border-radius-bottomright: 4px;-moz-border-radius-bottomleft: 4px;border-bottom-right-radius: 4px;border-bottom-left-radius: 4px;}.block .bottom .userdata{float:left; width:80%; height:36px; line-height:12px; font-size:90%;}.block .bottom .expandcollsape{float:left; width:20%;height:36px; position:relative;}.block .bottom .expandcollsape .minus{width:18px; height:17px; background:url(images/minus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;}.block .bottom .expandcollsape .plus{width:18px; height:17px; background:url(images/plus-icon.png) no-repeat; -moz-background-size:16px 15px;background-size:16px 15px; position:absolute; bottom:0; right:0;.htree{-ms-transform: rotate(270deg);-webkit-transform: rotate(270deg);-moz-transform: rotate(270deg); position:absolute; height:100%; width:100px;}.htree ul {padding-top: 20px; position: relative;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.htree li {float: left; text-align: center;list-style-type: none;position: relative;padding: 20px 5px 0 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;}.htree li::before, .htree li::after{content: '';position: absolute; top: 0; right: 50%;border-top: 1px solid #ccc;width: 50%; height: 22px;}.htree li::after{right: auto; left: 50%;border-left: 1px solid #ccc;}.htree li:only-child::after, .htree li:only-child::before {display: none;}.htree li:only-child{ padding-top: 0;}.htree li:first-child::before, .htree li:last-child::after{border: 0 none;}.htree li:last-child::before{border-right: 1px solid #ccc;border-radius: 0 5px 0 0;-webkit-border-radius: 0 5px 0 0;-moz-border-radius: 0 5px 0 0;}.htree li:first-child::after{border-radius: 5px 0 0 0;-webkit-border-radius: 5px 0 0 0;-moz-border-radius: 5px 0 0 0;}.htree ul ul::before{content: '';position: absolute; top: 0; left: 50%;border-left: 1px solid #ccc;width: 0; height: 20px;}.htree li a{border: 1px solid #ccc;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;transition: all 0.5s;-webkit-transition: all 0.5s;-ms-transform: rotate(90deg);-moz-transition: all 0.5s;-webkit-transform: rotate(90deg);-moz-transform: rotate(90deg); margin:24px 0 18px;}.htree .active{background:#FFFBBE;border: 1px solid #94a0b4;width:100px;text-decoration: none;color: #666;font-family: arial, verdana, tahoma;font-size: 11px;display: inline-block;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;	transition: all 0.5s;-webkit-transition: all 0.5s;-moz-transition: all 0.5s;-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.htree li a:hover, .htree li a:hover+ul li a{-moz-box-shadow: 0 0 5px #609AD3;-webkit-box-shadow: 0 0 5px #609AD3;box-shadow: 0 0 5px #609AD3;}.htree li a:hover+ul li::after, .htree li a:hover+ul li::before, .htree li a:hover+ul::before, .htree li a:hover+ul ul::before{border-color:#94a0b4;.printftree {font-family: arial;font-size: 68.75%;}.printftree ul{margin:0;padding:0;}.printftree li{list-style:none; text-indent:10px;line-height:20px;}.printftree li a{text-decoration:none; padding:0 0 0 16px;display:block;}.printftree ul.sub{margin:0 0 0 20px;}.folder{background:url(images/collaspe.png) left center no-repeat, url(images/folder.png) 10px 0  no-repeat;}.folder_open{background:url(images/expand.png) left center no-repeat, url(images/folder.png) 10px 0  no-repeat;}.person{background:url(images/person.png) left center no-repeat;}/]]></style>"+
			"<foreignObject width='"+containerWidth+"' height='"+containerHeight+"'>"+                  
						 "<div xmlns='http://www.w3.org/1999/xhtml' style='font-size:12px'>" +
							  "<div class='"+svgClass+"' width='"+containerWidth+"' height='"+containerHeight+"'>"+
								"<ul id='ftree' style='width:"+containerWidth+"px;height:"+containerHeight+"px;'>"+
									$('#ftree').html()+							 
								"</ul>"	+							
							 "</div>"+
							"</div>"+ 
						 "</foreignObject>";
			}				
						data+="</svg>";
			var svg = new (self.BlobBuilder || self.MozBlobBuilder || self.WebKitBlobBuilder); 
			var DOMURL = self.URL || self.webkitURL || self;
			var img =  new Image(containerWidth,containerHeight);  
			svg.append(data);  
			url = DOMURL.createObjectURL(svg.getBlob("image/svg+xml;charset=utf-8"));
			ctx.fillStyle = "#ffffff";
			img.onload = function() {
				ctx.drawImage(img,0,0,containerWidth,containerHeight);
				DOMURL.revokeObjectURL(url);
			}; 
			img.src = url;
		   sliceImage(svg);
			
		},
		open: function(event, ui) {
			popupHeight=$(this).outerHeight();
			popupWidth=$(this).outerWidth();
		}
		,
		resizable: false
	});
	$("."+svgClass).dialog("close");
	
	printIt();
}

function sliceImage(svg){
 	var image = svg ; // new Image();
	image.onload = cutImageUp;
	//image.src = url;
	function cutImageUp() {
    var imagePieces = [];
	var widthOfOnePiece=1200;
	var heightOfOnePiece=200;
	
	if(containerWidth>1200)
		widthOfOnePiece=1200;
	else	
	  widthOfOnePiece=containerWidth;	
	
	heightOfOnePiece=containerHeight;
	
	if(containerHeight<200 && containerWidth<1200)
	{
		var canvas = document.getElementById("canvas");		   
		var context = canvas.getContext("2d");
		canvas.width = widthOfOnePiece;
		canvas.height = heightOfOnePiece;
		context.drawImage(image,0, 0, canvas.width, canvas.height);
		imagePieces.push(canvas.toDataURL("image/png"));
	}
	else
	{
	
	var numColsToCut = Math.round(containerWidth/widthOfOnePiece);
	var numRowsToCut =Math.round(containerHeight/heightOfOnePiece);
	for(var x = 0; x < numColsToCut; ++x) {
	    for(var y = 0; y < numRowsToCut; ++y) {
           var canvas = document.getElementById("canvas");
		   var context = canvas.getContext("2d");	
			canvas.width = widthOfOnePiece;
			canvas.height = heightOfOnePiece;
			context.drawImage(image, x * widthOfOnePiece, y * heightOfOnePiece, widthOfOnePiece, heightOfOnePiece, 0, 0, canvas.width, canvas.height);
			imagePieces.push(canvas.toDataURL("image/png"));
        }
    }
	}
	$('#myImageElementInTheDom').empty();
    var anImageElement = document.getElementById('myImageElementInTheDom');
	for(var s=0;s<imagePieces.length;s++)
	{
			var oImg=document.createElement("img");
			oImg.setAttribute('src', imagePieces[s]);
			oImg.setAttribute('class', imagePieces[s]);
			anImageElement.appendChild(oImg);
	}
	
	   var win = window.open('', 'Image', 'resizable=yes,...');
        if (win) {
				win.document.writeln('<html><head><style type="text/css" media="print"> #bg img{ display:block; page-break-after:always;}  </style></head><body style="background:#fff;">');
                win.document.writeln('<div id="bg" class="bg">'+document.getElementById('myImageElementInTheDom').innerHTML+'</div>');
				win.document.writeln("</body></html>");
                win.document.close();
                win.focus();
                win.print();
                if(treeOpenName=="V")
				{
					$('#collapser').find('a').find('div').each(function(){
	     				if(this.id=='boxdata'){
							$(this).css('display','block');
						}
					});
				}
				else if(treeOpenName=="H")
				{
					$('#htree').find('a').find('div').each(function(){
	     				if(this.id=='boxdata'){
							$(this).css('display','block');
						}
					});
				}
				else if(treeOpenName=="F")
				{
					$('#ftree').find('a').find('div').each(function(){
	     				if(this.id=='boxdata'){
							$(this).css('display','block');
						}
					});
				}
        }
	
	}
}
function printIt() {
       //var win = window.open('', 'Image', 'resizable=yes,...');
        if (win) {
				win.document.writeln('<html><head><style type="text/css" media="print"> img#img { display:block;page-break-inside:always;background:#fff;}</style></head><body style="background:#fff;">');
                win.document.writeln("<img width='"+containerWidth+"' height='"+containerHeight+"' style='background:#fff' id='img_print' src=\""+strDataURI+"\" alt='file.png'></html>");
                win.document.close();
                win.focus();
                win.print();
        }
        return false;
}

function createSVG(h,w,NS){
 var svg = document.createElementNS(NS,"svg");
 svg.width=w;
 svg.height=h;
 svg.id ="amit";
 return svg;
}
