package club;

import java.util.ArrayList;

/**
 * Created by User on 21.09.2017.
 */
public class NightClub extends Thread {
    private static volatile NightClub instance;

    private ArrayList<String> musicList = new ArrayList<>();
    private volatile String music;

    {
        musicList.add("Pop");
        musicList.add("Rnb");
        musicList.add("Electrodance");
    }

    private NightClub(){}

    public static NightClub getInstance() {
        NightClub localInstance = instance;
        if (localInstance == null) {
            synchronized (NightClub.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new NightClub();
                }
            }
        }
        return localInstance;
    }

    public synchronized String getMusic() {
        return music;
    }


    /**
     * change the music every 5 seconds
     * @throws InterruptedException
     */
    public  void playMusic() throws InterruptedException {
        while (true) {
            for (String music : musicList) {
                System.out.println("Play " + music);
                this.music = music;
                Thread.sleep(5000);
            }
        }
    }

    @Override
    public void run() {
        try {
            playMusic();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
