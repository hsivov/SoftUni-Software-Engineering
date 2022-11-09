package InterfacesAndAbstraction.militaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
