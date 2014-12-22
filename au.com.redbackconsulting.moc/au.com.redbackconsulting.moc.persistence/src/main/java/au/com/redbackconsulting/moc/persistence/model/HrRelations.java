package au.com.redbackconsulting.moc.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Entity implementation class for Entity: HrRelations
 *
 */
@Entity

@IdClass( HrRelationsPk.class)
public class HrRelations implements IDBEntity {

	   
	@Id
	private Integer tenantId;
	@Id
	private String relatType;
	private String relatTypeT;
	private static final long serialVersionUID = 1L;
	 
	public HrRelations() {
		super();
	}   
	public String getRelatType() {
		return this.relatType;
	}

	public void setRelatType(String relatType) {
		this.relatType = relatType;
	}   
	public String getRelatTypeT() {
		return this.relatTypeT;
	}

	public void setRelatTypeT(String relatTypeT) {
		this.relatTypeT = relatTypeT;
	}
	 
   
}
