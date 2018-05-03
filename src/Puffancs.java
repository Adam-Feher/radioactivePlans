public class Puffancs extends Plant {
    public Puffancs(String name, int tapanyag) {
        this.name = name;
        this.tapanyag = tapanyag;
        this.isAlive = true;
    }

    public void handleRad(World world) {
        if (world.getCurrentRad() == "alpha") {
            tapanyag += 2;
        } else if (world.getCurrentRad() == "delta") {
            tapanyag -= 2;
        } else {
            tapanyag-=1;
        }
        checkResources();
        if (this.isAlive) {
            world.needOfAlphaRad += 10 - tapanyag;
        }
    }

    @Override
    public void checkResources() {
        if (tapanyag < 1  || tapanyag > 10) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        return "Puffancs{" +
                "name='" + name + '\'' +
                ", tapanyag=" + tapanyag +
                ", isAlive=" + isAlive +
                '}';
    }
}
