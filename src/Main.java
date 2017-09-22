import club.NightClub;
import dancers.ElectroDancer;
import dancers.PopDancer;
import dancers.RnbDancer;

public class Main {
    public static void main(String[] args) {
        NightClub nightClub = NightClub.getInstance();
        nightClub.start();

        PopDancer popDancer = new PopDancer("Алексей");
        RnbDancer rnbDancer = new RnbDancer("Вова");
        ElectroDancer electroDancer = new ElectroDancer("Василий");
        popDancer.start();
        rnbDancer.start();
        electroDancer.start();
    }
}
