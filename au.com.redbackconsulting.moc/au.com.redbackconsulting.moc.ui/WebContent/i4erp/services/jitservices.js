var hierarchyDepth=3;
var rdbRootSqnNo =2;
var orgFrameWork = new OrgFrameWork({});
orgFrameWork.init();
function getHierarchyDataFromServlet(){
	//var jsonObject={"jsondata":{"id":"2","name":"DODGI 12","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000051","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"21","name":"HO 1","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000070","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"211","name":"Executive","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000053","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"212","name":"Contracts","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000069","validity":{"begda":"1995-07-27","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"22","name":"Western","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000151","validity":{"begda":"1995-08-18","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"221","name":"Reg Manager","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000274","validity":{"begda":"2012-03-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"222","name":"Admin","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000275","validity":{"begda":"2012-03-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"223","name":"Nat Resource","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000237","validity":{"begda":"2012-03-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"23","name":"Eastern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000052","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"231","name":"CFO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000109","validity":{"begda":"1995-07-27","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"232","name":"PA","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000112","validity":{"begda":"1995-07-27","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"233","name":"ExecutiveOff","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000179","validity":{"begda":"1995-08-31","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"234","name":"Policy","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000055","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"24","name":"Southern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000054","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"241","name":"CIO","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000110","validity":{"begda":"1995-07-27","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"242","name":"PA","data":{"Img":"/mocjit/images/s.png","Otype":"S","ObjectId":"50000113","validity":{"begda":"1995-07-27","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"243","name":"SA","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000063","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"244","name":"Tasmania","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000064","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]},{"id":"25","name":"Northern","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000058","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[{"id":"251","name":"Integration","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000059","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]},{"id":"252","name":"L&D","data":{"Img":"/mocjit/images/o.png","Otype":"O","ObjectId":"50000060","validity":{"begda":"2010-01-01","endda":"9999-12-31"},"boxinfo":{"0":"Email Id:","1":"Mobile No","2":"City:","3":"Address:"},"addInfo":{}},"children":[]}]}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null}
//;
	var jsonObject= orgFrameWork.getHierarchy1(50000051);
	//var jsonObject={jsondata:data};
	parentObjectId = jsonObject.jsondata.id;
	orgFrameWork.setInitialRoot(jsonObject.jsondata.id);
		maxRows = getMaxRowsForBoxData(jsonObject.jsondata.data);
		last_SqnNo = jsonObject.lastsqn;
		convert_JSON_TO_ARRAY(jsonObject.jsondata,'1',1);
		createLevelParentChildsList(parentChild,jsonObject.jsondata.id);
	creatingUIElementFromInitialHierarchyCollectionData();
	createBoxTree();
	initAutoComplete();
	attachDrag();
	getChildListStatus.push(jsonObject.jsondata.id);
	var actions={previous:"service",next:"expend"};
	
	nodeExpCollapseActionContainer[jsonObject.jsondata.id]= actions;
	setInitailTreesRootWithChildStatus(jsonObject.jsondata.id);
	getSelectedOType(jsonObject.jsondata.id);
		getAddtionalAndObjectInfoOfSelectedNodeFromServlet(jsonObject.jsondata.id);
	//objectCenter("1");
	//	getAddtionalAndObjectInfoOfSelectedNodeFromServlet(jsonObject.jsondata.id);
	
	
//	$.ajax({
//		type:'POST',
//        url: serverUrl,
//		data:"action=hierdata&scenario="+scenario+"&filterdate="+filterdate,
//		dataType: "json" ,
//		async:false,
//  		success: function(jsonObject){
//  			var _status =eval("(" + jsonObject.ui.status + ")");
//  			if(_status){
//  				parentObjectId = jsonObject.jsondata.id;
//  				maxRows = getMaxRowsForBoxData(jsonObject.jsondata.data);
//  				last_SqnNo = jsonObject.lastsqn;
//  				convert_JSON_TO_ARRAY(jsonObject.jsondata,'1',1);
//  				createLevelParentChildsList(parentChild,jsonObject.jsondata.id);
//				creatingUIElementFromInitialHierarchyCollectionData();
//				createBoxTree();
//				initAutoComplete();
//				attachDrag();
//				getChildListStatus.push(jsonObject.jsondata.id);
//				nodeExpCollapseActionContainer[jsonObject.jsondata.id]= false;
//				var actions ={expendStatus:false,childStatus:false,toggleStatus:false};
//				actions.expendStatus = false;
//				actions.childStatus = false;
//				actions.toggleStatus = true;
//				nodePlusMinusStatus[jsonObject.jsondata.id] = actions;
//				setInitailTreesRootWithChildStatus(jsonObject.jsondata.id);
//				getSelectedOType(jsonObject.jsondata.id);
//  				getAddtionalAndObjectInfoOfSelectedNodeFromServlet(jsonObject.jsondata.id);
//  			}else{
//  				var cnst = new RdbConstant();
//				rdbpopup = new RdbPOPUPModal();
//  				rdbpopup.getJSONErrorMessagePOPUP (jsonObject.ui.messages,Object,jsonObject.ui.headerString,cnst.POPUP_FILTER_HIER_ACTION,"2");
//  			}				
//		},
//		error: function(XMLHttpRequest, textStatus,errorThrown){
//			var cnst = new RdbConstant();
//			rdbpopup = new RdbPOPUPModal();
//			rdbpopup.getJSONErrorMessagePOPUP(null,XMLHttpRequest,'Hierarchy Web-Service',cnst.POPUP_FILTER_HIER_ACTION,"");
//		}
// 	} ); 
}

