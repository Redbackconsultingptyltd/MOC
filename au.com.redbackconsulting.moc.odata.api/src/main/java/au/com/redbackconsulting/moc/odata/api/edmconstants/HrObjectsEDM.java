package au.com.redbackconsulting.moc.odata.api.edmconstants;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HROBJECTSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTCONSTRAINTS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_CASYSTEMS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1000_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HROBJECTS;

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



public class HrObjectsEDM  extends BaseEDM{
	public HrObjectsEDM(String namespace , String entity_type_name, String entity_set_name, EntityTypeFactory factory  ) {
		super(namespace,  entity_type_name,   entity_set_name, factory);
		// TODO Auto-generated constructor stub
	}

	public static String  tenantId="tenantId";
	public static String  objectType="objectType";
	public static String  systId ="systId";
	public static String  sObjectType ="sObjectType";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.objectType).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.systId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrObjectsEDM.sObjectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrObjectsEDM.tenantId));
		 keyProperties.add(new PropertyRef().setName(HrObjectsEDM.systId));
		 keyProperties.add(new PropertyRef().setName(HrObjectsEDM.systId));
			
		 return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals( ASSOCIATION_FQN_HROBJECTS_TENANTS.getName())){
		    return new Association().setName( ASSOCIATION_FQN_HROBJECTS_TENANTS.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_TENANTS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_TENANTS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
	} else if(relatedEntity.getName().equals( ASSOCIATION_FQN_HROBJECTS_CASYSTEM.getName())){
		    return new Association().setName( ASSOCIATION_FQN_HROBJECTS_CASYSTEM.getName())
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_CASYSTEMS).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_CASYSTEMS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
	} 
//		else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTCONSTRAINTS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	}   else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HROBJECTSSTATUS)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HROBJECTSSTATUS).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTSSTATUS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	} else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HROBJECTCONSTRAINTS).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTCONSTRAINTS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	}else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_CASYSTEM)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTS_CASYSTEM.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_CASYSTEMS).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_CASYSTEMS_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	}else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HROBJECTREL)){
//		    return new Association().setName( ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HROBJECTREL).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HROBJECTREL_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	} else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HRP1001)){
//		    return new Association().setName( ASSOCIATION_FQN_HRP1001_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HRP1001).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HRP1001_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	} else if(relatedEntity.getName().equals( ENTITY_TYPE_NAME_HRP1000)){
//		    return new Association().setName( ASSOCIATION_FQN_HRP1000_HROBJECTS.getName())
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole( ROLE_HROBJECTS_HRP1000).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole( ROLE_HRP1000_HROBJECTS).setMultiplicity(EdmMultiplicity.ONE));
//	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association ) {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_HROBJECTS_TENANTS.getName().equals(association.getName())) {
			      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_TENANTS)
			          .setAssociation(ASSOCIATION_FQN_HROBJECTS_TENANTS)
			          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_TENANTS).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
			          .setEnd2(new AssociationSetEnd().setRole(ROLE_TENANTS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_TENANTS));
			    } 
			    else  if (ASSOCIATION_FQN_HROBJECTS_CASYSTEM.equals(association)) {
				      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_CASYSTEMS)
					          .setAssociation(ASSOCIATION_FQN_HROBJECTS_CASYSTEM)
					          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_CASYSTEMS).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
					          .setEnd2(new AssociationSetEnd().setRole(ROLE_CASYSTEMS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_CASYSTEM));
					    }
//			    else  if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.equals(association)) {
//						      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_HROBJECTSTATUS)
//							          .setAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS)
//							          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HROBJECTSSTATUS).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
//							          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTSSTATUS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HROBJECTSSTATUS));
//							    }else  if (ASSOCIATION_FQN_HROBJECTS_CASYSTEM.equals(association)) {
//								      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_CASYSTEMS)
//									          .setAssociation(ASSOCIATION_FQN_HROBJECTS_CASYSTEM)
//									          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_CASYSTEMS).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
//									          .setEnd2(new AssociationSetEnd().setRole(ROLE_CASYSTEMS_HROBJECTS).setEntitySet(ENTITY_SET_NAME_CASYSTEM));
//									    }else  if (ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.equals(association)) {
//										      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_HROBJECTREL)
//											          .setAssociation(ASSOCIATION_FQN_HROBJECTREL_HROBJECTS)
//											          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HROBJECTREL).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
//											          .setEnd2(new AssociationSetEnd().setRole(ROLE_HROBJECTREL_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HROBJECTREL));
//											    }else  if (ASSOCIATION_FQN_HRP1001_HROBJECTS.equals(association)) {
//												      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_HRP1001)
//													          .setAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTS)
//													          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HRP1001).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
//													          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRP1001_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HRP1001));
//													    }else  if (ASSOCIATION_FQN_HRP1000_HROBJECTS.equals(association)) {
//														      return new AssociationSet().setName(ASSOCIATION_SET_HROBJECTS_HRP1000)
//															          .setAssociation(ASSOCIATION_FQN_HRP1000_HROBJECTS)
//															          .setEnd1(new AssociationSetEnd().setRole(ROLE_HROBJECTS_HRP1000).setEntitySet(ENTITY_SET_NAME_HROBJECTS))
//															          .setEnd2(new AssociationSetEnd().setRole(ROLE_HRP1000_HROBJECTS).setEntitySet(ENTITY_SET_NAME_HRP1000));
//															    }
			  }
		return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_TENANTS).setRelationship(ASSOCIATION_FQN_HROBJECTS_TENANTS).setFromRole(ROLE_HROBJECTS_TENANTS).setToRole(ROLE_TENANTS_HROBJECTS));
//		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS).setRelationship(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS).setFromRole(ROLE_HROBJECTS_HROBJECTCONSTRAINTS).setToRole(ROLE_HROBJECTCONSTRAINTS_HROBJECTS));
//		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTSSTATUS).setRelationship(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS).setFromRole(ROLE_HROBJECTS_HROBJECTSSTATUS).setToRole(ROLE_HROBJECTSSTATUS_HROBJECTS));
		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_CASYSTEM).setRelationship(ASSOCIATION_FQN_HROBJECTS_CASYSTEM).setFromRole(ROLE_HROBJECTS_CASYSTEMS).setToRole(ROLE_CASYSTEMS_HROBJECTS));
//		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HROBJECTREL).setRelationship(ASSOCIATION_FQN_HROBJECTREL_HROBJECTS).setFromRole(ROLE_HROBJECTS_HROBJECTREL).setToRole(ROLE_HROBJECTREL_HROBJECTS));
//		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRP1001).setRelationship(ASSOCIATION_FQN_HRP1001_HROBJECTS).setFromRole(ROLE_HROBJECTS_HRP1001).setToRole(ROLE_HRP1001_HROBJECTS));
//		navigationProperties.add(new NavigationProperty().setName(ENTITY_TYPE_NAME_HRP1000 ).setRelationship(ASSOCIATION_FQN_HRP1000_HROBJECTS ).setFromRole(ROLE_HROBJECTS_HRP1000).setToRole(ROLE_HRP1000_HROBJECTS));
	 
		return navigationProperties;
	}
	 
 
}
