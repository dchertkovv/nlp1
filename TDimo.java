/*
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.LowerCaseTokenizerFactory;
import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.PorterStemmerTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.util.CoreMap;
*/
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TDimo{
	private static String paragraph = "Let's pause, \nand then reflect.";

	public static void main(String[] args){
		//Токенизация при помощи Scanner для токенизации
		System.out.println("Использование класса Scanner для токенизации");
		usingTheScannerClass();
		
		//Токенизация при помощи метода split()
		System.out.println("\n\nИспользование метода split для токенизации");
		String text = "Mr. Smith went to 14 Washington avenue.";
		String[] tokens = text.split("\\s+");
		for (String token : tokens){
			System.out.println(token);
		}
		System.out.println("\n");
		text = paragraph;
		String[] tokens2 = text.split("\\s+");
		for (String token : tokens2){
			System.out.println(token);
		}

		//Токенизация при помощи класса BreakIterator
		System.out.println("\n\nТокенизация при помощи класса BreakIterator");
		usingTheBreakIterator();

		//Токенизация при помощи класса StreamTokinizer
		System.out.println("\n\nТокенизация при помощи класса StreamTokenizer");
		usingStreamTokenizerClass();
	}

	private static void usingTheScannerClass(){
		Scanner scanner = new Scanner(paragraph);
		List<String> list = new ArrayList<>();
		scanner.useDelimiter("[ ,.]");

		while (scanner.hasNext()) {
			String token = scanner.next();
			list.add(token);
		}
		for (String token:list){
			System.out.println(token);
		}
	}

	private static void usingTheBreakIterator() {
		BreakIterator wordIterator = BreakIterator.getWordInstance();
		String text2 = paragraph;
		wordIterator.setText(text2);
		int boundary = wordIterator.first();
		while (boundary != BreakIterator.DONE) {
			int begin = boundary;
			System.out.print(boundary + "-");
			boundary = wordIterator.next();
			int end = boundary;
			if(end == BreakIterator.DONE) break;
			System.out.println(boundary + " [" + text2.substring(begin,end) + "]");
		}
		System.out.println();
	}

	private static void usingStreamTokenizerClass(){
		try{
			StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(paragraph));
			tokenizer.ordinaryChar('\'');
			tokenizer.ordinaryChar(',');
			boolean isEOF = false;
			while (!isEOF){
				int token = tokenizer.nextToken();
				switch (token){
					case StreamTokenizer.TT_EOF:
						isEOF = true;
						break;
					case StreamTokenizer.TT_EOL:
						break;
					case StreamTokenizer.TT_WORD:
						System.out.println(tokenizer.sval);
						break;
					case StreamTokenizer.TT_NUMBER:
						System.out.println(tokenizer.nval);
						break;
					default:
						System.out.println((char) token);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
