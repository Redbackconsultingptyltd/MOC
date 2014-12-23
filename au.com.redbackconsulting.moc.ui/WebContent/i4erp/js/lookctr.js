var url="";
var containerWidth = 0 ;
var containerHeight = 0;
var scale=1.05;
var maxScale=5.0;
var minScale=1.05;
var scaleZoom=.05;
var callWSDL="0";
var treeWidth = 120;
var beforeDoubleClickZomm;
var flagDoubleClick=false;
var selectedParent=null;
var timer;
var timer1;
var selectedObject=null;
var treeOpenName='V';
var nodeClickId=null;
var nodeClickCounter=0;
var counter=1;
var clickIdArray=new Array();
var canvasCounter=1;
var selectedObjectReset=null;
var selectedObjectVerticle=null;
var selectedObjectHorizontal=null;
var selectedObjectfolder=null;
var popupHeight=0;
var popupWidth=0;
var lastSqnNo = 0;
var rdbNodeConfig ={awidth:100,bheight:46};
var objectImagePros={otype:"",objectid:"",short:""};
var maxRows=0;
var parentObjectId ;
var imageObjectId= "";
var map1  = '<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.co.in/maps?f=d&amp;source=s_d&amp;saddr=Nainital,+Uttarakhand&amp;daddr=29.391785,79.456137&amp;geocode=FdBOwAEdjoS8BClhnf0ovKGgOTGzfZgWqXuufA%3BFal7wAEdiWe8BA&amp;sll=29.391776,79.456151&amp;sspn=0.001437,0.002068&amp;hl=en&amp;mra=ls&amp;ie=UTF8&amp;ll=29.385995,79.459995&amp;spn=0.01139,0.00811&amp;t=m&amp;output=embed"></iframe><br /><small><a href="http://maps.google.co.in/maps?f=d&amp;source=embed&amp;saddr=Nainital,+Uttarakhand&amp;daddr=29.391785,79.456137&amp;geocode=FdBOwAEdjoS8BClhnf0ovKGgOTGzfZgWqXuufA%3BFal7wAEdiWe8BA&amp;sll=29.391776,79.456151&amp;sspn=0.001437,0.002068&amp;hl=en&amp;mra=ls&amp;ie=UTF8&amp;ll=29.385995,79.459995&amp;spn=0.01139,0.00811&amp;t=m" style="color:#0000FF;text-align:left">View Larger Map</a></small>';
var map2 = '<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=roorkee+polaris&amp;aq=&amp;sll=29.389093,79.459584&amp;sspn=0.011498,0.016544&amp;ie=UTF8&amp;hq=polaris&amp;hnear=Motel,+Polaris,Roorkee,+Haridwar,+Uttarakhand&amp;ll=29.865098,77.889469&amp;spn=0.023838,0.006295&amp;t=m&amp;output=embed"></iframe><br /><small><a href="http://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=roorkee+polaris&amp;aq=&amp;sll=29.389093,79.459584&amp;sspn=0.011498,0.016544&amp;ie=UTF8&amp;hq=polaris&amp;hnear=Roorkee,+Haridwar,+Uttarakhand&amp;ll=29.865098,77.889469&amp;spn=0.023838,0.006295&amp;t=m" style="color:#0000FF;text-align:left">View Larger Map</a></small>';
var packet = ' <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:sap-com:document:sap:soap:functions:mc-style">'+
   			'  <soapenv:Header/>'+
   			'  <soapenv:Body>'+
      			' <urn:_-rdb_-mocTcOcGethierdata>'+
        		' <Begindate>2012-03-24</Begindate>'+
         		'<Enddate>2012-03-24</Enddate>'+
         		' <HierDepth>0</HierDepth>'+
         		' <HierObjId>50000051</HierObjId>'+
         		' <HierObjType>O</HierObjType>'+
         		' <Hierarchymap>O-S-P</Hierarchymap>'+
      			' </urn:_-rdb_-mocTcOcGethierdata>'+
   			' </soapenv:Body>'+
			' </soapenv:Envelope>' ;
 
var url1 ="http://rbapp02vm.redbackconsulting.local:8000/sap/bc/srt/scs/rdb/moc_tc_oc_gethierdata?sap-client=100";
var url ="http://rbapp02vm.redbackconsulting.local:8000/sap/bc/srt/scs/rdb/moc_tc_oc_gethierdata?sap-client=100";
var jArray = new Array();
var parentArrlist=new Array();
var parentArr=new Array();
var parentChild=new Array();
var finalarray=new Array();
var tempArray=new Array();
var tempVacantArray=new Array();
var fieldsobj = {fields:[]}; //json object for search
var jsonsobj = {fields:[]}; //json object for search
var jsonAutoSuggest = new Array();
var jsonAutoSuggestObject;
var nodewidthArr = new Array();
var arr=new Array();
var nodeWidthArr = new Array();
/* variable for post process */
var post_ParentChild = new Array();
var post_JsonAutoSuggest = new Array();
var post_Fieldsobj = {fields:[]};
var post_TempVacantArray = new Array();
var post_ParentArr = new Array();
var post_ParentArrlist = new Array();
var post_Finalarray = new Array();
var getChildListStatus = new Array();
var last_SqnNo ;
var initialRootForTrees={trees:[]};
var selectedNodeIdForCSS = null;
var selectedTreeViewSizeFactor= new Array();
var objectInformationColl = new Array();
var searchCase = false;
var searchNodeId;
jQuery.support.cors = true;
/*load xml*/
var levelParentList = new Array();
var levelParentChildsList = new Array();
var nodeExpCollapseActionContainer = new Array();
var nodePlusMinusStatus = new Array();
var nodePlusMinusStatusManager = new Array();
var HIERARCHY_DEPTH_COMMON_FACTOR =1;
var xNodeWidth = new Array();
var xOpenNode= new Array();
var xOpenNodeStatusList= new Array();
function loadi4erpConfig()
{
	$.ajax({
			type: "GET",
			url:  contextRootPath+'/i4erp/xml/i4erpconfig.xml',
			data: "xml",
			dataType: "xml",
			success: function(xml){
				$(xml).find("i4erpconfig").each(function(){	
                 //alert('hi'+$(this).find('callwsdl').text());				
						scale=$(this).find('scale').text();
						maxScale=$(this).find('maxscale').text();
						minScale=$(this).find('minscale').text();
						scaleZoom=$(this).find('scalezoom').text();
						callWSDL=$(this).find('callwsdl').text();
						//alert('hi callWSDL:--?'+callWSDL);
						if($.cookie('treeOpenName_arr')!=null)
						{
							treeOpenName=$.cookie('treeOpenName_arr');
						}
						else
						{	
							treeOpenName=$(this).find('treeOpenName').text();
						}
						getHierarchyDataFromServlet();					
				});
				},
			error: function(e,textStatus, errorThrown){
				alert('Config XML Read Error:'+errorThrown); 
				
				}
			});
			
			
			return;
			
}						
	
/*call wsdl*/	
function initView(){
	var wrapperElement = document.getElementById("wrapper");
	wrapperStyel = wrapperElement.style;
	wrapperStyel.width = document.body.clientWidth;
   	wrapperStyel.height = (document.body.clientHeight )-124+ 'px';
   	//Nodetreecontainer 
   var 	midContainerElement = document.getElementById("midcontain");
	midContainerStyel = midContainerElement.style;
	midContainerStyel.width = document.body.clientWidth;
   	midContainerStyel.height = (document.body.clientHeight)-160 + 'px';
   	
   	
 	var midContainerElement = document.getElementById("treecontainer");
	midContainerStyel = midContainerElement.style;
	midContainerStyel.width = document.body.clientWidth;
   	midContainerStyel.height = (document.body.clientHeight)-160 + 'px';
   	
	b3Element = document.getElementById("b3");
	b3Styel = b3Element.style;
	b3Styel.height = (document.body.clientHeight)-408 +'px';
	
	rightreeElement = document.getElementById("rightree");
	rightreeStyel = rightreeElement.style;
	rightreeStyel.height = (document.body.clientHeight)-160 +'px';
	
	orgFrameWork.setHierarcy();
	orgFrameWork.setAdditionalInfo();
	new datepickr('filter-dt-text', {
		'dateFormat': 'd-m-y'
	});
	var _date = new Date();
	var _date_str = orgFrameWork.orgFormatMonthAndDate(_date.getDate())+'-'+orgFrameWork.orgFormatMonthAndDate(_date.getMonth()+1)+'-'+_date.getFullYear().toString();
	orgFrameWork.setOrgCurrentDate(_date_str);
	document.getElementById("filter-dt-text").value= orgFrameWork.getOrgCurrentDate();
	var uiMessage = new UIMessage();
	uiMessage.generateMenuBarItems(orgFrameWork.getMenuBarItems());
	document.getElementById("orgNavigation").style.display='block';
	
	
}
function beginSaveProduct()
{
	initView();
  //  loadi4erpConfig();	
  if($.cookie('treeOpenName_arr')!=null)
						{
							treeOpenName=$.cookie('treeOpenName_arr');
						}
						else
						{	
							treeOpenName='V';
						}
  getHierarchyDataFromServlet();	
	attachDrag();
	$('#foldertreecontainer').html("");
		
		
		return false;
} 
/*parse xml response*/	
function parse(document)
{	
            	parentChild=new Array();	
             $(document).find("ResultObjec").each(function(){	  
            	$(this).find("item").each(function(){
										   
            		var objId=$(this).find('Objid').text();
            		var objShort=$(this).find('Short').text();
					var objPerson=$(this).find('Stext').text();
            		$(document).find("ResultStruc").each(function(){
            			$(this).find("item").each(function(){
            				if($(this).find('Objid').text()==objId)
            				{
            						fieldsobj["fields"].push({Seqnr:$(this).find('Seqnr').text(),Pup:$(this).find('Pup').text(),Objid:objId,Short:objShort,Vrsign:$(this).find('Vrsign').text(),Vrelat:$(this).find('Vrelat').text(),Otype:$(this).find('Otype').text(),personName:objPerson,Vbegda:$(this).find('Vbegda').text(),Vendda:$(this).find('Vendda').text()}); /*populated json object*/
            						parentChild.push(
            						$(this).find('Seqnr').text()+'@'+
            						$(this).find('Pup').text()+'@'+	
            						objId+'@'+
            						objShort+'@'+$(this).find('Vrsign').text()+'@'+$(this).find('Vrelat').text()+'@'+$(this).find('Otype').text()+'@'+objPerson+'@'+$(this).find('Vbegda').text()+'@'+$(this).find('Vendda').text()
            				);  
									jsonAutoSuggest.push({"id":$(this).find('Seqnr').text(),"value":objId+" {"+$(this).find('Otype').text()+"} "+objPerson});
            				}
            				
            			});
						
            		  });
            	});
				
				$(document).find("ResultObjtypedata").each(function(){
					$(this).find("item").each(function(){
					if($(this).find('Objid').text()!='')
					{
						tempVacantArray.push($(this).find('Objid').text());
					}
					});});
              });
              
             initTree();
			 createBoxTree();
			 initAutoComplete();
		     attachDrag();
}
function isValidLevel(rootId,parent){
   if(rootId==1)return true;
	for(var i=0;i<parent.length;i++){
		if(parent[i].split("@")[0]==rootId){
			if(parent[i].split("@")[8]< hierarchyDepth ){
				return true;
			}else{
				return false;
			}
		}
	}
	return false;
}


