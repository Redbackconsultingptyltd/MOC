package au.com.redbackconsulting.moc.odata.api;

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
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRHIERMAP;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTREL;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSCONSTRAINTS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HROBJECTSSTATUS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1000;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRP1001;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_HRRELATIONS;
import static au.com.redbackconsulting.moc.odata.api.Constants.ENTITY_SET_NAME_TENANTS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_CASYSTEMS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIER;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRHIERMAP; 
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTCONSTRAINTS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTSREL;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HROBJECTSTATUS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRP1000;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRP1001;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_HRRELATIONS;
import static au.com.redbackconsulting.moc.persistence.factory.Constants.PERSISTENCE_TENANTS;



















import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderReadProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.ep.entry.ODataEntry;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.info.DeleteUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.PostUriInfo;
import org.apache.olingo.odata2.api.uri.info.PutMergePatchUriInfo;
import org.apache.olingo.odata2.core.commons.ContentType;

import au.com.redbackconsulting.moc.odata.api.bl.BLModelFactory;
import au.com.redbackconsulting.moc.odata.api.bl.IBLModel;
import au.com.redbackconsulting.moc.odata.api.edmconstants.CaSystemEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HRP1001EDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrHierMapEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectRelEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsConstraintsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrObjectsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.HrRelationsEDM;
import au.com.redbackconsulting.moc.odata.api.edmconstants.TenantsEDM;
import au.com.redbackconsulting.moc.persistence.factory.Constants;
import au.com.redbackconsulting.moc.persistence.factory.PKFactory;
import au.com.redbackconsulting.moc.persistence.model2.Casystem;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhiermap;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectrel;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectrelPK;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsconstraintPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrobjectsstatus;
import au.com.redbackconsulting.moc.persistence.model2.HrobjectsstatusPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000;
import au.com.redbackconsulting.moc.persistence.model2.Hrp1000PK;
import au.com.redbackconsulting.moc.persistence.model2.HrrelationPK;
import au.com.redbackconsulting.moc.persistence.model2.IDBEntity;
import au.com.redbackconsulting.moc.persistence.model2.Tenant;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class MyODataSingleProcessor extends ODataSingleProcessor {

	// private DataStore dataStore = new DataStore();
	private BLModelFactory bmf = BLModelFactory.getInstance();

	@Override
	public ODataResponse readEntity(GetEntityUriInfo uriInfo, String contentType)
			throws ODataException {

		if (uriInfo.getNavigationSegments().size() == 0) {
			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
			IBLModel bModel =bmf.getInstance1(entitySet);
			Map<String , Object > result = bModel.read(uriInfo);
			if(result!=null){
			URI serviceRoot1 = getContext().getPathInfo().getServiceRoot();
			ODataEntityProviderPropertiesBuilder propertiesBuilder1 = EntityProviderWriteProperties
					.serviceRoot(serviceRoot1);
			return EntityProvider.writeEntry(contentType, entitySet, result,
					propertiesBuilder1.build());
			}
			
//			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
//				CasystemPK pk = (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
//				pk.setIdsys(sysId);
//				pk.setTenants_idTenants((tenantId));
// 
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//				
//				if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
//				int hierId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
//				HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
//				pk.setIdHrHier(hierId);
//				pk.setTenants_idTenants(tenantId);
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//				
				
//				if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIERMAP);
//				
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				int seqNo = getKeyValue(uriInfo.getKeyPredicates().get(2));
//
//				HrhiermapPK pk = (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);
//
//				pk.setHrHierId((id));
//				pk.setTenants_idTenants(tenantId);
//				pk.setSeqNo(seqNo);
//
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//				
				
//				if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSREL);
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int objectType = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				int timeConstraints = getKeyValue(uriInfo.getKeyPredicates().get(2));
//				int sObjectType = getKeyValue(uriInfo.getKeyPredicates().get(3));
//				String relatType = getKeyValueString(uriInfo.getKeyPredicates().get(4));
//				
//				
//				
//				
//
//				HrobjectrelPK pk = (HrobjectrelPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTSREL);
//				pk.setIdobjectype(objectType);
//				pk.setIdrelatType(relatType);
//				pk.setIdsobjectype(sObjectType);
//				pk.setTenants_idTenants(tenantId);
//				pk.setTimeConstraints(timeConstraints);
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//				
				
//				if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
//				int objectType  = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTS);
//				HrobjectPK pk = (HrobjectPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTS);
//				pk.setIdObjectType(objectType);
//				pk.setTenants_idTenants(tenantId);
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//				
//				if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet
//					.getName())) {
//				int objectType = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//
//				
//				IBLModel blModel = bmf
//						.getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
//				HrobjectsconstraintPK  pk = (HrobjectsconstraintPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTCONSTRAINTS);
//				pk.setHrObject(objectType);
//				pk.setTenants_idTenants(tenantId);
//				
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
////				
//				if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet
//					
//					.getName())) {
//				int hrobjectStatusId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSSTATUS);
//				HrobjectsstatusPK pk =(HrobjectsstatusPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HROBJECTSTATUS);
//				pk.setIdHrObjectsStatus(hrobjectStatusId);
//				pk.setTenants_idTenants(tenantId);
//				
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else 
//			if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
//				TenantPK pk = new TenantPK();
//				pk.setId((tenantId));
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
//				TenantPK pk = new TenantPK();
//				pk.setId((tenantId));
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} else
//				
//				
//				if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
//				String relatType = getKeyValueString(uriInfo.getKeyPredicates().get(0));
//
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRRELATIONS);
//				HrrelationPK  pk = (HrrelationPK) PKFactory.getInstance().getPKModel(Constants.PERSISTENCE_HRRELATIONS);
//				pk.setRelatType(relatType);
//				pk.setTenants_idTenants(tenantId);
//				// Map<String, Object> data = blModel.getData(pk);
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//						.serviceRoot(serviceRoot);
//				return EntityProvider.writeEntry(contentType, entitySet, data,
//						propertiesBuilder.build());
//			} 
//
//		} else if (uriInfo.getNavigationSegments().size() == 1) {
//			EdmEntitySet entitySet = uriInfo.getTargetEntitySet();
//
//			if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
//				// String sysId =
//				// getKeyValueString(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
//				TenantPK pk =  (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
//				pk.setId((tenantId));
//				IDBEntity entity = blModel.getData(pk);
//				Map<String, Object> data = blModel.convertModelToEDM(entity);
//
////				List<Map<String, Object>> result1 = new ArrayList<Map<String, Object>>();
////				result1.add(data);
//				if (data != null) {
//					URI serviceRoot = getContext().getPathInfo()
//							.getServiceRoot();
//					ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
//							.serviceRoot(serviceRoot);
//
//					return EntityProvider.writeEntry(contentType, entitySet,
//							data, propertiesBuilder.build());
//				}
//
//			} 

		}
		return null;

		// if (uriInfo.getNavigationSegments().size() == 0) {
		// EdmEntitySet entitySet = uriInfo.getStartEntitySet();
		//
		// if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
		// int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		// Map<String, Object> data = dataStore.getCar(id);
		//
		// if (data != null) {
		// URI serviceRoot = getContext().getPathInfo()
		// .getServiceRoot();
		// ODataEntityProviderPropertiesBuilder propertiesBuilder =
		// EntityProviderWriteProperties
		// .serviceRoot(serviceRoot);
		//
		// return EntityProvider.writeEntry(contentType, entitySet,
		// data, propertiesBuilder.build());
		// }
		// } else if (ENTITY_SET_NAME_MANUFACTURERS
		// .equals(entitySet.getName())) {
		// int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		// Map<String, Object> data = dataStore.getManufacturer(id);
		//
		// if (data != null) {
		// URI serviceRoot = getContext().getPathInfo()
		// .getServiceRoot();
		// ODataEntityProviderPropertiesBuilder propertiesBuilder =
		// EntityProviderWriteProperties
		// .serviceRoot(serviceRoot);
		//
		// return EntityProvider.writeEntry(contentType, entitySet,
		// data, propertiesBuilder.build());
		// }
		// } else if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
		// int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		// // Map<String, Object> data = dataStore.getSan(id);
		//
		// } else if (ENTITY_SET_NAME_CASYSTEMS.equals(entitySet.getName())) {
		// int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
		//
		// Map<String, Object> data = dataStore.getCaSystem(id);
		//
		// if (data != null) {
		// URI serviceRoot = getContext().getPathInfo()
		// .getServiceRoot();
		// ODataEntityProviderPropertiesBuilder propertiesBuilder =
		// EntityProviderWriteProperties
		// .serviceRoot(serviceRoot);
		//
		// return EntityProvider.writeEntry(contentType, entitySet,
		// data, propertiesBuilder.build());
		// }
		// }
		// throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		//
		// } else if (uriInfo.getNavigationSegments().size() == 1) {
		// // navigation first level, simplified example for illustration
		// // purposes only
		// EdmEntitySet entitySet = uriInfo.getTargetEntitySet();
		// if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
		// int carKey = getKeyValue(uriInfo.getKeyPredicates().get(0));
		// return EntityProvider.writeEntry(
		// contentType,
		// uriInfo.getTargetEntitySet(),
		// dataStore.getManufacturer(carKey),
		// EntityProviderWriteProperties.serviceRoot(
		// getContext().getPathInfo().getServiceRoot())
		// .build());
		// }
		//
		// throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		// }
		//
		// throw new ODataNotImplementedException();
	}

	// Implement MyODataSingleProcessor.readEntitySet(GetEntitySetUriInfo
	// uriParserResultInfo) by overriding the corresponding method of the
	// ODataSingleProcessor

	public ODataResponse readEntitySet(GetEntitySetUriInfo uriInfo,
			String contentType) throws ODataException {

		EdmEntitySet entitySet;

		if (uriInfo.getNavigationSegments().size() == 0) {
			entitySet = uriInfo.getStartEntitySet();
			IBLModel bModel = BLModelFactory.getInstance().getInstance1(entitySet);
			if(bModel!=null){
			List<Map<String, Object>>result =	bModel.readSet();
			//String jsonContent = org.apache.olingo.odata2.api.commons.HttpContentType.APPLICATION_JSON;
			return EntityProvider.writeFeed(
				contentType,
					entitySet,
					result,
					EntityProviderWriteProperties.serviceRoot(
							getContext().getPathInfo().getServiceRoot())
							.build());	
			}
			
//			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIERMAP);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSREL);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTS);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet
//					.getName())) {
//				IBLModel blModel = bmf
//						.getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet
//					.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSSTATUS);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1000);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRRELATIONS);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
//				List<IDBEntity> entities = blModel.getDataSet();
//				List<Map<String, Object>> data = blModel
//						.convertModelToEDMCollection(entities);
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//
//		} else if (uriInfo.getNavigationSegments().size() == 1) {
//			// navigation first level, simplified example for illustration
//			// purposes only
//			entitySet = uriInfo.getTargetEntitySet();
//
//			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
//				TenantPK pk = new TenantPK();
//				// pk.setSystId(sysId);
//				pk.setId((tenantId));
//				List<Map<String, Object>> data = blModel.getRelatedData(pk);
//				// List<Map<String, Object>> result1 = new ArrayList<Map<String,
//				// Object>>();
//				// result1.add(data);
//
//				return EntityProvider.writeFeed(
//						contentType,
//						entitySet,
//						data,
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//
//			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
//		} else if (uriInfo.getNavigationSegments().size() == 1) {
//			// navigation first level, simplified example for illustration
//			// purposes only
//			entitySet = uriInfo.getTargetEntitySet();
//
//			// if (ENTITY_SET_NAME_CASYSTEMS.equals(entitySet.getName())) {
//			// int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//			//
//			// List<Map<String, Object>> caSystems = new ArrayList<Map<String,
//			// Object>>();
//			// caSystems.addAll(dataStore.getCaSystems());
//			//
//			// return EntityProvider.writeFeed(
//			// contentType,
//			// entitySet,
//			// caSystems,
//			// EntityProviderWriteProperties.serviceRoot(
//			// getContext().getPathInfo().getServiceRoot())
//			// .build());
//			// }
//
//			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		}

		throw new ODataNotImplementedException();
	}

	@Override
	public ODataResponse updateEntity(PutMergePatchUriInfo uriInfo,
			InputStream content, String requestContentType, boolean merge,
			String contentType) throws ODataException {

		if (uriInfo.getNavigationSegments().size() > 0) {
			throw new ODataNotImplementedException();
		}

 
		EntityProviderReadProperties properties = EntityProviderReadProperties
				.init().mergeSemantic(false).build();
		ODataEntry entry = EntityProvider.readEntry(requestContentType,
				uriInfo.getStartEntitySet(), content, properties);
		Map<String, Object> data = entry.getProperties();

		if (uriInfo.getNavigationSegments().size() == 0) {
			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
			IBLModel bModel =BLModelFactory.getInstance().getInstance1(entitySet);
			Map<String, Object>result = bModel.update(uriInfo, data);
			
			return ODataResponse.status(HttpStatusCodes.OK).build();
			
//			if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_TENANTS);
//				//Read PK from URL
//				int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(0));
//				TenantPK pk = new TenantPK();
//				pk.setId(pkTenantId);
//
//				
//				//Read Form Data
//				Tenant entity = (Tenant) blModel.convertEDMDataToModelEDM(data);
//				
//		 		entity = (Tenant) blModel.updateData(pk, entity);
//		 		if(entity!=null){
//				return super.updateEntity(uriInfo, content, requestContentType
//						,
//						merge, contentType);
//		 		} else { 
//		 			///
//		 		}
//			} else if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_CASYSTEM);
//				CasystemPK pk = (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
//				int pksysId =getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int pkTenantId =getKeyValue(uriInfo.getKeyPredicates().get(1));
//				
//				pk.setIdsys(pksysId);
//				pk.setTenants_idTenants(pkTenantId);
//
//				Casystem entity = (Casystem) blModel.convertEDMDataToModelEDM(data);
//				
//				entity = (Casystem) blModel.updateData(pk, entity);
//
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else	if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
//				
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
//				
//				int hierId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
//				pk.setIdHrHier(hierId);
//				pk.setTenants_idTenants(tenantId);
//			
//				 
//								
//				//Read Form Data
//				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
//				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRHIERMAP);
//				//Read PK from URL
//				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				int seqNo =getKeyValue(uriInfo.getKeyPredicates().get(1));
//				int pktenantId =getKeyValue(uriInfo.getKeyPredicates().get(2));
//				PKFactory pkFactory= PKFactory.getInstance();
//				HrhiermapPK pk = (HrhiermapPK) pkFactory.getPKModel(PERSISTENCE_HRHIERMAP);
//				pk.setTenants_idTenants(pktenantId);
//				pk.setHrHierId(pkId);
//				pk.setSeqNo(seqNo);
//				
//				//Read Form Data
//				Hrhiermap entity =   (Hrhiermap) blModel.convertEDMDataToModelEDM(data);
//			
//				
//				entity =  (Hrhiermap) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTS);
//				Map<String, Object > result =blModel.update(uriInfo, data);
////				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectPK pk = (HrobjectPK) pkFactory.getPKModel(PERSISTENCE_HROBJECTS);
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTSREL);
//				blModel.update(uriInfo, data);
//				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HROBJECTSREL);
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTSCONSTRAINTS);
//				blModel.update(uriInfo, data);
//				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HROBJECTCONSTRAINTS);
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTSSTATUS);
//				blModel.update(uriInfo, data);
//				//				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HROBJECTSTATUS);
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			} else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRP1000);
//				blModel.update(uriInfo, data);
////				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HRP1000);
////				
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			} else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRP1001);
//				blModel.update(uriInfo, data);
////				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HRP1001);
////				
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
//				
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRRELATIONS);
//				blModel.update(uriInfo, data);
////				//Read PK from URL
////				int pkId =getKeyValue(uriInfo.getKeyPredicates().get(0));
////				PKFactory pkFactory= PKFactory.getInstance();
////				HrobjectrelPK  pk = (HrobjectrelPK) pkFactory.getPKModel(PERSISTENCE_HRRELATIONS);
////				
////				pk.setTenants_idTenants(pkId);
////
////				
////				//Read Form Data
////				Hrhier entity =   (Hrhier) blModel.convertEDMDataToModelEDM(data);
////				entity =  (Hrhier) blModel.updateData(pk, entity);
//				return super.updateEntity(uriInfo, content, requestContentType,
//						merge, contentType);
//			}
//


		}
		return null;
		

	}

	private int getKeyValue(KeyPredicate key) throws ODataException {
		EdmProperty property = key.getProperty();
		EdmSimpleType type = (EdmSimpleType) property.getType();
		return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
				property.getFacets(), Integer.class);
	}

	private String getKeyValueString(KeyPredicate key) throws ODataException {
		EdmProperty property = key.getProperty();
		EdmSimpleType type = (EdmSimpleType) property.getType();
		return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT,
				property.getFacets(), String.class);
	}

	@Override
	public ODataResponse createEntity(PostUriInfo uriInfo, InputStream content,
			String requestContentType, String contentType)
			throws ODataException {
		EdmEntitySet entitySet;
		if (uriInfo.getNavigationSegments().size() > 0) {
			throw new ODataNotImplementedException();
		}

		// No support for media resources
		if (uriInfo.getStartEntitySet().getEntityType().hasStream()) {
			throw new ODataNotImplementedException();
		}

		EntityProviderReadProperties properties = EntityProviderReadProperties
				.init().mergeSemantic(false).build();

		ODataEntry entry = EntityProvider.readEntry(requestContentType,
				uriInfo.getStartEntitySet(), content, properties);
		// if something goes wrong in deserialization this is managed via the
		// ExceptionMapper
		// no need for an application to do exception handling here an convert
		// the exceptions in HTTP exceptions

		Map<String, Object> data = entry.getProperties();
		// now one can use the data to create the entry in the backend ...
		// retrieve the key value after creation, if the key is generated by the
		// server

		if (uriInfo.getNavigationSegments().size() == 0) {
			entitySet = uriInfo.getStartEntitySet();
			IBLModel bModel =bmf.getInstance1(entitySet);
			Map<String, Object > result =bModel.createNew(data);
			return EntityProvider.writeEntry(
					contentType,
					uriInfo.getStartEntitySet(),
					result,
				 
					EntityProviderWriteProperties.serviceRoot(
							getContext().getPathInfo().getServiceRoot())
							.build());
			// update the data accordingly
//			if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_TENANTS);
//
//				TenantPK  pk = (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
//				
//				Tenant entity = (Tenant) blModel.convertEDMDataToModelEDM(data);
//				
//				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_CASYSTEM);
//
//				int tenantId = (Integer) data.get(CaSystemEDM.TENANTID);
//				String sysDesc = (String) data.get(CaSystemEDM.SYSDESC);
//				CasystemPK pk = new CasystemPK();
//				pk.setTenants_idTenants(tenantId);
//				Casystem entity = new Casystem();
//				entity.setId(pk);
//				entity.setSysdesc(sysDesc);
//				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else
//			if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRHIER);
//
//				int tenantId = (Integer) data.get(HrHierEDM.tenantId);
////				int hierId = (Integer) data.get(HrHierEDM.hierId);
//				String hierDesc = (String) data.get(HrHierEDM.hierDesc);
//				HrhierPK pk = (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
////				HrhierPK pk = new HrhierPK();
//				pk.setTenants_idTenants(tenantId);
////				pk.setIdHrHier(hierId);
//				Hrhier entity = (Hrhier) blModel.convertEDMDataToModelEDM(data);
//
//				
//				entity.setHierdesc(hierDesc);
//				entity.getId().setIdHrHier(0);
//				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HRHIERMAP);
//
////				int tenantId = (Integer) data.get(HrHierMapEDM.tenantId);
////				int hierId = (Integer) data.get(HrHierMapEDM.hierId);
////				String objectType = (String) data.get(HrHierMapEDM.objectType);
////				int relatType = (Integer) data.get(HrHierMapEDM.relatType);
//
////				HrhiermapPK pk = (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);
////				pk.setTenants_idTenants(tenantId);
// 
//				Hrhiermap entity = (Hrhiermap) blModel.convertEDMDataToModelEDM(data);
//
////				entity.setId(pk);
//				// entity.setHierdesc(hierDesc);
//				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTS);
//				Map<String, Object> result = blModel.createNew(data);
//
//				int tenantId = (Integer) data.get(HrObjectsEDM.tenantId);
////				int hierId = (Integer) data.get(HrObjectsEDM.hierId);
////				String objectType = (String) data.get(HrObjectsEDM.objectType);
////				int relatType = (Integer) data.get(HrObjectsEDM.relatType);
//
//				HrobjectPK pk = (HrobjectPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTS);
//				pk.setTenants_idTenants(tenantId);
//			 
//				Hrhier entity = new Hrhier();
//
//				//entity.setId(pk);
//				// entity.setHierdesc(hierDesc);
//				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						result,
//					//	entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTSREL);
//				Map<String, Object> result =blModel.createNew(data);
//
////				int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
////			//	int hierId = (Integer) data.get(HrObjectRelEDM.hierId);
////				String objectType = (String) data.get(HrObjectRelEDM.objectType);
////				int relatType = (Integer) data.get(HrObjectRelEDM.relatType);
////
////				HrobjectrelPK  pk = (HrobjectrelPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTSREL);
////				Hrobjectrel entity = (Hrobjectrel) blModel.convertEDMDataToModelEDM(data);
////
////				pk.setTenants_idTenants(tenantId);
////				
////				entity.setId(pk);
////				// entity.setHierdesc(hierDesc);
////				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						result,
//						//entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet.getName())) {
//				IBLModel blModel = BLModelFactory.getInstance().getInstance(
//						ENTITY_KEY_HROBJECTSCONSTRAINTS);
//
//				Map<String, Object> result =blModel.createNew(data);
////				int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
////			//	int hierId = (Integer) data.get(HrObjectsConstraintsEDM.hierId);
////				String objectType = (String) data.get(HrObjectsConstraintsEDM.objectType);
////			//	int relatType = (Integer) data.get(HrObjectsConstraintsEDM.relatType);
////
////				HrhierPK pk = new HrhierPK();
////				pk.setTenants_idTenants(tenantId);
////		//		pk.setIdHrHier(hierId);
////				Hrhier entity = new Hrhier();
////
////				entity.setId(pk);
////				// entity.setHierdesc(hierDesc);
////				blModel.createData(entity);
//
//				// serialize the entry, Location header is set by OData Library
//				return EntityProvider.writeEntry(
//						contentType,
//						uriInfo.getStartEntitySet(),
//						result,
//						//entry.getProperties(),
//						EntityProviderWriteProperties.serviceRoot(
//								getContext().getPathInfo().getServiceRoot())
//								.build());
//			}
//			 else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet.getName())) {
//					IBLModel blModel = BLModelFactory.getInstance().getInstance(
//							ENTITY_KEY_HROBJECTSSTATUS);
//					Map<String , Object> result = blModel.createNew(data);
//
////					int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
////				//	int hierId = (Integer) data.get(HrObjectsConstraintsEDM.hierId);
////					String objectType = (String) data.get(HrObjectsConstraintsEDM.objectType);
////			//		int relatType = (Integer) data.get(HrObjectsConstraintsEDM.relatType);
////
////					HrobjectsstatusPK  pk = (HrobjectsstatusPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTSREL);
////					Hrobjectsstatus entity = (Hrobjectsstatus) blModel.convertEDMDataToModelEDM(data);
////
////				 
////					entity.setId(pk);
////					// entity.setHierdesc(hierDesc);
////					blModel.createData(entity);
//
//					// serialize the entry, Location header is set by OData Library
//					return EntityProvider.writeEntry(
//							contentType,
//							uriInfo.getStartEntitySet(),
//							entry.getProperties(),
//							EntityProviderWriteProperties.serviceRoot(
//									getContext().getPathInfo().getServiceRoot())
//									.build());
//				}
//			 else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
//					IBLModel blModel = BLModelFactory.getInstance().getInstance(
//							ENTITY_KEY_HRP1000);
//
//					int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
//				//	int hierId = (Integer) data.get(HrObjectsConstraintsEDM.hierId);
//					String objectType = (String) data.get(HrObjectsConstraintsEDM.objectType);
//				//	int relatType = (Integer) data.get(HrObjectsConstraintsEDM.relatType);
//
//					Hrp1000PK  pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRP1000);
//					Hrp1000 entity = (Hrp1000) blModel.convertEDMDataToModelEDM(data);
//
//				 
//					entity.setId(pk);
//					// entity.setHierdesc(hierDesc);
//					blModel.createData(entity);
//
//					// serialize the entry, Location header is set by OData Library
//					return EntityProvider.writeEntry(
//							contentType,
//							uriInfo.getStartEntitySet(),
//							entry.getProperties(),
//							EntityProviderWriteProperties.serviceRoot(
//									getContext().getPathInfo().getServiceRoot())
//									.build());
//				}
//			 else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
//					IBLModel blModel = BLModelFactory.getInstance().getInstance(
//							ENTITY_KEY_HRP1001);
//
//					int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
//				//	int hierId = (Integer) data.get(HrObjectsConstraintsEDM.hierId);
//					String objectType = (String) data.get(HrObjectsConstraintsEDM.objectType);
////					int relatType = (Integer) data.get(HrObjectsConstraintsEDM.relatType);
//
//					//Hrp1001PK  pk = (Hrp1000PK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRP1001);
////					HRP1001EDM entity = (Hrp1001) blModel.convertEDMDataToModelEDM(data);
//
//				 
////					entity.setId(pk);
////					// entity.setHierdesc(hierDesc);
////					blModel.createData(entity);
//
//					// serialize the entry, Location header is set by OData Library
//					return EntityProvider.writeEntry(
//							contentType,
//							uriInfo.getStartEntitySet(),
//							entry.getProperties(),
//							EntityProviderWriteProperties.serviceRoot(
//									getContext().getPathInfo().getServiceRoot())
//									.build());
//				}
//			 else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
//					IBLModel blModel = BLModelFactory.getInstance().getInstance(
//							ENTITY_KEY_HRRELATIONS);
//					
//					Map<String, Object> result =blModel.createNew(data);
//
////					int tenantId = (Integer) data.get(HrObjectRelEDM.tenantId);
//////					int hierId = (Integer) data.get(HrObjectsConstraintsEDM.hierId);
////					String objectType = (String) data.get(HrObjectsConstraintsEDM.objectType);
//////					int relatType = (Integer) data.get(HrObjectsConstraintsEDM.relatType);
////
////					HrrelationPK  pk = (HrrelationPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRRELATIONS);
////					HrRelationsEDM  entity = (HrRelationsEDM) blModel.convertEDMDataToModelEDM(data);
////
////				 
//////					entity.setId(pk);
//////					// entity.setHierdesc(hierDesc);
//////					blModel.createData(entity);
//
//					// serialize the entry, Location header is set by OData Library
//					return EntityProvider.writeEntry(
//							contentType,
//							uriInfo.getStartEntitySet(),
//							result,
//						//	entry.getProperties(),
//							EntityProviderWriteProperties.serviceRoot(
//									getContext().getPathInfo().getServiceRoot())
//									.build());
//				}
		}
		return null;
		
	}

	@Override
	public ODataResponse deleteEntity(DeleteUriInfo uriInfo, String contentType)
			throws ODataException {
		if (uriInfo.getNavigationSegments().size() == 0) {
			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
			IBLModel bModel = bmf.getInstance1(entitySet);
			boolean status =bModel.delete(uriInfo);
			if(status)
				return ODataResponse.status(HttpStatusCodes.OK).build();
			else

				return ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
//				int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
//				CasystemPK pk =  (CasystemPK) PKFactory.getInstance().getPKModel(PERSISTENCE_CASYSTEMS);
//				pk.setIdsys(sysId);
//				pk.setTenants_idTenants((tenantId));
//				boolean status = blModel.deleteData(pk);
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
//				HrhierPK pk =  (HrhierPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIER);
//				pk.setIdHrHier(id);
//				pk.setTenants_idTenants(tenantId);
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
//				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
//				int seqNo = getKeyValue(uriInfo.getKeyPredicates().get(2));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIERMAP);
//				HrhiermapPK pk =  (HrhiermapPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRHIERMAP);
//
//				pk.setHrHierId((id));
//				pk.setTenants_idTenants(tenantId);
//				pk.setSeqNo(seqNo);
//
//				boolean status = blModel.deleteData(pk);
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSREL);
//				HrobjectrelPK pk =  (HrobjectrelPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTSREL);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTS);
//				HrobjectPK pk =  (HrobjectPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTS);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet
//					.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf
//						.getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
//				HrobjectsconstraintPK pk =  (HrobjectsconstraintPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTCONSTRAINTS);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet
//					.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSSTATUS);
//				HrobjectsstatusPK pk =  (HrobjectsstatusPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HROBJECTSTATUS);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
//				Hrp1000PK pk =  (Hrp1000PK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRP1000);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} 
////			else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
////				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
////
////				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
////				TenantPK pk =  PKFactory.getInstance().getPKModel(PERSISTENCE_HRRELATIONS);
////				pk.setId((tenantId));
////				boolean status = blModel.deleteData(pk);
////
////				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
////				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
////			}
//		else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRRELATIONS);
//				HrrelationPK pk =  (HrrelationPK) PKFactory.getInstance().getPKModel(PERSISTENCE_HRRELATIONS);
////				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			} else if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
//				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
//
//				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
//				TenantPK pk =  (TenantPK) PKFactory.getInstance().getPKModel(PERSISTENCE_TENANTS);
//				pk.setId((tenantId));
//				boolean status = blModel.deleteData(pk);
//
//				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
//				ODataResponse.status(HttpStatusCodes.NO_CONTENT).build();
//			}

		}
		return null;
	}
}
