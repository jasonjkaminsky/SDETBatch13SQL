import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    public static List<Map<String,String>> fetchDbData(String query){
        String dburl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        List<Map<String,String>> tableData=null;
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
             connection= DriverManager.getConnection(dburl,userName,password);
             statement=connection.createStatement();
             resultSet=statement.executeQuery(query);
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
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


        return tableData;
    }
}
