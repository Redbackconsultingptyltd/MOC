package au.com.redbackconsulting.moc.persistence.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: HrObjectsStatus
 *
 */
@Entity

@IdClass( HrObjectsStatusPk.class)
public class HrObjectsStatus implements IDBEntity {

	 @Id
	 private Integer tenantId;
	@Id
	private String status;
	private String description;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "hrObjectsStatus")
	private Collection<HRP1001> hRP1001;
	@OneToMany(mappedBy = "hrObjectsStatus")
	private Collection<HRP1000> hRP1000;

	public HrObjectsStatus() {
		super();
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<HRP1001> getHRP1001() {
	    return hRP1001;
	}
	public void setHRP1001(Collection<HRP1001> param) {
	    this.hRP1001 = param;
	}
	public Collection<HRP1000> getHRP1000() {
	    return hRP1000;
	}
	public void setHRP1000(Collection<HRP1000> param) {
	    this.hRP1000 = param;
	}
   
}
