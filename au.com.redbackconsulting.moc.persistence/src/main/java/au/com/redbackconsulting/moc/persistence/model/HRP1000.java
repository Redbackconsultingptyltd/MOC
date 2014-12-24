package au.com.redbackconsulting.moc.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: HRP1000
 *
 */
@Entity

@IdClass(HRP1000PK.class)
public class HRP1000 implements IDBEntity {

	@Id
	private Integer tenantId;
	   
	
	@Id
	private String objectType;   
	@Id
	private String objectId;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date validTo;   
	@Id
	@Temporal(TemporalType.DATE)
	private Date validFrom;   
	@Id
	private String seqNr;
	private String objectDesc;   
	private String status;
	private String stext;
	@Temporal(TemporalType.DATE)
	private Date changedOn;
	@Temporal(TemporalType.DATE)
	private Date changedBy;
	private String guid;
	private static final long serialVersionUID = 1L;
	
	
	
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="status", referencedColumnName="status", insertable=false, updatable=false),
	@JoinColumn(name="tenantId", referencedColumnName="tenantId", insertable=false, updatable=false)
	})
	private HrObjectsStatus hrObjectsStatus;
	
	public HRP1000() {
		super();
	}   
	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}   
	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}   
	public String getObjectDesc() {
		return this.objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
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
	public String getSeqNr() {
		return this.seqNr;
	}

	public void setSeqNr(String seqNr) {
		this.seqNr = seqNr;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public String getStext() {
		return this.stext;
	}

	public void setStext(String stext) {
		this.stext = stext;
	}   
	public Date getChangedOn() {
		return this.changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}   
	public Date getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(Date changedBy) {
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
	 
	
	/**
	 * @return the tenant
	 */
	public Integer getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenant the tenant to set
	 */
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * @return the hRP1001_1
	 */
	 
   
}
