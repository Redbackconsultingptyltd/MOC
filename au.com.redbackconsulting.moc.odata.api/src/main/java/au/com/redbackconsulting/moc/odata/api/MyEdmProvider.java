package au.com.redbackconsulting.moc.odata.api;

import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_HRHIERMAP;

	
	import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_CASYSTEM_TENANT;
	import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRHIER_TENANT;
	import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRHIER_HRHIERMAP;
	
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1000_HROBJECTS ;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1000_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1001_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1001_HRRELATIONS;

import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1001_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRP1001_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRHIERMAP_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTREL_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTREL_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HROBJECTS_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRRELATIONS_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants. ASSOCIATION_FQN_HRRELATIONS_HRP1001;
 























import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_CONTAINER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_KEY_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_CASYSTEM;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.NAMESPACE;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIER;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIER;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS;

import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_TYPE_NAME_TENANTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityContainer;
import org.apache.olingo.odata2.api.edm.provider.EntityContainerInfo;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.exception.ODataException;

import au.com.redbackconsulting.moc.odata.api.edmconstants.BaseEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.EntityTypeFactory;

import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_CASYSTEM;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HRHIER;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HRHIERMAP;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HROBJECTSREL;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HROBJECTSCONSTRAINT;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HROBJECTS;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HROBJECTSSTATUS;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HRP1000;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HRP1001;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_HRRELATIONS;
import static  au.com.redbackconsulting.moc.odata.api.Constants. ENTITY_FQN_TENANTS;


public class MyEdmProvider extends EdmProvider implements IMyEdmProvider {

	EntityTypeFactory entityFactory = EntityTypeFactory.getInstance(NAMESPACE);

	@Override
	public List<Schema> getSchemas() throws ODataException {
		 
		List<Schema> schemas = new ArrayList<Schema>();
		Schema schema = new Schema();
		schema.setNamespace(NAMESPACE);
		List<EntityType> entityTypes = new ArrayList<EntityType>();
		List<EntitySet> entitySets = new ArrayList<EntitySet>();
		List<Association> associations = new ArrayList<Association>();

		List<AssociationSet> associationSets = new ArrayList<AssociationSet>();
		List<EntityContainer> entityContainers = new ArrayList<EntityContainer>();
		EntityContainer entityContainer = new EntityContainer();
		
// 		TENANTS
		entityTypes.add(getEntityType(ENTITY_FQN_TENANTS));
		
		
//		CaSystem	 
		entityTypes.add(getEntityType(ENTITY_FQN_CASYSTEM));
		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_CASYSTEM));
		associations.add(getAssociation(ASSOCIATION_FQN_CASYSTEM_TENANT));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_CASYSTEM_TENANT, null, null));
 		
		
//		HRHier
		entityTypes.add(getEntityType(ENTITY_FQN_HRHIER));
		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HRHIER));
		associations.add(getAssociation(ASSOCIATION_FQN_HRHIER_TENANT));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRHIER_TENANT, null, null));
	
		associations.add(getAssociation(ASSOCIATION_FQN_HRHIER_HRHIERMAP));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRHIER_HRHIERMAP, null, null));
	

//		HRHIERMAP
 		entityTypes.add(getEntityType(ENTITY_FQN_HRHIERMAP));
 		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HRHIERMAP));
 		associations.add(getAssociation(ASSOCIATION_FQN_HRHIERMAP_TENANTS)); 		
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRHIERMAP_TENANTS, null, null)); 
		
		associations.add(getAssociation(ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL, null, null));
		
//		HROBJECTSREL
	 	entityTypes.add(getEntityType(ENTITY_FQN_HROBJECTSREL));
 		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HROBJECTREL));
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTREL_TENANTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTREL_TENANTS, null, null));	

		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTREL_HROBJECTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTREL_HROBJECTS, null, null));
	 	
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS, null, null));
	 	
//		HROBJECTS
		entityTypes.add(getEntityType(ENTITY_FQN_HROBJECTS));	
 		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HROBJECTS));
 		
 		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTS_TENANTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTS_TENANTS, null, null));
		
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTS_CASYSTEM));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTS_CASYSTEM, null, null));
		
		
		
//		HROBJECTSCONSTRAINT
		entityTypes.add(getEntityType(ENTITY_FQN_HROBJECTSCONSTRAINT));
 		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HROBJECTSCONSTRAINTS));
 		
 		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT, null, null));
 		
 		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS, null, null));
		
