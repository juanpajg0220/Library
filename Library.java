import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class Library {
    private ArrayList<Person> people;
    private ArrayList<Material> materials;
    private ArrayList<MovementHistory> movementHistory;

    public Library() {
        people = new ArrayList<>();
        materials = new ArrayList<>();
        movementHistory = new ArrayList<>();
    }

    public void registerPerson(Person person) {
        if (people.stream().noneMatch(p -> p.getId().equals(person.getId()))) {
            people.add(person);
        } else {
            System.out.println("Person with ID " + person.getId() + " is already registered.");
        }
    }

    public void registerMaterial(Material material) {
        if (materials.stream().noneMatch(m -> m.getIdentifier().equals(material.getIdentifier()))) {
            materials.add(material);
        } else {
            System.out.println("Material already registered.");
        }
    }

    public void registerBorrow(String personId, String materialId) {
        Person person = findPerson(personId);
        Material material = findMaterial(materialId);

        if (person != null && material != null) {
            try {
                if (material.borrow()) {
                    person.borrowMaterial(material);
                    movementHistory.add(new MovementHistory(materialId, "Borrow", personId, new Date()));
                } else {
                    System.out.println("Material unavailable.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registerReturn(String personId, String materialId) {
        Person person = findPerson(personId);
        Material material = findMaterial(materialId);

        if (person != null && material != null) {
            material.returnMaterial();
            person.returnMaterial(material);
            movementHistory.add(new MovementHistory(materialId, "Return", personId, new Date()));
        }
    }

    private Person findPerson(String id) {
        return people.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    private Material findMaterial(String id) {
        return materials.stream().filter(m -> m.getIdentifier().equals(id)).findFirst().orElse(null);
    }

    public void checkHistory() {
        for (MovementHistory movement : movementHistory) {
            System.out.println(movement.getMovementType() + ": Material " + movement.getMaterialIdentifier()
                    + " - Person " + movement.getPersonId() + " - Date " + movement.getMovementDate());
        }
    }

    public void savePeopleToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(people);
            System.out.println("People saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving people to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadPeopleFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            people = (ArrayList<Person>) ois.readObject();
            System.out.println("People loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading people from file: " + e.getMessage());
        }
    }
}