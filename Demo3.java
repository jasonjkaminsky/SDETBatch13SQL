import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Demo3 {
    public static void main(String[] args) {

        String dburl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        List<Map<String,String>> tableData=null;
        try {
            Connection connection= DriverManager.getConnection(dburl,userName,password);
            Statement statement=connection.createStatement();
            String query="select * from employee";
            ResultSet resultSet=statement.executeQuery(query);
            ResultSetMetaData resultInfo= resultSet.getMetaData();
             tableData=new ArrayList<>();
            while (resultSet.next()){
                LinkedHashMap<String,String> rowData=new LinkedHashMap<>();
                for (int i = 1; i <= resultInfo.getColumnCount() ; i++) {
                    rowData.put(resultInfo.getColumnName(i),resultSet.getString(i));
                }
               tableData.add(rowData);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(tableData);
    }
}