function setInitailTreesRootWithChildStatus(rootId){
	var arr = new Array();
	arr['rootId'] = rootId;
	arr['childStatus'] = true;
	arr['tree'] ='H';
	initialRootForTrees['trees'].push(arr);
	arr = null
	arr = new Array();
	arr['rootId'] = rootId;
	arr['childStatus'] = true;
	arr['tree'] ='V';
	initialRootForTrees['trees'].push(arr);
	arr = null
	arr = new Array();
	arr['rootId'] = rootId;
	arr['childStatus'] = true;
	arr['tree'] ='F';
	initialRootForTrees['trees'].push(arr);
}

function createInitialViewForEarchTreeTypes(tree){

	var trees = initialRootForTrees.trees;
	var nodeId,status;
	for(var i=0;i<trees.length;i++){
	    var arr = trees[i];
		if(arr['tree']==tree){
			nodeId = arr['rootId'];
			status = arr['childStatus'];
			trees[i]['childStatus']=false;
			break;
		}
	}
	if(!status){
		if(tree=='H'){
			$('.htree').width(parseInt(selectedTreeViewSizeFactor[tree]));
			$(".htree [id^='V'] a").each(function() {
				$(this).removeClass("active");
			});
			$(".htree").find('a[id='+selectedNodeIdForCSS+']').addClass("active"); 
		}else if(tree=='V'){
			$('.tree').width(parseInt(selectedTreeViewSizeFactor[tree]));
			$(".tree [id^='V'] a").each(function() {
				$(this).removeClass("active");
			});
			$(".tree").find('a[id='+selectedNodeIdForCSS+']').addClass("active");
		}
		objectCenter(selectedNodeIdForCSS);
		
		return;
	}
	if(tree=='H'){
		$('.htree').width(parseInt(selectedTreeViewSizeFactor[tree]));
		$('#htree').find('a[id='+nodeId+']').find('div').each(function(){
			if(this.id=='plusMinus')
			{
				if($(this).hasClass('plus')){
					$('#htree').find('li[id=V'+nodeId+']').find('ul').each(function(){
						$(this).css('display','none');
					});
					createBoxTree();
				}else{
					createBoxTree();
				
				}
			}
			
		});  
		$(".htree [id^='V'] a").each(function() {
				$(this).removeClass("active");
		});
		$(".htree").find('a[id='+selectedNodeIdForCSS+']').addClass("active"); 	
		objectCenter(selectedNodeIdForCSS);	
	}else if(tree=='V'){
		$('.tree').width(parseInt(selectedTreeViewSizeFactor[tree]));
		$('#collapser').find('a[id='+nodeId+']').find('div').each(function(){
			if(this.id=='plusMinus')
			{
				if($(this).hasClass('plus')){
					$('#htree').find('li[id=V'+nodeId+']').find('ul').each(function(){
						$(this).css('display','none');
					});
					createBoxTree();
				}else{
					createBoxTree();
				}
			}
		});
		$(".tree [id^='V'] a").each(function() {
				$(this).removeClass("active");
		});
		$(".tree").find('a[id='+selectedNodeIdForCSS+']').addClass("active");
		objectCenter(selectedNodeIdForCSS);
	}else if(tree=='F'){
		$('#ftree').find('li[id=V'+nodeId+']').find('a[id='+nodeId+']').each(function(){
				if($(this).hasClass('folder')){
					$('#ftree').find('li[id=V'+nodeId+']').find('ul').css('display','none');
				}
		});
		
		createBoxTree();
	}
	

}

function include(arr, obj) {
	for(var i=0; i<arr.length; i++) {
		if (arr[i] == obj) return true;
    }
    return false;
}
function includeVacant(arrVacant, obj) {
	var flag=false;
    for(var i=0; i<arrVacant.length; i++) {
		if ( $.trim(arrVacant[i]) ==  $.trim(obj))
		{
			flag=true;
		}
		return flag;
    }
    return flag;
}
            

var d ;
var t;
var at;
var pendingClick = 0;
function connectedToEvent(event,Obj,eType)
{
   // kill any pending single clicks
	//alert(selectedParent);
	if(orgFrameWork.getContextMenuStatus()){return false;}
    if (pendingClick) {
        clearTimeout(pendingClick);
        pendingClick = 0;
    }
	switch (event.detail) {
        case 1:
            pendingClick = setTimeout(function() {
                //console.log('single click action here');
				SelectedCSS(event,Obj);
            }, 500);// should match OS multi-click speed
            break;
        case 2:
            //console.log('double click action here');
			SelectedCSS(event,Obj);
			onaDoubleClickZomm(event,Obj);
            break;
        default:
            //console.log('higher multi-click actions can be added as needed');
            break;
    }

	
	
	return;
}	
function unique(arrayName)
{
	var newArray=new Array();
    label:for(var i=0; i<arrayName.length;i++ )
    {  
       	for(var j=0; j<newArray.length;j++ )
       	{
          	if(newArray[j]==arrayName[i]) 
    	       	continue label;
       	}
       	newArray[newArray.length] = arrayName[i];
    }
    return newArray;
}

//populate AdditionInfo data
function populateSelected(liId)
{
	getSelectedOType(liId);
	getAddtionalAndObjectInfoOfSelectedNodeFromServlet(liId);
	
	return;
}
function SelectedFolderCSS(Obj)   // i am working here ..................................
{
	selectedParent=Obj;
	selectedNodeIdForCSS = Obj;
	//new Code..
	getSelectedOType(Obj);
	
	if(orgFrameWork.getContextMenuStatus()){return false;}
	
	var action = getChildStatus(Obj);
	if(action=="service"){
		
		getChildHierarchyDataFromServlet(objectImagePros.objectid,objectImagePros.otype,Obj);
		restUpdate(Obj,true);

	}else if(action=="collapse"){
	     restUpdate(Obj,false);
	    
	}else if(action=="expend"){
	     restUpdate(Obj,true);
	    
	}
	
	
	
//	if(getChildStatus(Obj)){
//		getChildHierarchyDataFromServlet(objectImagePros.objectid,objectImagePros.otype,Obj);
//		getChildListStatus.push(Obj); 
//	}else{
//	 	 populateSelected(Obj);
//	     restUpdate(Obj);
//	 
//	}
	//end of new code here ..........
	$(".stree [id^='V'] a").each(function() {	
		if(this.id==Obj)
		{
			resetboxClass();
			$(this).addClass("active");
			selectedObjectfolder=Obj;
		}
		});	
}
function SelectedCSS(e,Obj)
{
	if(searchCase==true){
		if(Obj.id!=searchNodeId){
			searchCase = false;
			return;
		}
	}
	
	resetClass();
	selectedNodeIdForCSS = Obj.id;
	if(treeOpenName=="V"){	
		$(".tree li[id='V"+Obj.id+"'] a[id='"+Obj.id+"']").each(function() {	
		$(this).removeClass("active");
		selectedObjectVerticle=Obj.id;
	});
	}
	if(treeOpenName=='H'){	
	$(".htree li[id='V"+Obj.id+"'] a[id='"+Obj.id+"']").each(function() {	
		$(this).removeClass("active");
		selectedObjectHorizontal=Obj.id;
	});
	}
	$(Obj).addClass('active');
	populateSelected(Obj.id);
	$(".stree [id^='V'] a").each(function() {	
		if(this.id==Obj.id)
		{
			resetboxClass();

			$(this).addClass("active");

		}
		});	
	
}

