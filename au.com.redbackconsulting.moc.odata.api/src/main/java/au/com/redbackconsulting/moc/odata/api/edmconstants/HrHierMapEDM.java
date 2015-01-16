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
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRHIERMAP_HRHIER;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_SET_HRHIERMAP_HROBJECTREL;
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
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_NAME_HRHIER_HRHIERMAP;

import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_CASYSTEMS_TENANTS_1_1;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIER_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIER_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_CASYSTEMS_1_2;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_TENANTS_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ROLE_HROBJECTREL_HRHIERMAP;

public class HrHierMapEDM extends BaseEDM {

	public HrHierMapEDM(String namespace, String entity_type_name,
			String entity_set_name, EntityTypeFactory factory) {
		super(namespace, entity_type_name, entity_set_name, factory);

	}

	public static String hierId = "hierId";
	public static String tenantId = "tenantId";
	public static String seqNo = "seqno";
	public static String objectType;
	public static String relatType;
	public static String sObjType;
	public static String skip;

	@Override
	public List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		properties.add(new SimpleProperty().setName(HrHierMapEDM.hierId)
				.setType(EdmSimpleTypeKind.Int32)
				.setFacets(new Facets().setNullable(false)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.tenantId)
				.setType(EdmSimpleTypeKind.Int32)
				.setFacets(new Facets().setNullable(false)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.seqNo)
				.setType(EdmSimpleTypeKind.String)
				.setFacets(new Facets().setNullable(true)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.objectType)
				.setType(EdmSimpleTypeKind.String)
				.setFacets(new Facets().setNullable(true)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.relatType)
				.setType(EdmSimpleTypeKind.String)
				.setFacets(new Facets().setNullable(true)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.sObjType)
				.setType(EdmSimpleTypeKind.String)
				.setFacets(new Facets().setNullable(true)));
		properties.add(new SimpleProperty().setName(HrHierMapEDM.skip)
				.setType(EdmSimpleTypeKind.String)
				.setFacets(new Facets().setNullable(true)));
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
		if (relatedEntity.getName().equals(ENTITY_TYPE_NAME_TENANTS)) {
			return new Association()
					.setName(ASSOCIATION_FQN_HRHIERMAP_TENANTS.getName())
					.setEnd1(
							new AssociationEnd()
									.setType(getFullQualifiedName())
									.setRole(ROLE_HRHIERMAP_TENANTS)
									.setMultiplicity(EdmMultiplicity.MANY))
					.setEnd2(
							new AssociationEnd().setType(relatedEntity)
									.setRole(ROLE_TENANTS_HRHIERMAP)
									.setMultiplicity(EdmMultiplicity.ONE));
		} else if (relatedEntity.getName().equals(ENTITY_TYPE_NAME_HRHIER)) {
			return new Association()
					.setName(ASSOCIATION_FQN_HRHIER_HRHIERMAP.getName())
					.setEnd1(
							new AssociationEnd()
									.setType(getFullQualifiedName())
									.setRole(ROLE_HRHIERMAP_HRHIER)
									.setMultiplicity(EdmMultiplicity.MANY))
					.setEnd2(
							new AssociationEnd().setType(relatedEntity)
									.setRole(ROLE_HRHIER_HRHIERMAP)
									.setMultiplicity(EdmMultiplicity.ONE));
		}
		return null;

	}

	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association) {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
			if (ASSOCIATION_FQN_CASYSTEM_TENANT.equals(association)) {
				return new AssociationSet()
						.setName(ASSOCIATION_SET_CASYSTEM_TENANT)
						.setAssociation(ASSOCIATION_FQN_CASYSTEM_TENANT)
						.setEnd1(
								new AssociationSetEnd().setRole(
										ROLE_CASYSTEMS_TENANTS_1_1)
										.setEntitySet(ENTITY_SET_NAME_CASYSTEM))
						.setEnd2(
								new AssociationSetEnd().setRole(
										ROLE_TENANTS_CASYSTEMS_1_2)
										.setEntitySet(ENTITY_SET_NAME_TENANTS));
			} else if (ASSOCIATION_FQN_HRHIER_HRHIERMAP.equals(association)) {
				return new AssociationSet()
						.setName(ASSOCIATION_SET_HRHIERMAP_HRHIER)
						.setAssociation(ASSOCIATION_FQN_HRHIER_HRHIERMAP)
						.setEnd1(
								new AssociationSetEnd().setRole(
										ROLE_HRHIERMAP_HRHIER).setEntitySet(
										ENTITY_SET_NAME_HRHIERMAP))
						.setEnd2(
								new AssociationSetEnd().setRole(
										ROLE_HRHIER_HRHIERMAP).setEntitySet(
										ENTITY_SET_NAME_HRHIER));
			} else if (ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL
					.equals(association)) {
				return new AssociationSet()
						.setName(ASSOCIATION_SET_HRHIERMAP_HROBJECTREL)
						.setAssociation(ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL)
						.setEnd1(
								new AssociationSetEnd()
										.setRole(ROLE_HRHIERMAP_HROBJECTREL)
										.setEntitySet(ENTITY_SET_NAME_HRHIERMAP))
						.setEnd2(
								new AssociationSetEnd().setRole(
										ROLE_HROBJECTREL_HRHIERMAP)
										.setEntitySet(
												ENTITY_SET_NAME_HROBJECTREL));
			}
		}
		return null;

	}

	@Override
	public List<NavigationProperty> getNavigations() {
		List<NavigationProperty> navigationProperties = new ArrayList<NavigationProperty>();
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_TENANTS)
				.setRelationship(ASSOCIATION_FQN_HRHIERMAP_TENANTS)
				.setFromRole(ROLE_HRHIERMAP_TENANTS)
				.setToRole(ROLE_TENANTS_HRHIERMAP));
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_HRHIER)
				.setRelationship(ASSOCIATION_FQN_HRHIER_HRHIERMAP)
				.setFromRole(ROLE_HRHIERMAP_HRHIER)
				.setToRole(ROLE_HRHIER_HRHIERMAP));
		navigationProperties.add(new NavigationProperty()
				.setName(ENTITY_TYPE_NAME_HROBJECTREL)
				.setRelationship(ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL)
				.setFromRole(ROLE_HRHIERMAP_HROBJECTREL)
				.setToRole(ROLE_HROBJECTREL_HRHIERMAP));

		return navigationProperties;
	}

}
