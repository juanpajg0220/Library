public class Teacher extends Person {
    public Teacher(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public boolean canBorrow() { return getBorrowedMaterials().size() < 3; }
}
