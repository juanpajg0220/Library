import java.util.Date;

public class Material {
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

    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public int getRegisteredQuantity() {
        return registeredQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public boolean borrow() {
        if (currentQuantity > 0) {
            currentQuantity--;
            return true;
        }
        System.out.println("Not enough units available to borrow.");
        return false;
    }

    public void returnMaterial() {
        currentQuantity++;
    }

    public void increaseQuantity(int quantity) {
        this.registeredQuantity += quantity;
        this.currentQuantity += quantity;
    }
}