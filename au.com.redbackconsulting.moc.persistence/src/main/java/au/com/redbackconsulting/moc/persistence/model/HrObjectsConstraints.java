package au.com.redbackconsulting.moc.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: HrObjectsConstraints
 *
 */
@Entity

@IdClass( HrObjectsConstraintsPk.class)
public class HrObjectsConstraints implements IDBEntity {

	   
	@Id
	private Integer tenantId;
	
	@Id
	private String objectType;
	private String tableId;
	private String timeConstraint;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="objectType", referencedColumnName="objectType", insertable=false, updatable=false),
	@JoinColumn(name="tenantId", referencedColumnName="tenantId", insertable=false, updatable=false)
	})
	private HrObjects hrObjects;

	public HrObjectsConstraints() {
		super();
	}   
	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}   
	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}   
	public String getTimeConstraint() {
		return this.timeConstraint;
	}

	public void setTimeConstraint(String timeConstraint) {
		this.timeConstraint = timeConstraint;
	}
	public HrObjects getHrObjects() {
	    return hrObjects;
	}
	public void setHrObjects(HrObjects param) {
	    this.hrObjects = param;
	}
   
}
