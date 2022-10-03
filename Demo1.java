import java.sql.*;

public class Demo1 {

    public static void main(String[] args) {

        // info that we need to connect to a database
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            // We need a connection to the database before we can start executing the queries on
            // that database
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
            // Takes the queries from this java code executes them on the database and
            // brings back the results
            Statement statement= connection.createStatement();
            String query="select * from person";
            // Result set is like iterator that contains the data from statement
            ResultSet resultSet= statement.executeQuery(query);
            // resultSet.next will keep on returning true as long as there are rows in result set
            while (resultSet.next()){

                // we can get the data for all columns by providing their names
                String firstName=resultSet.getString("firstname");
                String lastName=resultSet.getString("LastName");
                String age=resultSet.getString("age");
                System.out.println(firstName+" "+lastName+" "+age);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
