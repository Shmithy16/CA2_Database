import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database_Connecter {
    static final String DB_URL = "jdbc:mysql://localhost/college_system";
    static final String USER = "user";
    static final String PASS = "";
    static final String QUERY = "SELECT teacher_id, name, address, wage FROM teachers";
    static final String QUERY2 = "SELECT subject_name, supplies FROM subjects";
    static final String QUERY3 = "SELECT student_id, name, age, address FROM students";
    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO departments VALUES('NGEN',50,'Health & Science');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO departments VALUES('BHUM',52,'Humanities');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO teachers VALUES('BHUM','BHUM1335','Abby Morin','2 Old Rd',35.42,17,0860509349);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO teachers VALUES('NGEN','NGEN1297','Carolina Hogarth','74 High St',35.89,  25.2,0578662280);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO students VALUES('D22465','Steven Murray',27,'82 Piperstown',012176100);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO students VALUES('B23222','Katelin Bryant',31,'92 Rochestown',0429334202)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO subjects VALUES('Introduction to Programming','NetBeans');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO subjects VALUES('Software Testing','IntelliJ');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO subjects VALUES('Rise of USA','American History');";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO subjects VALUES('Quality Assurance',NULL);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO student_classes VALUES('D22465','Software Testing',1080,10);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO student_classes VALUES('B23222','Software Testing',1080,16);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO teacher_classes VALUES('BHUM1335','Rise of USA',1060);";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO teacher_classes VALUES('NGEN1297','Quality Assurance',1107);";
            stmt.executeUpdate(sql);

            sql = "UPDATE teachers " +
                    "SET address = '46 Piperstown' WHERE teacher_id = 'ICAM1160'";
            stmt.executeUpdate(sql);
            sql = "UPDATE subjects " +
                    "SET supplies = 'Calculator' WHERE subject_name = 'Marketing';";
            stmt.executeUpdate(sql);
            sql = "UPDATE students " +
                    "SET age = 20 WHERE student_id = 'A22874';";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.print("Teacher_Id: " + rs.getString("teacher_id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", Address: " + rs.getString("address"));
                System.out.println(", Wage: " + rs.getDouble("wage"));
            }
            rs.close();

            rs = stmt.executeQuery(QUERY2);
            while(rs.next()){
                //Display values
                System.out.print("Subject_Name: " + rs.getString("subject_name"));
                System.out.print(", Supplies: " + rs.getString("supplies"));
            }
            rs.close();

            rs = stmt.executeQuery(QUERY3);
            while(rs.next()){
                //Display values
                System.out.print("Student_ID: " + rs.getString("student_id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.println(", Address: " + rs.getString("address"));
            }
            rs.close();

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