//for serach functionality
function resetClass()
{
	if(treeOpenName=='V'){														  
	$(".tree li[id^='V'] a").each(function() {	
		$(this).removeClass("active");
	});
	}
	if(treeOpenName=='H'){														  
	$(".htree li[id^='V'] a").each(function() {	
		$(this).removeClass("active");
	});
	}
}

function searchInChart(objId)
{
	resetClass();
	populateSelected(objId);
	selectedNodeIdForCSS = objId;	
	var objThis='V'+objId;
	$("li[id="+objThis+"] a").removeClass("");
	$("li[id="+objThis+"] a[id="+objId+"]").addClass("active");
	objectCenter(objId);
	createBoxTree();
	return;
}

function createBoxTreeforFolder()
{
		if(selectedObject!=null)
			{
				$(".stree [id^='V'] a").each(function() {	
					if(this.id==selectedObject)
					{
						resetboxClass();
						$(this).addClass("active");
				  
					}
					});	
			}
	calculateOpenLi();
    sliceNode();
	clearInterval(timer1);
	return;
}
function createBoxTree()
{
    $('#dragarea').html("");	

            if(selectedParent == orgFrameWork.initialRoot){
            	var actions = nodeExpCollapseActionContainer[selectedParent];
            	if(actions.previous==false && actions.next=="collapse"){
            		$('#dragarea').html('<ul class="stree">'+$('#htree').html()+'</ul>');	
        		//	orgFrameWork.setBoxTreeStatus(true);
            	}else{
            		 $('#dragarea').html('<ul class="stree">'+$('#htree').html()+'</ul>');	
          			$('.stree').css('margin-left','13%');
          			$('.stree').css('margin-top','8%');
          			//orgFrameWork.setBoxTreeStatus(true);
            	}
            }else{
            	if(selectedParent==null){
            		$('#dragarea').html('<ul class="stree">'+$('#htree').html()+'</ul>');	
            	}else{
            		$('#dragarea').html('<ul class="stree">'+$('#htree').html()+'</ul>');	
         			$('.stree').css('margin-left','13%');
         			$('.stree').css('margin-top','8%');
            	}
            	 
            }
	
			orgFrameWork.setBoxTreeStatus(true);
	
	$.each(fieldsobj.fields, function(i, v) {
		var objThis='V'+v.Seqnr;
		$('#dragarea').find("li[id="+objThis+"] a[id="+v.Seqnr+"]").html("");
		$('#dragarea').find("li[id="+objThis+"] a[id="+v.Seqnr+"]").mouseover(function() {
			showBox(this.id);
			populateSelected(v.Seqnr);				
		  }).mouseout(function(){
		  });
	});
	calculateOpenLi();
	sliceNode();
	clearInterval(timer);
	
	
	return;
}
function getNodeAction(id){
	return nodeExpCollapseActionContainer[id];
	
}
function updateNodeAction(act,id){
	return ;
	
	for(sqn in nodePlusMinusStatus){
		if(id == sqn){
			var actions = nodePlusMinusStatus[sqn];
			actions.expendStatus=act;
			if(actions.expendStatus==false){
				actions.toggleStatus = false;
			}else{
				actions.toggleStatus = true;
			}
			nodePlusMinusStatus[sqn]= actions;	
		}
	}
}

function setSelectedId(thisId)
{
	if(orgFrameWork.getContextMenuStatus()){return false;}
	selectedParent=thisId;
	selectedNodeIdForCSS = thisId;
	getSelectedOType(thisId);
	var action = getChildStatus(thisId);
	if(action=="service"){
		getChildHierarchyDataFromServlet(objectImagePros.objectid,objectImagePros.otype,thisId);
		restUpdate(thisId,true);

	}else if(action=="collapse"){
	     restUpdate(thisId,false);
	    
	}else if(action=="expend"){
	     restUpdate(thisId,true);
	    
	}
	
	
}
function getChildStatus(parentSqn){
	var actions = nodeExpCollapseActionContainer[parentSqn];
	if(actions==null){
		actions={previous:false,next:"service"};
		nodeExpCollapseActionContainer[parentSqn]=actions;
	}
	if(actions.previous="service" && actions.next=="expend"){
		return actions.next;
	}else if(actions.previous=="expend" && actions.next=="collapse"){
		return actions.next;
	}else if(actions.previous=="collapse" && actions.next=="service"){
		return actions.next;
	}else if(actions.previous==false && actions.next=="collapse"){
		return actions.next;
	}else if(actions.previous==false && actions.next=="service"){
		return actions.next;
	}else if(actions.previous==false && actions.next=="expend"){
		return actions.next;
	}
}


function applyTreeWidthPlus(pid)
{
	canvasCounter++;
  debugger;
	var countArr = 1;
	counter=0;
	widthMinus=0;
	var xCounter=0;

	for(var i=0;i<parentChild.length;i++){
		if(parentChild[i].split('@')[1]==pid){
			xCounter+=1;
		}
	}
	var tree=10;
	if(xCounter>1)
	{
	
		if(orgFrameWork.initialRoot==pid){
			if(xCounter==2){
				tree = (120*(xCounter-1))+(((xCounter*2))*10);
			}else{
				tree = (120*(xCounter-1))+(((xCounter*2)-1)*10);
			}
		}else{
			tree = (120*(xCounter-1))+((xCounter+1)*10);
	}
	}	
		
		$('.htree').width(parseInt($(".htree").width())+parseInt(tree));
		$('.tree').width(parseInt($(".tree").width())+parseInt(tree));
		selectedTreeViewSizeFactor['V'] = parseInt($(".tree").width());
		selectedTreeViewSizeFactor['H'] = parseInt($(".htree").width());
			
		//document.getElementById("text").innerHTML="";
		//document.getElementById("text").innerHTML='<div> counter::'+xCounter+':::'+pid+"::"+tree+'<br> tree*:'+$(".tree").width()+'</div>';
	
	
	orgFrameWork.setOrgNodeStatus(pid, false);
	xNodeWidth[pid]=tree;	
	orgFrameWork.setPlusMinusListStatus(parentChild, pid);
	objectCenter(orgFrameWork.initialRoot);
	return ;
	
}

function _updatePlusMinus(pid){
	var _updatedList = new Array();
	for(var obj in xOpenNodeStatusList){
		if(obj!=pid){
			_updatedList[obj]=xOpenNodeStatusList[obj];
			deleteRecursiveFromParent(pid);
		}
	}
}
function deleteRecursiveFromParent(pid){
	for(var i=0;i<parentChild.length;i++)
	{
		if(parentChild[i].split('@')[0]==pid){
			var _root = parentChild[i].split('@')[1];
			var _upArray = xOpenNodeStatusList[_root];
			if(_upArray!=null){
				var _xArray = new Array();
				for(var l=0;l<_upArray.length;l++){
					if(_upArray[l]!=pid){
						_xArray.push(_upArray[l]);
					}
				}
			}
			xOpenNodeStatusList[_root]=_xArray;
			break;
		}
	}
}
var widthMinus=0;
function recursiveCheckChild(selected)
{
	for(var i=0;i<parentChild.length;i++)
	{
		if(selected==parentChild[i].split('@')[1])
		{
			var obj;
			if(treeOpenName=='H'){obj='.htree';}
			if(treeOpenName=='V'){obj='.tree';}

			$(obj).find('li [id=V'+parentChild[i].split('@')[0]+']').find("div").each(function(){
				if ($(this).hasClass('minus')) {
					if(jQuery.inArray(parentChild[i].split('@')[0], arr)!=-1)
					{
						for(var s=0;s<nodeWidthArr.length;s++)
						{
							if(nodeWidthArr[s].split('@')[0]==parentChild[i].split('@')[0])
							{
								widthMinus+=parseInt(nodeWidthArr[s].split('@')[1]);
								arr.splice(arr.indexOf(nodeWidthArr[s].split('@')[0]),1);
								recursiveCheckChild(parentChild[i].split('@')[0]);
							}
						}
					}
				}
			});
						
		}
	}
		
}
function recursiveMinusCheck(rootID,minus){
	var list = orgFrameWork.plusMinusStatusList[rootID];
	if(list!=null){
		for(var l=0;l<list.length;l++){
			minus+=xNodeWidth[list[l]];
			minus=recursiveMinusCheck(list[l],minus);
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[list[l]]= actions;
			
		}
	}
	return minus;
}
 function applyTreeWidthMinus()
	{
	 var xMinus = 0;
	 orgFrameWork.setObjectCenter(false);
	 var _arr = orgFrameWork.plusMinusStatusList[selectedParent];
	 if(_arr!=null){
		 if(_arr.length>0){
			 xMinus+=xNodeWidth[selectedParent];
			for(var j=0;j<_arr.length;j++){
				 xMinus=recursiveMinusCheck(_arr[j],xMinus);
				 xMinus+=xNodeWidth[_arr[j]];
				orgFrameWork.updatePlusMinus(parentChild,_arr[j]);
				var actions={previous:false,next:"service"};
				nodeExpCollapseActionContainer[_arr[j]]= actions;
			}
			
		}else{
			xMinus+=xNodeWidth[selectedParent];
			orgFrameWork.updatePlusMinus(parentChild,selectedParent);
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[_arr[j]]= actions;
		}
			 
	 }
	
	// xOpenNode = orgFrameWork.applyRecursiveExpendCollapseRules(xOpenNode,selectedParent,'@'+selectedParent)	; 
	 orgFrameWork.setOrgNodeStatus(selectedParent, true);
	
	$('.htree').width(parseInt($(".htree").width())-parseInt(xMinus));
	$('.tree').width(parseInt($(".tree").width())-parseInt(xMinus));
	selectedTreeViewSizeFactor['V'] = parseInt($(".tree").width());
	selectedTreeViewSizeFactor['H'] = parseInt($(".htree").width());
	
	//timer = setInterval('createBoxTree()', 1000 );
	objectCenter(orgFrameWork.initialRoot);
	orgFrameWork.removeSuggestionContent(selectedParent);
	return ;
}
//on box selected

