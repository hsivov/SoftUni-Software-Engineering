package ForLoop.exercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        double total = 0;
        int musala = 0;
        int montblanc = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;

        for (int i = 0; i < groups; i++) {
            int members = Integer.parseInt(scanner.nextLine());
            total += members;

            if (members <= 5){
                musala += members;
            }else if(members <= 12){
                montblanc += members;
            }else if(members <= 25){
                kilimandjaro += members;
            }else if (members <= 40){
                k2 += members;
            }else{
                everest += members;
            }
        }
        double percentMusala = musala / total * 100;
        double percentMontblanc = montblanc / total * 100;
        double percentKilimandjaro = kilimandjaro / total * 100;
        double percentK2 = k2 / total * 100;
        double percentEverest = everest / total * 100;

        System.out.printf("%.2f%%%n", percentMusala);
        System.out.printf("%.2f%%%n", percentMontblanc);
        System.out.printf("%.2f%%%n", percentKilimandjaro);
        System.out.printf("%.2f%%%n", percentK2);
        System.out.printf("%.2f%%", percentEverest);
    }
}
