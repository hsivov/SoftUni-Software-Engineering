package InterfacesAndAbstraction.militaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    private final Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator())
                .append("Corps: ").append(getCorps()).append(System.lineSeparator())
                .append("Repairs: ");


        for (Repair repair : getRepairs()) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(repair);
        }
        return sb.toString();
    }
}
