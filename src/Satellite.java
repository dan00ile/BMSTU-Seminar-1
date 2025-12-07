public abstract class Satellite {
    protected static final int DEFAULT_BATTERY_LEVEL = 100;
    protected static final boolean DEFAULT_ACTIVE = true;

    private final String name;
    private boolean isActive;
    private double batteryLevel;

    public Satellite(String name, boolean isActive, int batteryLevel) {
        this.name = name;
        this.isActive = isActive;
        this.batteryLevel = batteryLevel / 100.0;
    }

    public boolean activate() {
        if (isActive) {
            System.out.println(ConsoleColors.warning(name + ": Уже активирован!"));
            return false;
        }

        if (batteryLevel > 0.2) {
            isActive = true;
            System.out.println(ConsoleColors.success(name + ": Активация успешна"));
            return true;
        }

        System.out.println(ConsoleColors.error(name + ": Ошибка активации (заряд: " +
                          String.format("%.0f", batteryLevel * 100) + "%)"));
        return false;
    }
    public boolean deactivate() {
        if (!isActive) {
            System.out.println(ConsoleColors.warning(name + ": Уже выключен!"));
            return false;
        }
        isActive = false;

        System.out.println(ConsoleColors.success(name + ": Деактивация успешна"));
        return true;
    }

    public void consumeBattery(double amount) {
        if (batteryLevel < amount) {
            batteryLevel = 0;
            isActive = false;
            System.out.println(ConsoleColors.error(name + ": Батарея разряжена. Спутник выключен"));
            return;
        }
        batteryLevel -= amount;
    }

    protected abstract void performMission();

    protected void printCreationMessage() {
        System.out.println("Создан спутник: " + this);
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public String toString() {
        String batteryColor;
        if (batteryLevel > 0.7) {
            batteryColor = ConsoleColors.GREEN;
        } else if (batteryLevel > 0.3) {
            batteryColor = ConsoleColors.YELLOW;
        } else {
            batteryColor = ConsoleColors.RED;
        }

        String statusColor = isActive ? ConsoleColors.GREEN : ConsoleColors.RED;
        String statusText = isActive ? "активен" : "неактивен";

        return ConsoleColors.CYAN_BOLD + name + ConsoleColors.RESET +
               " [" + statusColor + statusText + ConsoleColors.RESET + "] " +
               "(заряд: " + batteryColor + String.format("%.0f", batteryLevel * 100) + "%" +
               ConsoleColors.RESET + ")";
    }
}