function resetboxClass()
{
	$(".stree [id^='V'] a").each(function() {	
		$(this).removeClass("active");
		$(this).addClass("reset");
	});
return;
}
function resetDeativeClass()
{
	if(treeOpenName=='V')
	{
		$(".tree [id^='V'] a").each(function() {	
		$(this).removeClass("dcactive");
		$(this).addClass("");
		applyZommEffect(this,scale,"zoom");
		});
	}
	if(treeOpenName=='H')
	{
		$(".htree [id^='V'] a").each(function() {	
		$(this).removeClass("dcactive");
		$(this).addClass("");
		applyZommEffect(this,scale,"zoom");
		});
	}
return;
}

//on mouse over
function showBox(selectId) {
	
	resetClass();
	var objThis=document.getElementById('V'+selectId);
	if(treeOpenName=='V'){
	$(".tree li[id="+objThis+"] a").removeClass("");
	$(".tree li[id="+objThis+"] a[id="+selectId+"]").addClass("active"); 
	}
	if(treeOpenName=='H')
	{
		$(".htree li[id="+objThis+"] a").removeClass("");
		$(".htree li[id="+objThis+"] a[id="+selectId+"]").addClass("active"); 
	}
	if(treeOpenName=='F')
	{
		
	}
	
}
function onaDoubleClickZomm(e,Obj)
{
	beforeDoubleClickZomm=scale;
	if(flagDoubleClick == true)
	{
		if(treeOpenName=='V'){applyZommEffect('.tree',beforeDoubleClickZomm,"zoom");}
		
		if(treeOpenName=='H'){applyZommEffect('.htree',beforeDoubleClickZomm,"zoom");}
		
		flagDoubleClick=false;
	}
	else
	{
			
		if(treeOpenName=='V'){applyZommEffect('.tree',maxScale,"zoom");}
		
		if(treeOpenName=='H'){applyZommEffect('.htree',maxScale,"zoom");}
		
		flagDoubleClick=true;
	}
	objectCenter(Obj.id);
}

function applyZommEffect(divId,scaleZomm,className)
{
	if(treeOpenName=='V'){
		$(divId).css({
		"-moz-transform": "scale("+scaleZomm+")",
		"-webkit-transform": "scale("+scaleZomm+")",
		"-o-transform": "scale("+scaleZomm+")",
		"transform":"scale("+scaleZomm+")",
		"-ms-transform": "scale("+scaleZomm+")"
		});
	  }
	  
	if(treeOpenName=='H'){
	  $(divId).css({
		"-moz-transform": "scale("+scaleZomm+") rotate(270deg)",
		"-webkit-transform": "scale("+scaleZomm+") rotate(270deg)",
		"-o-transform": "scale("+scaleZomm+") rotate(270deg)",
		"transform":"scale("+scaleZomm+") rotate(270deg)",
		"-ms-transform": "scale("+scaleZomm+") rotate(270deg)"
		});
	  }
	}

function objectCenter(ListItem)
{

	if(treeOpenName=='V')
	{
		$(".tree [id='V"+ListItem+"']").find("a[id="+ListItem+"]").each(function()
			{
				if(this.id==ListItem)
				{
					var foo = $(this);
				    var centerDiv=$('#centerDiv').offset();		   
	 				$('.tree').css('left',"0px");
				    $('.tree').css('top',"0px");
				    
				    if(orgFrameWork.getSelectedNodeLevel(selectedParent)==1||orgFrameWork.getSelectedNodeLevel(selectedParent)==null){
				    	$(".tree").css({
							position: "absolute",
							top: Math.round(centerDiv.top)-Math.round(foo.offset().top) + "px",
							left: Math.round(centerDiv.left)-Math.round(foo.offset().left)+ "px"
						}).show();
						$('div.getchildloading').show();
				    }else{
				    	
				    	$(".tree").css({
							position: "absolute",
							top: Math.round(centerDiv.top)-orgFrameWork.calculateLevelScaleFactor(orgFrameWork.getSelectedNodeLevel(selectedParent)) + "px",
							left: Math.round(centerDiv.left)-Math.round(foo.offset().left)+ "px"
						}).show();
						$('div.getchildloading').show();
				    }
					
				}	
		   });
	}
	if(treeOpenName=='H')
	{
		$(".htree [id='V"+ListItem+"']").find("a[id="+ListItem+"]").each(function()
			{
				if(this.id==ListItem)
				{
					var foo = $(this);
				    var centerDiv=$('#centerDiv').offset();		   
	 				$('.htree').css('left',"0px");
				    $('.htree').css('top',"0px");
				 	
					
					if(orgFrameWork.getSelectedNodeLevel(selectedParent)==1||orgFrameWork.getSelectedNodeLevel(selectedParent)==null){
						$(".htree").css({
							position: "absolute",
							top: Math.round(centerDiv.top)-Math.round(foo.offset().top) + "px",
							left: Math.round(centerDiv.left)-Math.round(foo.offset().left)+ "px"
						}).show();			    
					$('div.getchildloading').show();
				    }else{
				    	$(".htree").css({
							position: "absolute",
							top: Math.round(centerDiv.top)-Math.round(foo.offset().top) + "px",
							left: Math.round(centerDiv.left)-(Math.round(foo.offset().left)+orgFrameWork.calculateLevelScaleFactor(orgFrameWork.getSelectedNodeLevel(selectedParent)))+ "px"
						}).show();			    
					$('div.getchildloading').show();
				    
				    }
				}	
		   });
	}
			
}

/*init AutoComplete*/
var finalarraySearch=new Array();
function initAutoComplete()
{
	$("input#searchText").autocomplete({
		width: 300,
		max: 10,
		delay: 100,
		minLength: 1,
		autoFocus: true,
		cacheLength: 1,
		scroll: true,
		highlight: true,
		source: jsonAutoSuggest,
		select: function(event, ui)
		{ 
			finalarrayCSS=new Array();
			var tParentArr = new Array();
			var tParentArrlist = new Array();
			for(var i=0;i<parentChild.length;i++)
           	{
           		var str=parentChild[i].split("@")[1];
           		tParentArr.push(str);
           	}
           	tParentArr=unique(tParentArr);
           	for(var i=0;i<tParentArr.length;i++)
           	{
           		var  arr=new Array();
        		for(var j=0;j<parentChild.length;j++)
        		{
        			if(tParentArr[i]==parentChild[j].split("@")[1])
        			{
        				arr.push(parentChild[j].split("@")[0]);
        			}
        		}
        		tParentArrlist.push(arr);
           	}
           	for(var i=0;i<tParentArr.length;i++)
           	{
           		for(var s=0;s<tParentArrlist[i].length;s++)
           		{
           			finalarrayCSS.push(tParentArr[i]+","+tParentArrlist[i][s]);
           		}
           	}
			resetClass();
			openNodeAfterSearch(ui.item.id);
			searchInChart(ui.item.id);
			searchNodeId = ui.item.id;
			searchCase = true;
			return;
		}
	});
}
function openNodeAfterSearch(liId)
{
	var objThis=liId;	
	var treeContainer;
	
	if(treeOpenName=='V'){treeContainer="#TreeContainer";}
	if(treeOpenName=='H'){treeContainer="#horizontalContainer";}
	
		$(treeContainer).find("a[id="+objThis+"]").find("div").each(function(){
			if(this.id=='plusMinus')
			{
				if($(this).hasClass('plus'))
				{$(this).click();}
				return;				
			}
			else
			{
				var parentId=getParentId(liId);
				openNodeAfterSearch(parentId);			
			}
		});
						
return;
}
function getParentId(ObjId)
{
	for(var d=0;d<finalarrayCSS.length;d++)
    {
    	if(finalarrayCSS[d].split(",")[1]==ObjId)
    	{
			return finalarrayCSS[d].split(",")[0];
		}
	}
	return 0;
}

function applyAutoCompleteCSS(Obj)
{
	resetClass();
	var myLength = Obj.length;
    if(myLength>0)
    {
		for(ob in jsonAutoSuggest){
			var obj = jsonAutoSuggest[ob];
			if (obj.value.toLowerCase().indexOf(Obj.toLowerCase())>=0)
			{
				var tree;
                if(treeOpenName=='V'){tree=".tree";}
                if(treeOpenName=='H'){tree=".htree";}
				var objThis='V'+obj.id;
				$(tree+" li[id="+objThis+"] a").removeClass("");
				$(tree+" li[id="+objThis+"] a[id="+obj.id+"]").addClass("active");
			}
		}	
    }
}

function attachDrag(){
	$('#uidrag').mousemove(function(){
    var coord = $(this).position();
	$('#collapser').animate({top: -(coord.top*2), left: -(coord.left*2)},0);
 });
 
	$('#cloneuidrag').mousemove(function(){
    var coord = $(this).position();
	$('#hdrag').animate({top: -(coord.top*2), left: -(coord.left*2)},0);
 });
 }

