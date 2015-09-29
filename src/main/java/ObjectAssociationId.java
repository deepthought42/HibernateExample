import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * @author Brandon Kindred
 */
@Embeddable
public class ObjectAssociationId implements Serializable{

	private static final long serialVersionUID = 1L;
	private int object1_id;
	private int object2_id;

	public ObjectAssociationId(){
		
	}
	
	public ObjectAssociationId(int object1_id, int object2_id) {
		this.setObject1Id(object1_id);
		this.setObject2Id(object2_id);
	}

	public int getObject1Id() {
		return object1_id;
	}

	public void setObject1Id(int object1_id) {
		this.object1_id = object1_id;
	}

	public int getObject2Id() {
		return object2_id;
	}

	public void setObject2Id(int object2_id) {
		this.object2_id = object2_id;
	}
	
	public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof ObjectAssociationId))
            return false;
        ObjectAssociationId castOther = (ObjectAssociationId) other;
 
        return (this.getObject1Id() == castOther.getObject1Id())
                && (this.getObject2Id() == castOther.getObject2Id());
    }
 
    public int hashCode() {
        int result = 17;
 
        result = 37 * result + this.getObject1Id();
        result = 37 * result + this.getObject2Id();
        return result;
    }
	


}
