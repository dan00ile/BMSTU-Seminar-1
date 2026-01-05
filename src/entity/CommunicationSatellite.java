package entity;

import utils.ConsoleColors;

public class CommunicationSatellite extends Satellite {
    private final double bandwidth;

    public CommunicationSatellite(String name, boolean isActive, int batteryLevel, double bandwidth) {
        super(name, isActive, batteryLevel);
        this.bandwidth = bandwidth;
        printCreationMessage();
    }

    public CommunicationSatellite(String name, boolean isActive, double bandwidth) {
        this(name, isActive, Satellite.DEFAULT_BATTERY_LEVEL, bandwidth);
    }

    public CommunicationSatellite(String name, double bandwidth) {
        this(name, Satellite.DEFAULT_ACTIVE, Satellite.DEFAULT_BATTERY_LEVEL, bandwidth);
    }

    public double getBandwidth() {
        return bandwidth;
    }

    @Override
    protected void performMission() {
        if (isActive()) {
            System.out.println(ConsoleColors.colorize(getName() +
                             ": Передача данных со скоростью " + bandwidth + " Мбит/с",
                             ConsoleColors.CYAN));
            sendData(bandwidth);
            consumeBattery(0.05);
        } else {
            System.out.println(ConsoleColors.error(getName() + ": Не может выполнить передачу данных - не активен"));
        }
    }

    private void sendData(double data) {
        System.out.println(ConsoleColors.colorize(getName() +
                         ": Отправил " + data + " Мбит данных!",
                         ConsoleColors.GREEN));
    }

    @Override
    public String toString() {
        return super.toString() + " " + ConsoleColors.colorize(
               "[Связь: " + bandwidth + " Мбит/с]", ConsoleColors.PURPLE);
    }
}
