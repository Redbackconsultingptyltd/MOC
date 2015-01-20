package au.com.redbackconsulting.moc.odata.api;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_CASYSTEM_TENANT;
import static au.com.redbackconsulting.moc.odata.api.Constants.ASSOCIATION_FQN_HRHIER_HRHIERMAP;

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


public class MyEdmProvider extends EdmProvider  implements IMyEdmProvider{
	

	
 
        
      EntityTypeFactory entityFactory = EntityTypeFactory.getInstance(NAMESPACE);

 
	@Override
	public List<Schema> getSchemas() throws ODataException {
		 
		List<Schema> schemas = new ArrayList<Schema>();
		Schema schema = new Schema();
		schema.setNamespace(NAMESPACE);
		List<EntityType> entityTypes = new ArrayList<EntityType>();
				BaseEDM caSystemEDM = entityFactory.getEDM(ENTITY_KEY_CASYSTEM);
		entityTypes.add(caSystemEDM.getEntityType());

		BaseEDM hrHierEDM = entityFactory.getEDM(ENTITY_KEY_HRHIER);
		entityTypes.add(hrHierEDM.getEntityType());
		
		BaseEDM hrHierMapEDM = entityFactory.getEDM(ENTITY_KEY_HRHIERMAP);
		entityTypes.add(hrHierMapEDM.getEntityType());
		
		BaseEDM hrObjectConstraintsEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSCONSTRAINTS);
		entityTypes.add(hrObjectConstraintsEDM.getEntityType());
		
		BaseEDM hrObjectsRelEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSREL); 
		entityTypes.add(hrObjectsRelEDM.getEntityType());
		
		BaseEDM hrObjectsEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTS);
		entityTypes.add(hrObjectsEDM.getEntityType());
		
		BaseEDM hrObjectsStutusEDM = entityFactory.getEDM(ENTITY_KEY_HROBJECTSSTATUS);
		entityTypes.add(hrObjectsStutusEDM.getEntityType());
		
		BaseEDM hrP1000EDM = entityFactory.getEDM(ENTITY_KEY_HRP1000);
		entityTypes.add(hrP1000EDM.getEntityType());
		
		BaseEDM hrP1001EDM= entityFactory.getEDM(ENTITY_KEY_HRP1001); 
		entityTypes.add(hrP1001EDM.getEntityType());
		
		BaseEDM hrRelationsEDM= entityFactory.getEDM(ENTITY_KEY_HRRELATIONS);
		entityTypes.add(hrRelationsEDM.getEntityType());
		
		BaseEDM tenantEDM = entityFactory.getEDM(ENTITY_KEY_TENANTS);
		entityTypes.add(tenantEDM.getEntityType());
		schema.setEntityTypes(entityTypes);


//		List<ComplexType> complexTypes = new ArrayList<ComplexType>();
//		complexTypes.add(getComplexType(COMPLEX_TYPE));
//		schema.setComplexTypes(complexTypes);

		List<Association> associations = new ArrayList<Association>();
		Association caSystemAssocation = caSystemEDM.getAssociation(ASSOCIATION_FQN_CASYSTEM_TENANT);
		
		associations.add(caSystemAssocation);
		Association hrhierAssocation = caSystemEDM.getAssociation(ASSOCIATION_FQN_HRHIER_HRHIERMAP);
		associations.add(hrhierAssocation);
		schema.setAssociations(associations);
		
	

		
		
		List<EntityContainer> entityContainers = new ArrayList<EntityContainer>();
		EntityContainer entityContainer = new EntityContainer();
		entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);
