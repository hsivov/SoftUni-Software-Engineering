package InterfacesAndAbstraction.militaryElite;

public class SpyImpl extends PrivateImpl{

    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, double salary, String codeNumber) {
        super(id, firstName, lastName, salary);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s", getFirstName(), getLastName(), getId(), codeNumber);
    }
}
