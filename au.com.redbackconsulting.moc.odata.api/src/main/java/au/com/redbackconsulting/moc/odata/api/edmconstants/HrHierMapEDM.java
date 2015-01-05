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

public class HrHierMapEDM  extends BaseEDM{

	
	public HrHierMapEDM(String namespace, String entity_type_name, String entity_set_name, EntityTypeFactory factory  ) {
		super(namespace, entity_type_name, entity_set_name, factory);
		 
	}
	public static String hierId ="hierId";
	public static String tenantId="tenantId";
	public static String seqNo="seqno";
	public static String objectType;
	public static String relatType;
	public static String sObjType;
	public static String skip;
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.hierId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.seqNo).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.objectType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.relatType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.sObjType).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierMapEDM.skip).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(HrHierMapEDM.hierId));
		  keyProperties.add(new PropertyRef().setName(HrHierMapEDM.tenantId));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
//		if(relatedEntity.getName().equals(ENTITY_TYPE_NAME_CASYSTEM)){
//		    return new Association().setName(CaSystemEDM.ASSOCIATION_CASYSTEM_TENANT)
//		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(CaSystemEDM.ROLE_1_2).setMultiplicity(EdmMultiplicity.MANY))
//		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(CaSystemEDM.ROLE_2_1).setMultiplicity(EdmMultiplicity.ONE));
//	}
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
		// TODO Auto-generated method stub
		return null;
	}
 
 
} 
