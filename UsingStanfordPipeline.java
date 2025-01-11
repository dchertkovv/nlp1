import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;

public class UsingStanfordPipeline {

    public static void process(String paragraph) {
        Properties properties = new Properties();
        properties.put("annotators", "tokenize, ssplit");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
        Annotation annotation = new Annotation(paragraph);
        pipeline.annotate(annotation);
        pipeline.prettyPrint(annotation, System.out);
    }
}