/*  ===============================================================================================================================
	= End....																													  =
	= Initial Hierarchy Web Service Call With Defualt Parameter                                                                   =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Child Hierarchy Web Service Call With Specified Parameter Parametere List Like Node Type,NodeId,Squence No etc          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getChildHierarchyDataFromServlet(nodeId,nodeType,selectedSqn){
	//orgFrameWork.setObjectCenter(false);
	removingAllChildBeforAddingNewChilds(selectedSqn);
	var jsonObject= orgFrameWork.getHierarchy1(nodeId);
  if(jsonObject==null){return;}
	
	maxRows = getMaxRowsForBoxData(jsonObject.jsondata.data);
		last_SqnNo = jsonObject.lastsqn;
		 convert_JSON_TO_ARRAY_POSTPROCESS(jsonObject.jsondata,'1',1,orgFrameWork.getSelectedNodeLevel(selectedSqn));
		 createLevelParentChildsList(post_ParentChild,selectedSqn);
		 
	 creatingUIElementFromGetChildHierarchyCollectionData();
	 initAutoComplete();
	 attachDrag();
	 
	 var actions={previous:"service",next:"expend"};
		nodeExpCollapseActionContainer[jsonObject.jsondata.id]= actions;
	 
	
	// updatedParentStatus(getSelectedChildParent(selectedSqn),selectedSqn,getParentChildStatus(getSelectedChildParent(selectedSqn)));
	 
	// nodeExpCollapseActionContainer[selectedSqn]=false;
//	$.ajax({
//		type:'POST',
//        url: serverUrl,
//		data:"action=hierdata&hiernodeid="+nodeId+"&hiernodetype="+nodeType+"&scenario="+scenario+"&selectedsqn="+selectedSqn+"&filterdate="+filterdate,
//		dataType: "json" ,
//		async:false,
//  		success: function(jsonObject){
//  			var _status =eval("(" + jsonObject.ui.status + ")");
//  			$('div.getchildloading').remove();
//  			if(_status){
//  				maxRows = getMaxRowsForBoxData(jsonObject.jsondata.data);
//  				last_SqnNo = jsonObject.lastsqn;
//  				 convert_JSON_TO_ARRAY_POSTPROCESS(jsonObject.jsondata,'1',1);
//  				 createLevelParentChildsList(post_ParentChild,selectedSqn);
//  				 removingAllChildBeforAddingNewChilds(selectedSqn);
//				 creatingUIElementFromGetChildHierarchyCollectionData();
//				 initAutoComplete();
//				 attachDrag();
//				 nodeExpCollapseActionContainer[selectedSqn]=true;
//				 var actions ={expendStatus:false,childStatus:false,toggleStatus:false};
//				 actions.childStatus = true;
//				 actions.toggleStatus = true;
//				 nodePlusMinusStatus[selectedSqn] = actions;
//				 updatedParentStatus(getSelectedChildParent(selectedSqn),selectedSqn,getParentChildStatus(getSelectedChildParent(selectedSqn)));
//				 restUpdate(selectedSqn);
//				 nodeExpCollapseActionContainer[selectedSqn]=false;
//				// getAddtionalAndObjectInfoOfSelectedNodeFromServlet(jsonObject.jsondata.id);
//  			}else{
//  				var cnst = new RdbConstant();
//				rdbpopup = new RdbPOPUPModal();
//  				rdbpopup.getJSONErrorMessagePOPUP (jsonObject.ui.messages,Object,jsonObject.ui.headerString,cnst.POPUP_FILTER_HIER_ACTION,"2");
//  			}				
//		},
//		error: function(XMLHttpRequest, textStatus,errorThrown){
//			$('div.getchildloading').remove();
//			var cnst = new RdbConstant();
//			rdbpopup = new RdbPOPUPModal();
//			rdbpopup.getJSONErrorMessagePOPUP(null,XMLHttpRequest,'Hierarchy Web-Service',cnst.POPUP_FILTER_HIER_ACTION,"");
//		}
// 	} ); 
}

/*
    ===============================================================================================================================
    = End....													                                                                  =
    = Get Child Hierarchy Web Service Call With Defualt Parameter                                                                 =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Addtional Information For Selected Node /Searched Node Web Service Call With Defualt Parameter                          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getAddtionalAndObjectInfoOfSelectedNodeFromServlet(sqNO){
	if(lastSqnNo==sqNO){
		return ;
	}
	
	var jsonObject = orgFrameWork.getAdditionalInfo(orgFrameWork.getRootObjectId(parentChild, sqNO));
	if(jsonObject==null){
		return ;
	}
	//var jsonObject ={"jsondata":{"id":"2","data":[{"addinfo":{"id":"2","data":[{"panelId":"addinfo","orinetation":"vertical","actions":[{"actionId":"delete","actionLabel":"Delete","enableStatus":"true"},{"actionId":"create","actionLabel":"Create","enableStatus":"true"},{"actionId":"edit","actionLabel":"Edit","enableStatus":"true"},{"actionId":"finalsave","actionLabel":"FinalSave","enableStatus":"true"},{"actionId":"finalcancel","actionLabel":"FinalCancel","enableStatus":"true"}],"groups":[{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department"],"uiElementId":"0"},{"fieldName":"OFFICEADDRESS","fieldType":"input","fieldLabel":"STREET ADDRESS (PD)","readOnly":"false","mandatory":" false","defaultValues":[""],"uiElementId":"1"},{"fieldName":"PERSAREAPD","fieldType":"input","fieldLabel":"PERSONNEL AREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","1000"],"uiElementId":"2"},{"fieldName":"PERSUBAREAPD","fieldType":"label","fieldLabel":"PERSONNEL SUBAREA (PD)","readOnly":"false","mandatory":" false","defaultValues":["","0100"],"uiElementId":"3"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Department"]},{"uiElementId":"1","currentValues":[""]},{"uiElementId":"2","currentValues":["1000"]},{"uiElementId":"3","currentValues":["0100"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2012"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[{"fieldName":"BELONGSTO","fieldType":"","fieldLabel":"BELONGS TO ORG UNIT","readOnly":"false","mandatory":" false","defaultValues":["00013001001000","00000020021000","50000070","50000151","50000052","50000054","50000058","1000","1000","10000100","1000","1000","1000","50000070","50000151","50000052","50000054","50000058","50000070","50000151","50000052","50000054","50000058","50000070","50000151","50000052","50000054","50000058","50000070","50000151","50000052","50000054","50000058","50000070","50000151","50000052","50000054","50000058"],"uiElementId":"0"},{"fieldName":"OBJLONGNAME","fieldType":"label","fieldLabel":"OBJECT NAME (LONG)","readOnly":"false","mandatory":" false","defaultValues":["Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department","Dep't of Digital Geographic Information","Dep't of Digital Geographic Information","Department","Department"],"uiElementId":"1"}],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":["Department"]}],"validity":{"validFrom":"10.04.2012","validTo":"10.04.2012"}}]}]}]},"objectinfo":{"id":"2","data":[{"panelId":"objectinfo","orinetation":"vertical","actions":[{"actionId":"delete","actionLabel":"Delete","enableStatus":"true"},{"actionId":"create","actionLabel":"Create","enableStatus":"true"},{"actionId":"edit","actionLabel":"Edit","enableStatus":"true"},{"actionId":"finalsave","actionLabel":"FinalSave","enableStatus":"true"},{"actionId":"finalcancel","actionLabel":"FinalCancel","enableStatus":"true"}],"groups":[{"groupName":"business","groupDesc":" BUSINESS INFORMATION","uiEleMetaData":[],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"1","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"2","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"3","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"4","currentValues":[""]},{"uiElementId":"5","currentValues":[""]},{"uiElementId":"6","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.2010"}},{"rowId":"1","uiElements":[{"uiElementId":"0","currentValues":["Department"]},{"uiElementId":"1","currentValues":["Department"]},{"uiElementId":"2","currentValues":["Department"]},{"uiElementId":"3","currentValues":["Department"]},{"uiElementId":"4","currentValues":[""]},{"uiElementId":"5","currentValues":["1000"]},{"uiElementId":"6","currentValues":["0100"]}],"validity":{"validFrom":"01.01.2011","validTo":"31.12.9999"}}]},{"groupName":"orgunit","groupDesc":" ORG UNIT DETAILS","uiEleMetaData":[],"data":[{"rowId":"0","uiElements":[{"uiElementId":"0","currentValues":["00013001001000"]},{"uiElementId":"1","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"2","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"3","currentValues":["Dep't of Digital Geographic Information"]},{"uiElementId":"4","currentValues":["Dep't of Digital Geographic Information"]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.2011"}},{"rowId":"1","uiElements":[{"uiElementId":"0","currentValues":["00000020021000"]},{"uiElementId":"1","currentValues":["Department"]},{"uiElementId":"2","currentValues":["Department"]},{"uiElementId":"3","currentValues":["Department"]},{"uiElementId":"4","currentValues":["Department"]}],"validity":{"validFrom":"01.01.2012","validTo":"31.12.9999"}},{"rowId":"2","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"3","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"4","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"5","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"6","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"7","uiElements":[{"uiElementId":"0","currentValues":["1000"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.2011"}},{"rowId":"8","uiElements":[{"uiElementId":"0","currentValues":["1000"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.2011"}},{"rowId":"9","uiElements":[{"uiElementId":"0","currentValues":["10000100"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2012","validTo":"31.12.9999"}},{"rowId":"10","uiElements":[{"uiElementId":"0","currentValues":["1000"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2012","validTo":"31.12.9999"}},{"rowId":"11","uiElements":[{"uiElementId":"0","currentValues":["1000"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2012","validTo":"31.12.9999"}},{"rowId":"12","uiElements":[{"uiElementId":"0","currentValues":["1000"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2012","validTo":"31.12.9999"}},{"rowId":"13","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"14","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"15","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"16","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"17","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"18","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"19","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"20","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"21","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"22","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"23","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"24","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"25","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"26","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"27","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"28","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"29","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"30","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"31","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"32","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"33","uiElements":[{"uiElementId":"0","currentValues":["50000070"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"34","uiElements":[{"uiElementId":"0","currentValues":["50000151"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"35","uiElements":[{"uiElementId":"0","currentValues":["50000052"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"36","uiElements":[{"uiElementId":"0","currentValues":["50000054"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}},{"rowId":"37","uiElements":[{"uiElementId":"0","currentValues":["50000058"]},{"uiElementId":"1","currentValues":[""]}],"validity":{"validFrom":"01.01.2010","validTo":"31.12.9999"}}]}]}]}}]},"ui":{"messages":{},"status":"true","headerString":"Hierarchy data service error!"},"lastsqn":null};
	var html="<div class='p_wrap'><div class='texture'><div class='user-data'><div class='userprofile'><div class='user_fp'><div class='fb-img'><img src='images/userpic.jpg' width='148' height='149' alt='userpic'></div></div><div class='user_fd'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td>BEGINDATE:</td><td>01.01.2010</td></tr><tr><td>ENDDATE:</td><td>11.05.2011</td></tr><tr><td>FIRSTNAME:</td><td>SGUPTA</td></tr><tr><td>0001 RDBLANGU:</td><td>EN</td></tr><tr><td>ID:</td><td>50000052</td></tr><tr><td>NICK NAME:</td><td>Western Reg</td></tr><tr><td>DETAIL:</td><td>Western Region</td></tr><tr><td>ObjectType:</td><td>O</td></tr></table></div><div class='user_cl'><a href='javascript:void(0)'onclick = 'closelightbox()'>Close</a></div></div></div></div></div>";
	var additionaldata =jsonObject.jsondata.data[0];
	convertIntoAdditionInformationCollection(jsonObject.jsondata.data[0]);
	for(obj in additionaldata){
		if(obj == 'addinfo'){
			var groups = additionaldata[obj].data[0].groups;
			var addintoTable = populateGroupsData(groups);
			document.getElementById('typeO').innerHTML="";
			document.getElementById('typeO').innerHTML=addintoTable;
			document.getElementById('typeO').style.display='block';
		}
	}
//	
//	lastSqnNo = sqNO ;
//	document.getElementById('typeO').innerHTML="";
//	$.ajax({
//		type:'POST',
//        url: serverUrl,
//		data:"objid="+sqNO+"&action=addinfo&scenario="+scenario,
//		dataType: "json" ,
//  		success: function(jsonObject){
//  			var _status =jsonObject.ui.status;
//  			if(_status =="true"){
//  				if(jsonObject.jsondata.data[0]!=null){
//					var html="<div class='p_wrap'><div class='texture'><div class='user-data'><div class='userprofile'><div class='user_fp'><div class='fb-img'><img src='images/userpic.jpg' width='148' height='149' alt='userpic'></div></div><div class='user_fd'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td>BEGINDATE:</td><td>01.01.2010</td></tr><tr><td>ENDDATE:</td><td>11.05.2011</td></tr><tr><td>FIRSTNAME:</td><td>SGUPTA</td></tr><tr><td>0001 RDBLANGU:</td><td>EN</td></tr><tr><td>ID:</td><td>50000052</td></tr><tr><td>NICK NAME:</td><td>Western Reg</td></tr><tr><td>DETAIL:</td><td>Western Region</td></tr><tr><td>ObjectType:</td><td>O</td></tr></table></div><div class='user_cl'><a href='javascript:void(0)'onclick = 'closelightbox()'>Close</a></div></div></div></div></div>";
//					var additionaldata =jsonObject.jsondata.data[0];
//					convertIntoAdditionInformationCollection(jsonObject.jsondata.data[0]);
//					for(obj in additionaldata){
//						if(obj == 'addinfo'){
//							var groups = additionaldata[obj].data[0].groups;
//							var addintoTable = populateGroupsData(groups);
//							document.getElementById('typeO').innerHTML="";
//							document.getElementById('typeO').innerHTML=addintoTable;
//							document.getElementById('typeO').style.display='block';
//						}
//					}
//				}
//  			}else{
//  				var cnst = new RdbConstant();
//				rdbpopup = new RdbPOPUPModal();
//  				rdbpopup.getJSONErrorMessagePOPUP (jsonObject.ui.messages,Object,jsonObject.ui.headerString,cnst.POPUP_ADDINFO_ACTION,sqNO);
//  			}				
//		 },
//		 error: function(XMLHttpRequest, textStatus,errorThrown){
//		 	var cnst = new RdbConstant();
//			rdbpopup = new RdbPOPUPModal();
//  			rdbpopup.getJSONErrorMessagePOPUP(null,XMLHttpRequest,'Additional Info Web  Service',cnst.POPUP_ADDINFO_ACTION,sqNO);
//		}
// 	} );	
}
/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Get Addtional Information For Selected Node /Searched Node Web Service Call With Defualt Parameter                          =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Location Map From Web Service  Call With Defualt Parameter                 		   								      =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getGoogleMaps(nodeId){
 	$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=map&id="+nodeId,
		dataType: "json" ,
  		success: function(mapObject){
  			var cnst = new RdbConstant();
  			rdbpopup = new RdbPOPUPModal();
  			var _status =eval("(" + mapObject.ui.status + ")");
  			if(_status){
  				rdbpopup.getJSONErrorMessagePOPUP(mapObject.mapUrl,Object,'Google Map',cnst.POPUP_MAP_ACTION,nodeId);
  				
  			}else{
  				rdbpopup.getJSONErrorMessagePOPUP(mapObject.ui.messages,Object,mapObject.ui.headerString,cnst.POPUP_MAP_ACTION,nodeId);
			}				
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
			var cnst = new RdbConstant();
			rdbpopup = new RdbPOPUPModal();
			rdbpopup.getJSONErrorMessagePOPUP(null,XMLHttpRequest,'Hierarchy Map Error',cnst.POPUP_MAP_ACTION,"");
		}
 	});
}
/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Get Location Map From Web Service  Call With Defualt Parameter                 		   								      =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Image From Root Folder Web Service  Call With Defualt Parameter              		   								      =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getImageFromRootFolder(objectId){
$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=getimage&objectid="+objectId,
		dataType: "text" ,
		success: function(imageName){  
			createToolTip(imageName,objectId);
			if(imageName==""){
				$("div.tooltip").hide();
				$("div.tooltip").remove();
			}
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
			if(imageName!=null && imageName!=""){
		 		createToolTip(imageName,objectiId);
		 	}
		}
 	}); 
}
function getImageString(objectId){
	return;
$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=getimage&objectid="+objectId,
		dataType: "text" ,
		success: function(imageString){  
			createToolTipFromImageString(imageString,objectId);
			if(imageString=="" ||imageString==null){
				$("div.tooltip").hide();
				$("div.tooltip").remove();
			}
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
			
		}
 	}); 
}
/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Get Image From Root Folder Web Service  Call With Defualt Parameter              		   								      =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Delete Image From Root Folder Web Service  Call With Defualt Parameter           		   								      =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function deleleObjectImage(objectId){
$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=deleteimage&objectid="+imageObjectId,
		dataType: "text" ,
		success: function(obj){  
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
		}
 	} ); 
}
/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Delete Image From Root Folder Web Service  Call With Defualt Parameter           		   								      =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= get Object Image From Root Folder Web Service  Call With Defualt Parameter  Object Image Properties					      =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getObjectImage(objectImgPros){
	return;
	if(imageObjectId!=objectImgPros){
		getImageString(objectImgPros);
		imageObjectId = objectImgPros;
	}
/*
	
    if(imageObjectId!=objectImgPros){
       	$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=deleteimage&objectid="+imageObjectId,
		dataType: "text" ,
		success: function(obj){  
			//getImageFromRootFolder(objectImgPros);
			getImageString(objectImgPros);
			imageObjectId= objectImgPros;
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
		}
 	 } ); 
    }
    */
}
/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= get Object Image From Root Folder Web Service  Call With Defualt Parameter  Object Image Properties					      =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
	===============================================================================================================================
	= Convert Initail Get Hierarchy Web Service Response Into UI Correspoding Array Data             					          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function convert_JSON_TO_ARRAY (hierData,rootId,level){
	if(hierData!=null){
		var id = hierData.id;
		var name = hierData.name;
		var data = hierData.data;
		var child = hierData.children;
		var len = rdbHasChilds(child);
		var str=' ';
		var validity = data.validity;
		var _filter_date = orgFrameWork.converStringToDateFormat(validity.begda);
		var _filter_date1 = orgFrameWork.converStringToDateFormat(validity.endda);
		if(_filter_date <= orgFrameWork.getOrgKeyDate()&& _filter_date1>=orgFrameWork.getOrgKeyDate()){
			for(obj in data.boxinfo){
				str+=data.boxinfo[obj]+',';
			}
			var newStr = str.substring(0,str.length-1);	
			var _lvl=level;
						/*		0      1	       2	          3	        4		          5		                6	                  7*/
			parentChild.push(id+'@'+rootId+'@'+data.ObjectId+'@'+name+'@'+data.Otype+'@'+data.validity.begda+'@'+data.validity.endda+'@'+newStr+'@'+level+'@'+_lvl);
			jsonAutoSuggest.push({'id':id,'value':data.ObjectId+'{'+data.Otype+'}'+name});
			fieldsobj["fields"].push({Seqnr:id,Pup:rootId,Objid:data.ObjectId,Short:name,Otype:data.Otype,Vbegda:data.validity.begda,Vendda:data.validity.endda}); /*populated json object*/
			if(data.Otype=='S'){
				tempVacantArray.push(data.ObjectId);
			}
			if(len>0){
				rootId = id;
				for(var i=0;i<len;i++){
					convert_JSON_TO_ARRAY(child[i],rootId,level+1);
				}
				var actions ={expendStatus:false,childStatus:false,toggleStatus:false};
				if(level != parseInt(hierarchyDepth)-1){
					levelParentList[rootId]= len+'@'+level;
					
					if(level!=1){
						//nodeExpCollapseActionContainer[rootId]=true;
						actions.expendStatus = false;
						actions.childStatus = false;
						actions.toggleStatus = true;
						nodePlusMinusStatus[rootId] = actions;
					}
				}else{
					actions.expendStatus = true;
					actions.childStatus = false;
					actions.toggleStatus = false;
					nodePlusMinusStatus[rootId] = actions;
					//nodeExpCollapseActionContainer[rootId]=false;
				}
			}
		}
	
	}		
}

