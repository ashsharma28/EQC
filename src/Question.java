/**
 * Created by Ashish Sharma on 19-Mar-17.
 */
public class Question {

    String text ="";
    Context context = null;
    Topic topic;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
