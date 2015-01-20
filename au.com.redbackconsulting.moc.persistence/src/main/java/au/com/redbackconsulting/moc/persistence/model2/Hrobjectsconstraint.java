package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hrobjectsconstraints database table.
 * 
 */
@Entity
@Table(name="hrobjectsconstraints")
@NamedQuery(name="Hrobjectsconstraint.findAll", query="SELECT h FROM Hrobjectsconstraint h")
public class Hrobjectsconstraint implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrobjectsconstraintPK id;

	private String tableId;

	private int timeConstraint;

	//bi-directional one-to-one association to Hrobject
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="hrObject", referencedColumnName="idObjectType"),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants")
		})
	private Hrobject hrobject;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumn(name="Tenants_idTenants")
	private Tenant tenant;

	public Hrobjectsconstraint() {
	}

	public HrobjectsconstraintPK getId() {
		return this.id;
	}

	public void setId(HrobjectsconstraintPK id) {
		this.id = id;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public int getTimeConstraint() {
		return this.timeConstraint;
	}

	public void setTimeConstraint(int timeConstraint) {
		this.timeConstraint = timeConstraint;
	}

	public Hrobject getHrobject() {
		return this.hrobject;
	}

	public void setHrobject(Hrobject hrobject) {
		this.hrobject = hrobject;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

}