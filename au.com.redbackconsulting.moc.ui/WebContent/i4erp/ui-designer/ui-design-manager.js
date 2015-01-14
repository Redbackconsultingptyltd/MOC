/*
 ===========================================================================================
 = This file is being used for designing ui interface.									   =
 ===========================================================================================


    =====================================================================
	= Designing Ui Element With Initial Hierarchy Web Service Call Data =
	= Start....															=
	=====================================================================
*/
function creatingUIElementFromInitialHierarchyCollectionData(){     	
	for(var i=0;i<parentChild.length;i++){
    	var str=parentChild[i].split("@")[1];
        parentArr.push(str);
    }
    parentArr=unique(parentArr);
    for(var i=0;i<parentArr.length;i++){
    	var  arr=new Array();
        for(var j=0;j<parentChild.length;j++){
        	if(parentArr[i]==parentChild[j].split("@")[1])
        	{
        		arr.push(parentChild[j].split("@")[0]);
        	}
        }
        parentArrlist.push(arr);
    }
            	
    for(var i=0;i<parentArr.length;i++){
    	for(var s=0;s<parentArrlist[i].length;s++){
        	finalarray.push(parentArr[i]+","+parentArrlist[i][s]);
        }
    }
    for(var d=0;d<finalarray.length;d++){
    	var _rootId = finalarray[d].split(",")[1];
    	if(isValidLevel(_rootId,parentChild)){
    	if(finalarray[d].split(",")[0]=="1")
        {
        	if($('#TreeContainer').find('ul[id=collapser]').length==1)
            {
            	$('#TreeContainer').find('ul[id=collapser]').append('<li class="child" id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+ '</li>');
            }
			if($('#folderContainer').find('ul[id=ftree]').length==1)
            {
				for(var i=0;i<parentChild.length;i++)
				{
					if(parseInt(finalarray[d].split(",")[1])==parseInt(parentChild[i].split('@')[0]))	
					{
						$('#folderContainer').find('ul[id=ftree]').append('<li id=V'+finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+finalarray[d].split(",")[1]+')" id='+finalarray[d].split(",")[1]+' class="folder">'+parentChild[i].split('@')[3]+'</a></li>');
					}
				}
            }
			if($('#horizontalContainer').find('ul[id=htree]').length==1)
            {
				for(var i=0;i<parentChild.length;i++)
				{
					if(parseInt(finalarray[d].split(",")[1])==parseInt(parentChild[i].split('@')[0]))	
					{
						$('#horizontalContainer').find('ul[id=htree]').append('<li id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li>');
					}
				}
            }
         }
         $('#TreeContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').each(function(i, ele) {
    		if ($(this).find('ul').length == 0) {
    			$('#TreeContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').append('<ul class="parent" style=display:none ><li class="child" id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+ '</li></ul>');
    		} else {
    			$('#TreeContainer').find('li[id=V'+finalarray[d].split(",")[0]+'] ul').append('<li class="child" id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li>');
    		}
		 });
		var hasChild="true";
        if(include(parentArr,finalarray[d].split(",")[1])==false)
        {
        	hasChild="false";
        }
        $('#folderContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').each(function(i, ele) {
			var aData="";
			for(var i=0;i<parentChild.length;i++)
			{
				if(parseInt(finalarray[d].split(",")[1])==parseInt(parentChild[i].split('@')[0]))	
				{
						aData=parentChild[i].split('@')[3];
				}
			}
    		if ($(this).find('ul').length == 0) {
    			if(hasChild=="true")
    			    $('#folderContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').append('<ul class="sub"><li id=V'+finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+finalarray[d].split(",")[1]+')" id='+finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li></ul>');
    			else
    				$('#folderContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').append('<ul class="sub"><li id=V'+finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+finalarray[d].split(",")[1]+')" id='+finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li></ul>');
    		} else {
    				if(hasChild=="true")
    					$('#folderContainer').find('li[id=V'+finalarray[d].split(",")[0]+'] ul').append('<li id=V'+finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+finalarray[d].split(",")[1]+')" id='+finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li>');
    				else
    					$('#folderContainer').find('li[id=V'+finalarray[d].split(",")[0]+'] ul').append('<li id=V'+finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+finalarray[d].split(",")[1]+')" id='+finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li>');	
    		}
		});
		/*horizontal container*/
		$('#horizontalContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').each(function(i, ele) {
			var aData="";
			for(var i=0;i<parentChild.length;i++)
			{
				if(parseInt(finalarray[d].split(",")[1])==parseInt(parentChild[i].split('@')[0]))	
				{
					aData=parentChild[i].split('@')[3];
				}
			}
			if ($(this).find('ul').length == 0) {
    			if(hasChild=="true")
    			    $('#horizontalContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li></ul>');
    			else
    				$('#horizontalContainer').find('li[id=V'+finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li></ul>');
    		} else {
    			if(hasChild=="true")
    				$('#horizontalContainer').find('li[id=V'+finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li>');
    			else
    				$('#horizontalContainer').find('li[id=V'+finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+finalarray[d].split(",")[1]+'>'+getnodeData(finalarray[d].split(",")[1])+'</li>');	
    			}
    	});
       }
    }	
    
	$("#verticle").trigger('click', ['objectCenter']);
	updateInitialHierarchyCollectionDataWithLevel();
	applyTreeWidthMinus();
	scrollWithdrag();			
}	
/*  ===============================================================================================================================
	= End....																													  =
	= Designing Ui Element With Initial Hierarchy Web Service Call Data                                                          =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Designing Ui Element With Get Child Hierarchy Web Service Call Data												          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function removingAllChildBeforAddingNewChilds(ulId){
 $('#TreeContainer').find('li[id=V'+ulId+']').each(function(i, ele) {
    	$(this).find('ul').empty();
    });
    $('#folderContainer').find('li[id=V'+ulId+']').each(function(i, ele) {
    	$(this).find('ul').empty();
    });
	$('#horizontalContainer').find('li[id=V'+ulId+']').each(function(i, ele) {
		$(this).find('ul').empty();
	});
							
}
function creatingUIElementFromGetChildHierarchyCollectionData(){
	for(var i=0;i<post_ParentChild.length;i++){
    	var str=post_ParentChild[i].split("@")[1];
        post_ParentArr.push(str);
    }
    post_ParentArr=unique(post_ParentArr);
    for(var i=0;i<post_ParentArr.length;i++){
    	var  arr=new Array();
        for(var j=0;j<post_ParentChild.length;j++){
        	if(post_ParentArr[i]==post_ParentChild[j].split("@")[1])
        	{
        		arr.push(post_ParentChild[j].split("@")[0]);
        	}
        }
        post_ParentArrlist.push(arr);
    }    	
    for(var i=0;i<post_ParentArr.length;i++){
    	for(var s=0;s<post_ParentArrlist[i].length;s++){
        	post_Finalarray.push(post_ParentArr[i]+","+post_ParentArrlist[i][s]);
        }
    }
    for(var d=0;d<post_Finalarray.length;d++){
       var _rootId = post_Finalarray[d].split(",")[1];
       if(isValidLevel(_rootId,post_ParentChild)){
       		var hasChild="true";
        	if(include(post_ParentArr,post_Finalarray[d].split(",")[1])==false)
        	{
        		hasChild="false";
        	}	       
    	  	$('#TreeContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').each(function(i, ele) {
    			if ($(this).find('ul').length == 0) {
    				if(hasChild=="true")
    			   		 $('#TreeContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li></ul>');
    				else
    					$('#TreeContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li></ul>');
    			} else {
    				if(hasChild=="true")
    					$('#TreeContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li>');
    				else
    					$('#TreeContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li>');	
    				}
			});		
        	$('#folderContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').each(function(i, ele) {
				var aData="";
				for(var i=1;i<post_ParentChild.length;i++)
				{
					if(parseInt(post_Finalarray[d].split(",")[1])==parseInt(post_ParentChild[i].split('@')[0]))	
					{
						aData=post_ParentChild[i].split('@')[3];
					}
				}
    			if ($(this).find('ul').length == 0) {
    				if(hasChild=="true")
    			  	  	$('#folderContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul class="sub"><li id=V'+post_Finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+post_Finalarray[d].split(",")[1]+')" id='+post_Finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li></ul>');
    				else
    					$('#folderContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul class="sub"><li id=V'+post_Finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+post_Finalarray[d].split(",")[1]+')" id='+post_Finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li></ul>');
    			} else {
    				if(hasChild=="true")
    					$('#folderContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li id=V'+post_Finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+post_Finalarray[d].split(",")[1]+')" id='+post_Finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li>');
    				else
    					$('#folderContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li id=V'+post_Finalarray[d].split(",")[1]+'><a onclick="SelectedFolderCSS('+post_Finalarray[d].split(",")[1]+')" id='+post_Finalarray[d].split(",")[1]+' class="folder">'+aData+'</a></li>');	
    			}
			});
			/*horizontal container*/
			$('#horizontalContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').each(function(i, ele) {
				var aData="";
				for(var i=0;i<post_ParentChild.length;i++)
				{
					if(parseInt(post_Finalarray[d].split(",")[1])==parseInt(post_ParentChild[i].split('@')[0]))	
					{
						aData=post_ParentChild[i].split('@')[3];
					}
				}
				if ($(this).find('ul').length == 0) {
    				if(hasChild=="true")
    			   		 $('#horizontalContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li></ul>');
    				else
    						$('#horizontalContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+']').append('<ul><li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li></ul>');
    			} else {
    				if(hasChild=="true")
    					$('#horizontalContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li>');
    				else
    					$('#horizontalContainer').find('li[id=V'+post_Finalarray[d].split(",")[0]+'] ul').append('<li  id=V'+post_Finalarray[d].split(",")[1]+'>'+postGetNodeData(post_Finalarray[d].split(",")[1])+'</li>');	
    				}
    		});
       }
    }	
    
	
	updateGetChildHierarchyCollectionDataWithLevel();
	margingHierarchyDataCollection();
	//updateNodeAction(true,selectedParent);
	//applyTreeWidthMinus();
	scrollWithdrag();
}
/*  ===============================================================================================================================
	= End....																													  =
	= Designing Ui Element With Get Child Hierarchy Web Service Call Data                                                        =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Updating Initial Hierarchy Web Service Call Data Collection With Filter Level 1 & 2 								          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function updateInitialHierarchyCollectionDataWithLevel(){
	var tArray = new Array();
 	var arr = new Array();
 	for(var i=0;i<parentChild.length;i++){
 		if(parentChild[i].split("@")[8]!= hierarchyDepth){
 			tArray.push(parentChild[i]);
 		}else{
 			arr.push(parentChild[i].split("@")[0]);
 		}
 	}
 	parentChild = null;
 	parentChild = tArray;
 	tArray = null;
 	tArray = new Array();
 	var flag=false;
 	for(var i=0;i<jsonAutoSuggest.length;i++){
 		var obj = jsonAutoSuggest[i];
 		for(var j=0;j<arr.length;j++){
 			if(obj.id==arr[j]){
 				flag = true;
 				break;
 			}else{
 				flag = false;
 			}
 		}
 		if(!flag){
 			tArray.push(obj);
 		}
 	}
 	jsonAutoSuggest = null;
    jsonAutoSuggest = tArray;
    tArray = null
    tArray = new Array();
    var statusMatch =0;
    for(var i=0;i<parentArrlist.length;i++){
    	var ar = parentArrlist[i];
    	var lenAr = ar.length;
    	statusMatch =0;
    	for(var j=0;j<ar.length;j++){
    		for(var k=0;k<arr.length;k++){
    			if(arr[k]==ar[j]){
    				statusMatch+=1;
    			}
    		}
    	}
    	if(statusMatch!=lenAr){
    	 tArray.push(ar);
    	}
    }
   parentArrlist = null;
   parentArrlist = tArray;
   tArray = new Array();
   for(var i=0;i<parentArr.length;i++){
   		flag = false;
   		for(var j=0;j<arr.length;j++){
   			if(arr[j]==parentArr[i]){
   				flag = true;
   				break;
   			}
   		}
   		if(!flag){
   			tArray.push(parentArr[i]);
   		}
    }
    parentArr = null;
    parentArr = tArray;
    tArray = null;
 	var fields = fieldsobj.fields;
   	var tempFieldsObj ={fields:[]};
  
 	for(var obj in fields){
		var objInfo = fields[obj];
		flag = false;
		for(var i=0;i<arr.length;i++){
			if(objInfo.Seqnr== arr[i]){
				flag = true;
				break;
			}
		}
		if(!flag){
			tempFieldsObj["fields"].push(fields[obj]);
		}
	}
	fieldsobj = null;
	fieldsobj = tempFieldsObj;
	tempFieldsObj = null;
}
/*  ===============================================================================================================================
	= End....																													  =
	= Updating Initial Hierarchy Web Service Call Data Collection With Filter Level: 1 & 2                                        =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Updating Get Child Hierarchy Web Service Call Data Collection With Filter Level only: 2 							          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function updateGetChildHierarchyCollectionDataWithLevel(){
	var tArray = new Array();
 	var arr = new Array();
 	for(var i=0;i<post_ParentChild.length;i++){
 		if(post_ParentChild[i].split("@")[8]!= hierarchyDepth && post_ParentChild[i].split("@")[8]!= '1' ){
 			tArray.push(post_ParentChild[i]);
 		}else{
 			arr.push(post_ParentChild[i].split("@")[0]);
 		}
 	}
 	post_ParentChild = null;
 	post_ParentChild = tArray;
 	tArray = null;
 	tArray = new Array();
 	var flag=false;
 	for(var i=0;i<post_JsonAutoSuggest.length;i++){
 		var obj = post_JsonAutoSuggest[i];
 		flag=false;
 		for(var j=0;j<arr.length;j++){
 			if(obj.id==arr[j]){
 				flag = true;
 				break;
 			}else{
 				flag = false;
 			}
 		}
 		if(!flag){
 			tArray.push(obj);
 		}
 	}
 	post_JsonAutoSuggest = null;
    post_JsonAutoSuggest = tArray;
    tArray = null
    tArray = new Array();
    var statusMatch =0;
    for(var i=0;i<post_ParentArrlist.length;i++){
    	var ar = post_ParentArrlist[i];
    	var lenAr = ar.length;
    	statusMatch =0;
    	for(var j=0;j<ar.length;j++){
    		for(var k=0;k<arr.length;k++){
    			if(arr[k]==ar[j]){
    				statusMatch+=1;
    			}
    		}
    	}
    	if(statusMatch!=lenAr){
    	 tArray.push(ar);
    	}
    }
   post_ParentArrlist = null;
   post_ParentArrlist = tArray;
   tArray = new Array();
   for(var i=0;i<post_ParentArr.length;i++){
   		flag = false;
   		for(var j=0;j<arr.length;j++){
   			if(arr[j]==post_ParentArr[i]){
   				flag = true;
   				break;
   			}
   		}
   		if(!flag){
   			tArray.push(post_ParentArr[i]);
   		}
    }
    post_ParentArr = null;
    post_ParentArr = tArray;
    tArray = null;
 	var fields = post_Fieldsobj.fields;
   	var tempFieldsObj ={fields:[]};
  
 	for(var obj in fields){
		var objInfo = fields[obj];
		flag = false;
		for(var i=0;i<arr.length;i++){
			if(objInfo.Seqnr== arr[i]){
				flag = true;
				break;
			}
		}
		if(!flag){
			tempFieldsObj["fields"].push(fields[obj]);
		}
	}
	post_Fieldsobj = null;
	post_Fieldsobj = tempFieldsObj;
	tempFieldsObj = null;
}
/*  ===============================================================================================================================
	= End....																													  =
	= Updating Get Child Hierarchy Web Service Call Data Collection With Filter Level only: 2                                     =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Marging Get Child Hierarchy Collection With Initial Hierarchy Collection Data             						          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function margingHierarchyDataCollection(){
	for(var i=0;i<post_ParentChild.length;i++){
 		var flag=false;
 		for(var j=0;j<parentChild.length;j++){
 			if(parentChild[j].split("@")[0]== post_ParentChild[i].split("@")[0]){
 				flag= true;
 				break;
 			}
 		}
 		if(!flag){
 			parentChild.push(post_ParentChild[i]);
 		}
 	}
 	post_ParentChild = null;
 	post_ParentChild = new Array();
 	for(obj1 in post_JsonAutoSuggest){
 	    var value = post_JsonAutoSuggest[obj1];
 	    var flag = false;
 	   for(obj2 in jsonAutoSuggest){
 	    	if(post_JsonAutoSuggest[obj1].id == jsonAutoSuggest[obj2].id){
 	    		flag = true;
 	    		break;
 	    	}
 	    }
 	   if(!flag){
    		jsonAutoSuggest.push(value);
       }
    }
    post_JsonAutoSuggest = null;
    post_JsonAutoSuggest = new Array();
    for(var i=0;i<post_ParentArrlist.length;i++){
    	var data1 = post_ParentArrlist[i];
		var match=0;
    	var flag=false;
    	for(var j=0;j<parentArrlist.length;j++){
    		var data2 = parentArrlist[j];
    		for(var x=0;x<data1.length;x++){
    			for(var y=0;y<data2.length;y++){
    				if(data1[x]==data2[y]){
    					match+=1;
    				}
    			}
    		}
    		if(data2.length==match){
    			flag=false;
    			break;
    		}
    	}
    	if(!flag){
    		parentArrlist.push(post_ParentArrlist[i]);
    	}
    }
    post_ParentArrlist = null;
    post_ParentArrlist = new Array();
    
    for(var i=0;i<post_ParentArr.length;i++){
    	var flag =false;
    	for(var j=0;j<parentArr.length;j++){
    		if(parentArr[j]== post_ParentArr[i]){
    			flag = true;
    			break;
    		}
    	}
    	if(!flag){
    		parentArr.push(post_ParentArr[i]);
    	}
    }
    post_ParentArr = null;
    post_ParentArr = new Array();
    
    var fields1 = post_Fieldsobj.fields;
    var fields2 = fieldsobj.fields;
    for(var obj1 in fields1){
    	var flag = false;
    	for(obj2 in fields2){
    		if(fields1[obj1].Seqnr == fields2[obj2].Seqnr){
    			flag = true;
    			break;
    		}
    	}
    	if(!flag){
			fieldsobj["fields"].push(fields1[obj1]);
		}
	}
      
    post_Fieldsobj = null;
    post_Fieldsobj = {fields:[]};
    
	post_TempVacantArray = null;
	post_TempVacantArray = new Array();

	post_Finalarray = null;
	post_Finalarray = new Array();

	 	
}
/*  ===============================================================================================================================
	= End....																													  =
	= Marging Get Child Hierarchy Collection With Initial Hierarchy Collection Data                                               =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Node Data For Initial Hierarchy                                                       						          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function getnodeData(childId){
	var hasChild="true";
	if(jQuery.inArray(childId, parentArr)!=-1)            	
    {
    	hasChild="false";
    }
    for(var i=0;i<parentChild.length;i++)
    {
    	if(parseInt(childId)==parseInt(parentChild[i].split('@')[0]))	
        {
        	var classDiv="top_contain blue";
			var classIcon="inserticon p"
			if(parentChild[i].split('@')[4]=='O')
			{
				classDiv="top_contain blue";
				classIcon="inserticon o";
			} 
			if(parentChild[i].split('@')[4] =='P')
			{

			} 
			if(parentChild[i].split('@')[4]=='S')
			{
				classDiv="top_contain green";
				classIcon="inserticon s";
			}
			
			if(jQuery.inArray(parentChild[i].split('@')[2], tempVacantArray)!=-1)
			{
							//classDiv="top_contain blue";
							//classIcon="inserticon v";							
			}
			var html="";
			var click="click";
			var dblClick="dblclick";	
			var objectId = parentChild[i].split('@')[2];
			if(hasChild=="false")
			{
				//onMouseOver=getObjectImage("+objectId+")
			   html="<a id="+childId+"  ondragstart='drag(event,"+childId+","+objectId+")' ondrop='drop(event,"+childId+","+objectId+")' ondragover='allowDrop(event)'  onclick='connectedToEvent(event,this,\""+click+"\")' href='javascript:void(0)'><div  class='block'    ><div class=\""+classDiv+"\"> <div class=map onclick=getGoogleMaps("+childId+") ></div><div class='insertid' onclick='toggleDraggableControl("+childId+")'>"+parentChild[i].split('@')[2]+"{"+parentChild[i].split('@')[4]+"}</div><div class=\""+classIcon+"\"  ></div></div><div class='bottom' id='"+getMaxRowCSS()+"' ><div class='userdata' id='userdata' >"+boxInformation(parentChild[i].split('@')[3],parentChild[i].split('@')[7])+"</div><span id=hint><div id='imagepanel'  oncontextmenu='ShowMenu(event,"+childId+","+objectId+")'></div></span><div class='expandcollsape'><span id='loading'><div id='plusMinus' onclick='setSelectedId("+childId+")' class='plus'></div></span></div></div></div></a>";											
			}					
			else
			{		//onMouseOver=getObjectImage("+objectId+")			 
			  html="<a id="+childId+"  ondragstart='drag(event,"+childId+","+objectId+")' ondrop='drop(event,"+childId+","+objectId+")' ondragover='allowDrop(event)'  onclick='connectedToEvent(event,this,\""+click+"\")'  href='javascript:void(0)'><div class='block' ><div class=\""+classDiv+"\"> <div class=map onclick=getGoogleMaps("+childId+")></div> <div class='insertid' onclick='toggleDraggableControl("+childId+")'>"+parentChild[i].split('@')[2]+"{"+parentChild[i].split('@')[4]+"}</div><div class=\""+classIcon+"\" ></div></div><div class='bottom ' id='"+getMaxRowCSS()+"' ><div class='userdata' id='userdata'>"+boxInformation(parentChild[i].split('@')[3],parentChild[i].split('@')[7])+"</div><span id=hint><div id='imagepanel'  oncontextmenu='ShowMenu(event,"+childId+","+objectId+")'></div></span><div class='expandcollsape'><div id='plusMinus' onclick='setSelectedId("+childId+")' class=''></div></div></div></div></a>";											
			}
            return html;
        }
    }
}
function activate(ele,sqNo,objId){
	
	if(orgFrameWork.getSelectedAppVersion()==0){
		return;
	}
	if(orgFrameWork.isContextMenuPaste()){return;}
	if(orgFrameWork.initialRoot==sqNo && orgFrameWork.getMovePasteStatus()==false){return ;}
	orgFrameWork.setDraggableToNodeMove({isMove:false,sqnNo:sqNo,objectId:objId});
	
	 if(!orgFrameWork.getMovePasteStatus()){
		 var props =	orgFrameWork.getDraggalbeProperties();
		 props.control = ele;
		 orgFrameWork.setDraggalbeProperties(props);
		 orgFrameWork.setObjectId(objId);
			orgFrameWork.setRootSqNo(sqNo);
			return;
	 }

		
		
		
	  
}
function allowDrop(ev) {
	//alert(ev.target.id);
    ev.preventDefault();
}
function drop(ev,sqNo,objId){
	if(orgFrameWork.getDraggableNodeMoveSqnNo()!=sqNo){
		orgFrameWork.setObjectId(objId);
		orgFrameWork.setRootSqNo(sqNo);
		if(orgFrameWork.getMovePasteStatus()){
			
			var moveNodeParentId = orgFrameWork.getRoot(parentChild, orgFrameWork.getDraggableNodeMoveSqnNo());
			if(moveNodeParentId!=sqNo){
				if(orgFrameWork.isNotMoveNodeSqNoIsInitailSqNo(orgFrameWork.getSelectedMoveNodeSqNo())&& orgFrameWork.isNotMoveNodeMoveToItsChilds(orgFrameWork.getRootSqNo(), orgFrameWork.getSelectedMoveNodeSqNo())){
					orgFrameWork.setIsDragStatus(false);
					debugger;
					var mChild = orgFrameWork.getMoveChildInfo(orgFrameWork.getSelectedMoveNodeSqNo(),orgFrameWork.getRootSqNo());
					orgFrameWork.setMoveChildInfo(mChild);
					orgFrameWork.setFormJson(createEmptyFormTemplate());
					orgFrameWork.approveObjectDataBeforeMoveConfirm(mChild);
				}
				else{
					var uiMessage = new UIMessage();
					uiMessage.dragAlertMessage({text:"The parent root node can't be moved its own hierarchy level",label:"Cancel",action:"HIDE-DRAG-DROP-MESSAGE"});

				}
			}else{
				var uiMessage = new UIMessage();
				uiMessage.dragAlertMessage({text:"The move node already belong to that relationship !",label:"Cancel",action:"HIDE-DRAG-DROP-MESSAGE"});

			}
			
		}
		
	}
	 ev.preventDefault();
}
function toggleDraggableControl(sqNo,objId){
	if(orgFrameWork.getSelectedAppVersion()==0){
		return;
	}
	if(orgFrameWork.initialRoot==sqNo){
		var uiMessage = new UIMessage();
		
		uiMessage.dragAlertMessage({text:"Root node is not draggable!",label:"Hide",action:"HIDE-DRAG-DROP-MESSAGE"});
		return;
	}
	var props = orgFrameWork.getDraggalbeProperties();
	if(props.status==true){
			var rootSqn = orgFrameWork.getRoot(parentChild, props.sqNo);
			var actions={previous:false,next:"collapse"};
			nodeExpCollapseActionContainer[rootSqn]= actions;
			setSelectedId(rootSqn);
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[rootSqn]= actions;
			setSelectedId(rootSqn);
			orgFrameWork.setMovePasteStatus(false);
			orgFrameWork.setDraggableNodeMove({isMove:false,sqnNo:null,objectId:null});
			var props = orgFrameWork.getDraggalbeProperties();
			props.status=false;
			props.sqNo=0;
			orgFrameWork.setDraggalbeProperties(props);
			orgFrameWork.setIsDragStatus(false);
			 var ele = document.getElementById(sqNo);
			 $(ele).attr("draggable", "false");
			var uiMessage = new UIMessage();
			uiMessage.removeDragMessage();
		return;}
	
	if(props.sqNo!=sqNo){
		 props.sqNo=sqNo;
		 orgFrameWork.setDraggalbeProperties(props);
		 var ele = document.getElementById(sqNo);
		 $(ele).draggable();
		//
		 orgFrameWork.setMoveMessageStatus(false);
		 orgFrameWork.setDraggableNodeMove({isMove:true,sqnNo:sqNo,objectId:objId});
			orgFrameWork.setMovePasteStatus(true);
			orgFrameWork.setSelectedMoveNodeSqNo(sqNo);
			var props = orgFrameWork.getDraggalbeProperties();
			props.status=true;
			orgFrameWork.setDraggalbeProperties(props);
			orgFrameWork.setIsDragStatus(true);
		 //
		 $('#collapser').find('a[id='+sqNo+']').find('div').each(function(){
			 if($(this).hasClass("block")){
					$(this).css('border-style','dotted');
				}
			});

		 orgFrameWork.setDragNodeId(sqNo);
	}else{
		if(props.control!=null){
			if($(props.control)!=null){
				 var ele = document.getElementById(props.sqNo);
				 $(ele).draggable(false);
				//$("a."+props.sqNo).attr("draggable", "false");
				//$(props.control).draggable(false);
				 props.control = null;
				 props.status=false;
				 orgFrameWork.setDraggalbeProperties(props);
				 $('#collapser').find('a[id='+sqNo+']').find('div').each(function(){
					 if($(this).hasClass("block")){
							$(this).css('border-style','none');
						}
					});
			}
		}
	}
}
function drag(evt,sqNo,objId){
	if(orgFrameWork.getSelectedAppVersion()==0){
		return;
	} 
	if(!orgFrameWork.getMoveMessageStatus()){
		var uiMessage = new UIMessage();
		uiMessage.dragAlertMessage({text:"Node:{"+objId+"} is ready for drag and drop !",label:"Cancel",action:"CANCEL-DRAG-DROP-ACTION"});
		orgFrameWork.setMoveMessageStatus(true);

	}
}
/*  ===============================================================================================================================
	= End....																													  =
	= Get Node Data For Initial Hierarchy                                                                                         =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    ===============================================================================================================================
	= Get Node Data For Get Child Hierarchy Data                                                   						          =
	= Start....													                                                                  =
	===============================================================================================================================
*/
function postGetNodeData(childId){
	var hasChild="true";
	if(jQuery.inArray(childId, post_ParentArr)!=-1)            	
    {
    	hasChild="false";
    }
    for(var i=1;i<post_ParentChild.length;i++)
    {
    	if(parseInt(childId)==parseInt(post_ParentChild[i].split('@')[0]))	
        {
        	var classDiv="top_contain blue";
			var classIcon="inserticon p"
			if(post_ParentChild[i].split('@')[4]=='O')
			{
				classDiv="top_contain blue";
				classIcon="inserticon o";
			} 
			if(post_ParentChild[i].split('@')[4] =='P')
			{

			} 
			if(post_ParentChild[i].split('@')[4]=='S')
			{
				classDiv="top_contain green";
				classIcon="inserticon s";
			}
			if(jQuery.inArray(post_ParentChild[i].split('@')[2], post_TempVacantArray)!=-1)
			{
							//classDiv="top_contain blue";
							//classIcon="inserticon v";							
			}
			var html="";
			var click="click";
			var dblClick="dblclick";	
			var objectId = post_ParentChild[i].split('@')[2];
			if(hasChild=="false")
			{//onMouseOver=getObjectImage("+objectId+")
			   html="<a id="+childId+" ondragstart='drag(event,"+childId+","+objectId+")' ondrop='drop(event,"+childId+","+objectId+")' ondragover='allowDrop(event)'    onclick='connectedToEvent(event,this,\""+click+"\")' href='javascript:void(0)'><div class='block'><div class=\""+classDiv+"\" > <div class=map onclick=getGoogleMaps("+childId+") ></div><div class='insertid' onclick='toggleDraggableControl("+childId+","+objectId+")'>"+post_ParentChild[i].split('@')[2]+"{"+post_ParentChild[i].split('@')[4]+"}</div><div class=\""+classIcon+"\"  ></div></div><div class='bottom' id='"+getMaxRowCSS()+"' ><div class='userdata' id='userdata'>"+boxInformation(post_ParentChild[i].split('@')[3],post_ParentChild[i].split('@')[7])+"</div><span id=hint><div id='imagepanel'  oncontextmenu='ShowMenu(event,"+childId+","+objectId+")' ></div></span><div class='expandcollsape'><span id='loading'><div id='plusMinus' onclick='setSelectedId("+childId+")' class='plus'></div></span></div></div></div></a>";											
			}					
			else
			{	//onMouseOver=getObjectImage("+objectId+") 				 
			  html="<a id="+childId+" ondragstart='drag(event,"+childId+","+objectId+")'  ondrop='drop(event,"+childId+","+objectId+")' ondragover='allowDrop(event)'    onclick='connectedToEvent(event,this,\""+click+"\")'  href='javascript:void(0)'><div class='block'><div class=\""+classDiv+"\" > <div class=map onclick=getGoogleMaps("+childId+")></div> <div class='insertid' onclick='toggleDraggableControl("+childId+","+objectId+")'>"+post_ParentChild[i].split('@')[2]+"{"+post_ParentChild[i].split('@')[4]+"}</div><div class=\""+classIcon+"\"></div></div><div class='bottom ' id='"+getMaxRowCSS()+"' ><div class='userdata' id='userdata'>"+boxInformation(post_ParentChild[i].split('@')[3],post_ParentChild[i].split('@')[7])+"</div><span id=hint><div id='imagepanel'  oncontextmenu='ShowMenu(event,"+childId+","+objectId+")'></div></span><div class='expandcollsape'><div id='plusMinus' onclick='setSelectedId("+childId+")' class=''></div></div></div></div></a>";											
			}
            return html;
        }
    }
}
/*  ===============================================================================================================================
	= End....																													  =
	= Get Node Data For Get Child Hierarchy Data                                                                                  =
	===============================================================================================================================
	*******************************************************************************************************************************
	*******************************************************************************************************************************
    
*/

