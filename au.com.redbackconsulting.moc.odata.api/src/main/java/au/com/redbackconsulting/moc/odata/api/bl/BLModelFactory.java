package au.com.redbackconsulting.moc.odata.api.bl;

import au.com.redbackconsulting.moc.odata.api.IMyEdmProvider;
import au.com.redbackconsulting.moc.odata.api.MyEdmProvider;
import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import  static  au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM.ENTITY_SET_NAME_HRHIERMAP;
public class BLModelFactory {

 static	final String CaSystem = CaSystemEDM.ENTITY_SET_NAME_CASYSTEM;
	
	public BLModelFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static BLModelFactory getInstance() {
		return new BLModelFactory();
	}
	
	public IBLModel getInstance (int entityType){
  final	int caSystem =1;// CaSystemEDM.ENTITY_SET_NAME_CASYSTEM;
		switch (entityType) {
		case IMyEdmProvider.ENTITY_KEY_CASYSTEM :
			return new CaSystemsBL();
			 

		case IMyEdmProvider.ENTITY_KEY_HRHIER :
			return new HrHierBL();
			 
case IMyEdmProvider.ENTITY_KEY_HRHIERMAP :
			
		return new HrHierMapBL();	
case IMyEdmProvider.ENTITY_KEY_HROBJECTS :
	return new HrObjectsBL();
case IMyEdmProvider.ENTITY_KEY_HROBJECTSCONSTRAINTS :
	return new HrObjectsConstraintsBL();
case IMyEdmProvider.ENTITY_KEY_HROBJECTSREL :
	return new HrObjectsRelBL();
case IMyEdmProvider.ENTITY_KEY_HROBJECTSSTATUS :
	
	return new HrObjectsStatusBL();
	
case IMyEdmProvider.ENTITY_KEY_HRP1000 :
	
	return new HRP1000BL();
case IMyEdmProvider.ENTITY_KEY_HRP1001 :
	return new HRP1001BL();
case IMyEdmProvider.ENTITY_KEY_HRRELATIONS :
	
	return new HrRelationsBL();
case IMyEdmProvider.ENTITY_KEY_TENANTS :
	
	return new TenantsBL();
			
	 
		}
		return null;
	}
}
