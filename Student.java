public class Student extends Person {
    public Student(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public boolean canBorrow() { return getBorrowedMaterials().size() < 5; }
}
