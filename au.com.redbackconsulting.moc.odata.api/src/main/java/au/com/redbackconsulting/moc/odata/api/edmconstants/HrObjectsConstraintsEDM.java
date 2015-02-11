package au.com.redbackconsulting.moc.odata.api.edmconstants;


import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSCONSTRAINTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTSCONSTRAINTS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTCONSTRAINTS;

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

public class HrObjectsConstraintsEDM extends BaseEDM {
	public HrObjectsConstraintsEDM(String namespace , String entity_type_name, String entity_set_name, EntityTypeFactory factory) {
		super(namespace,    entity_type_name,   entity_set_name, factory);
		
	}
		public static String tenantId="tenantId";
	public static String objectType="objectType";
	public static String tableId="tableId";
	public static String timeConstraint="timeConstraint";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		 properties.add(new SimpleProperty().setName(HrObjectsConstraintsEDM.timeConstraint).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsConstraintsEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsConstraintsEDM.objectType).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectsConstraintsEDM.tableId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectsConstraintsEDM.objectType));
		  keyProperties.add(new PropertyRef().setName(HrObjectsConstraintsEDM.tenantId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT.getName())){
		    return new Association().setName(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT.getName())
		        .setEnd1(new AssociationEnd().setType(getFactory().getEDM(ENTITY_KEY_HROBJECTSCONSTRAINTS).getFullQualifiedName()).setRole( ROLE_HROBJECTCONSTRAINTS_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_TENANTS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.ONE));
	} 
		else if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName())){
		    return new Association().setName(ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS)
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTCONSTRAINTS_HROBJECTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.ONE));
	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT.getName().equals(association.getName())) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTSCONSTRAINTS_TENANTS)
			          .setAssociation(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTCONSTRAINTS_TENANTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSCONSTRAINTS))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HROBJECTCONSTRAINTS).setEntitySet(ENTITY_SET_NAME_TENANTS));
			    } 
			    else  if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName().equals(association.getName())) {
				      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTSCONSTRAINTS_HROBJECTS)
					          .setAssociation(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS)
					          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSCONSTRAINTS))
					          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HROBJECTCONSTRAINTS).setEntitySet(ENTITY_SET_NAME_HROBJECTS));
					    }
			  }
		return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT).setFromRole(ROLE_HROBJECTCONSTRAINTS_TENANTS).setToRole(ROLE_TENANTS_HROBJECTCONSTRAINTS));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS).setRelationship(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS).setFromRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTS).setToRole(ROLE_HROBJECTS_HROBJECTCONSTRAINTS));
	 
		return navigationProperties;
	}
 
	
}
