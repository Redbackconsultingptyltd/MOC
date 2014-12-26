package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.HashMap;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.provider.EntityType;

import au.com.redbackconsulting.moc.odata.api.MyEdmProvider;
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

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRRELATIONS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;





public class EntityTypeFactory {
	
	private String namespace =null;
	private Map<String, BaseEDM> edms = new HashMap<String, BaseEDM>();
	 
	private EntityTypeFactory(String namespace){
		this.namespace=namespace;
	}
	
	public static EntityTypeFactory getInstance (String namespace){
		
		return new EntityTypeFactory(namespace);
	}

	public BaseEDM getEDM (int entity_Key_name){
		
		switch (entity_Key_name) {
		case ENTITY_KEY_CASYSTEM:
			
			return  getEDMInstance(ENTITY_KEY_CASYSTEM, ENTITY_TYPE_NAME_CASYSTEM, ENTITY_SET_NAME_CASYSTEM);//new CaSystemEDM(this.namespace) ;
 
		case ENTITY_KEY_HRHIER:
			return getEDMInstance(ENTITY_KEY_HRHIER, ENTITY_TYPE_NAME_HRHIER, ENTITY_SET_NAME_HRHIER);
	
		case ENTITY_KEY_HRHIERMAP:
			return 		getEDMInstance(ENTITY_KEY_HRHIERMAP , ENTITY_TYPE_NAME_HRHIERMAP, ENTITY_SET_NAME_HRHIERMAP  );
		case ENTITY_KEY_HROBJECTSREL:
			return 		getEDMInstance(ENTITY_KEY_HROBJECTSREL , ENTITY_TYPE_NAME_HROBJECTREL , ENTITY_SET_NAME_HROBJECTREL );
		case ENTITY_KEY_HROBJECTSCONSTRAINTS:
			return 		getEDMInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS , ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS , ENTITY_SET_NAME_HROBJECTSCONSTRAINTS );
		case ENTITY_KEY_HROBJECTS:
			return 		getEDMInstance(ENTITY_KEY_HROBJECTS , ENTITY_TYPE_NAME_HROBJECTS, ENTITY_SET_NAME_HROBJECTS  );
		case ENTITY_KEY_HROBJECTSSTATUS:
			return 		getEDMInstance(ENTITY_KEY_HROBJECTSSTATUS , ENTITY_TYPE_NAME_HROBJECTSSTATUS , ENTITY_SET_NAME_HROBJECTSSTATUS);
		case ENTITY_KEY_HRP1000:
			return 		getEDMInstance(ENTITY_KEY_HRP1000 , ENTITY_TYPE_NAME_HRP1000 , ENTITY_SET_NAME_HRP1000 );
		case ENTITY_KEY_HRP1001:
			return 		getEDMInstance(ENTITY_KEY_HRP1001 , ENTITY_TYPE_NAME_HRP1001,  ENTITY_SET_NAME_HRP1001 );
		case ENTITY_KEY_HRRELATIONS:
			return 		getEDMInstance(ENTITY_KEY_HRRELATIONS , ENTITY_TYPE_NAME_HRRELATIONS , ENTITY_SET_NAME_HRRELATIONS);
		case ENTITY_KEY_TENANTS:
			return 		getEDMInstance(ENTITY_KEY_TENANTS , ENTITY_TYPE_NAME_TENANTS , ENTITY_SET_NAME_TENANTS  );
 

		default:
			break;
		}
		return null;
	}
	
	private BaseEDM getEDMInstance(int entity_Key, String entity_type_name, String entity_set_name ){
		BaseEDM edm =edms.get(entity_type_name);
		if (edm==null){
		switch (entity_Key) {
		case ENTITY_KEY_CASYSTEM:
			
			 edm =  new CaSystemEDM(this.namespace) ;
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HRHIER:
			edm= new HrHierEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HRHIERMAP:
			edm= new HrHierMapEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HROBJECTSREL:
			edm= new HrObjectRelEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HROBJECTSCONSTRAINTS:
			edm= new HrObjectsConstraintsEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HROBJECTS:
			edm= new HrObjectsEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HROBJECTSSTATUS:
			edm= new HrObjectsStatusEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HRP1000:
			edm= new HRP1000EDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HRP1001:
			edm= new HRP1001EDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_HRRELATIONS:
			edm= new HrRelationsEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
		case ENTITY_KEY_TENANTS:
			edm= new TenantsEDM(this.namespace);
			 edms.put(entity_type_name, edm);
			 return edm;
 

		
		}

		}
		return null;
	}
}
