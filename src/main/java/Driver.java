import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * Created by Ashish on 14-Mar-16.
 */


public class Driver {



    public static void main(String[] args) {

        InputStream modelIn = null;
        POSModel model;
        InputUI inputUI = new InputUI();
        inputUI.service(new File("C:\\Users\\admin\\Desktop\\QP.txt") ,"SampleQPType");


/*
        try {


            modelIn = new FileInputStream("src/NLPTools/en-pos-maxent.bin");
            model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);
            FileInputStream fileInputStream = new FileInputStream("F:\\Dev\\EQC\\src\\NLPTools\\QP.txt");
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String QP = new String(bytes);
            String[] questions = QP.split("Q[0-9].");
            List<String> list;
            List<List<String>> documents = new ArrayList<>();


            for (String question : questions) {

                String[] token = question.split(" ");

                list = new ArrayList<>();
                for (String s : token) {
                    list.add(s);
                }
                documents.add(list);
            }


            for (String question : questions) {


                InputStream modelForToks = new FileInputStream("src/NLPTools/en-token.bin");
                TokenizerModel model2 = new TokenizerModel(modelForToks);
                Tokenizer tokenizer = new TokenizerME(model2);
                String tokens[] = tokenizer.tokenize(question);
                String tags[] = tagger.tag(tokens);















                ArrayList<String> keywords = new ArrayList<>();

                for (int i = 0; i < tags.length; i++) {
                    if (tags[i].startsWith("N")) {
                        keywords.add(tokens[i]);
                    }
                }

                TreeMap<String, Integer> hashMap = new TreeMap<>();

                for (String keyword : keywords) {
                    if (keyword.length() < 3) continue;

                    System.out.print(keyword + ": ");
                    ArrayList<String> subjects = MapLogic.getSubject(keyword);

                    System.out.println(subjects);

                    for (String subject : subjects) {

                        if (hashMap.containsKey(subject)) {
                            hashMap.put(subject, hashMap.get(subject) + 1);
                        } else hashMap.put(subject, 1);
                    }

                }
                System.out.println(hashMap);


                System.out.println();
                System.out.println();


            }


        } catch (IOException | ClassNotFoundException | SQLException e) {
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
*/

    }

}

