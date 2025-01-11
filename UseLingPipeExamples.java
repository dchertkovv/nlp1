import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.sentences.SentenceChunker;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import java.util.List;
import java.util.Set;

public class UseLingPipeExamples {

    public static void process(String paragraph) {
        TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;
        com.aliasi.sentences.SentenceModel sentenceModel = new com.aliasi.sentences.IndoEuropeanSentenceModel();
        SentenceChunker sentenceChunker = new SentenceChunker(tokenizerFactory, sentenceModel);

        Chunking chunking = sentenceChunker.chunk(paragraph.toCharArray(), 0, paragraph.length());
        Set<Chunk> sentences = chunking.chunkSet();
        String slice = chunking.charSequence().toString();

        for (Chunk sentence : sentences) {
            System.out.println("[" + slice.substring(sentence.start(), sentence.end()) + "]");
        }
    }
}
