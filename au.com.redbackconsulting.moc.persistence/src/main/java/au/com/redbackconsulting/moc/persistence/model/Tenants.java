package au.com.redbackconsulting.moc.persistence.model;
 
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Tenants
 *
 */
@Entity
@IdClass( TenantsPk.class)
public class Tenants implements IDBEntity {

	   
	@Id
	private Integer idtenants;
	@Column(unique = true, nullable = false)
	private String tenantsCode;
	private String name;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy=  "tenants")
	private Collection<CaSystems> caSystems; 
	
	public Collection<CaSystems> getCaSystems() {
		return caSystems;
	}
	public void setCaSystems(Collection<CaSystems> caSystems) {
		this.caSystems = caSystems;
	}
	public Tenants() {
		super();
	}   
	public Integer getTenantId() {
		return this.idtenants;
	}

	public void setTenantId(Integer tenantId) {
		this.idtenants = tenantId;
	}   
	public String getTenantCode() {
		return this.tenantsCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantsCode = tenantCode;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
