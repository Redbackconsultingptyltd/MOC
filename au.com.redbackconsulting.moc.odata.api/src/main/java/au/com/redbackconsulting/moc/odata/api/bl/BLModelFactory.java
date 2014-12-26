package au.com.redbackconsulting.moc.odata.api.bl;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
 

public class BLModelFactory implements IBLModelFactory {

	
	public BLModelFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static BLModelFactory getInstance() {
		return new BLModelFactory();
	}
	
	public IBLModel getInstance (int entityType){
  final	int caSystem =1;// CaSystemEDM.ENTITY_SET_NAME_CASYSTEM;
		switch (entityType) {
		case  ENTITY_KEY_CASYSTEM :
			return new CaSystemsBL(this);
			 

		case ENTITY_KEY_HRHIER :
			return new HrHierBL(this);
			 
case ENTITY_KEY_HRHIERMAP :
			
		return new HrHierMapBL(this);	
case ENTITY_KEY_HROBJECTS :
	return new HrObjectsBL(this);
case ENTITY_KEY_HROBJECTSCONSTRAINTS :
	return new HrObjectsConstraintsBL(this);
case ENTITY_KEY_HROBJECTSREL :
	return new HrObjectsRelBL(this);
case ENTITY_KEY_HROBJECTSSTATUS :
	
	return new HrObjectsStatusBL(this);
	
case ENTITY_KEY_HRP1000 :
	
	return new HRP1000BL(this);
case ENTITY_KEY_HRP1001 :
	return new HRP1001BL(this);
case ENTITY_KEY_HRRELATIONS :
	
	return new HrRelationsBL(this);
case ENTITY_KEY_TENANTS :
	
	return new TenantsBL(this);
			
	 
		}
		return null;
	}
}
