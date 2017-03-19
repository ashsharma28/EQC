import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by Ashish Sharma on 18-Mar-17.
 */
public class MapLogic {

    public void setContextPriority() {

    }

    public void setTopicPriority() {

    }

    public void setPrimaryTopic() {

    }


    public void setKeywordPriorities() {

    }

    public void initiate(String[] questions) {

        HashMap<String[],String[]> taggedQuestions =  NLTools.POSTag(questions);
        Context context = NLTools.ContextIdentify(taggedQuestions);

        KeywordCorpusWrapper corpusWrapper = new KeywordCorpusWrapper();
        String[] keywords = corpusWrapper.queryFromDB();

        HashMap<String , Integer> JsonMap = NLTools.findMatchingSubject(keywords);
        OutputUI outputUI = new OutputUI();

        Gson gson = new Gson();
        String json = gson.toJson(JsonMap);

        outputUI.setResultJSON(json);


    }
}
