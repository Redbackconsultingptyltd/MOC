package au.com.redbackconsulting.moc.persistence.model2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hrrelations database table.
 * 
 */
@Entity
@Table(name="hrrelations")
@NamedQuery(name="Hrrelation.findAll", query="SELECT h FROM Hrrelation h")
public class Hrrelation implements IDBEntity {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HrrelationPK id;

	private String relatTypeT;

	public Hrrelation() {
	}

	public HrrelationPK getId() {
		return this.id;
	}

	public void setId(HrrelationPK id) {
		this.id = id;
	}

	public String getRelatTypeT() {
		return this.relatTypeT;
	}

	public void setRelatTypeT(String relatTypeT) {
		this.relatTypeT = relatTypeT;
	}

}