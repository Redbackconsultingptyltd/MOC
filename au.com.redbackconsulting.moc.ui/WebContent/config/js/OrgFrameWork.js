var OrgFrameWork=function(oData){
	this.objectId=0;
	this.objectSqNo=7000000;
	this.contextMenuStatus=false;
	this.selectedMoveNodeSqNo=0;
	this.movePasteStatus=false;
	this.initialRoot=0;
	this.plusMinusStatusList=new Array();
	this.hierarchy=[] ; /// hierarchy collection for planed version;
	this.activeHierarchy=[]; // active version hierarchy collection;
	this.additionalInfo=[];
	this.rootSqNo=1;
	this.orgNavigationFactor=5;
	this.orgNodeStatus =[]; //purpose: to take care of information is node expend or collapse; use in context menu visibility;
	this.selectedAppVersion=0;
	this.orgCurrentDate='';
	this.orgKeyDate =  new Date();
	this.IS_OBJECT_CENTER = true;
    this.expendCollspseRules=null;
	this.contextMenuVisible=false;
	this.draggableNodeMove={isMove:false,sqnNo:null,objectId:null};
	this.draggableToNodeMove={isMove:false,sqnNo:null,objectId:null};
	this.isNodeCenterStatus=false;
	this.isDragStatus=false;
	this.dragNodeId=null;
	this.FIRST_TWO_LEVEL_FACTOR=120;
	this.ABOVE_TWO_LEVEL_FACTOR=85;
	this.boxTreeStatus=false;
	this.moveApprove=false;
	this.contextMenuPaste=false;
	this.moveChildInfo={};
	this.moveMessageStatus=false;
	this.setMoveMessageStatus=function(status){
		this.moveMessageStatus=status;
	};
	this.getMoveMessageStatus=function(){
		return this.moveMessageStatus;
	};
	this.setExpendCollapseRules=function(rules){
		this.expendCollspseRules= rules;
	};
	this.getExpendCollapseRules=function(){
		return this.expendCollspseRules;
	};
	this.setMoveChildInfo=function(info){
		this.moveChildInfo=info;
	};
	this.getMoveChildInformation=function(){
		return this.moveChildInfo;
	};
	this.setContextMenuPasteStatus=function(status){
		this.contextMenuPaste=status;
	};
	this.isContextMenuPaste=function(){
		return this.contextMenuPaste;
	};
	this.setIsMoveApprove=function(is){
		this.moveApprove=is;
	};
	this.isMoveApprove=function(){
		return this.moveApprove;
	};
	this.getBoxTreeStatus=function(){
		return this.boxTreeStatus;
	};
	this.setBoxTreeStatus=function(status){
		this.boxTreeStatus =status;
	};
	this.calculateLevelScaleFactor=function(level){
		if(level<=2){
			return level*this.FIRST_TWO_LEVEL_FACTOR;
		}else{
			return level*this.ABOVE_TWO_LEVEL_FACTOR;
		}
	};
	this.formJson  =[];
	this.uiConstant = new Constant();
	this.getFormJson=function(){
		
		for(var j in this.formJson){
			if(this.formJson[j].id==this.uiConstant._ELE_ID_FORM_OBJECT_ID){
				this.formJson[j].value= this.getObjectSqNo();
				break;
			}
		}
		return this.formJson;
	};
	this.setFormJson=function(fjson){
		this.formJson=fjson;
	};
	this.setAppState=function(state){
		this.appInitializeState=state;
	};
	this.menuBarItems=[{id:"menu-bar-home",isActive:false,action:"org-home",view:"org-home" ,tooltip:"Home",text:"Home"}, {id:"menu-bar-midcontain",isActive:true,action:"org-midcontain",view:"midcontain" ,tooltip:"Organizational Chart",text:"Org Chart"}, {id:"menu-bar-reports",isActive:false,action:"org-reports",view:"org-reports", tooltip:"Reports",text:"Reports"}];
		
	this.contextMenuItems=[{id:"create",enabled:true,action:"create",text:"Create Node"},{id:"move",enabled:true,action:"move",text:"Move Node"},{id:"mpaste",enabled:false,action:"move-paste",text:"Move Paste"}, {id:"delete",enabled:false,action:"delete",text:"Delete Node"}];
	// draggable
	this.setMenuBarItems=function(items){
		this.menuBarItems = items;
	};
	this.getMenuBarItems=function(){
		return this.menuBarItems;
	};
	this.getDragNodeId=function(){
		return this.dragNodeId;
	};
	this.setDragNodeId=function(id){
		this.dragNodeId=id;
	};
	this.setContextMenuItems=function(items){
		this.contextMenuItems=items;
	};
	this.getContextMenuItems=function(){
		return this.contextMenuItems;
	};
	this.draggableProperties={control:null,status:false,sqNo:null};
	this.setDraggalbeProperties=function(props){
		this.draggableProperties=props;
	};
	this.getDraggalbeProperties=function(){
		return this.draggableProperties;
	};
	// end of draggable
	this.dragObject;
	this.setDragObject=function(obj){
		this.dragObject= obj;
	};
	this.getDragObject=function(){
		return this.dragObject;
	};
	
	this.setIsDragStatus=function(is){
		this.isDragStatus=is;
	};
	this.isDrag=function(){
		return this.isDragStatus;
	};
	this.setIsNodeCenter=function(is){
		this.isNodeCenterStatus=is;
	};
	this.isNodeCenter=function(){
		return this.isNodeCenterStatus;
	};
	this.setDraggableToNodeMove=function(obj){
		this.draggableToNodeMove.isMove=obj.isMove;
		this.draggableToNodeMove.sqnNo = obj.sqnNo;
		this.draggableToNodeMove.objectId= obj.objectId;
	};
	this.setDraggableNodeMove=function(obj){
		this.draggableNodeMove.isMove=obj.isMove;
		this.draggableNodeMove.sqnNo = obj.sqnNo;
		this.draggableNodeMove.objectId= obj.objectId;
	};
	
	this.getDraggableToNodeMoveSqnNo=function(){
		return this.draggableNodeMove.sqnNo;
	};
	this.getDraggableToNodeMoveObjectId=function(){
		this.draggableToNodeMove.objectId;
	};
	
	this.isDraggableNodeMove=function(){
		return this.draggableNodeMove.isMove;
	};
	this.setIsDraggableNodeMove=function(is){
		this.draggableNodeMove.isMove=is;
	};
	this.getDraggableNodeMoveSqnNo=function(){
		return this.draggableNodeMove.sqnNo;
	};
	this.getDraggableNodeMoveObjectId=function(){
		this.draggableNodeMove.objectId;
	};
	this.setContextMenuVisiblity=function(v){
		this.contextMenuVisible=v;
	};
	this.getContextMenuVisiblity=function(){
		return this.contextMenuVisible;
	};

	this.isObjectCenter=function(){
		return this.IS_OBJECT_CENTER;
	};
	this.setObjectCenter=function(is){
		this.IS_OBJECT_CENTER = is;
	};
	this.init=function(){
		
	};
	this.setOrgKeyDate=function(dt){
		this.orgKeyDate = dt;
	};
	this.getOrgKeyDate=function(){
		return this.orgKeyDate;
	};
	this.converStringToDateFormat=function(dt){
		 var dtArr = dt.split('-');
		   dtArr[0] = parseInt(dtArr[0]);
		   dtArr[1]= parseInt(dtArr[1])-1;
		   if(dtArr[2].length==2){
			   dtArr[2] = parseInt(dtArr[2])+2000;
		   }else{
			   dtArr[2] = parseInt(dtArr[2]);
		   } 
		   return new Date(dtArr[2],dtArr[1],dtArr[0]);
	};
	this.orgFormatMonthAndDate=function(number){
		if(number<10){
			return '0'+number.toString();
		}else{
			return number.toString();
		}
	};
	this.getOrgCurrentDate=function(){
		return this.orgCurrentDate;
	};
	this.setOrgCurrentDate=function(dt){
		 this.orgCurrentDate = dt;
	};
	this.setSelectedAppVersion=function(version){
		this.selectedAppVersion=version;
	};
	this.getSelectedAppVersion=function(){
		return this.selectedAppVersion;
	};
	this.getOrgNavigationFactor=function(){
		return this.orgNavigationFactor;
	};
	this.setContextMenuStatus=function(status){
		this.contextMenuStatus=status;
	};
	
	this.setInitialRoot=function(root){
		this.initialRoot=root;
	};
	this.getObjectSqNo=function(){
		return this.objectSqNo;
	};
	this.updateObjectSqNo=function(){
		this.objectSqNo+=1;
	};
	this.getInitialRoot=function(){
		return this.initialRoot;
	};
	
	this.setOrgNodeStatus=function(sqNo,status){
		this.orgNodeStatus[sqNo]=status;
	};
	this.getOrgNodeStatus=function(sqNo){
		return this.orgNodeStatus[sqNo];
	};
	this.checkChildsForContextMenu=function(parentChild,sqNo){
		var objectId=0;
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[0]==sqNo){
				 objectId = parentChild[i].split('@')[2];
				break;
			}
		}
		if(objectId==0){
			return false;
		}else{
			var list = this.hierarchy[objectId];
			if(list!=null){
				var childs = list.jsondata.children;
				if(childs.length>0){
					return true;
				}else{
					return false;
				}
			}else{
				var found=0;
				for(var o in this.orgNodeStatus){
					if(o==sqNo){
						found=1;
						break;
					}
				}
				if(found==0){
					return false;
				}else{
					return true;
				}
			}
			
		}
		return false;
	};
	this.getContextMenuStatus=function(){
		return this.contextMenuStatus;
	};
	this.createNewNode=function(){
		//var html='<div class="orgOverlayContainer"></div>';
	};
	this.setRootSqNo=function(sqn){
		this.rootSqNo=sqn;
	};
	this.getRootSqNo=function(){
		return this.rootSqNo;
	};
	this.setAdditionalInfo=function(){
		this.additionalInfo[50000070]={"jsondata":{"id":"21","data":[{"addinfo":{"id":"21","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"business","groupDesc":"VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["01-01-2010"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"label","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":["31-12-9999"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-01-2010"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Head Office 1"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Head Office 1"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Department"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":["Department"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2012"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
		
		this.additionalInfo[50000051]={"jsondata":{"id":"2","data":[{"addinfo":{"id":"2","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"validity","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-01-2010"]},{"uiElementId":"1","currentValues":["31-12-2014"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Department"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Department"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Department"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":["Department"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2012"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
			
			this.additionalInfo[50000151]={"jsondata":{"id":"22","data":[{"addinfo":{"id":"22","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"validity","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["18-8-1995"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Western"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Western"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Department"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000051"]},{"uiElementId":"1","currentValues":["Western"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2012"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};	
	
			this.additionalInfo[50000052]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["01-01-2010"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-01-2010"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Eastern"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Eastern"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Department"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000051"]},{"uiElementId":"1","currentValues":["Eastern"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
	
			this.additionalInfo[50000179]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"BEGIN DATE","readOnly":"false","mandatory":" false","defaultValues":["Executive Officer"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["31-08-1995"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Executive Officer"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Executive Officer"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Executive Officer"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":["Executive Officer"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
			
			this.additionalInfo[50000109]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["chief finance officer"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["27-07-1995"]},{"uiElementId":"1","currentValues":["31-12- 9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["chief finance officer"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Chief Finance Officer"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Chief Finance Officer"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":["Chief Finance Officer"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
	
			this.additionalInfo[50000275]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["Administrator"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-03-2012"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Administrator"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Administrator"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Administrator"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":["Administrator"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
			
			this.additionalInfo[50000274]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["Regional Manager"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-03-2012"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Regional Manager"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Regional Manager"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Regional Manager"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":["Regional Manager"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
			
			this.additionalInfo[50000053]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"23","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["Executive"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-01-2010"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Executive"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Executive"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Executive"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":["Executive"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
	       
			this.additionalInfo[50000069]={"jsondata":{"id":"23","data":[{"addinfo":{"id":"212","data":[{"panelId":"addinfo","orinetation":"vertical","groups":[{"groupName":"VALIDITY","groupDesc":" VALIDITY","uiEleMetaData":[{"fieldName":"BEGDDA","fieldType":"label","fieldLabel":"START DATE","readOnly":"false","mandatory":" false","defaultValues":["Contracts"],"uiElementId":"0"},{"fieldName":"ENDDA","fieldType":"input","fieldLabel":"END DATE","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["01-01-2010"]},{"uiElementId":"1","currentValues":["31-12-9999"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Contracts"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Contracts"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1011"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]},{"groupName":"orgunit","groupDesc":" PERSONAL DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["1000"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Contracts"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":["Contants"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2020"}}]}]}]},"objectinfo":{"id":"2","data":[]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
	};
	this.getAdditionalInfo=function(nodeId){
		return this.additionalInfo[nodeId];
	};
	this.getSelectedNodeLevel=function(sqnno){
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[0]==sqnno){
				 return parentChild[i].split('@')[9];
			}
		}
		return 1;
	};
	this.setHierarcy=function(){
	//	this.hierarchy[50000051]={"jsondata":{"id":"2","name":"DODGI 12","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000051","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"1995-08-18","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"24","name":"Southern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000054","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"25","name":"Northern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000058","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};

		 
//			this.hierarchy[50000051]={"jsondata":{"id":"2","name":"DODGI 12","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000051","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"1995-08-18","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"24","name":"Southern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000054","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"25","name":"Northern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000058","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}; 
		this.hierarchy[50000051]={"jsondata":{"id":"2","name":"DODGI 12","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000051","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"211","name":"Executive","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000053","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"212","name":"Contracts","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000069","validity":{"begda":"10-10-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"18-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"221","name":"Reg Manager","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000274","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"222","name":"Admin","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000275","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"231","name":"CFO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000109","validity":{"begda":"27-07-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"232","name":"ExecutiveOff","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000179","validity":{"begda":"31-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};	
		
		this.hierarchy[50000070]={"jsondata":{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"211","name":"Executive","data":{"Img":"/mocjit/images/o.png","Otype":"P","ObjectId":"50000053","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"212","name":"Contracts","data":{"Img":"/mocjit/images/o.png","Otype":"S","ObjectId":"50000069","validity":{"begda":"10-10-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
		
		this.hierarchy[50000151]={"jsondata":{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"18-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"221","name":"Reg Manager","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000274","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"222","name":"Admin","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000275","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}; 
		
		this.hierarchy[50000052]={"jsondata":{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"231","name":"CFO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000109","validity":{"begda":"27-07-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"233","name":"ExecutiveOff","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000179","validity":{"begda":"31-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}; 




	    this.activeHierarchy[50000051]={"jsondata":{"id":"2","name":"DODGI 12","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000051","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"211","name":"Executive","data":{"Img":"/mocjit/images/o.png","Otype":"P","ObjectId":"50000053","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"212","name":"Contracts","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000069","validity":{"begda":"10-10-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"18-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"221","name":"Reg Manager","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000274","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"222","name":"Admin","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000275","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"231","name":"CFO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000109","validity":{"begda":"27-07-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"232","name":"ExecutiveOff","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000179","validity":{"begda":"31-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};	
		
		this.activeHierarchy[50000070]={"jsondata":{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"211","name":"Executive","data":{"Img":"/mocjit/images/o.png","Otype":"P","ObjectId":"50000053","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"212","name":"Contracts","data":{"Img":"/mocjit/images/o.png","Otype":"S","ObjectId":"50000069","validity":{"begda":"10-10-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
		
		this.activeHierarchy[50000151]={"jsondata":{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"18-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"221","name":"Reg Manager","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000274","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"222","name":"Admin","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000275","validity":{"begda":"01-03-2012","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}; 
		
		this.activeHierarchy[50000052]={"jsondata":{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"01-01-2010","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"231","name":"CFO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000109","validity":{"begda":"27-07-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"233","name":"ExecutiveOff","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000179","validity":{"begda":"31-08-1995","endda":"31-12-9999"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}; 

	
	
	};
	this.add=function(objectId,hier){
		if(this.hierarchy[objectId]==null){
			this.hierarchy[objectId]=hier;
		}
		
	};
	this.getHierarchy1=function(ObjectId){
		if(this.getSelectedAppVersion()==1){
			if(this.hierarchy[ObjectId]==null){
				return null;
			}else{
				return this.hierarchy[ObjectId];
			}
		}else{
			if(this.activeHierarchy[ObjectId]==null){
				return null;
			}else{
				return this.activeHierarchy[ObjectId];
			}
		}
		
		
	};
	this.getHierarchy=function(ObjectId){
		if(this.getSelectedAppVersion()==1){
			if(this.hierarchy[ObjectId]==null){
				return null;
			}else{
				return this.hierarchy[ObjectId].jsondata;
			}
		}else{
			if(this.activeHierarchy[ObjectId]==null){
				return null;
			}else{
				return this.activeHierarchy[ObjectId].jsondata;
			}
		}
		
		
	};
	this.resetHierarchy=function(ObjectId,newHierarchy){
		if(this.getSelectedAppVersion()==1){
			this.hierarchy[ObjectId].jsondata=newHierarchy;
		}
	};
	this.updateRootContent=function(rootSqNo,sqNo,child){
		for(var i in this.hierarchy){
			if(rootSqNo==this.hierarchy[i].jsondata.id){
				var childs = this.hierarchy[i].jsondata.children;
				for(var c=0;i<childs.length;c++){
					if(childs[c].id==sqNo){
						childs[c].push(child);
						break;
					}
				}
				this.hierarchy[i].jsondata.children=childs;
			}
		}
		
	};
	this.createAndAddIfRecordNotFound=function(parentChild,hier){
		var rootSqn = this.getRoot(parentChild, this.getRootSqNo());
		var rootObjectId = this.getRootObjectId(parentChild, rootSqn);
		var data = this.hierarchy[rootObjectId].jsondata;
		if(data!=null){
			var childs = data.children;
			for(var i=0;i<childs.length;i++){
				if(childs[i].id==this.getRootSqNo()){
					childs[i].children.push(hier);
					this.hierarchy[this.getObjectId()]={jsondata:childs[i]};
				}
			}
		}
	};
	this.pushChildInHierarchy=function(rootId,childs,child){
		if(childs==null||childs.length==0){return ;}
		
		if(childs.id==rootId){
			childs.children.push(child);
			return true;
		}
		var arr = childs.children;
		if(arr.length>0){
			for(var i=0;i<arr.length;i++){
				var result =this.pushChildInHierarchy(rootId, arr[i], child);
				if(result){return ;}
			}
			
		}
		
	};
	this.setObjectId=function(objectId){
		this.objectId=objectId;
	};
	this.getObjectId=function(){
		return this.objectId;
	};
	this.getRootObjectId=function(parentChild,pid){
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[0]==pid){
				 return parentChild[i].split('@')[2];
			}
		}
	};
	this.getRoot=function(parentChild,pid){
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[0]==pid){
				 return parentChild[i].split('@')[1];
			}
		}
	};
	this.getPlusMinusStatusList=function(){
		return this.plusMinusStatusList;
	};
	this.isExitsInSuggestionArray=function(arr,found){
		for(var s=0;s<arr.length;s++){
			if(arr[s].id==found){
				return true;
			}
		}
		return false;
	};
	this.removeSuggestionContent=function(pid){
		//jsonAutoSuggest
		if(pid==null){return;}
		var arr = new Array();
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[1]==pid){
				arr.push(parentChild[i].split('@')[0]);
			}
		}
		if(arr.length>0){
			for(var i=0;i<arr.length;i++){
				var _arr = new Array();
				for(var obj in jsonAutoSuggest){
					if(jsonAutoSuggest[obj].id!=arr[i]){
						_arr.push(jsonAutoSuggest[obj]);
					 }
				}
				jsonAutoSuggest = _arr;	
				this.removeSuggestionContent(arr[i]);
			}
		}
		
	};
	this.setPlusMinusListStatus=function(parentChild,pid){
		
		var root= this.getRoot(parentChild,pid);
		var rList = this.plusMinusStatusList[root];
		var arr = this.plusMinusStatusList[pid];
		if(arr==null){
			arr = new Array();
			//arr.push(pid);
			this.plusMinusStatusList[pid]=arr;
			if(rList!=null){
				rList.push(pid);
				this.plusMinusStatusList[root]=rList;
			}
			
		}else{
			if(rList!=null){
				rList.push(pid);
				this.plusMinusStatusList[root]=rList;
			}
		}
	};
	this.updatePlusMinus=function(parentChild,pid){
		var _updatedList = new Array();
		for(var obj in this.plusMinusStatusList){
			if(obj!=pid){
				_updatedList[obj]=this.plusMinusStatusList[obj];
				
			}
		}
		this.plusMinusStatusList=_updatedList;
		this.deleteRecursiveFromParent(parentChild,pid);
	};
	this.deleteRecursiveFromParent=function(parentChild,pid){
		
		var root = this.getRoot(parentChild, pid);
		var _upArray = this.plusMinusStatusList[root];
		if(_upArray!=null){
			var _xArray = new Array();
			for(var l=0;l<_upArray.length;l++){
				if(_upArray[l]!=pid){
					_xArray.push(_upArray[l]);
				}
			}
			this.plusMinusStatusList[root]=_xArray;
		}
		
		
	};
	this.setSelectedMoveNodeSqNo =function(sqNo){
		this.selectedMoveNodeSqNo=sqNo;
	};
	this.getSelectedMoveNodeSqNo =function(){
		return this.selectedMoveNodeSqNo;
	};
	this.isNotMoveNodeSqNoIsInitailSqNo=function(moveSqno){
		if(this.initialRoot==moveSqno){
			return false;
		}else{
			return true;
		}
	};
	//return false is move to its childs else true;
	this.isNotMoveNodeMoveToItsChilds=function(toSqno,moveId){
		var len = moveId.toString().length;
		if(toSqno.toString().substring(0,len)==moveId.toString()){
			return false;
		}else{
			return true;
		}
	};
	this.setMovePasteStatus=function(status){
		this.movePasteStatus=status;
	};
	this.getMovePasteStatus=function(){
		return this.movePasteStatus;
	};
	this.createSaveNode=function(){ 
	//	this.clearForm();
		var json = {id:"",name:"",
				data:{
					Img:"",
					Otype:"",
					ObjectId:"",
					name:"",
					validity:{
						begda:"",
						endda:""
					},
					boxinfo:{
					},
					addInfo:{}
				},children:[]
		};
		
		var _data = json.data;
		debugger;
		
		//alert(document.getElementById("name").value);
		var uiMessage = new UIMessage();
		var formdata = uiMessage.getFormJsonData();
		if(formdata.name==""){
			 document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_NAME).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_ENTER_NAME;
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_NAME).style.color="Red";
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_NAME).style.visibility = "visible";
			 document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_NAME).focus();
		     return false;
		}else{
		    	document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_NAME).style.visibility = "hidden";
		}
		json.name= formdata.name;	
		json.data.Otype = formdata.oType;
		json.data.ObjectId = formdata.objectId;
		
		if(formdata.email==""){
			 document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_FIELD;
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.color="Red";
			 document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS).focus();
			 document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.visibility = "visible";
			 return false;
		}
		else{
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.visibility = "hidden";
		}
		
		var email = formdata.email.split('@');
		var valid_email=null;
		if(email.length!=2){
			
			 document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).innerHTML =this.uiConstant._MESSAGE_ERROR_INVALID_EMAL_ID;
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.color="Red";
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.visibility = "visible";
			 document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS).focus();
		     return false;
		}else{
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_EMAIL_ADDRESS).style.visibility = "hidden";
            valid_email = email[0]+'_'+email[1];
		}
		
		if(formdata.city==""){
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_CITY).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_FIELD;
		     document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_CITY).style.color="Red";
			 document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_CITY).focus();
			 document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_CITY).style.visibility = "visible";
			 return false;
		}else{
			//document.getElementById("lbl-city").innerHTML ="";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_CITY).style.visibility = "hidden";
		}
		if(formdata.address==""){
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ADDRESS).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_FIELD;
		    document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ADDRESS).style.color="Red";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ADDRESS).focus();
			document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_ADDRESS).style.visibility = "visible";
			 return false;
		}
		else{
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ADDRESS).style.visibility = "hidden";
		}
		json.data.validity = formdata.validity;
		
		var validity= formdata.validity;
		if(formdata.validity.begda==""){
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_FIELD;
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).style.color="Red";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).style.visibility = "visible";
			document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_BEGDA).focus();
			return false;
		}else{
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).style.visibility = "hidden";
		}
		if(formdata.validity.endda==""){
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ENDDA).innerHTML =this.uiConstant._MESSAGE_ERROR_MANADATORY_FIELD;
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ENDDA).style.color="Red";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ENDDA).style.visibility = "visible";
			document.getElementById(this.uiConstant._ELE_ID_FORM_OBJECT_ENDDA).focus();
			return false;
		}else{
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_ENDDA).style.visibility = "hidden";
		}
		
		var dt1 = orgFrameWork.converStringToDateFormat(validity.begda);
		var dt2 = orgFrameWork.converStringToDateFormat(validity.endda);
		if(dt1>=dt2){
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).innerHTML =this.uiConstant._MESSAGE_ERROR_BEDGA;
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).style.color="Red";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).style.visibility = "visible";
			document.getElementById(this.uiConstant._ELE_ID_WARNING_FORM_OBJECT_BEGDA).focus();
			return false;
		}
		
	
		var boxinfo ={0:valid_email,
				1:"Mobile No:",
				2:formdata.city,
				3:formdata.address,
		};
json.data.boxinfo = boxinfo;
		
		var sqnCounter=0;
		
		var orgLastSqN=0;
		for(var i=0;i<parentChild.length;i++){
			var _t = parentChild[i].split('@');
			if(_t[1]==orgFrameWork.getRootSqNo()){
				sqnCounter+=1;
				orgLastSqN=_t[0];
			}
		}
		var newSqNo=0;
		if(orgLastSqN==0){
			newSqNo = orgFrameWork.getRootSqNo().toString()+'1';
		}else{
			newSqNo=parseInt(orgLastSqN)+1;
		}
		
		json.id=newSqNo;
		debugger;
		var hier = orgFrameWork.getHierarchy(orgFrameWork.getObjectId());
		if(hier!=null){
			orgFrameWork.pushChildInHierarchy(orgFrameWork.getRootSqNo(), hier, json);
			orgFrameWork.resetHierarchy(orgFrameWork.getObjectId(), hier);
			orgFrameWork.add(json.data.ObjectId, {jsondata:json});
		}else{
			orgFrameWork.add(json.data.ObjectId, {jsondata:json});
			hier = orgFrameWork.getHierarchy(orgFrameWork.getObjectId());
			if(hier==null){
				orgFrameWork.createAndAddIfRecordNotFound(parentChild, json);
				hier = orgFrameWork.getHierarchy(orgFrameWork.getObjectId());
			}
			
		}
		
		if(orgFrameWork.getRootSqNo().toString().length>1){
			var _parent = orgFrameWork.getRootSqNo();
			var _supPerent = parseInt(_parent.toString().substring(0, _parent.toString().length-1));
			orgFrameWork.setContextMenuStatus(false);
			var actions={previous:false,next:"collapse"};
			nodeExpCollapseActionContainer[_supPerent]= actions;
			setSelectedId(_supPerent);
			
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[_supPerent]= actions;
			setSelectedId(_supPerent);
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[_parent]= actions;
			setSelectedId(_parent);
			this.setExpendCollapseRules(xOpenNode);
			//var uiMessage = new UIMessage();
			uiMessage.dragAlertMessage({text:"New node with name '"+formdata.name+"' created successfully",label:"Ok",action:"HIDE-DRAG-DROP-MESSAGE"});
			setTimeout(uiMessage.removeDragMessage,4000);
			this.applyExpendCollaseRules(_supPerent, _parent);
		}else{
			selectedParent=orgFrameWork.getRootSqNo();
			selectedNodeIdForCSS = orgFrameWork.getRootSqNo();
			getSelectedOType(orgFrameWork.getRootSqNo());
			orgFrameWork.setContextMenuStatus(false);
			var actions={previous:false,next:"collapse"};
			nodeExpCollapseActionContainer[orgFrameWork.getRootSqNo()]= actions;
			setSelectedId(orgFrameWork.getRootSqNo());
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[orgFrameWork.getRootSqNo()]= actions;
			setSelectedId(orgFrameWork.getRootSqNo());
			this.setExpendCollapseRules(xOpenNode);
			// Show message
			
		
			uiMessage.dragAlertMessage({text:"New node with name '"+formdata.name+"' created successfully",label:"Ok",action:"HIDE-DRAG-DROP-MESSAGE"});
			setTimeout(uiMessage.removeDragMessage,4000);
			this.applyExpendCollaseRules(1, selectedParent);
			
		}
		
		orgFrameWork.createAddInformation(json,orgFrameWork.getObjectId());
		uiMessage.removeJSONForm();
		
	};
	this.applyRecursiveExpendCollapseRules=function(xOpenNodes,pid,strpid){
		for(var x in xOpenNodes){
			var st = '@'+x;
			if(st!=strpid){
				var cid = st.substr(1,strpid.length-1);
				if(cid==pid){
					xOpenNodes[x]=false;
					xOpenNodes = this.applyRecursiveExpendCollapseRules(xOpenNodes,x,'@'+x);
				}
			}
		}
		return xOpenNodes;
	};
	this.applyExpendCollaseRules=function(pid,cid){
		debugger;
		var rules = this.getExpendCollapseRules();
		var found=false;
		for(var rule in rules){
			if(rule==pid){
				found=true;
			}else if(rule==cid){
				found=true;
			}else if(rule==this.initialRoot){
				found=true;
			}else{
				found=false;
			}
			if(found==false){
				var actions={previous:false,next:"service"};
				nodeExpCollapseActionContainer[rules[rule]]= actions;
				setSelectedId(rule);
			}
		}
	};
	this.getClickNodePosition=function(parentChild,rootId,sqno){
		var count=0;
		var found=0;
		var flag=false;
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[1]==rootId){
				if(parentChild[i].split('@')[0]==sqno){
					flag=true;
				}
				if(!flag){
					found+=1;
				}
				count+=1;
			}
		}	
		if(found==0){
			return 1;
		}else if(found==(count-1)){
			return 3;
		}else{
			return 2;
		}
	};
	this.updateRootRootChilds=function(rootRootObjectId,sqno,childChilds){
		var list = this.hierarchy[rootRootObjectId];
		if(list==null){return;}
		var childs = list.jsondata.children;
		for(var c in childs){
			if(childs[c].id==sqno){
				childs[c].children = childChilds;
				break;
			}
		}
		 list.jsondata.children=childs ;
		 this.hierarchy[rootRootObjectId]=list;
	};
	this.getMoveChildInfo=function(mNodeId,toNodeId){
		var toNodeObjectId = this.getRootObjectId(parentChild, toNodeId);
		if(toNodeObjectId==null){
			return null;
		}
		var list = this.hierarchy[toNodeObjectId];
		var rootId = this.getRoot(parentChild, mNodeId);
    	var mNodeRootObjectId = this.getRootObjectId(parentChild, rootId);
		var rootList = this.hierarchy[mNodeRootObjectId];
		if(list==null){
			var arr = new Array();
			var rChilds = rootList.jsondata.children;
			var moveChild ={};
			for(var c in rChilds){
				if(rChilds[c].id!=mNodeId){
					arr.push(rChilds[c]);
				}else{
					moveChild =rChilds[c];
				}
			}
			return moveChild;
		}else{
			var arr = new Array();
			var rChilds = rootList.jsondata.children;
			var moveChild ={};
			for(var c in rChilds){
				if(rChilds[c].id!=mNodeId){
					arr.push(rChilds[c]);
				}else{
					moveChild =rChilds[c];
				}
			}
			return moveChild;
		}
	};
	this.doMoveNodeAction=function(mNodeId,toNodeId){
		var toNodeObjectId = this.getRootObjectId(parentChild, toNodeId);
		if(toNodeObjectId==null){
			return;
		}
		var list = this.hierarchy[toNodeObjectId];
		var rootId = this.getRoot(parentChild, mNodeId);
		var toRootId = this.getRoot(parentChild, toNodeId);
		var mNodeRootObjectId = this.getRootObjectId(parentChild, rootId);
		var rootList = this.hierarchy[mNodeRootObjectId];
		var newRootChild={};
		if(list==null){
			var arr = new Array();
			var rChilds = rootList.jsondata.children;
			var moveChild ={};
			for(var c in rChilds){
				if(rChilds[c].id!=mNodeId){
					arr.push(rChilds[c]);
				}else{
					moveChild =rChilds[c];
				}
			}
			
			rootList.jsondata.children = arr;
			var rChilds = rootList.jsondata.children;
			if(toRootId==rootId){
				for(c in rChilds){
					if(rChilds[c].id==toNodeId){
						var len = rChilds[c].children.length;
						if(len==0){
							len=1;
						}
						//
						var lastChildSqno=0;
						var childrens = rChilds[c].children;
						for(var i=0;i<childrens.length;i++){
							lastChildSqno = childrens[i].id;
						}
						if(lastChildSqno==0){
							lastChildSqno= toNodeId.toString()+'1';
						}else{
							lastChildSqno+=1;
						}
						//
						moveChild=orgFrameWork.getMoveChildInformation();
						moveChild.id = lastChildSqno.toString();
						rChilds[c].children.push(moveChild);
						newRootChild =rChilds[c];
						break;
					}
					
				}
				
				rootList.jsondata.children= rChilds;
				this.hierarchy[mNodeRootObjectId]=rootList;
				this.hierarchy[toNodeObjectId]={jsondata:newRootChild};
			}else{
				var toNodeRootObjectId = this.getRootObjectId(parentChild, toRootId);
				
				var list = this.hierarchy[toNodeRootObjectId];{
					var rChilds = list.jsondata.children;
					for(var c in rChilds){
						if(rChilds[c].id==toNodeId){
							rChilds[c].children.push(moveChild);
							newRootChild =rChilds[c];
						}
					}
				}
				list.jsondata.children=rChilds;
				this.hierarchy[toNodeObjectId]={jsondata:newRootChild};
			}
			
			
		}else{
			var arr = new Array();
			var rChilds = rootList.jsondata.children;
			var moveRootRootSqnId = this.getObjectIdRootSqNo(parentChild, mNodeRootObjectId);
			var mRootRootObjectId = this.getRootObjectId(parentChild, moveRootRootSqnId);
			var moveChild ={};
			for(var c in rChilds){
				if(rChilds[c].id!=mNodeId){
					arr.push(rChilds[c]);
				}else{
					moveChild =rChilds[c];
				}
			}
			
			rootList.jsondata.children = arr;
			this.hierarchy[mNodeRootObjectId]=rootList;
			this.updateRootRootChilds(mRootRootObjectId, rootId, arr);
			//var len = list.jsondata.children.length;
			var lastChildSqno=0;
			var childrens = list.jsondata.children;
			for(var i=0;i<childrens.length;i++){
				lastChildSqno = childrens[i].id;
			}
			if(lastChildSqno==0){
				lastChildSqno= toNodeId.toString()+'1';
			}else{
				lastChildSqno = parseInt(lastChildSqno)+1;
			}
			this.removeFromSuggessionParentChildList(moveChild.id);
			moveChild=orgFrameWork.getMoveChildInformation();
			moveChild.id=lastChildSqno.toString();
			list.jsondata.children.push(moveChild);
			if(moveChild.children.length>0){
				moveChild.children = this.changeRecursiveChildSqnNo(moveChild.children , moveChild.id);
				this.hierarchy[moveChild.data.ObjectId]={jsondata:moveChild};
			}
			this.hierarchy[toNodeObjectId]=list;
			if(rootList.jsondata.children.length==0){
				this.hierarchy[mNodeRootObjectId]=null;
			}
			
		}
		var uiMessage = new UIMessage();
		orgFrameWork.additionalInfo[moveChild.data.ObjectId].jsondata.data[0].addinfo.data[0].groups[0].data[0].validity=moveChild.data.validity;
		orgFrameWork.additionalInfo[moveChild.data.ObjectId].jsondata.data[0].addinfo.data[0].groups[2].data[0].uiElements[0].currentValues[0]=toNodeObjectId;
		orgFrameWork.setContextMenuStatus(false);
		
		var localFromParentSqn = orgFrameWork.getRoot(parentChild, rootId);
		var localToParentSqn = orgFrameWork.getRoot(parentChild, toNodeId);
		if(localFromParentSqn==localToParentSqn){
			this.collapseServiceForNode(localToParentSqn);
			this.expendServiceForNode(localFromParentSqn)	;
			this.expendServiceForNode(rootId);
			this.expendServiceForNode(toNodeId);
			this.setExpendCollapseRules(xOpenNode);
			this.applyExpendCollaseRules(rootId, toNodeId);
		}else{
			// when node move top level to low level in hierachy structure
			if(localFromParentSqn==orgFrameWork.initialRoot&&toNodeId!=orgFrameWork.initialRoot){
				this.moveNodeUpLevelToLowLevelInHierachy(localFromParentSqn, rootId, toNodeId);
				//this.setExpendCollapseRules(xOpenNode);
				//this.applyExpendCollaseRules(rootId, toNodeId);
			}else if(localToParentSqn==1){
				this.moveNodeLowLevelToUpLevelInHierachy(localToParentSqn, rootId, toNodeId);
				//this.setExpendCollapseRules(xOpenNode);
				//this.applyExpendCollaseRules(rootId, toNodeId);
			}else{
				this.moveNodeInHierachy(localToParentSqn, localFromParentSqn, toNodeId, rootId);
				//this.setExpendCollapseRules(xOpenNode);
				//this.applyExpendCollaseRules(rootId, toNodeId);
			}
			
		}
		   
		uiMessage.removeDragMessage();
		
	};
	this.moveNodeInHierachy=function(rootToSqn,rootFromSqn,toSqno,fromSqno){
		this.collapseServiceForNode(rootToSqn);
		this.expendServiceForNode(rootToSqn);
		this.expendServiceForNode(toSqno);
		this.collapseServiceForNode(rootFromSqn);
		this.expendServiceForNode(rootFromSqn);
		this.expendServiceForNode(fromSqno);
	};
	this.moveNodeLowLevelToUpLevelInHierachy=function(rootSqn,fromSqn,toSqno){
		this.collapseServiceForNode(rootSqn);
		this.expendServiceForNode(rootSqn);
		this.expendServiceForNode(toSqno);
		var arr = new Array();
		var sqn =orgFrameWork.getRoot(parentChild, fromSqn);
		arr.push(fromSqn);
		while(sqn>orgFrameWork.initialRoot){

			arr.push(sqn);
			sqn = orgFrameWork.getRoot(parentChild, sqn);
		}
		if(arr.length>0){
			for(var i=arr.length-1;i>=0;i--){
				this.expendServiceForNode(arr[i]);
			}
		}
	};
	this.moveNodeUpLevelToLowLevelInHierachy=function(rootSqn,fromSqn,toSqno){
		this.collapseServiceForNode(rootSqn);
		this.expendServiceForNode(rootSqn);
		this.expendServiceForNode(fromSqn);
		var arr = new Array();
		var sqn =orgFrameWork.getRoot(parentChild, toSqno);
		arr.push(toSqno);
		while(sqn>orgFrameWork.initialRoot){

			arr.push(sqn);
			sqn = orgFrameWork.getRoot(parentChild, sqn);
		}
		if(arr.length>0){
			for(var i=arr.length-1;i>=0;i--){
				this.expendServiceForNode(arr[i]);
			}
		}
		
	};
	this.assignApprovedInfoToMoveNode=function(moveChild){
		var uiMessage = new UIMessage();
		var formdata = uiMessage.getFormJsonData();
		moveChild.data.ObjectId = formdata.objectId;
		moveChild.name=formdata.name;
		moveChild.data.validity=formdata.validity;
		var boxinfo ={0:"Email Id:"+formdata.email,
				1:"Mobile No:",
				2:"City:"+formdata.city,
				3:"Address:",//+document.getElementById("address").value,
		};

		moveChild.data.boxinfo=boxinfo;
		this.setMoveChildInfo(moveChild);
	};
	this.resetFormElement=function(){
		for(var info in this.formJson){
			
			switch(this.formJson[info].id){
			case this.uiConstant._ELE_ID_FORM_OBJECT_ID:
				this.formJson[info].value="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_IS_CHIEF:
				this.formJson[info].value="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_TYPE:
				this.formJson[info].value="";
				this.formJson[info].readonly="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_NAME:
				this.formJson[info].value="";
				this.formJson[info].readonly="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS:
				this.formJson[info].value="";
				this.formJson[info].readonly="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_CITY:
				this.formJson[info].value="";
				this.formJson[info].readonly="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_ADDRESS:
				this.formJson[info].value="";
				this.formJson[info].readonly="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_BEGDA:
				this.formJson[info].value="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_ENDDA:
				this.formJson[info].value="";
				break;
			}
		}
	};
	this.approveObjectDataBeforeMoveConfirm=function(moveChild){
		debugger;
		for(var info in this.formJson){
			switch(this.formJson[info].id){
			case this.uiConstant._ELE_ID_FORM_OBJECT_ID:
				this.formJson[info].value=moveChild.data.ObjectId;
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_IS_CHIEF:
				this.formJson[info].value="";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_TYPE:
				this.formJson[info].value=moveChild.data.Otype;
				this.formJson[info].readonly="disabled";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_NAME:
				this.formJson[info].value=moveChild.name;
				this.formJson[info].readonly="readonly";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS:
				this.formJson[info].value=moveChild.data.boxinfo[0];
				this.formJson[info].readonly="readonly";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_CITY:
				this.formJson[info].value=moveChild.data.boxinfo[2];
				this.formJson[info].readonly="readonly";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_ADDRESS:
				this.formJson[info].value=moveChild.data.boxinfo[3];
				this.formJson[info].readonly="readonly";
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_BEGDA:
				this.formJson[info].value=moveChild.data.validity.begda;
				break;
			case this.uiConstant._ELE_ID_FORM_OBJECT_ENDDA:
				this.formJson[info].value=moveChild.data.validity.endda;
				break;
			}
		}
		this.setIsMoveApprove(false);
		var uiMessage = new UIMessage();
		uiMessage.JSONForm(this.formJson,{action:"move-approve",label:"Done"});
		
	};
	this.collapseServiceForNode=function(sqno){
		var actions={previous:false,next:"collapse"};
		nodeExpCollapseActionContainer[sqno]= actions;
		setSelectedId(sqno);
	};
	this.expendServiceForNode=function(sqno){
		var actions={previous:false,next:"service"};
		nodeExpCollapseActionContainer[sqno]= actions;
		setSelectedId(sqno);
	};
	this.removeFromSuggessionParentChildList=function(sqno){
		var _parr = new Array();
		var _suggestionArr = new Array();
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[0]!=sqno){
				_parr.push(parentChild[i]);
			}
		}
		parentChild = _parr;
		for(var i=0;i<jsonAutoSuggest.length;i++){
			if(jsonAutoSuggest[i].id!=sqno){
				_suggestionArr.push(jsonAutoSuggest[i]);
			}
		}
		jsonAutoSuggest=_suggestionArr;
		_parr = null;
		_suggestionArr=null;
	};
	this.changeRecursiveChildSqnNo=function(childs,psqn){
		if(childs==null){return;}
		var counter=1;
		for(var c=0;c<childs.length;c++){
			var newSqn = psqn+counter;
			this.removeFromSuggessionParentChildList(childs[c].id);
			childs[c].id= newSqn;
			var _childs = childs[c].children;
			counter+=1;
			if(_childs.length>0){
				_childs = this.changeRecursiveChildSqnNo(_childs, newSqn);
				childs[c].children = _childs;
			}
		}
		return childs;
	};
	this.getObjectIdRootSqNo=function(parentChild,objectId){
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[2]==objectId){
				return parentChild[i].split('@')[1];
			}
		}
	};
	this.createAddInformation=function(heir,rootObjectId){
		var addInfoJson = {
				  "jsondata": {
					    "id": "23",
					    "data": [
					      {
					        "addinfo": {
					          "id": heir.id,  //chage herer
					          "data": [
					            {
					              "panelId": "addinfo",
					              "orinetation": "vertical",
					              "groups": []
					            }
					          ]
					        },
					        "objectinfo": {
					          "id": "2",
					          "data": []
					        }
					      }
					    ]
					  },
					  "ui": {
					    "messages": {},
					    "status": "true",
					    "headerString": "Hierarchy data service error!"
					  },
					  "lastsqn": null
					};
		var group0={
				  "groupName": "VALIDITY",
				  "groupDesc": " VALIDITY",
				  "uiEleMetaData": [
				    {
				      "fieldName": "BEGDDA",
				      "fieldType": "label",
				      "fieldLabel": "START DATE",
				      "readOnly": "false",
				      "mandatory": " false",
				      "defaultValues": [
				        "Executive"
				      ],
				      "uiElementId": "0"
				    },
				    {
				      "fieldName": "ENDDA",
				      "fieldType": "input",
				      "fieldLabel": "END DATE",
				      "readOnly": "false",
				      "mandatory": " false",
				      "defaultValues": [
				        ""
				      ],
				      "uiElementId": "1"
				    }
				  ],
				  "data": [
				    {
				      "rowId": "0",
				      "uiElements": [
				        {
				          "uiElementId": "0",
				          "currentValues": [
				            heir.data.validity.begda
				          ]
				        },
				        {
				          "uiElementId": "1",
				          "currentValues": [
                             heir.data.validity.endda
				          ]
				        }
				      ],
				      "validity": {
				        "validFrom": "10.04.2012",
				        "validTo": "10.04.2020"
				      }
				    }
				  ]
				};
		var group1 =  {
                "groupName": "business",
                "groupDesc": " BUSINESS INFORMATION",
                "uiEleMetaData": [
                  {
                    "fieldName": "OBJLONGNAME",
                    "fieldType": "label",
                    "fieldLabel": "OBJECT NAME (LONG)",
                    "readOnly": "false",
                    "mandatory": " false",
                    "defaultValues": [
                      heir.name
                    ],
                    "uiElementId": "0"
                  },
                  {
                    "fieldName": "OFFICEADDRESS",
                    "fieldType": "input",
                    "fieldLabel": "STREET ADDRESS (PD)",
                    "readOnly": "false",
                    "mandatory": " false",
                    "defaultValues": [
                      ""
                    ],
                    "uiElementId": "1"
                  },
                  {
                    "fieldName": "PERSAREAPD",
                    "fieldType": "input",
                    "fieldLabel": "PERSONNEL AREA (PD)",
                    "readOnly": "false",
                    "mandatory": " false",
                    "defaultValues": [
                      "",
                      "1000"
                    ],
                    "uiElementId": "2"
                  },
                  {
                    "fieldName": "PERSUBAREAPD",
                    "fieldType": "label",
                    "fieldLabel": "PERSONNEL SUBAREA (PD)",
                    "readOnly": "false",
                    "mandatory": " false",
                    "defaultValues": [
                      "",
                      "0100"
                    ],
                    "uiElementId": "3"
                  }
                ],
                "data": [
                  {
                    "rowId": "0",
                    "uiElements": [
                      {
                        "uiElementId": "0",
                        "currentValues": [
                          heir.name   //change here
                        ]
                      },
                      {
                        "uiElementId": "1",
                        "currentValues": [
                          ""
                        ]
                      },
                      {
                        "uiElementId": "2",
                        "currentValues": [
                          "1011"
                        ]
                      },
                      {
                        "uiElementId": "3",
                        "currentValues": [
                          "0100"
                        ]
                      }
                    ],
                    "validity": {
                      "validFrom": heir.data.validity.bedda,     //change here;
                      "validTo": heir.data.validity.endda
                    }
                  }
                ]
              };
	 var group2 =  {
             "groupName": "orgunit",
             "groupDesc": " PERSONAL DETAILS",
             "uiEleMetaData": [
               {
                 "fieldName": "BELONGSTO",
                 "fieldType": "",
                 "fieldLabel": "BELONGS TO ORG UNIT",
                 "readOnly": "false",
                 "mandatory": " false",
                 "defaultValues": [
                   "1000"
                 ],
                 "uiElementId": "0"
               },
               {
                 "fieldName": "OBJLONGNAME",
                 "fieldType": "label",
                 "fieldLabel": "OBJECT NAME (LONG)",
                 "readOnly": "false",
                 "mandatory": " false",
                 "defaultValues": [
                   heir.name                    //change here
                 ],
                 "uiElementId": "1"
               }
             ],
             "data": [
               {
                 "rowId": "0",
                 "uiElements": [
                   {
                     "uiElementId": "0",
                     "currentValues": [
rootObjectId             // chage here
                     ]
                   },
                   {
                     "uiElementId": "1",
                     "currentValues": [
                       heir.name                //chage here
                     ]
                   }
                 ],
                 "validity": {
                   "validFrom": "10.04.2012",   //chage here
                   "validTo": "10.04.2020"
                 }
               }
             ]
           };
	 addInfoJson.jsondata.data[0].addinfo.data[0].groups.push(group0);
	 addInfoJson.jsondata.data[0].addinfo.data[0].groups.push(group1);
	 addInfoJson.jsondata.data[0].addinfo.data[0].groups.push(group2);
	 this.additionalInfo[heir.data.ObjectId] = addInfoJson;
	};
	
	
};