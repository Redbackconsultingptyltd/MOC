package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: HrObjects
 *
 */
@Entity

@IdClass( HrObjectsPk.class)
public class HrObjects implements IDBEntity {

	   
	@Id
	private Integer tenantId;
	
	@Id
	private String objectType;
	private String systId;
	private String sObjectType;
	private static final long serialVersionUID = 1L;
		@ManyToOne
		@JoinColumns({
	@JoinColumn(name="systId", referencedColumnName="systId"),
	@JoinColumn(name="tenantId", referencedColumnName="tenantId")}
	)
		
	private CaSystems caSystems;
	@OneToMany(mappedBy = "hrObjects")
	private Collection<HrObjectsConstraints> hrObjectsConstraints;
	@ManyToMany(mappedBy = "hrObjects")
	private Collection<HrObjectRel> hrObjectRel;
	public HrObjects() {
		super();
	}   
	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}   
	public String getSystId() {
		return this.systId;
	}

	public void setSystId(String systId) {
		this.systId = systId;
	}   
	public String getSObjectType() {
		return this.sObjectType;
	}

	public void setSObjectType(String sObjectType) {
		this.sObjectType = sObjectType;
	}
	
	public CaSystems getCaSystems() {
	    return caSystems;
	}
	public void setCaSystems(CaSystems param) {
	    this.caSystems = param;
	}
	public Collection<HrObjectsConstraints> getHrObjectsConstraints() {
	    return hrObjectsConstraints;
	}
	public void setHrObjectsConstraints(Collection<HrObjectsConstraints> param) {
	    this.hrObjectsConstraints = param;
	}
	public Collection<HrObjectRel> getHrObjectRel() {
	    return hrObjectRel;
	}
	public void setHrObjectRel(Collection<HrObjectRel> param) {
	    this.hrObjectRel = param;
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
