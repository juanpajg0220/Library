import java.util.ArrayList;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private ArrayList<Material> borrowedMaterials;

    public Person(String id, String firstName, String lastName, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.borrowedMaterials = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<Material> getBorrowedMaterials() {
        return borrowedMaterials;
    }

    public boolean canBorrow() {
        int borrowLimit = 0;
        switch (role) {
            case "Student":
                borrowLimit = 5;
                break;
            case "Teacher":
                borrowLimit = 3;
                break;
            case "Administrative":
                borrowLimit = 2;
                break;
        }
        return borrowedMaterials.size() < borrowLimit;
    }

    public void borrowMaterial(Material material) {
        if (canBorrow()) {
            borrowedMaterials.add(material);
        } else {
            System.out.println("Cannot borrow more materials. Limit reached.");
        }
    }

    public void returnMaterial(Material material) {
        borrowedMaterials.remove(material);
    }
}