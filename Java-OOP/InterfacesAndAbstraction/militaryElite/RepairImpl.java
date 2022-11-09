package InterfacesAndAbstraction.militaryElite;

public class RepairImpl implements Repair{
    private final String partName;
    private final int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", partName, hoursWorked);
    }
}
