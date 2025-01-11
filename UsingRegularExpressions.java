import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsingRegularExpressions {

    public static void process(String paragraph) {
        String pattern = "((?<=[a-z0-9][.?!])|(?<=[a-z0-9][.?!]\\\"))(\\s|\\r\\n)(?=\\\"?[A-Z])";
        String simple = "[.?!]";
        String[] splitString = (paragraph.split(simple));
        
        // Разделение строки с использованием регулярных выражений
        for (String string : splitString) {
            System.out.println(string);
        }

        // Печать предложений, найденных с помощью регулярного выражения
        Pattern sentencePattern = Pattern.compile(
            "# Match a sentence ending in punctuation or EOS.\n"
            + "[^.!?\\s]    # First char is non-punct, non-ws\n"
            + "[^.!?]*      # Greedily consume up to punctuation.\n"
            + "(?:          # Group for unrolling the loop.\n"
            + "  [.!?]      # (special) inner punctuation ok if\n"
            + "  (?!['\"]?\\s|$)  # not followed by ws or EOS.\n"
            + "  [^.!?]*    # Greedily consume up to punctuation.\n"
            + ")*           # Zero or more (special normal*)\n"
            + "[.!?]?       # Optional ending punctuation.\n"
            + "['\"]?       # Optional closing quote.\n"
            + "(?=\\s|$)",
            Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matcher = sentencePattern.matcher(paragraph);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
