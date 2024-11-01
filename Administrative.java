public class Administrative extends Person {
    public Administrative(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public boolean canBorrow() { return getBorrowedMaterials().size() < 2; }
}