/*drag with scrool*/
 function scrollWithdrag(){
 if(treeOpenName=='V'){
	 	$(function() {
	// $('#treecontainer, #firstdrag').dragscrollable({dragSelector: '.dragger', acceptPropagatedEvent: true});
  });
}
     if(treeOpenName=='H'){
	 	$(function() {
	// $('#hdrag').dragscrollable({dragSelector: '.dragger', acceptPropagatedEvent: true});
  });
  }
  }
  
	
function uiDragZeroV(){
    $('#uidrag').css('top',0);
	$('#uidrag').css('left',0);
	$('#uidrag').show();
	$('#cloneuidrag').hide();
	$('#Fuidrag').hide();
	}
function uiDragZeroH(){
    $('#cloneuidrag').css('top',0);
	$('#cloneuidrag').css('left',0);
	$('#uidrag').hide();
	$('#cloneuidrag').show();
	$('#Fuidrag').hide();
	}
function uiDragZeroF(){
    $('#Fuidrag').css('top',0);
	$('#Fuidrag').css('left',0);
	$('#uidrag').hide();
	$('#cloneuidrag').hide();
	$('#Fuidrag').show();
	}
	var openLiCount=0;
function calculateOpenLi()
{
	openLiCount=0;
	var count;
	 if(treeOpenName=="H")
	 {
		count=0;
		$('.htree').find('ul').each(function(){		
			if($(this).css('display') == 'block'){
			count+=$(this).children("li").length;
			}
		
		});
	 }
	  if(treeOpenName=="V")
	  {
		count=0;
		$('.tree').find('ul').each(function(){		
			if($(this).css('display') == 'block'){
			count+=$(this).children("li").length;
			}
		
		});
	  }
	  if(treeOpenName=="F")
	  {
		count=0;
		$('.ftree').find('ul').each(function(){		
			if($(this).css('display') == 'block'){
			count+=$(this).children("li").length;
			}
		});
	  }
	  openLiCount=count;
}


function replaceUderScoreWithAtTheRate(str){
	var newStr='';
	for(var i=0;i<str.length;i++){
		if(str[i]=='_'){
				newStr+='@';
		}else{
			newStr+=str[i];
		}
	}
	// document.getElementById("text").innerHTML="";
   //  document.getElementById("text").innerHTML+='<div>'+newStr+'</div></br>';
	
	return newStr;
}
function boxInformation(name,data){
	var arr = new Array();
	arr = data.split(',');
	var str ='<div id="nodename" style=margin-bottom:1px;margin-left:4px; width:100px;>'+ name +'</div><div id="boxdata">';
	str+='<table id=rdbDataTable style=margin-bottom:2px;margin-left:4px;>';
	var count=1;
	str+='<tr><td id=tdbTableTd><div style="width:105px;">'+arr[1]+'</div></td></tr>';
	str+='<tr><td id=tdbTableTd><div style="width:105px;">'+replaceUderScoreWithAtTheRate(arr[0])+'</div></td></tr>';
	str+='<tr><td id=tdbTableTd><div style="width:105px;">'+arr[2]+'</div></td></tr>';
	str+='<tr><td id=tdbTableTd><div style="width:95px;">'+arr[3]+'</div></td></tr>';
	str+='</table></div>';
	return str;
} 

function getMaxRowCSS(){
 var css='';
 if(maxRows<=4)
 {
  return 'maxrow_4';
 }else{
 	switch(maxRows){
 		case 5:
 			return 'maxrow_5';
 			break;
 		case 6:
 			return 'maxrow_6';
 			break;
 		case 7:
 			return 'maxrow_7';
 			break;
 		case 8:
 			return 'maxrow_8';
 			break;
 		case 9:
 			return 'maxrow_9';
 			break;
 		case 10:
 			return 'maxrow_10';
 			break;
 	}
 }
}

function populateGroupsData(groups){
	var infoCont ='<div>';
	for(g in groups){
		group = groups[g];
		metadata = group.uiEleMetaData;
		uiElement = group.data[0].uiElements;
		groupDesc = group.groupDesc;
		var addinfo='<table width="100%" class="bordered" border="0" cellspacing="0" cellpadding="0">';
		addinfo+='<tr><th colspan=3 style="text-align:left;padding-left:3%;color:black;">'+groupDesc+'</th></tr>';
		addinfo = populateGroupInfo(addinfo,uiElement,metadata);
		addinfo+='</table>';
		infoCont+=addinfo;
	}
	infoCont+='</div>';
	return infoCont;
}
function populateGroupInfo(addinfo,uiElement,metadata){
	for(var i=0;i<metadata.length;i++){
		addinfo+='<tr><td style=width:200px;>'+metadata[i].fieldLabel+'</td>';
		id = metadata[i].uiElementId;
		var val_info='';
		for(var j=0;j<uiElement.length;j++){
			if(uiElement[j].uiElementId==id){
				currValue = uiElement[j].currentValues;
				for(var v=0;v<currValue.length;v++){
					val_info+=currValue[v];
					if(v+1<currValue.length){
						val_info+=',';
					}
				
				}
				break;
			}
			
		}
		addinfo+='<td>:</td>';
		addinfo+='<td style=width:50%;>'+val_info+'</td></tr>';
	}	
	return addinfo;
}
function createToolTip(imageName,objectid){
    var imageSource = '"i4erp/images/'+imageName+'"';
	 changeTooltipPosition = function(event) {
	  var tooltipX = event.pageX - 8;
	  var tooltipY = event.pageY + 8;
	  $('div.tooltip').css({top: tooltipY, left: tooltipX});
	};
 
	var showTooltip = function(event) {
       
	  $('div.tooltip').remove();
	  if(imageName!=""){
	 	 $('<div class="tooltip"><img src='+imageSource+' alt="No Image Found"  width="80" height="95"/><div id="imageId">'+objectid+'</div></div>')
            .appendTo('body');
      //      var ele = document.getElementById("imgUploadButton");
		//ele.style.visibility ="hidden";
       }else{
       //	var ele = document.getElementById("imgUploadButton");
		//ele.style.visibility ="visible";
					
       }
	  changeTooltipPosition(event);
	};
 
	var hideTooltip = function() {
	   $('div.tooltip').remove();
	};
 
	$("span#hint").bind({
	   mousemove : changeTooltipPosition,
	   mouseenter : showTooltip,
	   mouseleave: hideTooltip
	});

}
function createToolTipFromImageString(imageString,objectid){
    var imageSource = "data:image/png;base64,"+imageString;
	 changeTooltipPosition = function(event) {
	  var tooltipX = event.pageX - 8;
	  var tooltipY = event.pageY + 8;
	  $('div.tooltip').css({top: tooltipY, left: tooltipX});
	};
 
	var showTooltip = function(event) {
       
	  $('div.tooltip').remove();
	  if(imageString!=""){
	 	 $('<div class="tooltip"><img src='+imageSource+' alt="No Image Found"  width="80" height="95"/><div id="imageId">'+objectid+'</div></div>')
            .appendTo('body');
     
       }else{
       
					
       }
	  changeTooltipPosition(event);
	};
 
	var hideTooltip = function() {
	   $('div.tooltip').remove();
	};
 
	$("span#hint").bind({
	   mousemove : changeTooltipPosition,
	   mouseenter : showTooltip,
	   mouseleave: hideTooltip
	});

}
function getSelectedOType(sqnr){
    var fields = fieldsobj.fields;
 	for(var obj in fields){
		var objInfo = fields[obj];
		if(objInfo.Seqnr==sqnr){
			objectImagePros.objectid =  objInfo.Objid;
			objectImagePros.otype= objInfo.Otype;
			objectImagePros.short = objInfo.Short;
			return;
		}
	}
	objectImagePros.objectid = "";
	objectImagePros.otype= ""; 
}
function getUploadImageWindow(){
	if(objectImagePros.otype=="" || objectImagePros.objectid==""){
  		alert('One of the node must be selected!');
  		return ;
  	}
  	serverUrl
  	var len = serverUrl.length;
	var l=0;
	var i = len;
	while(i>0){
	 	if(serverUrl[i]=="/"){
			break;
		}
		l+=1;
		i--;
	}
	var newUrl =  serverUrl.substring(0,len-l);
    var url = newUrl +'/iupload?objectid='+ objectImagePros.objectid +'&otype='+ objectImagePros.otype ;
   	imageObjectId = "";
	var imageUploadWindow = window.open(url,'uploadwindow','width ='+ window.innerWidth +',height='+window.innerHeight+',resizeable=no');
	if(window.focus){imageUploadWindow.focus();}
	
	return false;
	
}
function applyCSSMinusToParent(parent)
{
    for(var d=0;d<finalarrayCSS.length;d++)
    {
    	if(finalarrayCSS[d].split(",")[0]==parent)
    	{
			$('#collapser').find('a[id='+finalarrayCSS[d].split(",")[0]+']').find('div').each(function(){	
					if(this.id=='plusMinus')
					{
						if($(this).hasClass('minus')){
							$(this).removeClass('minus').addClass('plus');
							$('#collapser').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('ul').each(function(){
									$(this).css('display','none');					
							});
						}
					}
					
				});
				
				$('#ftree').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('a[id='+finalarrayCSS[d].split(",")[0]+']').each(function(){
		    		if($(this).hasClass('folder_open')){
		    			$(this).removeClass('folder_open').addClass('folder');
		    			$('#ftree').find('li[id=V'+finalarrayCSS[d].split(",")[0]+']').find('ul').each(function(){
		    	 			$(this).css('display','none');
		    	 		});
		    	 	}
		    	 });
		    	 			
				applyCSSMinusToParent(finalarrayCSS[d].split(",")[1]);
        }				  
	}
}
function applyCSSToChildNodeAfterExpend(parent)
{
	
		$('#collapser').find('a[id='+parent+']').find('div').each(function(){
	     	if(this.id=='plusMinus')
			{
				if($(this).hasClass('minus')){
					createBoxTree();
					$(this).removeClass('minus').addClass('plus');
				}
			}
		});
		
	
   		$('#collapser').find('li[id=V'+parent+']').find('ul').each(function(){
			$(this).css('display','none');
						
		});
		
		$('#htree').find('a[id='+parent+']').find('div').each(function(){
	     	if(this.id=='plusMinus')
			{
				if($(this).hasClass('minus')){
					createBoxTree();
					$(this).removeClass('minus').addClass('plus');
					
				}
			}
		});
	
   		$('#htree').find('li[id=V'+parent+']').find('ul').each(function(){
			$(this).css('display','none');
						
		});
		
		$('#ftree').find('a[id='+parent+']').find('a[id='+parent+']').each(function(){
	     		if($(this).hasClass('folder_open')){
					$(this).removeClass('folder_open').addClass('folder');
	     		}
			
		});
		
		$('#ftree').find('li[id=V'+parent+']').find('ul').each(function(){
			$(this).css('display','none');
						
		});
	
}

