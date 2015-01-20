package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hrp1000 database table.
 * 
 */
@Entity
@NamedQuery(name="Hrp1000.findAll", query="SELECT h FROM Hrp1000 h")
public class Hrp1000 implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Hrp1000PK id;

	private String changedBy;

	@Temporal(TemporalType.DATE)
	private Date changedOn;

	private String guid;

	private String objectDesc;

	private int seqNo;

	private String stext;

	//bi-directional many-to-one association to Hrobject
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idobjectType", referencedColumnName="idObjectType"),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants")
		})
	private Hrobject hrobject;

	//bi-directional many-to-one association to Hrobjectsstatus
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="status", referencedColumnName="idHrObjectsStatus"),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants", updatable=false, insertable=false)
		})
	private Hrobjectsstatus hrobjectsstatus;

	public Hrp1000() {
	}

	public Hrp1000PK getId() {
		return this.id;
	}

	public void setId(Hrp1000PK id) {
		this.id = id;
	}

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

	public String getObjectDesc() {
		return this.objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}

	public int getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getStext() {
		return this.stext;
	}

	public void setStext(String stext) {
		this.stext = stext;
	}

	public Hrobject getHrobject() {
		return this.hrobject;
	}

	public void setHrobject(Hrobject hrobject) {
		this.hrobject = hrobject;
	}

	public Hrobjectsstatus getHrobjectsstatus() {
		return this.hrobjectsstatus;
	}

	public void setHrobjectsstatus(Hrobjectsstatus hrobjectsstatus) {
		this.hrobjectsstatus = hrobjectsstatus;
	}

}