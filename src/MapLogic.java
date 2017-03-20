import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

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

    public void initiate(ArrayList<String> questions) {

        TreeMap<ArrayList<String>, ArrayList<String>> taggedQuestions =  NLTools.POSTag(questions);

        //Context context = NLTools.ContextIdentify(taggedQuestions);
        //String[] keywords = new KeywordCorpusWrapper().queryFromDB();

        TreeMap<Integer, TreeMap<String, Double>> JsonMap = NLTools.findMatchingSubject(taggedQuestions);

        String json = new Gson().toJson(JsonMap);
        new OutputUI().setResultJSON(json);



    }


    public static ArrayList<String> getSubject(String keyword) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "", "");

        PreparedStatement statement = con.prepareStatement("SELECT sName from subjects where subjects.sID IN (SELECT mappings.sid FROM mappings\n" +
                "where tId in (SELECT topics.tId FROM topics WHERE topics.Topics LIKE ?) );");

        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
        }

        return result;


    }


}
