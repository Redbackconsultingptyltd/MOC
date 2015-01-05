package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: caSystems
 *
 */
@Entity

@IdClass( CaSystemsPk.class)
public class CaSystems implements   ICaSystems{

	   
	
	
	@Id
	private String systId;
	@Id
	private Integer tenantId;
	
	private String systDesc;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="tenantId", referencedColumnName="tenantId", insertable=false, updatable=false)
	private Tenants tenants;
	
	public Tenants getTenants() {
		return tenants;
	}
	public void setTenants(Tenants tenants) {
		this.tenants = tenants;
	}
	@OneToMany(mappedBy = "caSystems")
	private Collection<HrObjects> hrObjects;
	public CaSystems() {
		super();
	}   
	public String getSystId() {
		return this.systId;
	}

	public void setSystId(String systId) {
		this.systId = systId;
	}   
	public String getSystDesc() {
		return this.systDesc;
	}

	public void setSystDesc(String systDesc) {
		this.systDesc = systDesc;
	}
	public Collection<HrObjects> getHrObjects() {
	    return hrObjects;
	}
	public void setHrObjects(Collection<HrObjects> param) {
	    this.hrObjects = param;
	}
   
	
	/**
	 * @return the tenantId
	 */
	public Integer getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
}
