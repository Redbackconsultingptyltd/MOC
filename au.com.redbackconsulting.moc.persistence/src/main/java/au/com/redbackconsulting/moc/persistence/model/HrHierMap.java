package au.com.redbackconsulting.moc.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: HrHierMap
 * 
 */
@Entity
@IdClass( HrHierMapPk.class)
public class HrHierMap implements IDBEntity {

	@Id
	private String hierId;
	@Id
	private Integer tenantId;
	
	private Integer seqNo;
	private String objectType;
	private String relatType;
	private String sObjType;
	private Boolean skip;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	
	
	@JoinColumn(name = "hierId")
	private HrHier hrHier; 
	

	public HrHierMap() {
		super();
	}

	public String getHierId() {
		return this.hierId;
	}

	public void setHierId(String hierId) {
		this.hierId = hierId;
	}

	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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

	public String getSObjType() {
		return this.sObjType;
	}

	public void setSObjType(String sObjType) {
		this.sObjType = sObjType;
	}

	public Boolean getSkip() {
		return this.skip;
	}

	public void setSkip(Boolean skip) {
		this.skip = skip;
	}

	public HrHier getHrHier() {
		return hrHier;
	}

	public void setHrHier(HrHier param) {
		this.hrHier = param;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer param) {
		this.tenantId = param;
	}

}
