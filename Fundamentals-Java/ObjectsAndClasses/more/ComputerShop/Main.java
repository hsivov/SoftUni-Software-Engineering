package ObjectsAndClasses.more.ComputerShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Computer> computerList = new ArrayList<>();

        String[] cpu = {"Intel i3-10100", "Intel i5-10400F", "Intel i5-11400F", "Ryzen 5600", "Ryzen 5600XT"};
        String[] ram = {"8GB", "16GB", "32GB", "2x8GB kit"};
        String[] gpu = {"Nvidia GTX-1660Super", "Nvidia RTX-2060", "Nvidia RTX-3060", "Radeon RX6600TX"};
        String[] storage = {"1TB", "SSD 256GB", "SSD 512GB", "Nve M2 500GB"};

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            Processor processor = new Processor(cpu[random.nextInt(cpu.length)], random.nextInt(265, 350));
            RAM memory = new RAM(ram[random.nextInt(ram.length)], random.nextInt(150, 200));
            GPU video = new GPU(gpu[random.nextInt(gpu.length)], random.nextInt(800, 1050));
            Storage hdd = new Storage(storage[random.nextInt(storage.length)], random.nextInt(80, 125));

            Computer computer = new Computer(processor, memory, video, hdd);
            computerList.add(computer);
        }

        for (Computer computer : computerList){
            System.out.println(computer.getProcessor().getModel() + " - " + computer.getProcessor().getPrice() + "лв.");
            System.out.println(computer.getRam().getCapacity() + " - " + computer.getRam().getPrice() + "лв.");
            System.out.println(computer.getGpu().getModel() + " - " + computer.getGpu().getPrice() + "лв.");
            System.out.println(computer.getStorage().getModel() + " - " + computer.getStorage().getPrice() + "лв.");
            System.out.println();
        }
    }
}
