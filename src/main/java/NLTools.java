import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Ashish Sharma on 18-Mar-17.
 */
public class NLTools {

    public static TreeMap<ArrayList<String> , ArrayList<String>> POSTag(ArrayList<String> questions) {

        TreeMap map = new TreeMap<>(
                new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
                // return 1 if lst1 > lst2, 0 if equal, -1 if lst1 < lst2
            return 1;
            }
        });



        InputStream modelIn = null;
        POSModel model;
        try {
            modelIn = new FileInputStream("src/main/java/NLPTools/en-pos-maxent.bin");
            model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);

            String[] tags;
            String[] tokens ;
            for (String question : questions) {
                InputStream modelForToks = new FileInputStream("src/main/java/NLPTools/en-token.bin");
                TokenizerModel model2 = new TokenizerModel(modelForToks);
                Tokenizer tokenizer = new TokenizerME(model2);
                tokens = tokenizer.tokenize(question);
                tags = tagger.tag(tokens);
                ArrayList<String> tokensList = new ArrayList<>(Arrays.asList(tokens));
                ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tags));

                map.put(tokensList , tagsList);
            }

            } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static Context ContextIdentify(TreeMap<String[], String[]> taggedQuestions) {

        return null;
    }

    public static TreeMap<Integer, TreeMap<String, Double>> findMatchingSubject(TreeMap<ArrayList<String>, ArrayList<String>> taggedQuestions) {


        TreeMap<Integer, TreeMap<String, Double>> toReturn = new TreeMap<>();

        final int[] x = {0};
        taggedQuestions.forEach((question, tag) -> {

            TreeMap<String, Double> hashMap = new TreeMap<>();
            ArrayList<String> keywords = new ArrayList<>();

            for (int i = 0; i < tag.size(); i++) {

                if (tag.get(i).startsWith("N")) {
                    keywords.add(question.get(i));
                }
            }


            for (String keyword : keywords) {
                if (keyword.length() < 3) continue;

                //System.out.print(keyword + ": ");
                ArrayList<String> subjects = null;

                try {


                    subjects = MapLogic.getSubject(keyword);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //System.out.println(subjects);

                for (String subject : subjects) {
                    if (hashMap.containsKey(subject)) {
                        hashMap.put(subject, hashMap.get(subject) + 1);
                    } else hashMap.put(subject, 1d);
                }
            }
            double sum = 0;
            for (Double aDouble : hashMap.values()) {
                sum+=aDouble;
            }
            if(sum==0)sum=1;

            for (String s : hashMap.keySet()) {
                hashMap.put(s, hashMap.get(s)/sum);
            }

            toReturn.put(x[0]++, hashMap);

        });

        return toReturn;
    }


    public static void setContext() {

    }

    public static void Topic() {

    }


}
