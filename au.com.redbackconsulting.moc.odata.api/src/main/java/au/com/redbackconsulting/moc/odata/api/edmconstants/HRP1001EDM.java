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
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRP1001_TENANTS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTSCONSTRAINTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HRP1000;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HROBJECTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HROBJECTSTATUS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HRP1000;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HRRELATIONS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
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


import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTS;


import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1000;



public class HRP1001EDM extends BaseEDM{

	public HRP1001EDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	 

	
	public static String tenantId ="tenantId";
	public static String robjectType="robjectType";
	public static String robjectId ="robjectId";
	public static String rsobjectType ="rsobjectType";
	public static String rsobjectId ="rsobjectId";
	public static String relatType ="relatType";
	public static String validTo ="validTo";
	public static String validFrom ="validFrom";
	public static String subType ="subType";	
	public static String status ="status";
	public static String changedOn ="changedOn";
	public static String changedBy ="changedBy";
	public static String guid="guid";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HRP1001EDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.robjectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.robjectId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.rsobjectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  properties.add(new SimpleProperty().setName(HRP1001EDM.rsobjectId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.validFrom).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.validTo).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.changedBy).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  properties.add(new SimpleProperty().setName(HRP1001EDM.changedOn).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.subType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.status).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1001EDM.guid).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  properties.add(new SimpleProperty().setName(HRP1001EDM.relatType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  
		  
		  
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HRP1001EDM.tenantId));
		  keyProperties.add(new PropertyRef().setName(HRP1001EDM.robjectId));
		  
		  keyProperties.add(new PropertyRef().setName(HRP1001EDM.rsobjectId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)){
		    return new Association().setName(ASSOCIATION_FQN_HRP1001_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_TENANTS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	} else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HRRELATIONS)){
		    return new Association().setName(ASSOCIATION_FQN_HRRELATIONS_HRP1001.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_HRRELATIONS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HRRELATIONS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTS)){
		    return new Association().setName(ASSOCIATION_FQN_HRP1001_HROBJECTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_HROBJECTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HRRELATIONS)){
		    return new Association().setName(ASSOCIATION_FQN_HRRELATIONS_HRP1001.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_HRRELATIONS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HRRELATIONS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	}
	else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTSSTATUS)){
		    return new Association().setName(ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTSSTATUS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTS)){
		    return new Association().setName(ASSOCIATION_FQN_HRP1001_HROBJECTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(ROLE_HRP1001_HROBJECTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(ROLE_HROBJECTS_HRP1001).setMultiplicity(EdmMultiplicity.ONE));
	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association) {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
		    if (ASSOCIATION_FQN_HRP1001_TENANTS.equals(association)) {
		      return new AssociationSet().setName(ASSOCIATION_SET_HRP1001_TENANTS)
		          .setAssociation(ASSOCIATION_FQN_HRP1001_TENANTS)
		          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1001_TENANTS).setEntitySet(ENTITY_SET_NAME_HRP1001))
		          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HRP1001).setEntitySet(ENTITY_SET_NAME_TENANTS));
		    } else  if (ASSOCIATION_FQN_HRP1001_HROBJECTS.equals(association)) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HRP1001_HRRELATIONS)
				          .setAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTS)
				          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1001_HRRELATIONS).setEntitySet(ENTITY_SET_NAME_HRP1001))
				          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRRELATIONS_HRP1001).setEntitySet(ENTITY_SET_NAME_HRRELATIONS));
				    }else  if (ASSOCIATION_FQN_HRP1001_HRP1000.equals(association)) {
					      return new AssociationSet().setName(ASSOCIATION_SET_HRP1001_HRP1000)
						          .setAssociation(ASSOCIATION_FQN_HRP1001_HRP1000)
						          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1001_HRP1000).setEntitySet(ENTITY_SET_NAME_HRP1001))
						          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRP1000_HRP1001).setEntitySet(ENTITY_SET_NAME_HRP1001));
						    }else  if (ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS.equals(association)) {
							      return new AssociationSet().setName(ASSOCIATION_SET_HRP1001_HROBJECTSTATUS)
								          .setAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS)
								          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1001_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_HRP1001))
								          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_HRP1001).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS));
								    }else  if (ASSOCIATION_FQN_HRP1001_HROBJECTS.equals(association)) {
									      return new AssociationSet().setName(ASSOCIATION_SET_HRP1001_HROBJECTS)
										          .setAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTS)
										          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1001_HROBJECTS ).setEntitySet(ENTITY_SET_NAME_HRP1001))
										          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HRP1001).setEntitySet(ENTITY_SET_NAME_HROBJECTS));
										    } 
		  }
	return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_HRP1001_TENANTS).setFromRole(ROLE_HRP1001_TENANTS).setToRole(ROLE_HRRELATIONS_HRP1001));
	 	navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRRELATIONS).setRelationship(ASSOCIATION_FQN_HRRELATIONS_HRP1001).setFromRole(ROLE_HRP1001_HRRELATIONS).setToRole(ROLE_HRRELATIONS_HRP1001));
	 	navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRP1000).setRelationship(ASSOCIATION_FQN_HRP1001_HRP1000).setFromRole(ROLE_HRP1001_HRP1000).setToRole(ROLE_HRP1000_HRP1001));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS).setFromRole(ROLE_HRP1001_HROBJECTSSTATUS).setToRole(ROLE_HROBJECTSSTATUS_HRP1001));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTS ).setRelationship(ASSOCIATION_FQN_HRP1001_HROBJECTS ).setFromRole(ROLE_HRP1001_HROBJECTS ).setToRole(ROLE_HROBJECTS_HRP1001));

		return navigationProperties;
	}
	 
	
}
