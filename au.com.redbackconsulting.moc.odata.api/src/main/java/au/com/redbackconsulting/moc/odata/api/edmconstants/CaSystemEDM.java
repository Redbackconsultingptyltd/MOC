package au.com.redbackconsulting.moc.odata.api.edmconstants;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.AssociationSetEnd;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_CASYSTEM_TENANT;




import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_CASYSTEM_TENANT;


import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;
 



public class CaSystemEDM extends BaseEDM {
	
	public static String SYSID ="sysId";
	public static String TENANTID="tenantId";
	public static String SYSDESC="sysDesc";
 
	
	
	
	public CaSystemEDM(String nameSpace, String entity_type_name, String entity_set_name, EntityTypeFactory factory){
		super(nameSpace, entity_type_name, entity_set_name, factory);
	//	entitySetName=CaSystemEDM.ENTITY_SET_NAME;
		
		
	}


	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(CaSystemEDM.SYSID).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(CaSystemEDM.TENANTID).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(CaSystemEDM.SYSDESC).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}


	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(CaSystemEDM.SYSID));
		  keyProperties.add(new PropertyRef().setName(CaSystemEDM.TENANTID));
		return keyProperties;
	}
	
	@Override
	public List<NavigationProperty> getNavigations() {
		
		List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_CASYSTEM_TENANT).setFromRole(ROLE_CASYSTEMS_TENANTS_1_1).setToRole(ROLE_TENANTS_CASYSTEMS_1_2));
		 return navigationProperties;
	}



	@Override
	public Association getAssociation(  FullQualifiedName edmFQName ) {
		if(edmFQName.getName().equals(ASSOCIATION_FQN_CASYSTEM_TENANT.getName())){
			Association association = new Association().setName(ASSOCIATION_NAME_CASYSTEM_TENANT)
			        .setEnd1(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_CASYSTEM).getFullQualifiedName()).setRole(ROLE_CASYSTEMS_TENANTS_1_1).setMultiplicity(EdmMultiplicity.MANY))
			        .setEnd2(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_TENANTS).getFullQualifiedName()).setRole(ROLE_TENANTS_CASYSTEMS_1_2).setMultiplicity(EdmMultiplicity.ONE));
			return association;
		}
		return null;
	 
	}


	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association 
			 ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_CASYSTEM_TENANT.equals(association)) {
			      return new AssociationSet().setName(ASSOCIATION_SET_CASYSTEM_TENANT)
			          .setAssociation(ASSOCIATION_FQN_CASYSTEM_TENANT)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_CASYSTEMS_TENANTS_1_1).setEntitySet(ENTITY_SET_NAME_CASYSTEM))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_CASYSTEMS_1_2).setEntitySet(ENTITY_SET_NAME_TENANTS));
			    }
			  }
			  return null;
 
	}




	
 
	
	
 	
	 
	

}
