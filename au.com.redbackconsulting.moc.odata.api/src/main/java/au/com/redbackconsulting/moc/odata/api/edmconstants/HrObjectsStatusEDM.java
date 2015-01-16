package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRP1000_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTSSTATUS;
public class HrObjectsStatusEDM extends BaseEDM {


 

	
	public HrObjectsStatusEDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	public static String tenantId ="tenantId";
	public static String status="status";
	public static String description ="description";
	public static String hRP1001="hRP1001;";
	public static String hRP1000 ="hRP1000";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.tenantId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.status).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.description).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.hRP1000).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.hRP1001).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectsStatusEDM.tenantId));
		
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_TENANTS).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_TENANTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY));
	} else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HRP1000)){
		    return new Association().setName(ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_HRP1000).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HRP1000_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY));
	} else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS)){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.ONE));
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
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS).setFromRole(ROLE_HROBJECTSSTATUS_TENANTS).setToRole(ROLE_TENANTS_HROBJECTSSTATUS));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS).setFromRole(ROLE_HROBJECTSSTATUS_HROBJECTS).setToRole(ROLE_HROBJECTS_HROBJECTSSTATUS));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS).setFromRole(ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS).setToRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS));

		return navigationProperties;
	}
	 
 
}
