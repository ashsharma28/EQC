import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ashish Sharma on 19-Mar-17.
 */
public class InputUI {

    String paperType = null;
    File paper = null ;

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

    public void service(File paper, String paperType){

        ArrayList<String> questions = getQuestions(paper, paperType);

        MapLogic mapLogic = new MapLogic();

        mapLogic.initiate(questions);
    }

    public static void mainq(String[] args) {

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


        return new ArrayList<>(Arrays.asList(questions));
    }
}
