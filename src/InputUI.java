import java.io.File;

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

    void Service(File paper, String paperType){

        String[] questions = getQuestions(paper, paperType);

        MapLogic mapLogic = new MapLogic();

        mapLogic.initiate(questions);
    }

    public static void mainq(String[] args) {

    }

    private String[] getQuestions(File paper, String paperType) {
        //TODO : get Questions.
        return new String[0];
    }
}
