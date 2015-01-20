package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hrhiermap database table.
 * 
 */
@Entity
@NamedQuery(name="Hrhiermap.findAll", query="SELECT h FROM Hrhiermap h")
public class Hrhiermap implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrhiermapPK id;

	private int objectTypeId;

	private String relatType;

	private String skip;

	private int sObjectTypeId;

	//bi-directional many-to-one association to Hrhier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="HrHierId", referencedColumnName="idHrHier"),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants")
		})
	private Hrhier hrhier;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="Tenants_idTenants", referencedColumnName="id", insertable=false, updatable=false)
	})
	private Tenant tenant;

	public Hrhiermap() {
	}

	public HrhiermapPK getId() {
		return this.id;
	}

	public void setId(HrhiermapPK id) {
		this.id = id;
	}

	public int getObjectTypeId() {
		return this.objectTypeId;
	}

	public void setObjectTypeId(int objectTypeId) {
		this.objectTypeId = objectTypeId;
	}

	public String getRelatType() {
		return this.relatType;
	}

	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}

	public String getSkip() {
		return this.skip;
	}

	public void setSkip(String skip) {
		this.skip = skip;
	}

	public int getSObjectTypeId() {
		return this.sObjectTypeId;
	}

	public void setSObjectTypeId(int sObjectTypeId) {
		this.sObjectTypeId = sObjectTypeId;
	}

	public Hrhier getHrhier() {
		return this.hrhier;
	}

	public void setHrhier(Hrhier hrhier) {
		this.hrhier = hrhier;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

}