/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Convert Initail Get Hierarchy Web Service Response Into UI Correspoding Array Data  					                      =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
	===============================================================================================================================
	= Convert Initail Get Child Hierarchy Web Service Response Into UI Correspoding Post Array Data             					          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function convert_JSON_TO_ARRAY_POSTPROCESS(hierData,rootId,level,lvl){
	if(hierData!=null){
		var id = hierData.id;
		var name = hierData.name;
		var data = hierData.data;
		var child = hierData.children;
		var len = rdbHasChilds(child);
		var str=' ';
		var validity = data.validity;
		var _filter_date = orgFrameWork.converStringToDateFormat(validity.begda);
		var _filter_date1 = orgFrameWork.converStringToDateFormat(validity.endda);
		if(_filter_date <= orgFrameWork.getOrgKeyDate()&& _filter_date1>=orgFrameWork.getOrgKeyDate()){
			for(obj in data.boxinfo){
				str+=data.boxinfo[obj]+',';
			}
			var newStr = str.substring(0,str.length-1);
			var _lvl = parseInt(lvl)+1;
						   /*		0      1	       2	          3	        4		          5		                6	                  7            8         9*/  
			post_ParentChild.push(id+'@'+rootId+'@'+data.ObjectId+'@'+name+'@'+data.Otype+'@'+data.validity.begda+'@'+data.validity.endda+'@'+newStr+'@'+level+'@'+_lvl);
			post_JsonAutoSuggest.push({'id':id,'value':data.ObjectId+'{'+data.Otype+'}'+name});
			post_Fieldsobj["fields"].push({Seqnr:id,Pup:rootId,Objid:data.ObjectId,Short:name,Otype:data.Otype,Vbegda:data.validity.begda,Vendda:data.validity.endda}); /*populated json object*/
			if(data.Otype=='S'){
				post_TempVacantArray.push(data.ObjectId);
			}
			
			if(len>0){
				rootId = id;
				for(var i=0;i<len;i++){
					convert_JSON_TO_ARRAY_POSTPROCESS(child[i],rootId,level+1,_lvl);
				}
				var actions ={expendStatus:false,childStatus:false,toggleStatus:false};
				if(level != parseInt(hierarchyDepth)-1){
					levelParentList[rootId]= len+'@'+level;
					if(level!=1){
					//	nodeExpCollapseActionContainer[rootId]=true;
						actions.expendStatus = false;
						actions.childStatus = false;
						actions.toggleStatus = false;
						nodePlusMinusStatus[rootId] = actions;
					}
				}else{
					actions.expendStatus = true;
					actions.childStatus = false;
					actions.toggleStatus = false;
					nodePlusMinusStatus[rootId] = actions;
				//	nodeExpCollapseActionContainer[rootId]=false;
				}
				
			}
			
			
		}
		
	}	
}