function restUpdate(thisId,status){

    if(!status){
    	
    	$('#collapser').find('a[id='+thisId+']').find('div').each(function(){
	     	if(this.id=='plusMinus')
			{
				if($(this).hasClass('minus')){
					$(this).removeClass('minus').addClass('plus');
					$('#TreeContainer').find('li[id=V'+thisId+']').find('ul').each(function(){
						$(this).css('display','none');
	
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
						//createBoxTree();
        				applyCSSMinusToParent(selectedParent);	
        				
					});
				}
			}
		});
		
		$('#htree').find('a[id='+thisId+']').find('div').each(function(){
	     	if(this.id=='plusMinus')
			{
				if($(this).hasClass('minus')){
					$(this).removeClass('minus').addClass('plus');
					$('#htree').find('li[id=V'+thisId+']').find('ul').each(function(){
						$(this).css('display','none');
						updateNodeAction(true,thisId);
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
						//createBoxTree();
        				applyCSSMinusToParent(selectedParent);	
        				
					});
				}
			}
		});	
		applyTreeWidthMinus();
		
		if(selectedParent==parentObjectId){
			$('.tree').width(120);
		}
	
		$('#ftree').find('li[id=V'+thisId+']').find('a[id='+thisId+']').each(function(){
		    if($(this).hasClass('folder_open')){
		    	$(this).removeClass('folder_open').addClass('folder');
		    	$('#ftree').find('li[id=V'+thisId+']').find('ul').each(function(){
		    	 	$(this).css('display','none');
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
						
        				applyCSSMinusToParent(selectedParent);	
		    	});
		    }
		 });
		 createBoxTree();
    	
		 var actions={previous:"collapse",next:"service"};
		 nodeExpCollapseActionContainer[thisId]= actions;
		 xOpenNode[thisId]=false;
    }else{
    	    	   	$('#collapser').find('a[id='+thisId+']').find('div').each(function(){
	     	if(this.id=='plusMinus')
			{
				if($(this).hasClass('plus')){
					$(this).removeClass('plus').addClass('minus');
					$('#collapser').find('li[id=V'+thisId+']').find('ul').each(function(){
						$(this).css('display','block');
						finalarrayCSS=new Array();
						var CSSParentList = new Array();
						var CSSParentArr = new Array();
						for(var i=0;i<parentChild.length;i++)
            			{
            				var str=parentChild[i].split("@")[1];
            				if(str==obj){
            					CSSParentArr.push(str);
            				}
            			}
            			CSSParentArr=unique(CSSParentArr);
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
            			for(var i=0;i<CSSParentList.length;i++){
            				arr = CSSParentList[i];
            				for(var j=0;j<arr.length;j++){
            					applyCSSToChildNodeAfterExpend(arr[j]);
            				}
            			}
            			
						//updateNodeAction(true,thisId);
					    
		    			
					});
				}
			//	createBoxTree();
			}
		});
	    
		$('#htree').find('a[id='+thisId+']').find('div').each(function(){
			if(this.id=='plusMinus')
			{
				if($(this).hasClass('plus')){
					$(this).removeClass('plus').addClass('minus');
					$('#htree').find('li[id=V'+thisId+']').find('ul').each(function(){
						$(this).css('display','block');
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
            			CSSParentArr=unique(CSSParentArr);
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
            			for(var i=0;i<CSSParentList.length;i++){
            				arr = CSSParentList[i];
            				for(var j=0;j<arr.length;j++){
            					applyCSSToChildNodeAfterExpend(arr[j]);
            				}
            			}
            						
					});
				}
			}
			
		});
		
		 applyTreeWidthPlus(thisId);
		 $('#ftree').find('li[id=V'+thisId+']').find('a[id='+thisId+']').each(function(){
		    if($(this).hasClass('folder')){
		    	$(this).removeClass('folder').addClass('folder_open');
		    	$('#ftree').find('li[id=V'+thisId+']').find('ul').each(function(){
		    	 	$(this).css('display','block');
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
            			CSSParentArr=unique(CSSParentArr);
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
            			for(var i=0;i<CSSParentList.length;i++){
            				arr = CSSParentList[i];
            				for(var j=0;j<arr.length;j++){
            					applyCSSToChildNodeAfterExpend(arr[j]);
            				}
            			}
		    	});
		    }
		 });
		//}
		createBoxTree();
		var actions={previous:"expend",next:"collapse"};
		 nodeExpCollapseActionContainer[thisId]= actions;
		 xOpenNode[thisId]=true;
	}
}


function createPrintableSelectedNodeInformation(){
   
    //getObjectImageForPrint(objectImagePros.objectid);
	//createCanvas();
	//htmlBasePrintOrg();
}
function htmlBasePrintOrg(){
	
	var  containerWidth;
	var containerHeight;
	var containerId;
	var rootcontainer;
	var data;
	if(treeOpenName=="V")
	{
		popupHeight = parseInt($('#TreeContainer').css('height')); 
		popupWidth = parseInt($('#TreeContainer').css('width')); 
		$('.printtree').html($('#TreeContainer').html());
		svgClass='printtree';
		popUpId='.printtree';
//		$('#collapser').find('a').find('div').each(function(){
//	     if(this.id=='boxdata'){
//			$(this).css('display','none');
//		}
//		});
	}
	else if(treeOpenName=="H")
	{
		popupHeight = parseInt($('#horizontalContainer').css('height')); 
		popupWidth = parseInt($('#horizontalContainer').css('width')); 
		$('.printtree').html($('#horizontalContainer').html());
		svgClass='printtree';
		popUpId='.printtree';
//		$('#htree').find('a').find('div').each(function(){
//	     if(this.id=='boxdata'){
//			$(this).css('display','none');
//		}
//		});
	}
	else if(treeOpenName=="F")
	{
		popupHeight = parseInt($('#folderContainer').css('height')); 
		popupWidth = parseInt($('#folderContainer').css('width')); 
		$('.printftree').html($('#folderContainer').html());
		svgClass='printftree';
		popUpId='.printftree';
//		$('#ftree').find('a').find('div').each(function(){
//	     if(this.id=='boxdata'){
//			$(this).css('display','none');
//		}
//		});
	}
	containerWidth=popupWidth;
	containerHeight=popupHeight;
	var win = window.open('', 'Image', 'resizable=yes,...');
	//alert($('#collapser').html());
	var data= '<div class="printtree" width="'+containerWidth+'" height="'+containerHeight+'>'+
						'<ul id="collasper" style="width:"'+containerWidth+'"px;height:"'+containerHeight+'px;">'+
							$('#collapser').html()+							 
						'</ul>'	+							
					 '</div>';
	
	if(win) {
				
				win.document.writeln('<!DOCTYPE html><html><head><style type="text/css" media="print"> #bg{ display:block; page-break-after:always;}</style>');
				win.document.writeln('<link href="i4erp/css/other.css" rel="stylesheet" type="text/css" media="all" />');
				win.document.writeln('<link href="i4erp/css/print.css" rel="stylesheet" type="text/css" media="all" />');
 				win.document.writeln('<link href="i4erp/css/printnode.css" rel="stylesheet" type="text/css" media="all" />');
				win.document.writeln('</head><body style="background-color:#ffffff;width:100%">');
				
				win.document.writeln(data);							 
				 
                win.document.writeln("</body></html>");
				win.document.close();
				win.focus();
				win.print();
				//win.close();
		}

}
function getObjectImageForPrint(objectImgPros){
    
       	$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=deleteimage&objectid="+imageObjectId,
		dataType: "text" ,
		success: function(obj){  
			getImageFromRootFolderForPrint(objectImgPros);
			imageObjectId= objectImgPros;
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
		}
 	 } ); 
    
}

