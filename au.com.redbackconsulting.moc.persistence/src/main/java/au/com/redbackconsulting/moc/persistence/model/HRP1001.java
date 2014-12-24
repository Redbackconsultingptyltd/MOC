package au.com.redbackconsulting.moc.persistence.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: HRP1001
 *
 */
@Entity

@IdClass(HRP1001PK.class)
public class HRP1001 implements IDBEntity {

	   
	@Id
	private Integer tenantId;
	@Id
	private String robjectType;   
	@Id
	private String robjectId;
	@Id
	private String rsobjectType;
	@Id
	private String rsobjectId;
	
	private String relatType;
	private Date validTo;
	private Date validFrom;
	private String subType;
	private Boolean status;
	private String changedOn;
	private String changedBy;
	private String guid;
	private static final long serialVersionUID = 1L;
	
	
	
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="status", referencedColumnName="status", insertable=false, updatable=false),
	@JoinColumn(name="tenantId", referencedColumnName="tenantId", insertable=false, updatable=false)
	})
	private HrObjectsStatus hrObjectsStatus;

	public HRP1001() {
		super();
	}   
	 

	  
	public String getRobjectId() {
		return this.robjectId;
	}

	public void setRobjectId(String objId) {
		this.robjectId = objId;
	}   
	public String getRelatType() {
		return this.relatType;
	}

	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}   
	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}   
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}   
	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}   
	 
	public String getRobjectType() {
		return robjectType;
	}



	public void setRobjectType(String robjectType) {
		this.robjectType = robjectType;
	}



	public String getSobjectType() {
		return rsobjectType;
	}



	public void setSobjectType(String sobjectType) {
		this.rsobjectType = sobjectType;
	}



	public String getSobjectId() {
		return rsobjectId;
	}



	public void setSobjectId(String sobjectId) {
		this.rsobjectId = sobjectId;
	}



	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}   
	public String getChangedOn() {
		return this.changedOn;
	}

	public void setChangedOn(String changedOn) {
		this.changedOn = changedOn;
	}   
	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}   
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	public HrObjectsStatus getHrObjectsStatus() {
	    return hrObjectsStatus;
	}
	public void setHrObjectsStatus(HrObjectsStatus param) {
	    this.hrObjectsStatus = param;
	}



	
   
}
