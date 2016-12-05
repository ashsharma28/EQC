import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by Ashish on 14-Mar-16.
 */


public class Driver {

    public static void main(String[] args) {


	/*	CORPUS DATASTRUCTURES = NEW CORPUS("ASHISH", "SHARMA", "YUP");
		HASHSET<STRING> STRINGSET = DATASTRUCTURES.GETSTRINGSET();

		FOR (STRING A : STRINGSET) {
			SYSTEM.OUT.PRINTLN(A);
		}*/

        ///////////////

        InputStream modelIn = null;
        POSModel model;

        try {


            modelIn = new FileInputStream("C:\\Users\\admin\\Downloads\\en-pos-maxent.bin");
            model = new POSModel(modelIn);

            POSTaggerME tagger = new POSTaggerME(model);



            String question = "A queue is implemented using an array such that ENQUEUE and DEQUEUE operations are" +
                    "performed efficiently. Which one of the following statements is CORRECT (n refers to the" +
                    "number of items in the queue" ;


            InputStream modelFOrToks = new FileInputStream("C:\\Users\\admin\\Downloads\\en-token.bin");
            TokenizerModel model2 = new TokenizerModel(modelFOrToks);
            Tokenizer tokenizer = new TokenizerME(model2);
            String tokens[] = tokenizer.tokenize(question);


            String tags[] = tagger.tag(tokens);
            ArrayList<String> keywords = new ArrayList<>();

            for (int i = 0; i < tags.length; i++) {

                System.out.print(tokens[i] + "- "  );
                System.out.println(tags[i]);

                if(tags[i].startsWith("N")){
                    keywords.add(tokens[i]);

                }


            }

            System.out.println("Keywords :-");
            System.out.println(keywords);








        } catch (IOException e) {
            // Model loading failed, handle the error
            e.printStackTrace();
        } finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                } catch (IOException e) {
                }
            }
        }

    }
}

