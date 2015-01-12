package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;
 
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
		    		 .setEnd1(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_HRHIER).getFullQualifiedName()).setRole(ROLE_ ).setMultiplicity(EdmMultiplicity.MANY))
				        .setEnd2(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_TENANTS).getFullQualifiedName()).setRole(ROLE_ ).setMultiplicity(EdmMultiplicity.ONE));
				 
	}
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
	List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_F).setFromRole(ROLE_CASYSTEMS_TENANTS_1_1).setToRole(ROLE_TENANTS_CASYSTEMS_1_2));
		 return navigationProperties;
	}
	 
 
}
