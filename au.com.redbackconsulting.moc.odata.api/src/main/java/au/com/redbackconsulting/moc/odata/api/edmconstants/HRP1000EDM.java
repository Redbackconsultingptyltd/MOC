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
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSCONSTRAINT_HROBJECTS; 
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HROBJECTREL_HROBJECTS;



import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_TENANTS;
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
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HROBJECTSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1001_TENANTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1000_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1000_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1000_HROBJECTSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRP1000_HROBJECTS;

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
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRRELATIONS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRP1001;
public class HRP1000EDM extends BaseEDM {

	 


	public HRP1000EDM(String namespace, String entityTypeName,
			String entitySetName, EntityTypeFactory factory) {
		super(namespace, entityTypeName, entitySetName, factory);
		// TODO Auto-generated constructor stub
	}
	public static String  tenantId="tenantId";
	public static String objectType="objectType";
	public static String objectId="objectId";
	public static String validTo="validTo";
	public static String validFrom="validFrom";
	public static String seqNr="seqNr";
	public static String objectDesc="objectDesc";
	public static String status="status";
	public static String stext="stext";
	public static String changedOn="changedOn";
	public static String changedBy="changedBy";
	public static String guid="guid";
	public static String hrObjectsStatus="hrObjectsStatus";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HRP1000EDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.objectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.objectId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.validFrom).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		
		  properties.add(new SimpleProperty().setName(HRP1000EDM.validTo).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.hrObjectsStatus).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.seqNr).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.objectDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  properties.add(new SimpleProperty().setName(HRP1000EDM.seqNr).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.status).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.stext).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.changedBy).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HRP1000EDM.changedOn).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  
		  
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HRP1000EDM.tenantId));
		  keyProperties.add(new PropertyRef().setName(HRP1000EDM.objectId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)){
		    return new Association().setName( ASSOCIATION_FQN_HRP1000_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HRP1000_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_TENANTS_HRP1000).setMultiplicity(EdmMultiplicity.ONE));
	} else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)){
		    return new Association().setName( ASSOCIATION_FQN_HRP1001_HRP1000.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HRP1000_HRP1001).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HRP1001_HRP1000).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTSSTATUS)){
		    return new Association().setName( ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HRP1000_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTSSTATUS_HRP1000).setMultiplicity(EdmMultiplicity.ONE));
	}else if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_HROBJECTS )){
		    return new Association().setName( ASSOCIATION_FQN_HRP1000_HROBJECTS .getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HRP1000_HROBJECTS ).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTS_HRP1000).setMultiplicity(EdmMultiplicity.ONE));
	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
		    if (ASSOCIATION_FQN_HRP1000_TENANTS.equals(association)) {
		      return new AssociationSet().setName(ASSOCIATION_SET_HRP1000_TENANTS)
		          .setAssociation(ASSOCIATION_FQN_HRP1000_TENANTS)
		          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1000_TENANTS).setEntitySet(ENTITY_SET_NAME_HRP1000))
		          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HRP1000).setEntitySet(ENTITY_SET_NAME_TENANTS));
		    } else  if (ASSOCIATION_FQN_HRP1001_HRP1000.equals(association)) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HRP1000_HRP1001)
				          .setAssociation(ASSOCIATION_FQN_HRP1001_HRP1000)
				          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1000_HRP1001).setEntitySet(ENTITY_SET_NAME_HRP1000))
				          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRP1001_HRP1000).setEntitySet(ENTITY_SET_NAME_HRP1000));
				    }else  if (ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS.equals(association)) {
					      return new AssociationSet().setName(ASSOCIATION_SET_HRP1000_HROBJECTSTATUS)
						          .setAssociation(ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS)
						          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1000_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS))
						          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_HRP1000).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS));
						    }else  if (ASSOCIATION_FQN_HRP1000_HROBJECTS.equals(association)) {
							      return new AssociationSet().setName(ASSOCIATION_SET_HRP1000_HROBJECTS)
								          .setAssociation(ASSOCIATION_FQN_HRP1000_HROBJECTS)
								          .setEnd1(new AssociationSetEnd().setRole(ROLE_HRP1000_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
								          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HRP1000).setEntitySet(ENTITY_SET_NAME_HROBJECTS));
								    }
		  }
	return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
		List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_HRP1000_TENANTS).setFromRole(ROLE_HRP1000_TENANTS).setToRole(ROLE_TENANTS_HRP1000));
	  	navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRP1001).setRelationship(ASSOCIATION_FQN_HRP1001_HRP1000).setFromRole(ROLE_HRP1000_HRP1001).setToRole(ROLE_HRP1001_HRP1000));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS).setFromRole(ROLE_HRP1000_HROBJECTSSTATUS).setToRole(ROLE_HROBJECTSSTATUS_HRP1000));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTS ).setRelationship(ASSOCIATION_FQN_HRP1000_HROBJECTS ).setFromRole(ROLE_HRP1000_HROBJECTS ).setToRole(ROLE_HROBJECTS_HRP1000));

		return navigationProperties;
	}
	 
}
