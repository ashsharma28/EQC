package com.springapp.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Ashish Sharma on 19-Mar-17.
 * A wrapper/ interface of the input of the EQC system. whatsoever may be the input
 */
public class InputUI {

    private String paperType = null;
    private File paper = null ;

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public File getPaper() {
        return paper;
    }

    public void setPaper(File paper) {
        this.paper = paper;
    }

    String service(File paper, String paperType){

        ArrayList<String> questions;

        if(paperType.equals("Text")){
            questions = getQuestionsFromTxt(paper.getAbsolutePath() , "NA");
        }
        else questions = getQuestions(paper, paperType);

        MapLogic mapLogic = new MapLogic();

        String json = mapLogic.initiate(questions);
        return json;
    }


    private ArrayList<String> getQuestions(File paper, String paperType) {
        String[] questions = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(paper);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String QP = new String(bytes);
            questions = QP.split("Q[0-9].");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert questions != null;
        return new ArrayList<>(Arrays.asList(questions));
    }




    protected ArrayList<String> getQuestionsFromTxt(String paperLoc, String OCR) {
        String QP = null;
        ArrayList<String> arr = new ArrayList<String>();
        try {
            Converter converter = new Converter();
            String txtFileLoc = null;
            if(OCR != "OCR"){
                if(paperLoc.endsWith(".pdf")){
                    txtFileLoc = converter.PDFToText(paperLoc);
                }
                else if(paperLoc.endsWith(".docx")){
                    txtFileLoc = converter.WordToText(paperLoc);
                }
                else if(paperLoc.endsWith(".txt")){
                    txtFileLoc = paperLoc;
                }
                FileInputStream fs = new FileInputStream(txtFileLoc); // Read TXT file from txtFileLoc
                byte[] bytes = new byte[fs.available()];
                fs.read(bytes);
                QP = new String(bytes);
                Pattern p = Pattern.compile("\\n(Q\\.\\d+)(.+?)(\\n\\(A\\))", Pattern.DOTALL);
                Matcher m = p.matcher(QP);
                while(m.find())
                {
                    arr.add(m.group(2));
                }
            }
            else{
                txtFileLoc = converter.OCRPDFToTxt(paperLoc);

                FileInputStream fs = new FileInputStream(txtFileLoc); // Read TXT file from txtFileLoc
                byte[] bytes = new byte[fs.available()];
                fs.read(bytes);
                QP = new String(bytes);
                Pattern p = Pattern.compile("(\\n[A-Z]\\.)([A-Z].+?)(\\n\\(A\\))", Pattern.DOTALL);
                Matcher m = p.matcher(QP);
                while(m.find())
                {
                    arr.add(m.group(2));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }



}
