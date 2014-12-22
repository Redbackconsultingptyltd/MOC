package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: HrObjectRel
 * 
 */
@Entity
@IdClass(HrObjectRelPK.class)
public class HrObjectRel implements IDBEntity  {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer tenantId;
	
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

	@Id
	private String objectType;
	@Id
	private String relatType;
	@Id
	private String sObjectType;

	private String timeConstraint;

	private String tableId;
	@ManyToMany
	private Collection<HrObjects> hrObjects;
	public HrObjectRel() {
		super();
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getRelatType() {
		return this.relatType;
	}

	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}

	public String getSObjectType() {
		return this.sObjectType;
	}

	public void setSObjectType(String sObjectType) {
		this.sObjectType = sObjectType;
	}

	public String getTimeConstraint() {
		return timeConstraint;
	}

	public void setTimeConstraint(String timeConstraint) {
		this.timeConstraint = timeConstraint;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String param) {
		this.tableId = param;
	}

	public Collection<HrObjects> getHrObjects() {
	    return hrObjects;
	}

	public void setHrObjects(Collection<HrObjects> param) {
	    this.hrObjects = param;
	}

}
