package InterfacesAndAbstraction.militaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{

    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }
}
