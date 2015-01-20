package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hrobjectsstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Hrobjectsstatus.findAll", query="SELECT h FROM Hrobjectsstatus h")
public class Hrobjectsstatus implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrobjectsstatusPK id;

	private String description;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="Tenants_idTenants", referencedColumnName="id")
	})
	private Tenant tenant;

	//bi-directional many-to-one association to Hrp1000
	@OneToMany(mappedBy="hrobjectsstatus")
	private List<Hrp1000> hrp1000s;

	public Hrobjectsstatus() {
	}

	public HrobjectsstatusPK getId() {
		return this.id;
	}

	public void setId(HrobjectsstatusPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Hrp1000> getHrp1000s() {
		return this.hrp1000s;
	}

	public void setHrp1000s(List<Hrp1000> hrp1000s) {
		this.hrp1000s = hrp1000s;
	}

	public Hrp1000 addHrp1000(Hrp1000 hrp1000) {
		getHrp1000s().add(hrp1000);
		hrp1000.setHrobjectsstatus(this);

		return hrp1000;
	}

	public Hrp1000 removeHrp1000(Hrp1000 hrp1000) {
		getHrp1000s().remove(hrp1000);
		hrp1000.setHrobjectsstatus(null);

		return hrp1000;
	}

}