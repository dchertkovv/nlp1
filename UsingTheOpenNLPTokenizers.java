import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
//hello
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UsingTheOpenNLPTokenizers {

    public static void main(String[] args) {
        usingTheSimpleTokenizerClass();
        usingTheTokenizerMEClass();
        usingTheWhitespaceTokenizer();
    }

    // Токенизация с использованием SimpleTokenizer
    private static void usingTheSimpleTokenizerClass() {
        System.out.println("--- SimpleTokenizer ---");
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = simpleTokenizer.tokenize("Let's pause, and then reflect.");
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    // Токенизация с использованием TokenizerME
    private static void usingTheTokenizerMEClass() {
        try {
            InputStream modelIn = new FileInputStream("path/to/your/tokenizer-model.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            Tokenizer tokenizer = new TokenizerME(model);
            String[] tokens = tokenizer.tokenize("Let's pause, and then reflect.");
            for (String token : tokens) {
                System.out.println(token);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Токенизация с использованием WhitespaceTokenizer
    private static void usingTheWhitespaceTokenizer() {
        String[] tokens = opennlp.tools.tokenize.WhitespaceTokenizer.INSTANCE.tokenize("Let's pause, and then reflect.");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
