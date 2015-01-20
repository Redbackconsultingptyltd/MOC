package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hrhier database table.
 * 
 */
@Entity
@NamedQuery(name="Hrhier.findAll", query="SELECT h FROM Hrhier h")
public class Hrhier implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrhierPK id;

	private String hierdesc;

	private String hiershortdesc;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="Tenants_idTenants", referencedColumnName="id")
	})
	private Tenant tenant;

	//bi-directional many-to-one association to Hrhiermap
	@OneToMany(mappedBy="hrhier")
	private List<Hrhiermap> hrhiermaps;

	public Hrhier() {
	}

	public HrhierPK getId() {
		return this.id;
	}

	public void setId(HrhierPK id) {
		this.id = id;
	}

	public String getHierdesc() {
		return this.hierdesc;
	}

	public void setHierdesc(String hierdesc) {
		this.hierdesc = hierdesc;
	}

	public String getHiershortdesc() {
		return this.hiershortdesc;
	}

	public void setHiershortdesc(String hiershortdesc) {
		this.hiershortdesc = hiershortdesc;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Hrhiermap> getHrhiermaps() {
		return this.hrhiermaps;
	}

	public void setHrhiermaps(List<Hrhiermap> hrhiermaps) {
		this.hrhiermaps = hrhiermaps;
	}

	public Hrhiermap addHrhiermap(Hrhiermap hrhiermap) {
		getHrhiermaps().add(hrhiermap);
		hrhiermap.setHrhier(this);

		return hrhiermap;
	}

	public Hrhiermap removeHrhiermap(Hrhiermap hrhiermap) {
		getHrhiermaps().remove(hrhiermap);
		hrhiermap.setHrhier(null);

		return hrhiermap;
	}

}