function getImageFromRootFolderForPrint(objectId){
	$.ajax({
		type:'POST',
        url: serverUrl,
		data:"action=getimage&objectid="+objectId,
		dataType: "text" ,
		success: function(imageName){  
						
			var win = window.open('', 'Image', 'resizable=no,width:650,..');
        	if (win) {
				win.document.writeln('<!DOCTYPE html><html><head>');
				win.document.writeln('</head><body style="background-color:#E0ECF8;">');
                win.document.writeln('<div id="bg" class="bg"></div>');
                win.document.writeln('<div id="objimg" class="objimg"></div>');
				win.document.writeln("</body></html>");
				
               win.document.getElementById("objimg").innerHTML = '<div><img id="pic" src="i4erp/images/icon.png" width="50" height="50" /></div><div><img id="objpic" src="i4erp/images/'+imageName+'" width="80" height="90" /></div>';
                  
                  win.document.close();
           
                var ele =win.document.getElementById("bg");
                var printCanvas = win.document.createElement('canvas');
				printCanvas.setAttribute("id", "canvas");
				ele.appendChild(printCanvas);
				var canvas = win.document.getElementById('canvas');
				initializePrintCanvas(canvas,win);
				win.focus();
				win.print();
				//deleleObjectImage(objectId);
				win.close();
				
        	}
				
			
		},
		error: function(XMLHttpRequest, textStatus,errorThrown){
			initializePrintCanvas(canvas,null,win);
		}
 	}); 
}

