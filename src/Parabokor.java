public class Parabokor extends Plant {
    public Parabokor(String name, int tapanyag) {
        this.name = name;
        this.tapanyag = tapanyag;
        this.isAlive = true;

    }

    @Override
    void handleRad(World world) {
        if (world.getCurrentRad() == "norad") {
            tapanyag -= 1;
        } else {
            tapanyag += 1;
        }
        checkResources();
    }

}
