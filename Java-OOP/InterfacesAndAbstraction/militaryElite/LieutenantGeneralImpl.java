package InterfacesAndAbstraction.militaryElite;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{

    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new HashSet<>();
    }


    @Override
    public void addPrivate(Private priv) {
        privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator())
                .append("Privates:");
        privates = privates.stream().
                sorted(Comparator.comparingInt(Soldier::getId).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Private aPrivate : privates) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(aPrivate);
        }
        return sb.toString();
    }
}
