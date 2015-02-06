package au.com.redbackconsulting.moc.odata.api.edmconstants;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_HRHIERMAP;


import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_HRHIERMAP;


import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRHIER_HRHIERMAP;


import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIER_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIER_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HRHIER;

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
 
public class HrHierEDM  extends BaseEDM{

	public HrHierEDM(String namespace, String entity_type_name, String entity_set_name, EntityTypeFactory factory) {
		super(namespace, entity_type_name, entity_set_name, factory);
		 
	}
	
	public static String hierId ="hierId";
	public static String tenantId="tenantId";
	public static String hierDesc="hierDesc";
	public static String hrHierMap="hrHierMap";
	@Override
	public List<Property> getProperties() {
		
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hrHierMap).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
		
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName("hierId"));
		  keyProperties.add(new PropertyRef().setName("tenantId"));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ASSOCIATION_NAME_HRHIER_TENANT)){
		    return new Association().setName(ASSOCIATION_NAME_HRHIER_TENANT)
		    		 .setEnd1(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_HRHIER).getFullQualifiedName()).setRole(ROLE_HRHIER_TENANTS ).setMultiplicity(EdmMultiplicity.MANY))
				        .setEnd2(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_TENANTS).getFullQualifiedName()).setRole(ROLE_TENANTS_HRHIER ).setMultiplicity(EdmMultiplicity.ONE));
				 
	}else if(relatedEntity.getName().equals(ASSOCIATION_NAME_HRHIER_HRHIERMAP)){
	    return new Association().setName(ASSOCIATION_NAME_HRHIER_HRHIERMAP)
	    		 .setEnd1(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_HRHIER).getFullQualifiedName()).setRole(ROLE_HRHIER_HRHIERMAP ).setMultiplicity(EdmMultiplicity.MANY))
			        .setEnd2(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_HRHIERMAP).getFullQualifiedName()).setRole(ROLE_HRHIERMAP_HRHIER ).setMultiplicity(EdmMultiplicity.ONE));
			 
}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_HRHIER_TENANT.equals(association)) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HRHIER_TENANT)
			          .setAssociation(ASSOCIATION_FQN_HRHIER_TENANT)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRHIER_TENANTS).setEntitySet(ENTITY_SET_NAME_HRHIER))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HRHIER).setEntitySet(ENTITY_SET_NAME_TENANTS));
			    } else  if (ASSOCIATION_FQN_HRHIER_HRHIERMAP.equals(association)) {
				      return new AssociationSet().setName(ASSOCIATION_SET_HRHIER_HRHIERMAP)
					          .setAssociation(ASSOCIATION_FQN_HRHIER_HRHIERMAP)
					          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRHIER_HRHIERMAP).setEntitySet(ENTITY_SET_NAME_HRHIER))
					          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRHIERMAP_HRHIER).setEntitySet(ENTITY_SET_NAME_HRHIERMAP));
					    }
			  }
//			  return null;
		return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
	List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_HRHIER_TENANT).setFromRole(ROLE_HRHIER_TENANTS).setToRole(ROLE_TENANTS_HRHIER));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRHIERMAP).setRelationship(ASSOCIATION_FQN_HRHIER_HRHIERMAP).setFromRole(ROLE_HRHIER_HRHIERMAP).setToRole(ROLE_HRHIERMAP_HRHIER));

		return navigationProperties;
	}
	 
 
}
