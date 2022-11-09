package InterfacesAndAbstraction.militaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{

    private final Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary()))
                .append(System.lineSeparator())
                .append("Corps: ").append(getCorps()).append(System.lineSeparator())
                .append("Missions: ");

        for (Mission mission : getMissions()) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission);
        }
        return sb.toString();
    }
}
