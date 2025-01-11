import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UsingOpenNLP {

    public static void process(String paragraph, String modelDir) {
        try (InputStream is = new FileInputStream(modelDir + "/opennlp-en-ud-ewt-sentence-1.1-2.4.0.bin")) {
            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME detector = new SentenceDetectorME(model);

            // Детектируем предложения
            Span[] spans = detector.sentPosDetect(paragraph);
            for (Span span : spans) {
                System.out.println(span + " [" + paragraph.substring(span.getStart(), span.getEnd()) + "]");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
