import java.text.BreakIterator;

public class UsingBreakIterator {

    public static void process(String paragraph) {
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance();
        sentenceIterator.setText(paragraph);
        int boundary = sentenceIterator.first();
        while (boundary != BreakIterator.DONE) {
            int begin = boundary;
            System.out.print(boundary + "-");
            boundary = sentenceIterator.next();
            int end = boundary;
            if (end == BreakIterator.DONE) {
                break;
            }
            System.out.println(boundary + " [" + paragraph.substring(begin, end) + "]");
        }
    }
}
