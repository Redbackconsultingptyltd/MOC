var UIMessage=function(){
	this.cssClass='orgMessageBar';
	this.messageId='orgMessageBar';
	//this.message=document.createElement('div');
	this.messageShow=function(text,type){
		var message = document.createElement('div');
	
		message.id="orgMessageBar";
		document.body.appendChild(message);
		
		var ele = document.createElement('div');
		ele.id="messageContainer";
		message.appendChild(ele);
		
		var mIcon = document.createElement("img");
		mIcon.src='img/more_icon.png';
		mIcon.id="messageIcon";
		ele.appendChild(mIcon);
		
		var mText=document.createElement("div");
		mText.id="messageText";
		ele.appendChild(mText);
		mText.appendChild(document.createTextNode (text));
		
		$("#orgMessageBar").addClass("orgMessageBarOpen");
		$("#messageContainer").addClass("messageContainer");
		$("#messageIcon").addClass("messageIcon");
		$("#messageText").addClass("messageText");
		setTimeout(this.destroyMessage,4000);
	};
	this.destroyMessage=function(){
		document.body.removeChild(document.getElementById("orgMessageBar"));
	};
	this.generateMenuBarItems=function(items){
		
		var html='<ul id="s-menu-bar">';
		for(var it in items){
			var cssClass="";
			if(items[it].isActive){
				cssClass="active";
				document.getElementById(items[it].view).style.display='block';
			}else{
				cssClass="inactive";
				document.getElementById(items[it].view).style.display='none';
			}
			html+='<li id="'+items[it].id+'" class="'+cssClass+'" onClick = doAction("'+items[it].action+'")><a herf="javascript:void(0)" title="'+items[it].tooltip+'">'+items[it].text+'</a></li>';
			
			
		}
		document.getElementById("navbar").innerHTML=html;
		
	};
	this.destroyMenuBarItems=function(){
		if(document.getElementById("s-menu-bar")!=null)
		document.getElementById("navbar").removeChild(document.getElementById("s-menu-bar"));
	};
	this.contextMenu=function(items,e){
		
		var html ='<table>';

		for(obj in items){
			var cssClass="";
			if(items[obj].enabled){
				cssClass="ContextItem";
			}else{
				cssClass="ContextItemDisable";
			}
			html+='<tr><td id="'+items[obj].id+'" class="'+cssClass+'"';
			if(items[obj].enabled){
				html+=' onClick=doAction("'+items[obj].action+'")>'+items[obj].text+'</td></tr>';
			}else{
				html+='>'+items[obj].text+'</td></tr>';
			}
		}
		html+='<tr><td id="exit"  class="ContextItem" onClick="HideMenu()">Exit</td></tr>';
		html+='</table>';
		
		var contextMenuEle = document.createElement('div');
		contextMenuEle.id="contentMenues";
		document.body.appendChild(contextMenuEle);
		document.getElementById("contentMenues").innerHTML=html;
		
		$("#contentMenues").addClass("contentMenues");
		var posx = e.clientX +window.pageXOffset +'px'; //Left Position of Mouse Pointer
	    var posy = e.clientY + window.pageYOffset + 'px'; //Top Position of Mouse Pointer
	    var fY = e.clientY+(30*items.length);
	    var dedicatedHeight = parseInt(document.getElementById("wrapper").style.height)+80;
	    if(fY>=dedicatedHeight){
	    	posy = e.clientY-(30*items.length+1)+'px';
	    }
	    var fX = e.clientX+110;
	    var dedicatedWidth= parseInt(document.body.clientWidth)-110;
	    if(fX>=dedicatedWidth){
	    	posx = (e.clientX -125)+'px';
	    }
	    document.getElementById("contentMenues").style.position = 'absolute';
	    document.getElementById("contentMenues").style.display = 'inline';
	    document.getElementById("contentMenues").style.left = posx;
	    document.getElementById("contentMenues").style.top = posy;     
	
	};
	this.destroyContextMenu=function(){
		if(document.getElementById("contentMenues")!=null)
		document.body.removeChild(document.getElementById("contentMenues"));
	};
	this.ShowAlertMessage=function(message){
		var orgCover = document.createElement('div');
		orgCover.id="orgCover";
		document.body.appendChild(orgCover);
		var orgAlertMessageScreen = document.createElement('div');
		orgAlertMessageScreen.id="orgAlertMessageScreen";
		document.getElementById("orgCover").appendChild(orgAlertMessageScreen);
		document.getElementById("orgAlertMessageScreen").innerHTML= this.alertMessageContent(message);
		$("#orgCover").addClass("orgCover");
	};
	this.removeDragMessage=function(){
		if(document.getElementById("dragMessage")!=null)
			document.body.removeChild(document.getElementById("dragMessage"));
	};
	this.dragAlertMessage=function(message){
		var dragMessage = document.createElement('div');
		dragMessage.id="dragMessage";
		document.body.appendChild(dragMessage);
		document.getElementById("dragMessage").innerHTML= this.dragMessageContent(message);
	};
	this.dragMessageContent=function(message){
		return '<div id="lightbox"  bor><table  width="267" height="177" align="left" cellpadding="0.0" cellspacing="0.0">'+
		'<tr><td width="10" height="29" bgcolor="#444444">&nbsp;</td><td width="131" bgcolor="#444444">&nbsp;</td><td width="126" bgcolor="#444444">&nbsp;</td></tr>'+
		'<tr><td bgcolor="#C6C6C6">&nbsp;</td><td colspan="2" valign="middle" bgcolor="#C6C6C6"><span><div style="font-size:12px; font-family: arial;">'+message.text+'</div></span></td></tr>'+
		'<tr><td height="19" bgcolor="#C6C6C6">&nbsp;</td><td bgcolor="#C6C6C6">&nbsp;</td><td align="right" valign="middle" bgcolor="#C6C6C6">&nbsp;</td></tr>'+
		'<tr><td height="68" bgcolor="#C6C6C6">&nbsp;</td><td bgcolor="#C6C6C6">&nbsp;</td><td align="right" valign="middle" bgcolor="#C6C6C6">'+
		'<div style=" border-radius: 8px; font-weight: bold; font-family: arial; font-size: 12px; height:17px; padding-top:5px; margin-bottom:15px; margin-left:30px border: 1px solid;" align="right"  class="commanAlertButton" onclick=doAlertAction("'+message.action+'") >'+message.label+'</div></td></tr>'+
		'<tr><td height="36" bgcolor="#909090">&nbsp;</td><td bgcolor="#909090">&nbsp;</td><td bgcolor="#909090">&nbsp;</td></tr>'+
		'</table></div>'   
	};
	this.alertMessageContent=function(message){
		return '<table width="314" height="181" border="0.1" cellpadding="0.0" cellspacing="0.0">'+
		'<tr><td width="10" bgcolor="#444444">&nbsp;</td><td width="304" bgcolor="#4A4A4A">&nbsp;</td></tr>'+
		'<tr><td bgcolor="#C6C6C6">&nbsp;</td><td bgcolor="#C6C6C6" style="font-size:12px;">'+message.text+'</td></tr>'+
		'<tr><td bgcolor="#C6C6C6">&nbsp;</td><td align="right" valign="middle" bgcolor="#C6C6C6">&nbsp;</td></tr>'+
		'<tr><td bgcolor="#C6C6C6">&nbsp;</td><td align="right" valign="middle" bgcolor="#C6C6C6">'+
		'<div  class="alertButtonYes" onclick=doAlertAction("'+message.action+'")>Yes</div>'+
		
		'<div class="alertButtonNo" onclick=doAlertAction("hide")>No</div></td></tr>'+
		'<tr>	<td bgcolor="#909090">&nbsp;</td><td bgcolor="#909090">&nbsp;</td>		</tr>'+
		'</table>';
	};
	this.JSONForm=function(json,action){
		var orgCover = document.createElement('div');
		orgCover.id="orgCover";
		document.body.appendChild(orgCover);
		var orgScreen = document.createElement('div');
		orgScreen.id="orgScreen";
		document.body.appendChild(orgScreen);
		document.getElementById("orgCover").appendChild(orgScreen);
		$("#orgCover").addClass("orgCover");
		$("#orgScreen").addClass("orgScreen");
	    document.getElementById("orgScreen").innerHTML= this.JSONToForm(json,action);
	    
	    new datepickr(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_BEGDA, {
			'dateFormat': 'd-m-y'
		});
		new datepickr(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ENDDA, {
			'dateFormat': 'd-m-y'
		});
		
	};
	this.removeJSONForm=function(){
		if(document.getElementById("orgCover")!=null){
			document.body.removeChild(document.getElementById("orgCover"));
		}
	};
	this.removeAlertMessage=function(){
		if(document.getElementById("orgCover")!=null){
			document.body.removeChild(document.getElementById("orgCover"));
		}
	};
	this.getInputFieldValue=function(id){
		if(document.getElementById(id)!=null){
			return document.getElementById(id).value;
		}else{
			return null;
		}
	};
	this.getDropDownBoxValue=function(id){
		return document.getElementById(id).options[document.getElementById(id).selectedIndex].text;
	};
	this.getFormJsonData=function(){
		return {objectId:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ID),
			    oType:this.getDropDownBoxValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_TYPE),
			    isChief:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_IS_CHIEF),
			    name:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_NAME),
			    email:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS),
			    address:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ADDRESS),
			    city:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_CITY),
			    validity:{begda:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_BEGDA),endda:this.getInputFieldValue(orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ENDDA)}
			    
		};
	};
	this.JSONToForm=function(json,action){
		var html='<div class="orgScreenTopBar"><div class="orgScreenTopBarButton" onclick=doAction("exit") ></div></div>';
		html+='<table class="orgFormTable"cellpadding="0" cellspacing="0" border="0">';
		for(obj in json){
			if(json[obj].visible==true){
				html+='<tr><td class="orgFormLabel">'+json[obj].label+':</td>';
				if(json[obj].type=="input"){
					html+='<td><input type="text" id="'+json[obj].id+'" placeholder="'+json[obj].placeholder+'" value="'+json[obj].value+'" style="width:'+json[obj].width+'" '+json[obj].readonly+' />';
					html+='<label id="WARNING-'+json[obj].id+'" style="font-size:12px;"></label></td></tr>';
				}else if(json[obj].type=="select"){
					html+='<td><select class="orgSelOType" id="'+json[obj].id+'"  onchange="doSelection(this)" '+json[obj].readonly+'>';
					var items=json[obj].items;
					for(var it in items){
						if(items[it].selected){
							html+='<option selected="selected">'+items[it].text+'</option>';
						}else{
							html+='<option>'+items[it].text+'</option>';
						}
						
					}
	               html+='</select>';
	               html+='<label id="WARNING-'+json[obj].id+'" style="font-size:12px;"></label></td></tr>';
	             
				}else if(json[obj].type="checkbox"){
					html+='<td><input type="checkbox" id="'+json[obj].id+'" '+json[obj].isChecked+' style="width:32px;height:18px;margin-top:10px;" '+json[obj].readonly+' /></td>';
					html+='<label id="WARNING-'+json[obj].id+'" style="font-size:12px;"></label></td></tr>';
				}
				
			}
		}
		html+='</table>';
		html+='<div class="orgScreenFooterBar">'+
			     '<div id="orgScreenFoterBar-actionBar" style="float:right;">'+
			          '<div class="orgActionButton" onclick=doAction("'+action.action+'")>'+action.label+'</div>'+
			         ' <div class="orgActionButton" onclick=doAction("exit")>Exit</div>'+
			    ' </div>'+
			'</div>';
		return html;
	};
	this.createElement=function(type,id){
		var ele;
		switch(type){
		case 'div':
			 
			ele = document.createElement('div');
			ele.id = id;
			break; 
		}
		return ele;
	};
	this.showMapWindow=function(mapAttr){
		
		document.body.appendChild( this.createElement('div','orgCover'));
		var orgScreen = this.createElement('div', 'orgScreen');
		document.getElementById("orgCover").appendChild(orgScreen);
		
		$("#orgCover").addClass("orgCover");
		$("#orgScreen").addClass("orgScreen");
		document.getElementById("orgScreen").appendChild(this.createElement('div', 'screenHeader'));
		document.getElementById("screenHeader").innerHTML= this.mapHeader(mapAttr.formatted_address);
		

		 var mapProp = {
			     zoom: 12,
			   center: new google.maps.LatLng(mapAttr.geometry.location.lat, mapAttr.geometry.location.lng),
			center: {lat:mapAttr.geometry.location.lat, lng: mapAttr.geometry.location.lng},
			    mapTypeId:google.maps.MapTypeId.ROADMAP,
			   
			  };
		
		 document.getElementById("orgScreen").appendChild(this.createElement('div', 'mapContent'));
		 $("#mapContent").css('width',$("#orgScreen").width()+'px');
		
		 $("#mapContent").css('height',$("#orgScreen").height()-50+'px');
		 $("#mapContent").addClass("mapContent");
		 var map=new google.maps.Map(document.getElementById("mapContent"), mapProp);
		 var markerPos = new google.maps.LatLng( mapAttr.geometry.location.lat, mapAttr.geometry.location.lng);

		 var marker = new google.maps.Marker({
			   position: markerPos,
			   map: mapContent,
			   title: "PC Pro Offices"
			});
		 
	};
	this.mapHeader=function(headerStr){
		var html='<div class="mapHeader">'+headerStr+'<div class="orgScreenTopBarButton" onclick=doAction("exit") ></div></div>';
		return html;
	};
};
