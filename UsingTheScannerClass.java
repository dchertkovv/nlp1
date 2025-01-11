import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsingTheScannerClass {

    public static void main(String[] args) {
        usingTheScannerClass();
    }

    // Токенизация с использованием класса Scanner
    private static void usingTheScannerClass() {
        String paragraph = "Let's pause, and then reflect.";
        Scanner scanner = new Scanner(paragraph);
        List<String> list = new ArrayList<>();
        // Указываем разделители для токенизации
        scanner.useDelimiter("[ ,.]");

        while (scanner.hasNext()) {
            String token = scanner.next();
            list.add(token);
        }
        for (String token : list) {
            System.out.println(token);
        }
    }
}
