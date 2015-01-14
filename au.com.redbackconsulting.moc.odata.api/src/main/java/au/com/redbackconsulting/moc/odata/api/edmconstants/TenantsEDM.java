package au.com.redbackconsulting.moc.odata.api.edmconstants;

 
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
  
 
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
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
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;

public class TenantsEDM extends BaseEDM {
	 

	public TenantsEDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	public static String tenantId="tenantId";
	public static String tenantCode="tenantCode";
	public static String name ="name"; 
	
	
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		 properties.add(new SimpleProperty().setName(TenantsEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));			  
		   properties.add(new SimpleProperty().setName(TenantsEDM.name).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(TenantsEDM.tenantCode).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 
		  keyProperties.add(new PropertyRef().setName(TenantsEDM.tenantId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_CASYSTEM)){
 
		    return new Association().setName( ASSOCIATION_FQN_CASYSTEM_TENANT.getName())
 
		     
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_TENANTS_CASYSTEMS_1_2).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_CASYSTEMS_TENANTS_1_1).setMultiplicity(EdmMultiplicity.MANY));
	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
 
			    if (ASSOCIATION_FQN_CASYSTEM_TENANT.equals(association)) {
			      return new AssociationSet().setName(ASSOCIATION_SET_CASYSTEM_TENANT)
			          .setAssociation(ASSOCIATION_FQN_CASYSTEM_TENANT)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_TENANTS_CASYSTEMS_1_2).setEntitySet(ENTITY_SET_NAME_TENANTS))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_CASYSTEMS_TENANTS_1_1).setEntitySet(ENTITY_SET_NAME_CASYSTEM));
			    }
			  }
			  return null;
 
	}
	@Override
	public List<NavigationProperty> getNavigations() {
List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		  navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_CASYSTEM).setRelationship(ASSOCIATION_FQN_CASYSTEM_TENANT).setFromRole(ROLE_CASYSTEMS_TENANTS_1_1).setToRole(ROLE_TENANTS_CASYSTEMS_1_2));
  
	return navigationProperties;	 
 
	}
	 
	 
 
}