//		HROBJECTSSTATUS		
	 	entityTypes.add(getEntityType(ENTITY_FQN_HROBJECTSSTATUS));
 		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HROBJECTSSTATUS));
 		
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS, null, null));
	 	
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS, null, null));
	 	
		associations.add(getAssociation(ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS));
		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS, null, null));

		
		
		//	 	entityTypes.add(getEntityType(ENTITY_FQN_HRP1000));
//	 	entityTypes.add(getEntityType(ENTITY_FQN_HRP1001));
//		entityTypes.add(getEntityType(ENTITY_FQN_HRRELATIONS));
		
		
		


//		List<ComplexType> complexTypes = new ArrayList<ComplexType>();
//		complexTypes.add(getComplexType(COMPLEX_TYPE));
//		schema.setComplexTypes(complexTypes);

		
	 	
	
//		
//		
//		
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1000_HROBJECTS));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1000_TENANTS));
//		
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTS));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1001_HRP1000));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1001_HRRELATIONS));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRP1001_TENANTS));
//		
//		associations.add(getAssociation(ASSOCIATION_FQN_HRRELATIONS_HRP1001));
//		associations.add(getAssociation(ASSOCIATION_FQN_HRRELATIONS_TENANTS));
//		
		
	

		
		
	

//		entityContainer.
	
		 
//		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HRP1000));
//		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_HRP1001));
//		entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_TENANTS));
		

	
//		

