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

import org.apache.olingo.odata2.api.edm.EdmEntitySet;

import au.com.redbackconsulting.moc.odata.api.Constants;

public class BLModelFactory implements IBLModelFactory {

	public BLModelFactory() {
		// TODO Auto-generated constructor stub
	}

	public static BLModelFactory getInstance() {
		return new BLModelFactory();
	}

	public IBLModel getInstance(int entityType) {

		switch (entityType) {
		case ENTITY_KEY_CASYSTEM:
			return new CaSystemsBL(this);
		case ENTITY_KEY_HRHIER:
			return new HrHierBL(this);
		case ENTITY_KEY_HRHIERMAP:
			return new HrHierMapBL(this);
		case ENTITY_KEY_HROBJECTS:
			return new HrObjectsBL(this);
		case ENTITY_KEY_HROBJECTSCONSTRAINTS:
			return new HrObjectsConstraintsBL(this);
		case ENTITY_KEY_HROBJECTSREL:
			return new HrObjectsRelBL(this);
		case ENTITY_KEY_HROBJECTSSTATUS:
			return new HrObjectsStatusBL(this);
		case ENTITY_KEY_HRP1000:
			return new HRP1000BL(this);
//		case ENTITY_KEY_HRP1001:
//			return new HRP1001BL(this);
		case ENTITY_KEY_HRRELATIONS:
			return new HrRelationsBL(this);
		case ENTITY_KEY_TENANTS:
			return new TenantsBL(this);

		}
		return null;
	}
	
	public IBLModel getInstance1(EdmEntitySet entitySet) {
		try {
			
		
		String name = entitySet.getName();
		if (Constants.ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_CASYSTEM);
		}else if (Constants.ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HRHIER);
		}else if (Constants.ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HRHIERMAP);
		}else if (Constants.ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HROBJECTSREL);
		}else if (Constants.ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HROBJECTS);
		}else if (Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
		}else if (Constants.ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HROBJECTSSTATUS);
		}else if (Constants.ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HRP1000);
		}else if (Constants.ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HRP1001);
		}else if (Constants.ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_HRRELATIONS);
		}else if (Constants.ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
			
			return getInstance(ENTITY_KEY_TENANTS);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return null;
	}
}