function ShowMenu(e,sqNo,objectId) {
	if(orgFrameWork.getSelectedAppVersion()==0){
		return;
	}
	if(orgFrameWork.isDrag()){return false;}
	orgFrameWork.setContextMenuStatus(true);
	if(sqNo!=null){
		orgFrameWork.setRootSqNo(sqNo);
	}
	if(objectId!=null){
		orgFrameWork.setObjectId(objectId);
	}
	if(sqNo==orgFrameWork.initialRoot){
		if(!orgFrameWork.getMovePasteStatus()){
			var json=[{id:"create",enabled:true,action:"create",text:"Create Node"},
			          {id:"move",enabled:false,action:"move",text:"Move Node"},
			          {id:"mpaste",enabled:false,action:"move-paste",text:"Move Paste"},
			          {id:"delete",enabled:false,action:"delete",text:"Delete Node"}		
			];
			orgFrameWork.setContextMenuItems(json);
			
		}
		
	}else{
		if(!orgFrameWork.getMovePasteStatus()){
			var json=[{id:"create",enabled:true,action:"create",text:"Create Node"},
			          {id:"move",enabled:true,action:"move",text:"Move Node"},
			          {id:"mpaste",enabled:false,action:"move-paste",text:"Move Paste"},
			          {id:"delete",enabled:false,action:"delete",text:"Delete Node"}		
			];
			orgFrameWork.setContextMenuItems(json);
		}
		
	}
	var uiMessage = new UIMessage();
	
	uiMessage.contextMenu(orgFrameWork.getContextMenuItems(), e);

			 
    return ;
}
function HideMenu() {
	orgFrameWork.setContextMenuStatus(false);
	var uiMessage = new UIMessage();
	uiMessage.destroyContextMenu();
}
function showMessage(){
	$('#orgMessageBar').removeClass('orgMessageBarClose').addClass('orgMessageBarOpen');
	setTimeout(hideOrgMessage,6000);
	
}
function hideOrgMessage(){
	$('#orgMessageBar').removeClass('orgMessageBarOpen').addClass('orgMessageBarClose');
}
function doAction(para,sqn){
	switch(para){
	case 'more-navigation':
		var left= $('#more-nav').css('margin-top');
		alert(left);
		break;
	case 'move':
		orgFrameWork.setMovePasteStatus(true);
		orgFrameWork.setContextMenuPasteStatus(true);
		orgFrameWork.setSelectedMoveNodeSqNo(orgFrameWork.getRootSqNo());
		var uiMessage = new UIMessage();
		var json=[{id:"create",enabled:false,action:"create",text:"Create Node"},
		          {id:"move",enabled:false,action:"move",text:"Move Node"},
		          {id:"mpaste",enabled:true,action:"move-paste",text:"Move Paste"},
		          {id:"delete",enabled:false,action:"delete",text:"Delete Node"}		
		];
		orgFrameWork.setContextMenuItems(json);
		uiMessage.destroyContextMenu();
		 $('#collapser').find('a[id='+orgFrameWork.getRootSqNo()+']').find('div').each(function(){
			 if($(this).hasClass("block")){
					$(this).css('border-style','dotted');
				
				}
			});
		 var tree;
         if(treeOpenName=='V'){tree=".tree";}
         if(treeOpenName=='H'){tree=".htree";}
			var objThis='V'+orgFrameWork.getRootSqNo();
			$(tree+" li[id="+objThis+"] a").removeClass("");
			$(tree+" li[id="+objThis+"] a[id="+orgFrameWork.getRootSqNo()+"]").addClass("active");
			var uiMessage = new UIMessage();
			uiMessage.dragAlertMessage({text:"Node:{"+orgFrameWork.getRootObjectId(parentChild, orgFrameWork.getRootSqNo())+"} is copy for move !",label:"Cancel",action:"CANCEL-COPY-ACTION"});


		break;
	case 'filter-date':
		   var dt = document.getElementById("filter-dt-text").value;
		   var dtType = orgFrameWork.converStringToDateFormat(dt);
		   orgFrameWork.setOrgKeyDate(dtType);
		    selectedParent=orgFrameWork.initialRoot;
			selectedNodeIdForCSS = orgFrameWork.initialRoot;
			getSelectedOType(orgFrameWork.initialRoot);
			var actions={previous:false,next:"collapse"};
			nodeExpCollapseActionContainer[orgFrameWork.initialRoot]= actions;
			setSelectedId(orgFrameWork.initialRoot);
			
			var actions={previous:false,next:"service"};
			nodeExpCollapseActionContainer[orgFrameWork.initialRoot]= actions;
			setSelectedId(orgFrameWork.initialRoot);
		
		break;
	case 'move-approve':
		debugger;
		var uiMessage = new UIMessage();
		orgFrameWork.assignApprovedInfoToMoveNode(orgFrameWork.getMoveChildInformation());
		orgFrameWork.doMoveNodeAction( orgFrameWork.getSelectedMoveNodeSqNo(),orgFrameWork.getRootSqNo());
		orgFrameWork.setMovePasteStatus(false);
		orgFrameWork.setDraggableNodeMove({isMove:false,sqnNo:null,objectId:null});
		var props = orgFrameWork.getDraggalbeProperties();
		props.status=false;
		orgFrameWork.setDraggalbeProperties(props);
		uiMessage.removeJSONForm();
		uiMessage.removeAlertMessage();
		break;
	case 'move-paste':
		if(orgFrameWork.getMovePasteStatus()){
			if(orgFrameWork.isNotMoveNodeSqNoIsInitailSqNo(orgFrameWork.getSelectedMoveNodeSqNo())&& orgFrameWork.isNotMoveNodeMoveToItsChilds(orgFrameWork.getRootSqNo(), orgFrameWork.getSelectedMoveNodeSqNo())){
				orgFrameWork.setMovePasteStatus(false);
				orgFrameWork.setContextMenuPasteStatus(true);
				var mChild = orgFrameWork.getMoveChildInfo( orgFrameWork.getSelectedMoveNodeSqNo(),orgFrameWork.getRootSqNo());		
				orgFrameWork.setMoveChildInfo(mChild);
				orgFrameWork.approveObjectDataBeforeMoveConfirm(mChild);
				var uiMessage = new UIMessage();
				uiMessage.removeDragMessage();
			}
			else{
				
				var uiMessage = new UIMessage();
				uiMessage.dragAlertMessage({text:"The parent root node can't be moved its own hierarchy level",label:"Cancel",action:"CANCEL-COPY-ACTION"});


			}
		}
		var json=[{id:"create",enabled:true,action:"create",text:"Create Node"},
		          {id:"move",enabled:true,action:"move",text:"Move Node"},
		          {id:"mpaste",enabled:false,action:"move-paste",text:"Move Paste"},
		          {id:"delete",enabled:false,action:"delete",text:"Delete Node"}		
		];
		orgFrameWork.setContextMenuItems(json);
		var uiMessage = new UIMessage();
		uiMessage.destroyContextMenu();
		orgFrameWork.resetFormElement();
		break;
	case 'context-menu-state':
		orgFrameWork.setContextMenuVisiblity(true);
		break;
	case 'hide-context-menu':
		var uiMessage = new UIMessage();
		uiMessage.destroyContextMenu();
			//document.getElementById("contentMenus").style.display = 'none'; 
		
		
		
		break;
	case 'type-selection':
		
		break;
	case 'create':
		if(!orgFrameWork.getMovePasteStatus())
		var uiMessage = new UIMessage();
		uiMessage.destroyContextMenu();
		if(orgFrameWork.getOrgNodeStatus(orgFrameWork.getRootSqNo())==null){
			if(!orgFrameWork.checkChildsForContextMenu(parentChild, orgFrameWork.getRootSqNo())){
				orgFrameWork.updateObjectSqNo();
				orgFrameWork.setFormJson(createEmptyFormTemplate());
				uiMessage.JSONForm(orgFrameWork.getFormJson(),{action:"create-save",label:"Create"});
				return;
			}else{
				uiMessage.ShowAlertMessage({text:"Node must be expended first. do you want to expend it?",action:"expend"});
				return;
			}
		}
		if(orgFrameWork.checkChildsForContextMenu(parentChild, orgFrameWork.getRootSqNo())){
			if(orgFrameWork.getOrgNodeStatus(orgFrameWork.getRootSqNo())==false){
				
				orgFrameWork.updateObjectSqNo();
				orgFrameWork.setFormJson(createEmptyFormTemplate());
				uiMessage.JSONForm(orgFrameWork.getFormJson(),{action:"create-save",label:"Create"});
				return;
			}else{
				uiMessage.ShowAlertMessage("Node must be expended first. do you want to expend it?");
				return;
			}
		}
		
		
		break;
	case 'exit':
		var uiMessage = new UIMessage();
		uiMessage.removeJSONForm();
		break;
	case 'org-home':
		$("#orgNavigation").css('display','none');
		$(".orgVersionDiv").css('display','none');
		var items=[{id:"menu-bar-home",isActive:true,action:"org-home",view:"org-home" ,tooltip:"Home",text:"Home"},
		           {id:"menu-bar-midcontain",isActive:false,action:"org-midcontain",view:"midcontain" ,tooltip:"Organizational Chart",text:"Org Chart"},
		           {id:"menu-bar-reports",isActive:false,action:"org-reports",view:"org-reports", tooltip:"Reports",text:"Reports"}];
		orgFrameWork.setMenuBarItems(items);
		var uiMessage = new UIMessage();
		uiMessage.destroyMenuBarItems();
		uiMessage.generateMenuBarItems(orgFrameWork.getMenuBarItems());
		break;
	case 'org-midcontain':
		$("#orgNavigation").css('display','block');
		$(".orgVersionDiv").css('display','block');
		var items=[{id:"menu-bar-home",isActive:false,action:"org-home",view:"org-home" ,tooltip:"Home",text:"Home"},
		           {id:"menu-bar-midcontain",isActive:true,action:"org-midcontain",view:"midcontain" ,tooltip:"Organizational Chart",text:"Org Chart"},
		           {id:"menu-bar-reports",isActive:false,action:"org-reports",view:"org-reports", tooltip:"Reports",text:"Reports"}];
		orgFrameWork.setMenuBarItems(items);
		var uiMessage = new UIMessage();
		uiMessage.destroyMenuBarItems();
		uiMessage.generateMenuBarItems(orgFrameWork.getMenuBarItems());
		break;
	case 'org-reports':
		$("#orgNavigation").css('display','none');
		$(".orgVersionDiv").css('display','none');
		var items=[{id:"menu-bar-home",isActive:false,action:"org-home",view:"org-home" ,tooltip:"Home",text:"Home"},
		           {id:"menu-bar-midcontain",isActive:false,action:"org-midcontain",view:"midcontain" ,tooltip:"Organizational Chart",text:"Org Chart"},
		           {id:"menu-bar-reports",isActive:true,action:"org-reports",view:"org-reports", tooltip:"Reports",text:"Reports"}];
		orgFrameWork.setMenuBarItems(items);
		var uiMessage = new UIMessage();
		uiMessage.destroyMenuBarItems();
		uiMessage.generateMenuBarItems(orgFrameWork.getMenuBarItems());
		break;
	case 'create-save':
		orgFrameWork.createSaveNode();
		break;
	}
	
	HideMenu();
}
function doOrgNavigation(navTo){
	switch(navTo){
	case 'up':
		orgFrameWork.setMousePress(false);
		break;
	case 'right':
			$('#TreeContainer').css('left',parseInt($('#TreeContainer').css('left'))+orgFrameWork.getOrgNavigationFactor());
			$('#horizontalContainer').css('left',parseInt($('#TreeContainer').css('left'))+orgFrameWork.getOrgNavigationFactor());
		break;
	case 'left':
		$('#TreeContainer').css('left',parseInt($('#TreeContainer').css('left'))-orgFrameWork.getOrgNavigationFactor());
		$('#horizontalContainer').css('left',parseInt($('#TreeContainer').css('left'))-orgFrameWork.getOrgNavigationFactor());
		break;
	case 'top':
		 $('#TreeContainer').css('top',parseInt($('#TreeContainer').css('top'))-orgFrameWork.getOrgNavigationFactor());
		 $('#horizontalContainer').css('top',parseInt($('#TreeContainer').css('top'))-orgFrameWork.getOrgNavigationFactor());
		break;
	case 'bottom':
		 $('#TreeContainer').css('top',parseInt($('#TreeContainer').css('top'))+orgFrameWork.getOrgNavigationFactor());
		 $('#horizontalContainer').css('top',parseInt($('#TreeContainer').css('top'))+orgFrameWork.getOrgNavigationFactor());
		break;
	}
}
function doSelection(evt){
	var fjson = orgFrameWork.getFormJson();
	if(evt.selectedIndex==1){
			
			for(var f in fjson){
				if(fjson[f].type=="checkbox"){
					fjson[f].visible=true;
					break;
				}
			}
	}else{
		for(var f in fjson){
			if(fjson[f].type=="checkbox"){
				fjson[f].visible=false;
				break;
			}
		}
		
		
	}
	for(var j in fjson){
		if(fjson[j].type=="select"){
			var items = fjson[j].items;
			for(var i=0;i<items.length;i++){
				if(evt.selectedIndex==i){
					items[i].selected=true;
				}else{
					items[i].selected=false;
				}
			}
			fjson[j].items = items;
			break;
		}
	}
	var uiMessage = new UIMessage();
	uiMessage.removeJSONForm();
	uiMessage.JSONForm(fjson,{action:"create-save",label:"Create"});
	
	//uiMessage.JSONForm(fjson,"create-save",);
	
}
function doAlertAction(choice){
	//alert(choice);
	var uiMessage = new UIMessage();
	switch(choice){
	case "expend":
		uiMessage.removeAlertMessage();
		orgFrameWork.getRootSqNo();
		orgFrameWork.setContextMenuStatus(false);
		var actions={previous:false,next:"service"};
		nodeExpCollapseActionContainer[orgFrameWork.getRootSqNo()]= actions;
		setSelectedId(orgFrameWork.getRootSqNo());
		
		break;
	case "hide":
		orgFrameWork.setIsMoveApprove(false);
		uiMessage.removeAlertMessage();
		break;
	case "CANCEL-COPY-ACTION":
		orgFrameWork.setMovePasteStatus(false);
		orgFrameWork.setContextMenuPasteStatus(false);
		//orgFrameWork.setSelectedMoveNodeSqNo(orgFrameWork.getRootSqNo());
		var uiMessage = new UIMessage();
		var json=[{id:"create",enabled:true,action:"create",text:"Create Node"},
		          {id:"move",enabled:true,action:"move",text:"Move Node"},
		          {id:"mpaste",enabled:false,action:"move-paste",text:"Move Paste"},
		          {id:"delete",enabled:false,action:"delete",text:"Delete Node"}		
		];
		orgFrameWork.setContextMenuItems(json);
		uiMessage.destroyContextMenu();
		 $('#collapser').find('a[id='+orgFrameWork.getRootSqNo()+']').find('div').each(function(){
			 if($(this).hasClass("block")){
					$(this).css('border-style','none');
				
				}
			});
		 var tree;
         if(treeOpenName=='V'){tree=".tree";}
         if(treeOpenName=='H'){tree=".htree";}
			var objThis='V'+orgFrameWork.getRootSqNo();
			$(tree+" li[id="+objThis+"] a").removeClass("active");
			uiMessage.removeDragMessage();
		break;
	case "HIDE-DRAG-DROP-MESSAGE":
		uiMessage.removeDragMessage();
		break;
	case "CANCEL-DRAG-DROP-ACTION":
		var props = orgFrameWork.getDraggalbeProperties();
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
				orgFrameWork.setDraggalbeProperties(props);
				orgFrameWork.setIsDragStatus(false);
				uiMessage.removeDragMessage();
				orgFrameWork.resetFormElement();
		break;
	}
};
function versionSelect(evt){
	debugger;
	orgFrameWork.setSelectedAppVersion(evt.selectedIndex);
	setSelectedId(orgFrameWork.initialRoot);
	orgFrameWork.setBoxTreeStatus(false);
	    selectedParent=orgFrameWork.initialRoot;
		selectedNodeIdForCSS = orgFrameWork.initialRoot;
		getSelectedOType(orgFrameWork.initialRoot);
		var actions={previous:false,next:"collapse"};
		nodeExpCollapseActionContainer[orgFrameWork.initialRoot]= actions;
		setSelectedId(orgFrameWork.initialRoot);
		
		var actions={previous:false,next:"service"};
		nodeExpCollapseActionContainer[orgFrameWork.initialRoot]= actions;
		setSelectedId(orgFrameWork.initialRoot);
}
function createEmptyFormTemplate(){
	return [{ id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ID,label:"ID",type:"input",value:"",placeholder:"Enter  Id",width:"150px",visible:true,readonly:"readonly"},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_TYPE,label:"Type",type:"select",value:"",placeholder:"",width:"",items:[{text:'O', selected:true},{text:'S',selected:false},{text:'P',selected:false}],visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_IS_CHIEF,label:"Is Chief",type:"checkbox",isChecked:"",visible:false,width:"150px",readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_NAME,label:"Name",type:"input",value:"",placeholder:"Enter  Name",width:"150px",visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_EMAIL_ADDRESS,label:"Email Address",type:"input",value:"",placeholder:"Enter email address",width:"300px",visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_CITY,label:"City",type:"input",value:"",placeholder:"Enter city",width:"400px",visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ADDRESS,label:"Address",type:"input",value:"",placeholder:"Enter address",width:"400px",visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_BEGDA,label:"Begin Date",type:"input",value:"",placeholder:"Begin date",width:"100px",visible:true,readonly:""},
				           {id:orgFrameWork.uiConstant._ELE_ID_FORM_OBJECT_ENDDA,label:"End Date",type:"input",value:"",placeholder:"End date",width:"100px",visible:true,readonly:""},
						   ];

}
