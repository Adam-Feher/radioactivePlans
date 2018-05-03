import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class World {
    public int needOfAlphaRad;
    public int needOfDeltaRad;
    private String currentRad;

    public String getCurrentRad() {
        return currentRad;
    }

    public static void main(String[] args) throws FileNotFoundException {
        World world = new World();
        ArrayList<String> simulationData = world.readSimulationData();
        ArrayList<Plant> plants = world.getPlants(simulationData);
        System.out.println(plants.stream().filter(plant -> plant.isAlive).map(plant -> plant.name).collect(Collectors.toList()));
        world.simulation(simulationData, plants);
        System.out.println(plants.stream().filter(plant -> plant.isAlive).map(plant -> plant.name).collect(Collectors.toList()));
    }

    private void simulation(ArrayList<String> simulationData, ArrayList<Plant> plants) {
        for (int i = 0; i < Integer.valueOf(simulationData.get(0));i++) {
            calcRad();
            System.out.println(this.currentRad);
            for (Plant plant : plants) {
                if (plant.isAlive) {
                    plant.handleRad(this);
                }
            }
        }
    }

    private ArrayList readSimulationData() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data.txt"));
        ArrayList<String> simulationData = new ArrayList<>();
        while (s.hasNextLine()){
            simulationData.add(s.nextLine());
        }
        s.close();
        return simulationData;
    }

    private ArrayList<Plant> getPlants(ArrayList<String> simulationData) {
        ArrayList<Plant> plants = new ArrayList<>();

        for (int i = 1; i < simulationData.size();i++) {
            List<String> plantData = Arrays.asList(simulationData.get(i).split(" "));
            if (plantData.get(1).equals("a")) {
                plants.add(new Puffancs(plantData.get(0), Integer.valueOf(plantData.get(2))));
            }
            if (plantData.get(1).equals("d")) {
                plants.add(new Deltafa(plantData.get(0), Integer.valueOf(plantData.get(2))));
            }
            if (plantData.get(1).equals("p")) {
                plants.add(new Parabokor(plantData.get(0), Integer.valueOf(plantData.get(2))));
            }
        }
        return plants;
    }

    private void calcRad() {
        if (needOfAlphaRad  > needOfDeltaRad +2) {
            currentRad = "alpha";
        } else if (needOfDeltaRad > needOfAlphaRad + 2) {
            currentRad = "delta";
        } else currentRad = "norad";
    }

}
