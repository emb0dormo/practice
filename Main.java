import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение:");
            String input = scanner.nextLine();

            String result = calculate(input);  
            System.out.println(result);  
            System.out.println(result.length());
        }
    }
    public static String calculate(String input) {
        input = input.trim(); // Remove extra spaces
        // +
        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str1 = parts[0].trim();
            String str2 = parts[1].trim();
            return str1.substring(1, str1.length() - 1) + str2.substring(1, str2.length() - 1);
        }
        // -
        if (input.contains("-")) {
            String[] parts = input.split("-");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str1 = parts[0].trim();
            String str2 = parts[1].trim();
            return str1.substring(1, str1.length() - 1).replace(str2.substring(1, str2.length() - 1), "");
        }

        // *
        if (input.contains("*")) {
            String[] parts = input.split("\\*");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str = parts[0].trim();
            int num;
            try {
                num = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                return "Неправильный формат числа.";
            }

            String repeatedStr = str.substring(1, str.length() - 1).repeat(num);
            if (repeatedStr.length() > 40) {
                return repeatedStr.substring(0, 40) + "...";
            } else {
                return repeatedStr;
            }
        }

        // delenie
        if (input.contains("/")) {
            String[] parts = input.split("/");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str = parts[0].trim();
            int num;
            try {
                num = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                return "Неправильный формат числа.";
            }
            String result = str.substring(1, str.length() - 1);
            if (num > result.length()) return "Делитель больше длины строки.";
            return result.substring(0, result.length() / num);
        }

        return "Неподдерживаемая операция.";
    }
}
