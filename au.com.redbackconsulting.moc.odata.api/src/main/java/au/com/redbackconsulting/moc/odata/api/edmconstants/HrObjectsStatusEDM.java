package au.com.redbackconsulting.moc.odata.api.edmconstants;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSTATUS_HROBJECTSCONSTRAINS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSTATUS_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTSSTATUS;

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
public class HrObjectsStatusEDM extends BaseEDM {


 

	
	public HrObjectsStatusEDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	public static String tenantId ="tenantId";
	public static String statusId="status";
	public static String description ="description";
//	public static String hRP1001="hRP1001;";
//	public static String hRP1000 ="hRP1000";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.statusId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.description).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		//  properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.hRP1000).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		 // properties.add(new SimpleProperty().setName(HrObjectsStatusEDM.hRP1001).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectsStatusEDM.statusId));
		 keyProperties.add(new PropertyRef().setName(HrObjectsStatusEDM.tenantId));
		
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName())){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_TENANTS).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_TENANTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY));
	}  else 	if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName())){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY));
	} else 	if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName())){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY));
	} 
 
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName().equals(association.getName())) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTSTATUS_TENANT)
			          .setAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_TENANTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_TENANTS));
			    } else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName().equals(association.getName())) {
				      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTSTATUS_HROBJECTS)
					          .setAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS)
					          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS))
					          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_HROBJECTS));
					    }
			    else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName().equals(association.getName())) {
				      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTSTATUS_HROBJECTSCONSTRAINS)
					          .setAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS)
					          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS))
					          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_HROBJECTS));
					    }
			  }
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
