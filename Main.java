import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create people
        Person person1 = new Person("123456789", "juan", "jimenez", "Student");
        Person person2 = new Person("987654321", "carolina", "gonzalez", "Teacher");

        // Register people
        library.registerPerson(person1);
        library.registerPerson(person2);

        // Create materials
        Material book1 = new Material("AU12345", "Advanced Mathematics", new Date(), 10);
        Material magazine1 = new Material("BR67890", "Science Magazine", new Date(), 5);

        // Register materials
        library.registerMaterial(book1);
        library.registerMaterial(magazine1);

        // Register a borrow
        library.registerBorrow("123456789", "AU12345");

        // Check history
        library.checkHistory();

        // Register a return
        library.registerReturn("123456789", "AU12345");

        // Check history again
        library.checkHistory();
    }
}