/*
    ===============================================================================================================================
    = End....													                                                                  =
   	= Convert Initail Get Child Hierarchy Web Service Response Into UI Correspoding Post Array Data 		                      =
	===============================================================================================================================
*/
function createLevelParentChildsList(parentLst,parent){
    var tarray = new Array();
	for(var i=0;i<parentLst.length;i++){
		if(parentLst[i].split('@')[8]<=(hierarchyDepth-2)){
			tarray.push(parentLst[i].split('@')[0]);
		}
	}
	levelParentChildsList[parent]= tarray;
}

function rdbHasChilds(child){
	var len;
	try{
		 len = child.length;
	}catch(e){
		return 0;
	}
	return len;
}
function getMaxRowsForBoxData(jsonData){
	var max_rows=0;
	var rowCounter=0;
	for( obj  in jsonData){
 		if(obj.toLowerCase()=='boxinfo'){
 			var boxDataObject = jsonData[obj];
 			for(boxObject in boxDataObject){
 				rowCounter+=1;
 			}
 			if(rowCounter>=max_rows){
 				max_rows = rowCounter;
 				rowCounter=0;
 			}
 		}
 	}
 	if(max_rows>10){ return 10;}
 	return max_rows;
}
function getEachGroupRowDataWithMappingUiElementType(data,uiData,gName,gDesc){
	var gObject = {groupName:"",groupData:"",groupDesc:""};
	gObject.groupName = gName;
	gObject.groupDesc = gDesc;
	var rows = new Array();
	for(var i=0;i<data.length;i++){
		var elements = data[i].uiElements;
		var rowValidity = data[i].validity;
		var rArr = new Array();
		if(elements!=null){
			for(var j=0;j<uiData.length;j++){
				var eleId = uiData[j].uiElementId;
				var fieldName = uiData[j].fieldLabel;
				var rdata = {fieldName:"",fieldValue:""}; 
				rdata.fieldName = fieldName;
				for(var k=0;k<elements.length;k++){
					if(elements[k].uiElementId==eleId){
						var values = elements[k].currentValues;
						var _value ='';
						for(var l=0;l<values.length;l++){
							_value+=values[l];
							if(l+1<values.length){
								_value+=',';
							} 
						}
						rdata.fieldValue = _value;
						break;
					}
					
				}
				rArr.push(rdata);
					
			}
			rows.push(rArr);
		}
	}
	gObject.groupData = rows;
	return gObject;
}
function convertIntoAdditionInformationCollection(data){
	objectInformationColl = new Array();
	for(d in data){
		var infoData = data[d];
		var tabObj = {tabName:"",groupInfo:""};
		if(infoData!=null){
			var tabName = infoData.data[0].panelId;
			tabObj.tabName = tabName;
			var groupsInfo = infoData.data[0].groups;
			var groups = new Array();
			if(groupsInfo!=null){
				for(var g=0;g<groupsInfo.length;g++){
					var uiEleMetaData = groupsInfo[g].uiEleMetaData;
					var data = groupsInfo[g].data;
					var groupName = groupsInfo[g].groupName;
					var groupDesc = groupsInfo[g].groupDesc;
					
					var gObj = getEachGroupRowDataWithMappingUiElementType(data,uiEleMetaData,groupName,groupDesc);
					if(gObj!=null){
						groups.push(gObj);
					}
				}
			}
			objectInformationColl[tabName]=groups;
		}
	}
}
function getSelectedChildParent(childId){
 for(var i=0;i<parentChild.length;i++){
 		if(childId == parentChild[i].split('@')[0]){
 			return parentChild[i].split('@')[1];
 		}
 }

}
function updatedParentStatus(parent,child,status){
	if(!status){
		var tarray = new Array();
		tarray.push(parent);
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[1]==parent){
				tarray.push(parentChild[i].split('@')[0]);
			}
		}
		for(var i=0;i<parentChild.length;i++){
			if(parentChild[i].split('@')[8]<=(hierarchyDepth-HIERARCHY_DEPTH_COMMON_FACTOR) && parentChild[i].split('@')[1]==child){
				tarray.push(parentChild[i].split('@')[0]);
			}
		}
		levelParentChildsList[parent]= tarray;
		updateNodeChildStatus(true,parent);
		if(parent == rdbRootSqnNo){
			updatedParentStatus(getSelectedChildParent(parent),parent,true);
		}else{
			updatedParentStatus(getSelectedChildParent(parent),parent,getParentChildStatus(getSelectedChildParent(parent)));
		}
			
	}else{
		return;
	}

}
function updateNodeChildStatus(act,id){
	for(sqn in nodePlusMinusStatus){
		if(id == sqn){
			var actions = nodePlusMinusStatus[sqn];
			actions.childStatus=act;
			nodePlusMinusStatus[sqn]= actions;
		}
	}
}
function getParentChildStatus(parentSqn){

	for(sqn in nodePlusMinusStatus){
		if(sqn==parentSqn){
			var actions = nodePlusMinusStatus[sqn];
			 return actions.childStatus;
		}
	}
}