import java.util.ArrayList;
import java.util.Date;

public class Library {
    private ArrayList<Person> people;
    private ArrayList<Material> materials;
    private ArrayList<MovementHistory> movementHistory;

    public Library() {
        people = new ArrayList<>();
        materials = new ArrayList<>();
        movementHistory = new ArrayList<>();
    }

    // Methods to handle people
    public void registerPerson(Person person) {
        for (Person p : people) {
            if (p.getId().equals(person.getId())) {
                System.out.println("Person with ID " + person.getId() + " is already registered.");
                return;
            }
        }
        people.add(person);
    }

    public void removePerson(String id) {
        Person person = findPerson(id);
        if (person != null) {
            if (person.getBorrowedMaterials().isEmpty()) {
                people.remove(person);
                System.out.println("Person successfully removed.");
            } else {
                System.out.println("Person has borrowed materials. Cannot remove.");
            }
        } else {
            System.out.println("Person not found.");
        }
    }

    public Person findPerson(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    // Methods to handle materials
    public void registerMaterial(Material material) {
        for (Material m : materials) {
            if (m.getIdentifier().equals(material.getIdentifier())) {
                System.out.println("Material with identifier " + material.getIdentifier() + " is already registered.");
                return;
            }
        }
        materials.add(material);
    }

    public Material findMaterial(String identifier) {
        for (Material material : materials) {
            if (material.getIdentifier().equals(identifier)) {
                return material;
            }
        }
        return null;
    }

    // Methods for borrowing
    public void registerBorrow(String personId, String materialIdentifier) {
        Person person = findPerson(personId);
        Material material = findMaterial(materialIdentifier);

        if (person != null && material != null && material.borrow()) {
            person.borrowMaterial(material);
            movementHistory.add(new MovementHistory(materialIdentifier, "Borrow", personId, new Date()));
        }
    }

    // Methods for returning
    public void registerReturn(String personId, String materialIdentifier) {
        Person person = findPerson(personId);
        Material material = findMaterial(materialIdentifier);

        if (person != null && material != null) {
            material.returnMaterial();
            person.returnMaterial(material);
            movementHistory.add(new MovementHistory(materialIdentifier, "Return", personId, new Date()));
        }
    }

    // Method to check library history
    public void checkHistory() {
        for (MovementHistory movement : movementHistory) {
            System.out.println(movement.getMovementType() + ": Material " + movement.getMaterialIdentifier()
                    + " - Person " + movement.getPersonId() + " - Date " + movement.getMovementDate());
        }
    }
}