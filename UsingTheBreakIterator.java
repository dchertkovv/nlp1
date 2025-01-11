import java.text.BreakIterator;
import java.util.Locale;

public class UsingTheBreakIterator {

    public static void main(String[] args) {
        usingTheBreakIterator();
    }

    // Токенизация с использованием BreakIterator
    private static void usingTheBreakIterator() {
        BreakIterator wordIterator = BreakIterator.getWordInstance(Locale.US);
        String text = "Let's pause, and then reflect.";
        wordIterator.setText(text);
        int boundary = wordIterator.first();
        while (boundary != BreakIterator.DONE) {
            int begin = boundary;
            boundary = wordIterator.next();
            int end = boundary;
            if (end == BreakIterator.DONE) break;
            System.out.println(text.substring(begin, end));
        }
    }
}
