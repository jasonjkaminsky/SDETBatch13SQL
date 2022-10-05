public class Demo4 {
    public static void main(String[] args) {
        String query="select * from employee";
        System.out.println(DbUtils.fetchDbData(query));
    }
}
