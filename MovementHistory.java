import java.util.Date;
import java.io.Serializable;

public class MovementHistory implements Serializable {
    private String materialIdentifier;
    private String movementType;
    private String personId;
    private Date movementDate;

    public MovementHistory(String materialIdentifier, String movementType, String personId, Date movementDate) {
        this.materialIdentifier = materialIdentifier;
        this.movementType = movementType;
        this.personId = personId;
        this.movementDate = movementDate;
    }

    public String getMaterialIdentifier() { return materialIdentifier; }
    public String getMovementType() { return movementType; }
    public String getPersonId() { return personId; }
    public Date getMovementDate() { return movementDate; }
}