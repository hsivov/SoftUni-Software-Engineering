package InterfacesAndAbstraction.militaryElite;

public class MissionImpl implements Mission {
    private final String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
        state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.toString());
    }
}
