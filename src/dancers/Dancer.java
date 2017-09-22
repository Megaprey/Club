package dancers;

import activitys.Activity;
import activitys.Dance;
import activitys.DrinkVodka;
import club.NightClub;

/**
 * Created by User on 21.09.2017.
 */
public abstract class Dancer extends Thread{
    private String name;
    private String musicDance;
    // I'm defined it for CPU not degradation
    private Activity currentActivity = new DrinkVodka();
    private final static NightClub nightClub = NightClub.getInstance();

    public Dancer(String name, String musicDance) {
        this.name = name;
        this.musicDance = musicDance;
    }

    private void setCurrentActivity(Activity activity){
        if (!(activity == null || currentActivity.getClass() == activity.getClass())){
            currentActivity = activity;
            activity.doSomething(name);
        }
    }


    @Override
    public void run() {
        Dance dance = new Dance();
        DrinkVodka drinkVodka = new DrinkVodka();
        String currentMuisicType;

        while(true){
            currentMuisicType = nightClub.getMusic();
            Activity activity = musicDance.equals(currentMuisicType) ? dance : drinkVodka;
            setCurrentActivity(activity);
            sleepDancer(500);
        }
    }

    private void sleepDancer(long milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
