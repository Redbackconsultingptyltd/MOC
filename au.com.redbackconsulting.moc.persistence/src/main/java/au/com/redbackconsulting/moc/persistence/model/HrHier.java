package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: HrHier
 * 
 */
@Entity
@IdClass(HrHierPk.class)
public class HrHier implements IDBEntity {

	@Id
	private String hierId;
	@Id
	private Integer tenantId;

	private String hierDesc;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "hrHier")
	private Collection<HrHierMap> hrHierMap;
	
	public HrHier() {
		super();
	}

	public String getHierId() {
		return this.hierId;
	}

	public void setHierId(String hierId) {
		this.hierId = hierId;
	}

	public String getHierDesc() {
		return this.hierDesc;
	}

	public void setHierDesc(String hierDesc) {
		this.hierDesc = hierDesc;
	}

	public Collection<HrHierMap> getHrHierMap() {
		return hrHierMap;
	}

	public void setHrHierMap(Collection<HrHierMap> param) {
		this.hrHierMap = param;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer param) {
		this.tenantId = param;
	}

}
