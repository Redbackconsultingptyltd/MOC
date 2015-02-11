package au.com.redbackconsulting.moc.odata.api.edmconstants;

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

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRHIERMAP_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_HROBJECTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
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
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS; 




import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIER_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_HROBJECTREL;




public class HrObjectRelEDM  extends BaseEDM{
 
	@Override
	public List<NavigationProperty> getNavigations() {
		List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_TENANTS)
				.setRelationship(ASSOCIATION_FQN_HRHIERMAP_TENANTS)
				.setFromRole(ROLE_HROBJECTREL_TENANTS)
				.setToRole(ROLE_TENANTS_HROBJECTREL));
		 
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_HRHIERMAP)
				.setRelationship(ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL)
				.setFromRole(ROLE_HRHIERMAP_HROBJECTREL)
				.setToRole(ROLE_HROBJECTREL_HRHIERMAP));

		navigationProperties.add(new NavigationProperty()
		.setName(ENTITY_TYPE_NAME_HROBJECTS)
		.setRelationship(ASSOCIATION_FQN_HROBJECTREL_HROBJECTS)
		.setFromRole(ROLE_HROBJECTREL_HROBJECTS)
		.setToRole(ROLE_HROBJECTS_HROBJECTREL));
		
		navigationProperties.add(new NavigationProperty()
		.setName(ENTITY_TYPE_NAME_HRRELATIONS)
		.setRelationship(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
		.setFromRole(ROLE_HROBJECTREL_HRRELATIONS)
		.setToRole(ROLE_HRRELATIONS_HROBJECTREL));
		
		return navigationProperties;
	}
	public HrObjectRelEDM(String namespace, String entity_type_name, String entity_set_name, EntityTypeFactory factory ) {
		super(namespace,    entity_type_name,  entity_set_name, factory );
		// TODO Auto-generated constructor stub
	}


	public static String hrobjectsId ="hrobjectsId";
	public static String tableId ="tableId";
	public static String tenantId="tenantId";
	public static String objectType="objectType";
	public static String relatType = "relatType";
	public static String sObjectType="sObjectType";
	public static String timeConstraint ="timeConstraint";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		 properties.add(new SimpleProperty().setName(HrObjectRelEDM.hrobjectsId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		 properties.add(new SimpleProperty().setName(HrObjectRelEDM.tableId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  properties.add(new SimpleProperty().setName(HrObjectRelEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectRelEDM.objectType).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectRelEDM.relatType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectRelEDM.sObjectType).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectRelEDM.timeConstraint).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectRelEDM.tenantId));
		 keyProperties.add(new PropertyRef().setName(HrObjectRelEDM.objectType));
		 keyProperties.add(new PropertyRef().setName(HrObjectRelEDM.timeConstraint));
		 keyProperties.add(new PropertyRef().setName(HrObjectRelEDM.sObjectType));
		 keyProperties.add(new PropertyRef().setName(HrObjectRelEDM.relatType));
		
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ASSOCIATION_FQN_HROBJECTREL_TENANTS.getName() )){
		    return new Association().setName( ASSOCIATION_FQN_HROBJECTREL_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HROBJECTREL_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_TENANTS_HROBJECTREL).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals( ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.getName())){
		    return new Association().setName( ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HROBJECTREL_HROBJECTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTS_HROBJECTREL).setMultiplicity(EdmMultiplicity.ONE));
	} else if(relatedEntity.getName().equals( ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName())){
		    return new Association().setName( ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HROBJECTREL_HRRELATIONS).setMultiplicity(EdmMultiplicity.ONE))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HRRELATIONS_HROBJECTREL).setMultiplicity(EdmMultiplicity.MANY));
	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
			if (ASSOCIATION_FQN_HROBJECTREL_TENANTS.getName().equals(association.getName())) {
				return new AssociationSet()
						.setName(ASSOCIATION_SET_HROBJECTREL_TENANTS)
						.setAssociation(ASSOCIATION_FQN_HROBJECTREL_TENANTS)
						.setEnd1(
								new AssociationSetEnd().setRole(
										ROLE_HROBJECTREL_TENANTS)
										.setEntitySet(ENTITY_SET_NAME_HROBJECTREL))
						.setEnd2(
								new AssociationSetEnd().setRole(
										ROLE_TENANTS_HROBJECTREL)
										.setEntitySet(ENTITY_SET_NAME_TENANTS));
			}else if (ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.equals(association)) {
				return new AssociationSet()
				.setName(ASSOCIATION_SET_HROBJECTREL_HROBJECTS)
				.setAssociation(ASSOCIATION_FQN_HROBJECTREL_HROBJECTS)
				.setEnd1(
						new AssociationSetEnd().setRole(
								ROLE_HROBJECTREL_HROBJECTS)
								.setEntitySet(ENTITY_SET_NAME_HROBJECTREL ))
				.setEnd2(
						new AssociationSetEnd().setRole(
								ROLE_HROBJECTS_HROBJECTREL)
								.setEntitySet(ENTITY_SET_NAME_HROBJECTS));
			}  else if (ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName().equals(association.getName())) {
				return new AssociationSet()
				.setName(ASSOCIATION_SET_HROBJECTREL_HRRELATIONS)
				.setAssociation(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
				.setEnd1(
						new AssociationSetEnd().setRole(
								ROLE_HROBJECTREL_HRRELATIONS)
								.setEntitySet(ENTITY_SET_NAME_HROBJECTREL ))
				.setEnd2(
						new AssociationSetEnd().setRole(
								ROLE_HRRELATIONS_HROBJECTREL)
								.setEntitySet(ENTITY_SET_NAME_HRRELATIONS));
	} 
			
//			else if (ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.equals(association)) {
//		return new AssociationSet()
//		.setName(ASSOCIATION_SET_HROBJECTREL_HRRELATIONS)
//		.setAssociation(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
//		.setEnd1(
//				new AssociationSetEnd().setRole(
//						ROLE_HROBJECTREL_HRRELATIONS)
//						.setEntitySet(ENTITY_SET_NAME_HROBJECTREL ))
//		.setEnd2(
//				new AssociationSetEnd().setRole(
//						ROLE_HRRELATIONS_HROBJECTREL)
//						.setEntitySet(ENTITY_SET_NAME_HRRELATIONS));
//} 
		}
		return null;

	}
 
}
