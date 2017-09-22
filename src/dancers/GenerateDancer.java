package dancers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GenerateDancer {
    private static String nameId = "";
    private static int id = 0;

    /**
     * lets dancers into the club
     * @param numberDancer number of dancers
     */
    public static void startDancers(int numberDancer){
        ExecutorService dancers = Executors.newFixedThreadPool(numberDancer);
        for(int i = 0; i < numberDancer; i++){
            dancers.submit(generateDancer());
        }
    }

    /**
     *
     * @return a dancer with a random name
     */
    private static Dancer generateDancer(){
        String name1 = "Алексей" + nameId;
        String name2 = "Анна" + nameId;
        String name3 = "Вова" + nameId;

        id++;
        nameId = "" + id;
        int a = 1 + (int)(Math.random() * 3);
        if(a == 1){
            return new ElectroDancer(name1);
        }
        if(a == 2){
            return new PopDancer(name2);
        }
        return new RnbDancer(name3);
    }
}
