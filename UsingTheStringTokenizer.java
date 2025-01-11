import java.util.StringTokenizer;

public class UsingTheStringTokenizer {

    public static void main(String[] args) {
        usingTheStringTokenizerClass();
    }

    // Токенизация с использованием StringTokenizer
    private static void usingTheStringTokenizerClass() {
        StringTokenizer st = new StringTokenizer("Let's pause, and then reflect.");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
