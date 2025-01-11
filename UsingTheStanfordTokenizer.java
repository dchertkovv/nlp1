import edu.stanford.nlp.ling.CoreAnnotations.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.process.*;

import java.util.*;

public class UsingTheStanfordTokenizer {

    public static void main(String[] args) {
        usingTheStanfordTokenizer();
    }

    // Токенизация с использованием Stanford Tokenizer
    private static void usingTheStanfordTokenizer() {
        String paragraph = "Let's pause, and then reflect.";

        // Использование PTBTokenizer
        PTBTokenizer<CoreLabel> ptb = new PTBTokenizer<>(new StringReader(paragraph), new CoreLabelTokenFactory(), "");
        while (ptb.hasNext()) {
            CoreLabel label = ptb.next();
            System.out.println(label.originalText());
        }

        // Использование DocumentPreprocessor
        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(new StringReader(paragraph));
        for (List<HasWord> sentence : documentPreprocessor) {
            for (HasWord word : sentence) {
                System.out.println(word.word());
            }
        }

        // Использование Stanford NLP Pipeline
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = new Annotation(paragraph);
        pipeline.annotate(annotation);
        pipeline.prettyPrint(annotation, System.out);
    }
}
