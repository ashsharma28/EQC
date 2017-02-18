import java.sql.*;
import java.util.ArrayList;

/**
 * Created by admin on 07-Feb-17.
 */
public class SQLWorker {
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
