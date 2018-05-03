public class Deltafa extends Plant {
    public Deltafa(String name, int tapanyag) {
        this.name = name;
        this.tapanyag = tapanyag;
        this.isAlive = true;

    }

    public void handleRad(World world) {
        if (world.getCurrentRad() == "alpha") {
            tapanyag -= 3;
        } else if (world.getCurrentRad() == "delta") {
            tapanyag += 4;
        } else {
            tapanyag -= 1;
        }

        checkResources();

        if (this.isAlive) {
            if (tapanyag < 5) {
                world.needOfDeltaRad+=4;
            } else if (tapanyag >= 5 && tapanyag <= 10) {
                world.needOfDeltaRad += 1;
            }
        }
    }
}
