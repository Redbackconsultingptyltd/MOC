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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;

import au.com.redbackconsulting.moc.odata.api.bl.BLModelFactory;
import au.com.redbackconsulting.moc.odata.api.bl.IBLModel;
import au.com.redbackconsulting.moc.persistence.model2.CasystemPK;
import au.com.redbackconsulting.moc.persistence.model2.Hrhier;
import au.com.redbackconsulting.moc.persistence.model2.HrhierPK;
import au.com.redbackconsulting.moc.persistence.model2.HrhiermapPK;
import au.com.redbackconsulting.moc.persistence.model2.TenantPK;

public class MyODataSingleProcessor extends ODataSingleProcessor {

	// private DataStore dataStore = new DataStore();
	private BLModelFactory bmf = BLModelFactory.getInstance();

	@Override
	public ODataResponse readEntity(GetEntityUriInfo uriInfo, String contentType)
			throws ODataException {

		if (uriInfo.getNavigationSegments().size() == 0) {
			EdmEntitySet entitySet = uriInfo.getStartEntitySet();
			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
				int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
				CasystemPK pk = new CasystemPK();
				pk.setIdsys(sysId);
				pk.setTenants_idTenants((tenantId));
				Map<String, Object> data = blModel.getData(pk);
				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
				HrhierPK pk = new HrhierPK();
				pk.setIdHrHier(id);
				pk.setTenants_idTenants(tenantId);
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
				int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
				int seqNo = getKeyValue(uriInfo.getKeyPredicates().get(2));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIERMAP);
				HrhiermapPK pk = new HrhiermapPK();
			
				pk.setHrHierId((id));
				pk.setTenants_idTenants(tenantId);
				pk.setSeqNo(seqNo);
				
				Map<String, Object> data = blModel.getData(pk);
				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSREL);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTS);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet
					.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf
						.getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet
					.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSSTATUS);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			} else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRRELATIONS);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			}
			else if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));

				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				TenantPK pk = new TenantPK();
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);

				URI serviceRoot = getContext().getPathInfo().getServiceRoot();
				ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
						.serviceRoot(serviceRoot);
				return EntityProvider.writeEntry(contentType, entitySet, data,
						propertiesBuilder.build());
			}
			
		} else if (uriInfo.getNavigationSegments().size() == 1) {
			EdmEntitySet entitySet = uriInfo.getTargetEntitySet();

			if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
				// String sysId =
				// getKeyValueString(uriInfo.getKeyPredicates().get(0));
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				TenantPK pk = new TenantPK();
				// pk.setSystId(sysId);
				pk.setId((tenantId));
				Map<String, Object> data = blModel.getData(pk);
				List<Map<String, Object>> result1 = new ArrayList<Map<String, Object>>();
				result1.add(data);
				if (data != null) {
					URI serviceRoot = getContext().getPathInfo()
							.getServiceRoot();
					ODataEntityProviderPropertiesBuilder propertiesBuilder = EntityProviderWriteProperties
							.serviceRoot(serviceRoot);

					return EntityProvider.writeEntry(contentType, entitySet,
							data, propertiesBuilder.build());
				}

			} else if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(1));
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				TenantPK pk = new TenantPK();
				// pk.setSystId(sysId);
				pk.setId((tenantId));
				List<Map<String, Object>> data = blModel.getRelatedData(pk);
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());

			}

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

			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_CASYSTEM);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HRHIER.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIER);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}

			else if (ENTITY_SET_NAME_HRHIERMAP.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRHIERMAP);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HROBJECTREL.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSREL);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HROBJECTS.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTS);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HROBJECTSCONSTRAINTS.equals(entitySet
					.getName())) {
				IBLModel blModel = bmf
						.getInstance(ENTITY_KEY_HROBJECTSCONSTRAINTS);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HROBJECTSSTATUS.equals(entitySet
					.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HROBJECTSSTATUS);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}

			else if (ENTITY_SET_NAME_HRP1000.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1000);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_HRP1001.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRP1001);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}

			else if (ENTITY_SET_NAME_HRRELATIONS.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_HRRELATIONS);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			} else if (ENTITY_SET_NAME_TENANTS.equals(entitySet.getName())) {
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				List<Map<String, Object>> data = blModel.getDataSet();
				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}

			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

		} else if (uriInfo.getNavigationSegments().size() == 1) {
			// navigation first level, simplified example for illustration
			// purposes only
			entitySet = uriInfo.getTargetEntitySet();

			if (ENTITY_SET_NAME_CASYSTEM.equals(entitySet.getName())) {

				int tenantId = getKeyValue(uriInfo.getKeyPredicates().get(0));
				IBLModel blModel = bmf.getInstance(ENTITY_KEY_TENANTS);
				TenantPK pk = new TenantPK();
				// pk.setSystId(sysId);
				pk.setId((tenantId));
				List<Map<String, Object>> data = blModel.getRelatedData(pk);
				// List<Map<String, Object>> result1 = new ArrayList<Map<String,
				// Object>>();
				// result1.add(data);

				return EntityProvider.writeFeed(
						contentType,
						entitySet,
						data,
						EntityProviderWriteProperties.serviceRoot(
								getContext().getPathInfo().getServiceRoot())
								.build());
			}

			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		} else if (uriInfo.getNavigationSegments().size() == 1) {
			// navigation first level, simplified example for illustration
			// purposes only
			entitySet = uriInfo.getTargetEntitySet();

			// if (ENTITY_SET_NAME_CASYSTEMS.equals(entitySet.getName())) {
			// int sysId = getKeyValue(uriInfo.getKeyPredicates().get(0));
			//
			// List<Map<String, Object>> caSystems = new ArrayList<Map<String,
			// Object>>();
			// caSystems.addAll(dataStore.getCaSystems());
			//
			// return EntityProvider.writeFeed(
			// contentType,
			// entitySet,
			// caSystems,
			// EntityProviderWriteProperties.serviceRoot(
			// getContext().getPathInfo().getServiceRoot())
			// .build());
			// }

			throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
		}

		throw new ODataNotImplementedException();
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
}
