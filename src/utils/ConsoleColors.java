package utils;

public class ConsoleColors {
    public static final String RESET = "\033[0m";

    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";

    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";

    public static String colorize(String text, String color) {
        return color + text + RESET;
    }

    public static String success(String text) {
        return GREEN_BOLD + "✅ " + RESET + GREEN + text + RESET;
    }

    public static String error(String text) {
        return RED_BOLD + "🛑 " + RESET + RED + text + RESET;
    }

    public static String warning(String text) {
        return YELLOW_BOLD + "⚠ " + RESET + YELLOW + text + RESET;
    }

    public static String header(String text) {
        return BLUE_BOLD + text + RESET;
    }

    public static String separator(int length, char symbol) {
        return String.valueOf(symbol).repeat(Math.max(0, length));
    }
}
