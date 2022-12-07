package designPatterns.command;

public class RemoteControl {

    private int volume;
    private int program;

    public RemoteControl() {
        this.volume = 0;
        this.program = 0;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
