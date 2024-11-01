import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Person student = new Student("123456789", "John", "Doe");
        Person teacher = new Teacher("987654321", "Anna", "Smith");

        library.registerPerson(student);
        library.registerPerson(teacher);

        library.savePeopleToFile("people.dat");
        library.loadPeopleFromFile("people.dat");

        Material book = new Book("AU12345", "Advanced Mathematics", new Date(), 10);
        Material magazine = new Magazine("BR67890", "Science Magazine", new Date(), 5);

        library.registerMaterial(book);
        library.registerMaterial(magazine);

        library.registerBorrow("123456789", "AU12345");
        library.checkHistory();

        library.registerReturn("123456789", "AU12345");
        library.checkHistory();
    }
}
