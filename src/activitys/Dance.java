package activitys;

public class Dance implements Activity {
    /**
     *
     * @param name the name of the dancer
     */
    @Override
    public void doSomething(String name) {
        System.out.println(name + " танцует.");
    }
}
