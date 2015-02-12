package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hrobjectrel database table.
 * 
 */
@Entity
@NamedQuery(name="Hrobjectrel.findAll", query="SELECT h FROM Hrobjectrel h")
public class Hrobjectrel implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrobjectrelPK id;

	private int hrObjectsId;

	private String tableId;

	//bi-directional many-to-one association to Hrobject
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idobjectype", referencedColumnName="idObjectType", updatable=false, insertable=false),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants", updatable=false, insertable=false)
		})
	private Hrobject hrobject1;

	//bi-directional many-to-one association to Hrobject
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idsobjectype", referencedColumnName="idObjectType", updatable=false, insertable=false),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants", insertable=false, updatable=false)
		})
	private Hrobject hrobject2;

	public Hrobjectrel() {
	}

	public HrobjectrelPK getId() {
		return this.id;
	}

	public void setId(HrobjectrelPK id) {
		this.id = id;
	}

	public int getHrObjectsId() {
		return this.hrObjectsId;
	}

	public void setHrObjectsId(int hrObjectsId) {
		this.hrObjectsId = hrObjectsId;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public Hrobject getHrobject1() {
		return this.hrobject1;
	}

	public void setHrobject1(Hrobject hrobject1) {
		this.hrobject1 = hrobject1;
	}

	public Hrobject getHrobject2() {
		return this.hrobject2;
	}

	public void setHrobject2(Hrobject hrobject2) {
		this.hrobject2 = hrobject2;
	}

}