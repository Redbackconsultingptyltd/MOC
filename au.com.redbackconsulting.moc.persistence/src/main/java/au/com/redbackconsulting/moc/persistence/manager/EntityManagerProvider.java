

package au.com.redbackconsulting.moc.persistence.manager;

import javax.persistence.EntityManager;


public interface EntityManagerProvider {

    EntityManager get();

}
