package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.NavigationProperty;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

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
//		if(relatedEntity.getName().equals(CaSystemEDM.ENTITY_TYPE_NAME_CASYSTEM)){
//		    return new Association().setName(CaSystemEDM.ASSOCIATION_CASYSTEM_TENANT)
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(CaSystemEDM.ROLE_1_2).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(CaSystemEDM.ROLE_2_1).setMultiplicity(EdmMultiplicity.ONE));
//	}
	return null;
 
	}
	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<NavigationProperty> getNavigations() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
}