//		entityContainer.
		List<EntitySet> entitySets = new ArrayList<EntitySet>();
		EntitySet caSystemEntitySet =caSystemEDM.getEntitySet( );
		entitySets.add(caSystemEntitySet);
 		entitySets.add(hrHierEDM.getEntitySet());
 		entitySets.add(hrHierMapEDM.getEntitySet());
 		entitySets.add(hrObjectsRelEDM.getEntitySet());
 		entitySets.add(hrObjectConstraintsEDM.getEntitySet());
 		entitySets.add(hrObjectsEDM.getEntitySet());
 		entitySets.add(hrObjectsStutusEDM.getEntitySet());
		entitySets.add(hrP1000EDM.getEntitySet());
		entitySets.add(hrP1001EDM.getEntitySet() );
		entitySets.add(hrRelationsEDM.getEntitySet());
		entitySets.add(tenantEDM.getEntitySet( ));
		entityContainer.setEntitySets(entitySets);

		List<AssociationSet> associationSets = new ArrayList<AssociationSet>();
		associationSets.add(entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getAssociationSet(entityContainer.getName(), ASSOCIATION_FQN_CASYSTEM_TENANT));
		associationSets.add(entityFactory.getEDM(ENTITY_KEY_HRHIER).getAssociationSet(entityContainer.getName(), ASSOCIATION_FQN_HRHIER_HRHIERMAP));
		
		associationSets.add(entityFactory.getEDM(ENTITY_KEY_TENANTS).getAssociationSet(entityContainer.getName(), ASSOCIATION_FQN_CASYSTEM_TENANT));
		
		entityContainer.setAssociationSets(associationSets);
		 
		

		entityContainers.add(entityContainer);
		schema.setEntityContainers(entityContainers);

		schemas.add(schema);

		return schemas;
	}




	@Override
	public EntityType getEntityType(FullQualifiedName edmFQName)
			throws ODataException {
		if (NAMESPACE.equals(edmFQName.getNamespace())) {
			  if (edmFQName.getName().equals(ENTITY_TYPE_NAME_CASYSTEM)) {
			EntityType entityType =entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getEntityType();

		return entityType; 	
				
			  }else 			  if (edmFQName.getName().equals(ENTITY_TYPE_NAME_HRHIER)) {
					EntityType entityType =entityFactory.getEDM(ENTITY_KEY_TENANTS).getEntityType();

					return entityType; 	
							
						  } else 			  if (edmFQName.getName().equals(ENTITY_TYPE_NAME_TENANTS)) {
					EntityType entityType =entityFactory.getEDM(ENTITY_KEY_TENANTS).getEntityType();

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
			    	EntitySet entitySet =  entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getEntitySet();
			      return entitySet;
			    } else if (ENTITY_SET_NAME_HRHIER.equals(name)) {
			    	EntitySet entitySet =  entityFactory.getEDM(ENTITY_KEY_HRHIER).getEntitySet();
				return entitySet; 
			    }  else if (ENTITY_SET_NAME_TENANTS.equals(name)) {
			    	EntitySet entitySet =  entityFactory.getEDM(ENTITY_KEY_TENANTS).getEntitySet();
				return entitySet; 
			    } 
			  }
			  return null;
	}




	@Override
	public EntityContainerInfo getEntityContainerInfo(String name)
			throws ODataException {
		 if (name == null || "ODataMOCEntityContainer".equals(name)) {
			    return new EntityContainerInfo().setName("ODataMOCEntityContainer").setDefaultEntityContainer(true);
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
//			FullQualifiedName fqName = ASSOCIATION_FQN_CASYSTEM_TENANT;
		    if (ASSOCIATION_FQN_CASYSTEM_TENANT.getName().equals(edmFQName.getName())) {
		      Association association = entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getAssociation(edmFQName);
		    	return association;
		    }
		  }
		  return null;
		  }
		
		
	 




	@Override
	public AssociationSet getAssociationSet(String entityContainer,
			FullQualifiedName association, String sourceEntitySetName,
			String sourceEntitySetRole) throws ODataException {
		 if (ENTITY_CONTAINER.equals(entityContainer)) {
			    if (ASSOCIATION_FQN_CASYSTEM_TENANT.equals(association)) {
			    	AssociationSet associationSet = entityFactory.getEDM(ENTITY_KEY_CASYSTEM).getAssociationSet( entityContainer,
			    			 association );
			      return associationSet;
			    }
			  }
			  return null;
	
 
	}


}
