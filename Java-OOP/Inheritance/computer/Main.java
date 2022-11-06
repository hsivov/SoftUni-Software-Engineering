package Inheritance.computer;

public class Main {
    public static void main(String[] args) {

        Processor processor = new Processor("Intel I5-10400F", 315, "4.3 GHz");
        MotherBoard motherBoard = new MotherBoard("ASUS ROG STRIX B460-F GAMING", 399);
        RAM ram = new RAM("Corsair 2x8GB", 186, 16);
        HDD hdd = new HDD("Samsung Evo-9", 215, 500,"M.2 NVMe");
        VideoCard videoCard = new VideoCard("ASUS Dual GeForce RTX 2060 OC EVO 6GB", 919, 6, 192);

        Computer computer = new Computer("Razor");

        computer.addComponent(processor);
        computer.addComponent(motherBoard);
        computer.addComponent(ram);
        computer.addComponent(hdd);
        computer.addComponent(videoCard);

        System.out.println(computer);
        System.out.printf("%nTotal price: %.2f лв.", computer.getTotalPrice());
    }
}
