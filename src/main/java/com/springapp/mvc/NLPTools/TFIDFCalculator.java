package com.springapp.mvc.NLPTools;

/**
 * Created by Ashish Sharma on 01-Mar-17.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mohamed Guendouz
 */
public class TFIDFCalculator {
    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {

        return tf(doc, term) * idf(docs, term);
    }

    public static void main(String[] args) throws IOException {

        //Application.launch();


        FileInputStream fileInputStream = new FileInputStream("F:\\Dev\\EQC\\src\\NLPTools\\QP.txt");
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);

        String QP = new String(bytes);
        String[] questions = QP.split("Q[0-9].");

        List<String> list = new ArrayList<>();
        List<List<String>> documents = new ArrayList<>();
        TFIDFCalculator calculator = new TFIDFCalculator();
        HashMap<String, Double> hashMap = new HashMap<>();


        for (String question : questions) {
            String[] split = question.split(" ");
            list = new ArrayList<>();
            for (String s : split) {
                list.add(s);
            }
            documents.add(list);
        }


        //Documents is ready, all the documents are in this 'documents'

        FileOutputStream fileOutputStream = new FileOutputStream("F:\\Dev\\EQC\\src\\NLPTools\\TfIdf.csv");

        double tfidf;
        ArrayList<HashMap> arrayList = new ArrayList<>();
        for (List<String> document : documents) {

            String report = "";
            for (String s : document) {
                s = s.trim();
                s = s.replaceAll("[.,:();?\"'~`!{}\\[\\]\\//0-9]", "");
                if(s.length()<= 2) continue;

                tfidf = calculator.tfIdf(document, documents, s);
                report = report.concat(s + ", " + tfidf + "\n");
                //hashMap.put(s, tfidf);
            }
            report = report.concat("-----------------, 0\n");
            fileOutputStream.write(report.getBytes());


            //arrayList.add(hashMap);
            //PieChartExperiments.setListOfPieCharts(arrayList);
        }

        //Application.launch(PieChartExperiments.class);

    }

}