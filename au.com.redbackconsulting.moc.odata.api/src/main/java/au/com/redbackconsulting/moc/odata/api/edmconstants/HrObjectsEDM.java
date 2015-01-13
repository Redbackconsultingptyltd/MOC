package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_CASYSTEM;


import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1001;



public class HrObjectsEDM  extends BaseEDM{
	public HrObjectsEDM(String namespace , String entity_type_name, String entity_set_name, EntityTypeFactory factory  ) {
		super(namespace,  entity_type_name,   entity_set_name, factory);
		// TODO Auto-generated constructor stub
	}

	public static String  tenantId="tenantId";
	public static String  objectType="objectType";
	public static String  systId ="systId";
	public static String  sObjectType ="sObjectType";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.objectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.systId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.sObjectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectsEDM.tenantId));
		 keyProperties.add(new PropertyRef().setName(HrObjectsEDM.systId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
//		if(relatedEntity.getName().equals(CaSystemEDM.ENTITY_TYPE_NAME_CASYSTEM)){
//		    return new Association().setName(CaSystemEDM.ASSOCIATION_CASYSTEM_TENANT)
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(CaSystemEDM.ROLE_1_2).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(CaSystemEDM.ROLE_2_1).setMultiplicity(EdmMultiplicity.ONE));
//	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
		// TODO Auto-generated method stub
		return null;
	}
	 
 
}
