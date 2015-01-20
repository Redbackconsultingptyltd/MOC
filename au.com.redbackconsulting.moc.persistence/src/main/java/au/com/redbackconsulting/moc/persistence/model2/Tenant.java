package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tenants database table.
 * 
 */
@Entity
@Table(name="tenants")
@NamedQuery(name="Tenant.findAll", query="SELECT t FROM Tenant t")
public class Tenant implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private TenantPK tenantPK;

	public TenantPK getTenantPK() {
		return tenantPK;
	}

	public void setTenantPK(TenantPK tenantPK) {
		this.tenantPK = tenantPK;
	}

	private String name;

	private String tenantsCode;

	//bi-directional many-to-one association to Casystem
	@OneToMany(mappedBy="tenant")
	private List<Casystem> casystems;

	//bi-directional many-to-one association to Hrhier
	@OneToMany(mappedBy="tenant")
	private List<Hrhier> hrhiers;

	//bi-directional many-to-one association to Hrhiermap
	@OneToMany(mappedBy="tenant")
	private List<Hrhiermap> hrhiermaps;

	//bi-directional many-to-one association to Hrobject
	@OneToMany(mappedBy="tenant")
	private List<Hrobject> hrobjects;

	//bi-directional many-to-one association to Hrobjectsconstraint
	@OneToMany(mappedBy="tenant")
	private List<Hrobjectsconstraint> hrobjectsconstraints;

	//bi-directional many-to-one association to Hrobjectsstatus
	@OneToMany(mappedBy="tenant")
	private List<Hrobjectsstatus> hrobjectsstatuses;

	public Tenant() {
	}

//	public int getIdTenants() {
//		return this.idTenants;
//	}
//
//	public void setIdTenants(int idTenants) {
//		this.idTenants = idTenants;
//	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenantsCode() {
		return this.tenantsCode;
	}

	public void setTenantsCode(String tenantsCode) {
		this.tenantsCode = tenantsCode;
	}

	public List<Casystem> getCasystems() {
		return this.casystems;
	}

	public void setCasystems(List<Casystem> casystems) {
		this.casystems = casystems;
	}

	public Casystem addCasystem(Casystem casystem) {
		getCasystems().add(casystem);
		casystem.setTenant(this);

		return casystem;
	}

	public Casystem removeCasystem(Casystem casystem) {
		getCasystems().remove(casystem);
		casystem.setTenant(null);

		return casystem;
	}

	public List<Hrhier> getHrhiers() {
		return this.hrhiers;
	}

	public void setHrhiers(List<Hrhier> hrhiers) {
		this.hrhiers = hrhiers;
	}

	public Hrhier addHrhier(Hrhier hrhier) {
		getHrhiers().add(hrhier);
		hrhier.setTenant(this);

		return hrhier;
	}

	public Hrhier removeHrhier(Hrhier hrhier) {
		getHrhiers().remove(hrhier);
		hrhier.setTenant(null);

		return hrhier;
	}

	public List<Hrhiermap> getHrhiermaps() {
		return this.hrhiermaps;
	}

	public void setHrhiermaps(List<Hrhiermap> hrhiermaps) {
		this.hrhiermaps = hrhiermaps;
	}

	public Hrhiermap addHrhiermap(Hrhiermap hrhiermap) {
		getHrhiermaps().add(hrhiermap);
		hrhiermap.setTenant(this);

		return hrhiermap;
	}

	public Hrhiermap removeHrhiermap(Hrhiermap hrhiermap) {
		getHrhiermaps().remove(hrhiermap);
		hrhiermap.setTenant(null);

		return hrhiermap;
	}

	public List<Hrobject> getHrobjects() {
		return this.hrobjects;
	}

	public void setHrobjects(List<Hrobject> hrobjects) {
		this.hrobjects = hrobjects;
	}

	public Hrobject addHrobject(Hrobject hrobject) {
		getHrobjects().add(hrobject);
		hrobject.setTenant(this);

		return hrobject;
	}

	public Hrobject removeHrobject(Hrobject hrobject) {
		getHrobjects().remove(hrobject);
		hrobject.setTenant(null);

		return hrobject;
	}

	public List<Hrobjectsconstraint> getHrobjectsconstraints() {
		return this.hrobjectsconstraints;
	}

	public void setHrobjectsconstraints(List<Hrobjectsconstraint> hrobjectsconstraints) {
		this.hrobjectsconstraints = hrobjectsconstraints;
	}

	public Hrobjectsconstraint addHrobjectsconstraint(Hrobjectsconstraint hrobjectsconstraint) {
		getHrobjectsconstraints().add(hrobjectsconstraint);
		hrobjectsconstraint.setTenant(this);

		return hrobjectsconstraint;
	}

	public Hrobjectsconstraint removeHrobjectsconstraint(Hrobjectsconstraint hrobjectsconstraint) {
		getHrobjectsconstraints().remove(hrobjectsconstraint);
		hrobjectsconstraint.setTenant(null);

		return hrobjectsconstraint;
	}

	public List<Hrobjectsstatus> getHrobjectsstatuses() {
		return this.hrobjectsstatuses;
	}

	public void setHrobjectsstatuses(List<Hrobjectsstatus> hrobjectsstatuses) {
		this.hrobjectsstatuses = hrobjectsstatuses;
	}

	public Hrobjectsstatus addHrobjectsstatus(Hrobjectsstatus hrobjectsstatus) {
		getHrobjectsstatuses().add(hrobjectsstatus);
		hrobjectsstatus.setTenant(this);

		return hrobjectsstatus;
	}

	public Hrobjectsstatus removeHrobjectsstatus(Hrobjectsstatus hrobjectsstatus) {
		getHrobjectsstatuses().remove(hrobjectsstatus);
		hrobjectsstatus.setTenant(null);

		return hrobjectsstatus;
	}

}