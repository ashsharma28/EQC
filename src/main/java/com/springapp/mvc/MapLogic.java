package com.springapp.mvc;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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


    public String initiate(ArrayList<String> questions) {

        TreeMap<ArrayList<String>, ArrayList<String>> taggedQuestions =  NLTools.POSTag(questions);

        //Context context = NLTools.ContextIdentify(taggedQuestions);
        //String[] keywords = new KeywordCorpusWrapper().queryFromDB();
        TreeMap<Integer, TreeMap<String, Double>> JsonMap = NLTools.findMatchingSubject(taggedQuestions);


        HashMap<String, TreeMap<String, Double>> modified = new HashMap<>();
        JsonMap.forEach((index, toKeepAsItIs) -> {
            if(index!=2){

                modified.put(questions.get(index) , toKeepAsItIs);
            }
        });




        String json = new Gson().toJson(JsonMap);
        new OutputUI().setResultJSON(json);
        return json;
    }


    static Connection con;
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> getSubject(String keyword) throws ClassNotFoundException, SQLException {


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
