package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hrobjects database table.
 * 
 */
@Entity
@Table(name="hrobjects")
@NamedQuery(name="Hrobject.findAll", query="SELECT h FROM Hrobject h")
public class Hrobject implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrobjectPK id;

	private String sObjectType;

	//bi-directional many-to-one association to Hrobjectrel
	@OneToMany(mappedBy="hrobject1")
	private List<Hrobjectrel> hrobjectrels1;

	//bi-directional many-to-one association to Hrobjectrel
	@OneToMany(mappedBy="hrobject2")
	private List<Hrobjectrel> hrobjectrels2;

	//bi-directional many-to-one association to Casystem
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="sysId", referencedColumnName="idsys"),
		@JoinColumn(name="Tenants_idTenants", referencedColumnName="Tenants_idTenants")
		})
	private Casystem casystem;

	//bi-directional many-to-one association to Tenant
	@ManyToOne
	@JoinColumn(name="Tenants_idTenants")
	private Tenant tenant;

	//bi-directional one-to-one association to Hrobjectsconstraint
	@OneToOne(mappedBy="hrobject")
	private Hrobjectsconstraint hrobjectsconstraint;

	//bi-directional many-to-one association to Hrp1000
	@OneToMany(mappedBy="hrobject")
	private List<Hrp1000> hrp1000s;

	public Hrobject() {
	}

	public HrobjectPK getId() {
		return this.id;
	}

	public void setId(HrobjectPK id) {
		this.id = id;
	}

	public String getSObjectType() {
		return this.sObjectType;
	}

	public void setSObjectType(String sObjectType) {
		this.sObjectType = sObjectType;
	}

	public List<Hrobjectrel> getHrobjectrels1() {
		return this.hrobjectrels1;
	}

	public void setHrobjectrels1(List<Hrobjectrel> hrobjectrels1) {
		this.hrobjectrels1 = hrobjectrels1;
	}

	public Hrobjectrel addHrobjectrels1(Hrobjectrel hrobjectrels1) {
		getHrobjectrels1().add(hrobjectrels1);
		hrobjectrels1.setHrobject1(this);

		return hrobjectrels1;
	}

	public Hrobjectrel removeHrobjectrels1(Hrobjectrel hrobjectrels1) {
		getHrobjectrels1().remove(hrobjectrels1);
		hrobjectrels1.setHrobject1(null);

		return hrobjectrels1;
	}

	public List<Hrobjectrel> getHrobjectrels2() {
		return this.hrobjectrels2;
	}

	public void setHrobjectrels2(List<Hrobjectrel> hrobjectrels2) {
		this.hrobjectrels2 = hrobjectrels2;
	}

	public Hrobjectrel addHrobjectrels2(Hrobjectrel hrobjectrels2) {
		getHrobjectrels2().add(hrobjectrels2);
		hrobjectrels2.setHrobject2(this);

		return hrobjectrels2;
	}

	public Hrobjectrel removeHrobjectrels2(Hrobjectrel hrobjectrels2) {
		getHrobjectrels2().remove(hrobjectrels2);
		hrobjectrels2.setHrobject2(null);

		return hrobjectrels2;
	}

	public Casystem getCasystem() {
		return this.casystem;
	}

	public void setCasystem(Casystem casystem) {
		this.casystem = casystem;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Hrobjectsconstraint getHrobjectsconstraint() {
		return this.hrobjectsconstraint;
	}

	public void setHrobjectsconstraint(Hrobjectsconstraint hrobjectsconstraint) {
		this.hrobjectsconstraint = hrobjectsconstraint;
	}

	public List<Hrp1000> getHrp1000s() {
		return this.hrp1000s;
	}

	public void setHrp1000s(List<Hrp1000> hrp1000s) {
		this.hrp1000s = hrp1000s;
	}

	public Hrp1000 addHrp1000(Hrp1000 hrp1000) {
		getHrp1000s().add(hrp1000);
		hrp1000.setHrobject(this);

		return hrp1000;
	}

	public Hrp1000 removeHrp1000(Hrp1000 hrp1000) {
		getHrp1000s().remove(hrp1000);
		hrp1000.setHrobject(null);

		return hrp1000;
	}

}