package au.com.redbackconsulting.moc.odata.api.edmconstants;

import org.apache.olingo.odata2.api.edm.provider.EntityType;

import au.com.redbackconsulting.moc.odata.api.MyEdmProvider;

public class EntityTypeFactory {
	
	private String namespace =null;
	 
	private EntityTypeFactory(String namespace){
		this.namespace=namespace;
	}
	
	public static EntityTypeFactory getInstance (String namespace){
		
		return new EntityTypeFactory(namespace);
	}

	public BaseEDM getEDM (int entity_name){
		
		switch (entity_name) {
		case MyEdmProvider.ENTITY_KEY_CASYSTEM:
			return new CaSystemEDM(this.namespace) ;
 
		case MyEdmProvider.ENTITY_KEY_HRHIER:
			return new HrHierEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HRHIERMAP:
			return new HrHierMapEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HROBJECTSREL:
			return new HrObjectRelEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HROBJECTSCONSTRAINTS:
			return new HrObjectsConstraintsEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HROBJECTS:
			return new HrObjectsEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HROBJECTSSTATUS:
			return new HrObjectsStatusEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HRP1000:
			return new HRP1000EDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HRP1001:
			return new HRP1001EDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_HRRELATIONS:
			return new HrRelationsEDM(this.namespace);
		case MyEdmProvider.ENTITY_KEY_TENANTS:
			return new TenantsEDM(this.namespace);
 

		default:
			break;
		}
		return null;
	}
}
