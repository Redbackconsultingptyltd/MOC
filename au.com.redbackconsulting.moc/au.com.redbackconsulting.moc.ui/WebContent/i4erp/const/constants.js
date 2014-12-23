
function RdbConstant(){
	this.TAB_OBJECT_INFO ="objectinfo";
	this.POPUP_HIER_ACTION="hierdata";
	this.POPUP_ADDINFO_ACTION ="addinfo";
	this.POPUP_MAP_ACTION = "map";
	this.POPUP_FILTER_HIER_ACTION="filterhier";
	this.HIER_PANEL_WIDTH=250;
	this.LOADING_IMAGE_WIDTH=150;
	this.LOADING_IMAGE_HEIGHT=150;
	this.TAB_ADD_INFO="addinfo";
	this.ACTION_EDIT="edit";
	this.ACTION_DELETE="delete";
	this.ACTION_CREATE="create";
	this.ACTION_GLOBAL_CANCEL="finalcancel";
	this.ACTION_GLOBAL_EDIT_TOGGLE="finalsave";
	this.ACTION_SAVE="save";
	this.tabs={addinfo:'Additional Information',objectinfo:'Object Information'};
	this.getTabsHeading = function(tName){
		for(obj in this.tabs){
			if(tName==obj){
				return this.tabs[obj];
			}
		}

	}
}
	
	
	

