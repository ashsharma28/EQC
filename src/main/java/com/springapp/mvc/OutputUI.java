package com.springapp.mvc;

/**
 * Created by Ashish Sharma on 19-Mar-17.
 */
public class OutputUI {
   Topic resultTopic = null;
   String resultJSON  = null;

    public Topic getResultTopic() {
        return resultTopic;
    }

    public void setResultTopic(Topic resultTopic) {
        this.resultTopic = resultTopic;
    }

    public String getResultJSON() {
        return resultJSON;
    }

    public void setResultJSON(String resultJSON) {
        System.out.println(resultJSON);
        this.resultJSON = resultJSON;
    }
}
