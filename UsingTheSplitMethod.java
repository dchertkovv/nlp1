public class UsingTheSplitMethod {

    public static void main(String[] args) {
        usingTheSplitMethod();
    }

    // Токенизация с использованием метода split
    private static void usingTheSplitMethod() {
        String text = "Mr. Smith went to 123 Washington avenue.";
        String[] tokens = text.split("\\s+");
        for (String token : tokens) {
            System.out.println(token);
        }

        text = "Let's pause, and then reflect.";
        tokens = text.split("[ ,.]");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
