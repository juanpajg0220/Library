import java.util.Date;
import java.io.Serializable;

public abstract class Material implements Borrowable, Serializable {
    private String identifier;
    private String title;
    private Date registrationDate;
    private int registeredQuantity;
    private int currentQuantity;

    public Material(String identifier, String title, Date registrationDate, int registeredQuantity) {
        this.identifier = identifier;
        this.title = title;
        this.registrationDate = registrationDate;
        this.registeredQuantity = registeredQuantity;
        this.currentQuantity = registeredQuantity;
    }

    public String getIdentifier() { return identifier; }
    public String getTitle() { return title; }
    public Date getRegistrationDate() { return registrationDate; }
    public int getCurrentQuantity() { return currentQuantity; }

    @Override
    public boolean borrow() {
        if (currentQuantity > 0) {
            currentQuantity--;
            return true;
        }
        return false;
    }

    @Override
    public void returnMaterial() { currentQuantity++; }
}

