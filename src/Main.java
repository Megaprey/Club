import club.NightClub;
import dancers.GenerateDancer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество танцоров в клубе :");
        Scanner scanner = new Scanner(System.in);
        int countDancers = scanner.nextInt();
        NightClub nightClub = NightClub.getInstance();
        GenerateDancer.startDancers(countDancers);
        nightClub.start();
    }
}
