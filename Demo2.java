import java.sql.*;

public class Demo2 {
    public static void main(String[] args) {

        String dburl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection= DriverManager.getConnection(dburl,userName,password);
            Statement statement=connection.createStatement();
            String query="select * from employee";
            ResultSet resultSet=statement.executeQuery(query);
            /*
            Results meta data gives us all the column names in a query
             */
            ResultSetMetaData resultInfo= resultSet.getMetaData();
            /*
            index starts from 1 instead of 0
            getcolumncount will return total number of columns in the results
             */

            for (int i = 1; i <=resultInfo.getColumnCount() ; i++) {
                System.out.print(resultInfo.getColumnName(i)+" ");
            }
            System.out.println();
            while (resultSet.next()){
                //getting all the data from all the columns in a row
                for (int i = 1; i <= resultInfo.getColumnCount() ; i++) {
                    System.out.print(resultSet.getString(i)+" ");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
