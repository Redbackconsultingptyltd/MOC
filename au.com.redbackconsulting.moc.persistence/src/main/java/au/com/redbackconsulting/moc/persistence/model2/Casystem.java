package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the casystems database table.
 * 
 */
@Entity
@Table(name="casystems")
@NamedQuery(name="Casystem.findAll", query="SELECT c FROM Casystem c")
public class Casystem implements IDBEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CasystemPK id;

	private String sysdesc;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumn(name="Tenants_idTenants")
	private Tenant tenant;

	//bi-directional many-to-one association to Hrobject
	@OneToMany(mappedBy="casystem")
	private List<Hrobject> hrobjects;

	public Casystem() {
	}

	public CasystemPK getId() {
		return this.id;
	}

	public void setId(CasystemPK id) {
		this.id = id;
	}

	public String getSysdesc() {
		return this.sysdesc;
	}

	public void setSysdesc(String sysdesc) {
		this.sysdesc = sysdesc;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Hrobject> getHrobjects() {
		return this.hrobjects;
	}

	public void setHrobjects(List<Hrobject> hrobjects) {
		this.hrobjects = hrobjects;
	}

	public Hrobject addHrobject(Hrobject hrobject) {
		getHrobjects().add(hrobject);
		hrobject.setCasystem(this);

		return hrobject;
	}

	public Hrobject removeHrobject(Hrobject hrobject) {
		getHrobjects().remove(hrobject);
		hrobject.setCasystem(null);

		return hrobject;
	}

}