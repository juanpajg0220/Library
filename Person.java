import java.util.ArrayList;
import java.io.Serializable;

public abstract class Person implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private ArrayList<Material> borrowedMaterials;

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedMaterials = new ArrayList<>();
    }

    public String getId() { return id; }
    public ArrayList<Material> getBorrowedMaterials() { return borrowedMaterials; }

    public boolean borrowMaterial(Material material) throws Exception {
        if (canBorrow()) {
            borrowedMaterials.add(material);
            return true;
        } else {
            throw new Exception("Borrow limit reached.");
        }
    }

    public void returnMaterial(Material material) { borrowedMaterials.remove(material); }

    public abstract boolean canBorrow();
}