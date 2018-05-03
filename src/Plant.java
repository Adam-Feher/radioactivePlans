public abstract class Plant {
    String name;
    int tapanyag;
    boolean isAlive;

    abstract void handleRad(World world);

    void checkResources() {
        if (tapanyag < 1) {
            this.isAlive = false;
        }
    }
}
