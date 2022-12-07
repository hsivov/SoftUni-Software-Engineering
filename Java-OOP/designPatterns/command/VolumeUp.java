package designPatterns.command;

public class VolumeUp implements Command{

    RemoteControl remoteControl;

    public VolumeUp(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public void execute() {
        int currentVolume = remoteControl.getVolume();
        remoteControl.setVolume(currentVolume + 1);
    }
}
