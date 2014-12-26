

package au.com.redbackconsulting.moc.odata.api;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;

public class MyServiceFactory extends ODataServiceFactory {

	@Override
	public ODataService createService(ODataContext ctx) throws ODataException {
		EdmProvider edmProvider = new OlingoMyEDMProvider(); // MyEdmProvider();
		ODataSingleProcessor singleProcessor = new OlingoODataSingleProcessor();//new MyODataSingleProcessor();

		return createODataSingleProcessorService(edmProvider, singleProcessor);
		  }
	}

 
