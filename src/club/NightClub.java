package club;

import music.Music;

import java.util.ArrayList;

/**
 * Created by User on 21.09.2017.
 */
public class NightClub extends Thread {
    private static volatile NightClub instance;

    private ArrayList<Music> musicList = new ArrayList<>();
    private volatile Music music;

    {
        musicList.add(Music.POP);
        musicList.add(Music.RNB);
        musicList.add(Music.ELECTROHOUSE);
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

    public synchronized Music getMusic() {
        return music;
    }


    /**
     * change the music every 5 seconds
     * @throws InterruptedException
     */
    public  void playMusic() throws InterruptedException {
        while (true) {
            for (Music music : musicList) {
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
