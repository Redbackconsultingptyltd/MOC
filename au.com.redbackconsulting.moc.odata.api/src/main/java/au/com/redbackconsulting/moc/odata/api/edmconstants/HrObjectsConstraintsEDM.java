package au.com.redbackconsulting.moc.odata.api.edmconstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationEnd;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.Facets;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.PropertyRef;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;

public class HrObjectsConstraintsEDM extends BaseEDM {
	public HrObjectsConstraintsEDM(String namespace ) {
		super(namespace,  ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS, ENTITY_SET_NAME_HROBJECTSCONSTRAINTS);
		// TODO Auto-generated constructor stub
	}
	public static String ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS="HrObjectsConstraints";
	public static String ENTITY_SET_NAME_HROBJECTSCONSTRAINTS="HrObjectsConstraintsSet";
	public static String tenantId="tenantId";
	public static String objectType="objectType";
	public static String tableId="tableId";
	public static String timeConstraint="timeConstraint";
	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierId).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.tenantId).setType(EdmSimpleTypeKind.Int32).setFacets(new Facets().setNullable(false)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hierDesc).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
		  properties.add(new SimpleProperty().setName(HrHierEDM.hrHierMap).setType(EdmSimpleTypeKind.String).setFacets(new Facets().setNullable(true)));
			
		  return properties;
	}
	@Override
	public List<PropertyRef> getKeys() {
		List<PropertyRef> keyProperties = new ArrayList<PropertyRef>();
		 keyProperties.add(new PropertyRef().setName(CaSystemEDM.SYSID));
		  keyProperties.add(new PropertyRef().setName(CaSystemEDM.TENANTID));
		return keyProperties;
	}
	@Override
	public Association getAssociation(FullQualifiedName relatedEntity) {
		if(relatedEntity.getName().equals(CaSystemEDM.ENTITY_TYPE_NAME_CASYSTEM)){
		    return new Association().setName(CaSystemEDM.ASSOCIATION_CASYSTEM_TENANT)
		        .setEnd1(new AssociationEnd().setType(getFullQualifiedName()).setRole(CaSystemEDM.ROLE_1_2).setMultiplicity(EdmMultiplicity.MANY))
		        .setEnd2(new AssociationEnd().setType(relatedEntity).setRole(CaSystemEDM.ROLE_2_1).setMultiplicity(EdmMultiplicity.ONE));
	}
	return null;
 
	}
 
	
}
