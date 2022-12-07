package designPatterns.command;

public class VolumeDown implements Command{

    RemoteControl remoteControl;

    public VolumeDown(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public void execute() {
        int currentVolume = remoteControl.getVolume();
        remoteControl.setVolume(currentVolume - 1);
    }
}
