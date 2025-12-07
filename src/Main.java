public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + ConsoleColors.colorize(
                         "ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ",
                         ConsoleColors.BLUE_BOLD));
        System.out.println(ConsoleColors.separator(60, '='));

        System.out.println(ConsoleColors.colorize(
                         "\nСОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:",
                         ConsoleColors.YELLOW_BOLD));
        System.out.println(ConsoleColors.separator(45, '-'));

        CommunicationSatellite comSat1 = new CommunicationSatellite("Связь-1", false, 85, 500.0);
        CommunicationSatellite comSat2 = new CommunicationSatellite("Связь-2", false, 75, 1000.0);
        ImagingSatellite imgSat1 = new ImagingSatellite("ДЗЗ-1", false, 92, 2.5);
        ImagingSatellite imgSat2 = new ImagingSatellite("ДЗЗ-2", false, 45, 1.0);
        ImagingSatellite imgSat3 = new ImagingSatellite("ДЗЗ-3", false, 15, 0.5);

        System.out.println(ConsoleColors.separator(45, '-'));

        SatelliteConstellation constellation = new SatelliteConstellation("RU Basic");

        System.out.println(ConsoleColors.colorize(
                         "\nФОРМИРОВАНИЕ ГРУППИРОВКИ:",
                         ConsoleColors.YELLOW_BOLD));
        System.out.println(ConsoleColors.separator(35, '-'));

        constellation.addSatellite(comSat1);
        constellation.addSatellite(comSat2);
        constellation.addSatellite(imgSat1);
        constellation.addSatellite(imgSat2);
        constellation.addSatellite(imgSat3);

        System.out.println(ConsoleColors.separator(35, '-'));

        constellation.displayStatus();

        System.out.println("\n" + ConsoleColors.colorize(
                         "АКТИВАЦИЯ СПУТНИКОВ:",
                         ConsoleColors.YELLOW_BOLD));
        System.out.println(ConsoleColors.separator(25, '-'));

        for (Satellite sat : constellation.getSatellites()) {
            sat.activate();
        }

        System.out.println("\n" + ConsoleColors.colorize(
                         "ВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ " +
                         constellation.toString().toUpperCase(),
                         ConsoleColors.PURPLE_BOLD));
        System.out.println(ConsoleColors.separator(50, '='));

        constellation.executeAllMission();

        constellation.displayStatus();

        System.out.println(ConsoleColors.separator(60, '=') + "\n");

        System.out.println(constellation.getSatellites());
    }
}