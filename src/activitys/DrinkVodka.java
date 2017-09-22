package activitys;

public class DrinkVodka implements Activity{
    /**
     *
     * @param name the name of the dancer
     */
    @Override
    public void doSomething(String name) {
        System.out.println(name + " пьёт водку в баре.");
    }
}
