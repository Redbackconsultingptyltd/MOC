package au.com.redbackconsulting.moc.odata.api.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;

public class EntityManagerInterceptor1 implements Filter {

	@Override
	public void destroy() {
		  PersistenceManager.getInstance().closeAll();
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		try {
            PersistenceManager.getInstance().initEntityManagerProvider();
            arg2.doFilter(arg0, arg1);
        } finally {
            PersistenceManager.getInstance().closeEntityManager();
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
