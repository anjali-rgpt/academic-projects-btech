import java.sql.*;

public class connection{
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found. "+e);
        }
        System.out.println("JDBC Class Found");
        int num_rows=0;

        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","RC7pA9vB");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Student");
            while (rs.next()){
                num_rows++;
            }
            System.out.println("No. of rows:"+num_rows);
            
            rs=stmt.executeQuery("select SName,RollNumber from Student where CGPA>8;");
            System.out.println("\nResult of query 1:");
            num_rows=0;
            while(rs.next()){
            	String name=rs.getString(1);
            	String roll=rs.getString(2);
            	System.out.println(""+name+":"+roll);
            	num_rows++;
            }
            System.out.println("\nNo.of rows selected:"+num_rows);
            
            rs=stmt.executeQuery("select RollNumber from Student where CompanyPlaced='Infosys';");
            System.out.println("\nResult of query 2:");
            num_rows=0;
            while(rs.next()){
            	String roll=rs.getString(1);
            	System.out.println(roll);
            	num_rows++;
            }
            System.out.println("\nNo.of rows selected:"+num_rows);
            
            rs=stmt.executeQuery("select SName,RollNumber from Student order by RollNumber desc");
            System.out.println("\nResult of query 3:");
            num_rows=0;
            while(rs.next()){
            	String name=rs.getString(1);
            	String roll=rs.getString(2);
            	System.out.println(""+name+":"+roll);  //sorted in descending because roll numbers are already sorted
            	num_rows++;
            }
            System.out.println("\nNo.of rows selected:"+num_rows);
            
            
            
        }
        catch(SQLException e){
            System.out.println("Error occurred"+e);
        }
    }
}