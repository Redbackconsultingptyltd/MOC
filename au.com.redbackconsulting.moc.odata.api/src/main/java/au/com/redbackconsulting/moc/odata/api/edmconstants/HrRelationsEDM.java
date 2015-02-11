package au.com.redbackconsulting.moc.odata.api.edmconstants;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRRELATIONS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRRELATIONS_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRRELATIONS_HROBJECTREL;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRRELATIONS;

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
public class HrRelationsEDM extends BaseEDM {

	 

	public HrRelationsEDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	public static String tenantId="tenantId";
	public static String relatType ="relatType";
	public static String relatTypeT="relatTypeT";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrRelationsEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrRelationsEDM.relatType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrRelationsEDM.relatTypeT).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  
			
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrRelationsEDM.relatType));
			
		keyProperties.add(new PropertyRef().setName(HrRelationsEDM.tenantId));
		 
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ASSOCIATION_FQN_HRRELATIONS_TENANTS.getName())){
		    return new Association().setName( ASSOCIATION_FQN_HRRELATIONS_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRRELATIONS_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_TENANTS_HRRELATIONS ).setMultiplicity(EdmMultiplicity.ONE));
	} 
		
//		else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRRELATIONS_HROBJECTREL).setMultiplicity(EdmMultiplicity.ONE))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTREL_HRRELATIONS ).setMultiplicity(EdmMultiplicity.MANY));
//	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HRP1001)){
//		    return new Association().setName( ASSOCIATION_FQN_HRRELATIONS_HRP1001.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRRELATIONS_HRP1001 ).setMultiplicity(EdmMultiplicity.ONE))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HRP1001_HRRELATIONS).setMultiplicity(EdmMultiplicity.MANY));
//	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
			if (ASSOCIATION_FQN_HRRELATIONS_TENANTS.equals(association)) {
				return new AssociationSet()
						.setName(ASSOCIATION_SET_HRRELATIONS_TENANTS)
						.setAssociation(ASSOCIATION_FQN_HROBJECTREL_TENANTS)
						.setEnd1(
								new AssociationSetEnd().setRole(
										ROLE_HRRELATIONS_TENANTS)
										.setEntitySet(ENTITY_SET_NAME_HRRELATIONS))
						.setEnd2(
								new AssociationSetEnd().setRole(
										ROLE_TENANTS_HRRELATIONS)
										.setEntitySet(ENTITY_SET_NAME_TENANTS));
			}
			
//			else if (ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.equals(association)) {
//				return new AssociationSet()
//				.setName(ASSOCIATION_SET_HRRELATIONS_HROBJECTREL)
//				.setAssociation(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
//				.setEnd1(
//						new AssociationSetEnd().setRole(
//								ROLE_HRRELATIONS_HROBJECTREL)
//								.setEntitySet(ENTITY_SET_NAME_HRRELATIONS ))
//				.setEnd2(
//						new AssociationSetEnd().setRole(
//								ROLE_HROBJECTREL_HRRELATIONS)
//								.setEntitySet(ENTITY_SET_NAME_HROBJECTREL));
//	}
//			else if (ASSOCIATION_FQN_HRRELATIONS_HRP1001.equals(association)) {
//		return new AssociationSet()
//		.setName(ASSOCIATION_SET_HRRELATIONS_HRP1001)
//		.setAssociation(ASSOCIATION_FQN_HRRELATIONS_HRP1001)
//		.setEnd1(
//				new AssociationSetEnd().setRole(
//						ROLE_HRRELATIONS_HRP1001)
//						.setEntitySet(ENTITY_SET_NAME_HRRELATIONS ))
//		.setEnd2(
//				new AssociationSetEnd().setRole(
//						ROLE_HRP1001_HRRELATIONS)
//						.setEntitySet(ENTITY_SET_NAME_HRRELATIONS));
//} 
			}
		return null;

	}
	@Override
	public List<NavigationProperty> getNavigations() {
		List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_TENANTS)
				.setRelationship(ASSOCIATION_FQN_HRRELATIONS_TENANTS)
				.setFromRole(ROLE_HRRELATIONS_TENANTS)
				.setToRole(ROLE_TENANTS_HRRELATIONS));
		 
//		navigationProperties.add(new NavigationProperty()
//				.setName(ENTITY_TYPE_NAME_HROBJECTS)
//				.setRelationship(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
//				.setFromRole(ROLE_HROBJECTREL_HRRELATIONS)
//				.setToRole(ROLE_HRRELATIONS_HROBJECTREL));
//
//		navigationProperties.add(new NavigationProperty()
//		.setName(ENTITY_TYPE_NAME_HROBJECTREL)
//		.setRelationship(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS)
//		.setFromRole(ROLE_HROBJECTREL_HROBJECTS)
//		.setToRole(ROLE_HROBJECTS_HROBJECTREL));
//		
	 
		
		return navigationProperties;
	}
 

}
