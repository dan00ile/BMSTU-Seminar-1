package entity;

import utils.ConsoleColors;

import java.util.ArrayList;
import java.util.List;

public class SatelliteConstellation {
    private final String constellationName;
    private final List<Satellite> satellite;

    public SatelliteConstellation(String constellationName) {
        this.constellationName = constellationName;
        this.satellite = new ArrayList<>();
        System.out.println(ConsoleColors.separator(45, '-'));
        System.out.println(ConsoleColors.header("Создана спутниковая группировка: " + constellationName));
        System.out.println(ConsoleColors.separator(45, '-'));
    }

    public void addSatellite(Satellite satellite) {
        this.satellite.add(satellite);
        System.out.println(ConsoleColors.colorize(satellite.getName() +
                " добавлен в группировку '" + constellationName + "'", ConsoleColors.GREEN));
    }

    public void executeAllMission() {
        for (Satellite satellite : satellite) {
            satellite.performMission();
        }
    }

    public List<Satellite> getSatellites() {
        return satellite;
    }

    public void displayStatus() {
        System.out.println("\n" + ConsoleColors.BLUE_BOLD + "СТАТУС ГРУППИРОВКИ: " +
                         constellationName.toUpperCase() + ConsoleColors.RESET);
        System.out.println(ConsoleColors.separator(60, '='));
        for (Satellite sat : satellite) {
            System.out.println("  " + sat);
        }
        System.out.println(ConsoleColors.separator(60, '='));
    }

    @Override
    public String toString() {
        return ConsoleColors.YELLOW_BOLD + constellationName + ConsoleColors.RESET;
    }
}
