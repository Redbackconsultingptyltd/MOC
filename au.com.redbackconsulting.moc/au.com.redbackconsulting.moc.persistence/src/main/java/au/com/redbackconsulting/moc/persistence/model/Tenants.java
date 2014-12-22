package au.com.redbackconsulting.moc.persistence.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Tenants
 *
 */
@Entity

public class Tenants implements IDBEntity {

	   
	@Id
	private Integer tenantId;
	@Column(unique = true, nullable = false)
	private String tenantCode;
	private String name;
	private static final long serialVersionUID = 1L;

	public Tenants() {
		super();
	}   
	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}   
	public String getTenantCode() {
		return this.tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
