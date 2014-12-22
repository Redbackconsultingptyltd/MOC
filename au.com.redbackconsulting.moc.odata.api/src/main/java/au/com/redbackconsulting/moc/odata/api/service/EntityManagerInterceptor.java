
package au.com.redbackconsulting.moc.odata.api.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import au.com.redbackconsulting.moc.persistence.manager.PersistenceManager;

 

public class EntityManagerInterceptor implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            PersistenceManager.getInstance().initEntityManagerProvider();
            chain.doFilter(request, response);
        } finally {
            PersistenceManager.getInstance().closeEntityManager();
        }
    }

    public void init(FilterConfig config) {
    }

    public void destroy() {
        PersistenceManager.getInstance().closeAll();
    }
}
