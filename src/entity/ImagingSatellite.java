package entity;

import utils.ConsoleColors;

public class ImagingSatellite extends Satellite {
    private final double resolution;
    private int photosTaken;

    public ImagingSatellite(String name, boolean isActive, int batteryLevel, double resolution) {
        super(name, isActive, batteryLevel);
        this.resolution = resolution;
        printCreationMessage();
    }

    public ImagingSatellite(String name, boolean isActive, double resolution) {
        this(name, isActive, DEFAULT_BATTERY_LEVEL, resolution);
    }

    public ImagingSatellite(String name, double resolution) {
        this(name, DEFAULT_ACTIVE, DEFAULT_BATTERY_LEVEL, resolution);
    }

    @Override
    protected void performMission() {
           if (isActive()) {
               System.out.println(ConsoleColors.colorize(getName() +
                                ": Съемка территории с разрешением " + resolution + " м/пиксель",
                                ConsoleColors.CYAN));
               takePhoto();
               consumeBattery(0.08);
               System.out.println(ConsoleColors.colorize(getName() +
                                ": Снимок #" + photosTaken + " сделан!",
                                ConsoleColors.GREEN));
           } else {
               System.out.println(ConsoleColors.error(getName() + ": Не может выполнить съемку - не активен"));
           }
    }

    public double getResolution() {
        return resolution;
    }
    public int getPhotosTaken() {
        return photosTaken;
    }

    private void takePhoto() {
        photosTaken++;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ConsoleColors.colorize(
               "[ДЗЗ: " + resolution + " м/пиксель, снимков: " + photosTaken + "]",
               ConsoleColors.BLUE);
    }
}
