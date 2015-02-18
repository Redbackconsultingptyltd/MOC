package au.com.redbackconsulting.moc.persistence.model2;


import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the hrp1000 database table.
 * 
 */
@Entity
@NamedQuery(name="Hrp1001.findAll", query="SELECT h FROM Hrp1000 h")
public class Hrp1001 implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Hrp1001PK id;

	private String subType;
	
	 
	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date changedOn;
	
	private String changedBy;

	private String guid;
	
	@Column
	private int idsobjectType;

	@Column
	private int idsobjectId;

	
	//bi-directional many-to-one association to Hrobject
//	@ManyToOne	
//	@JoinColumns({
//		@JoinColumn(name="idobjectType", referencedColumnName="idobjectType"),
//		@JoinColumn(name="idobjectId", referencedColumnName="idobjectId") 
//		
//		})
//	private Hrp1000 hrp1000;

	public int getIdsobjectType() {
		return idsobjectType;
	}

	public void setIdsobjectType(int idsobjectType) {
		this.idsobjectType = idsobjectType;
	}

	public int getIdsobjectId() {
		return idsobjectId;
	}

	public void setIdsobjectId(int idsobjectId) {
		this.idsobjectId = idsobjectId;
	}

	//bi-directional many-to-one association to Hrobjectsstatus
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="status", referencedColumnName="idHrObjectsStatus", insertable=false, updatable=false),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants", updatable=false, insertable=false)
		})
	private Hrobjectsstatus hrobjectsstatus;

	public Hrp1001() {
	}

	public Hrp1001PK getId() {
		return this.id;
	}

	public void setId(Hrp1001PK id) {
		this.id = id;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Hrp1000 getHrp1000() {
//		return hrp1000;
//	}
//
//	public void setHrp1000(Hrp1000 hrp1000) {
//		this.hrp1000 = hrp1000;
//	}

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedOn() {
		return this.changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	 
	 

	
	public Hrobjectsstatus getHrobjectsstatus() {
		return this.hrobjectsstatus;
	}

	public void setHrobjectsstatus(Hrobjectsstatus hrobjectsstatus) {
		this.hrobjectsstatus = hrobjectsstatus;
	}

}