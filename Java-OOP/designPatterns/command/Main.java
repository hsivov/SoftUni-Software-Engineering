package designPatterns.command;

public class Main {
    public static void main(String[] args) {

        RemoteControl remoteControl = new RemoteControl();

        Command volumeUp = new VolumeUp(remoteControl);
        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();

        Command volumeDown = new VolumeDown(remoteControl);

        volumeDown.execute();
        volumeDown.execute();
        volumeDown.execute();

        System.out.println(remoteControl.getVolume());
    }
}