//
//		
// 
//
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS, null, null));
//
//		
//
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1000_HROBJECTS, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1000_TENANTS, null, null));
//
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1001_HROBJECTS, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1001_HRP1000, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1001_HRRELATIONS, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRP1001_TENANTS, null, null));
//
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRRELATIONS_HRP1001, null, null));
//		associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_FQN_HRRELATIONS_TENANTS, null, null));

	
		
		schema.setEntityTypes(entityTypes);
			
		schema.setAssociations(associations);
		
		entityContainer.setAssociationSets(associationSets);
			
		entityContainer.setEntitySets(entitySets);
		entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);
		entityContainers.add(entityContainer);
		schema.setEntityContainers(entityContainers);

		schemas.add(schema);

		return schemas;
	}

	@Override
	public EntityType getEntityType(FullQualifiedName edmFQName)
			throws ODataException {
		if (NAMESPACE.equals(edmFQName.getNamespace())) {
			if (edmFQName.equals(ENTITY_FQN_CASYSTEM)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_CASYSTEM).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HRHIER)) {
				EntityType entityType = entityFactory.getEDM(ENTITY_KEY_HRHIER)
						.getEntityType();
				return entityType;
			} else

			if (edmFQName.equals(ENTITY_FQN_HRHIERMAP)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HRHIERMAP).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HROBJECTSREL)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HROBJECTS)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTS).getEntityType();
				return entityType;

			} else if (edmFQName.equals(
					ENTITY_FQN_HROBJECTSCONSTRAINT)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSCONSTRAINTS).getEntityType();
				return entityType;

			} else if (edmFQName.equals(
					ENTITY_FQN_HROBJECTSSTATUS)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HRP1000)) {
				EntityType entityType = entityFactory
						.getEDM(ENTITY_KEY_HRP1000).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HRP1001)) {
				EntityType entityType = entityFactory
						.getEDM(ENTITY_KEY_HRP1001).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_HRRELATIONS)) {
				EntityType entityType = entityFactory.getEDM(
						ENTITY_KEY_HRRELATIONS).getEntityType();
				return entityType;

			} else if (edmFQName.equals(ENTITY_FQN_TENANTS)) {
				EntityType entityType = entityFactory
						.getEDM(ENTITY_KEY_TENANTS).getEntityType();
				return entityType;

			}
		}
		return null;
	}

	@Override
	public EntitySet getEntitySet(String entityContainer, String name)
			throws ODataException {
		if (ENTITY_CONTAINER.equals(entityContainer)) {
			if (ENTITY_SET_NAME_CASYSTEM.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_CASYSTEM)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HRHIER.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HRHIER)
						.getEntitySet();
				return entitySet;
			}else if (ENTITY_SET_NAME_HRHIERMAP.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HRHIERMAP)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HROBJECTREL.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HROBJECTSREL)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HROBJECTS.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HROBJECTS)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HROBJECTSCONSTRAINTS)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HROBJECTSSTATUS)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HRP1000.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HRP1000)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HRP1001.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HRP1001)
						.getEntitySet();
				return entitySet;
			} else if (ENTITY_SET_NAME_HRRELATIONS.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_HRRELATIONS)
						.getEntitySet();
				return entitySet;
			}  else if (ENTITY_SET_NAME_TENANTS.equals(name)) {
				EntitySet entitySet = entityFactory.getEDM(ENTITY_KEY_TENANTS)
						.getEntitySet();
				return entitySet;
			}
		}
		return null;
	}

	@Override
	public EntityContainerInfo getEntityContainerInfo(String name)
			throws ODataException {
		if (name == null || "ODataMOCEntityContainer".equals(name)) {
			return new EntityContainerInfo().setName("ODataMOCEntityContainer")
					.setDefaultEntityContainer(true);
		}

		return null;
	}

	@Override
	public ComplexType getComplexType(FullQualifiedName edmFQName)
			throws ODataException {
		// TODO Auto-generated method stub
		return super.getComplexType(edmFQName);
	}

	@Override
	public Association getAssociation(FullQualifiedName edmFQName)
			throws ODataException {
		if (NAMESPACE.equals(edmFQName.getNamespace())) {
			// FullQualifiedName fqName = ASSOCIATION_FQN_CASYSTEM_TENANT;
			if (ASSOCIATION_FQN_CASYSTEM_TENANT.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_CASYSTEM).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIER_HRHIERMAP.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRHIER).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIER_TENANT.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRHIER).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRHIERMAP).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIERMAP_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRHIERMAP).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTS_CASYSTEM.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTS_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSCONSTRAINTS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSCONSTRAINTS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociation(edmFQName);
				return association;
				
			} else if (ASSOCIATION_FQN_HRP1000_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1000_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociation(edmFQName);
				return association;
			} else
				
				if (ASSOCIATION_FQN_HRP1001_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociation(edmFQName);
				return association;
			}  else if (ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_HRP1000.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_HRRELATIONS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRRELATIONS_HRP1001.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRRELATIONS).getAssociation(edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRRELATIONS_TENANTS.getName().equals(
					edmFQName.getName())) {
				Association association = entityFactory.getEDM(
						ENTITY_KEY_HRRELATIONS).getAssociation(edmFQName);
				return association;
			} 
		}
		return null;
	}

	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName edmFQName, String sourceEntitySetName,
			String sourceEntitySetRole) throws ODataException {
		
		if (NAMESPACE.equals(edmFQName.getNamespace())) {
			// FullQualifiedName fqName = ASSOCIATION_FQN_CASYSTEM_TENANT;
			if (ASSOCIATION_FQN_CASYSTEM_TENANT.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_CASYSTEM).getAssociationSet(entityContainer,edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIER_HRHIERMAP.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRHIER).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIER_TENANT.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRHIER).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIERMAP_HROBJECTREL.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRHIERMAP).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRHIERMAP_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRHIERMAP).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_HRRELATIONS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTREL_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSREL).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTS_CASYSTEM.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTS_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSCONSTRAINTS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSCONSTRAINT_TENANT.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSCONSTRAINTS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTCONSTRAINTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HROBJECTSSTATUS_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HROBJECTSSTATUS).getAssociationSet(entityContainer, edmFQName);
				return association;
				
			} else if (ASSOCIATION_FQN_HRP1000_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1000_HROBJECTSSTATUS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1000_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1000).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else
				
				if (ASSOCIATION_FQN_HRP1001_HROBJECTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociationSet(entityContainer, edmFQName);
				return association;
			}  else if (ASSOCIATION_FQN_HRP1001_HROBJECTSSTATUS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_HRP1000.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_HRRELATIONS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRP1001_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRP1001).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRRELATIONS_HRP1001.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRRELATIONS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} else if (ASSOCIATION_FQN_HRRELATIONS_TENANTS.getName().equals(
					edmFQName.getName())) {
				AssociationSet association = entityFactory.getEDM(
						ENTITY_KEY_HRRELATIONS).getAssociationSet(entityContainer, edmFQName);
				return association;
			} 
		}
		return null;
		
//		if (ENTITY_CONTAINER.equals(entityContainer)) {
//			if (ASSOCIATION_FQN_CASYSTEM_TENANT.equals(association)) {
//				AssociationSet associationSet = entityFactory.getEDM(
//						ENTITY_KEY_CASYSTEM).getAssociationSet(entityContainer,
//						association);
//				return associationSet;
//			}
//		}
//		return null;

	}

}
