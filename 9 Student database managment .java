import java.sql.*; 
 
public class Main { 
 
    static final String URL = "jdbc:mysql://localhost:3306/college"; 
    static final String USER = "root"; 
    static final String PASSWORD = "root";   // Change if needed 
 
    public static void main(String[] args) { 
 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
 
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD); 
 
            // Insert Records 
            String insert = "INSERT INTO student VALUES(?,?,?,?)"; 
            PreparedStatement ps = con.prepareStatement(insert); 
 
            ps.setInt(1, 101); 
            ps.setString(2, "Rahul"); 
            ps.setString(3, "CSE"); 
            ps.setInt(4, 90); 
            ps.executeUpdate(); 
 
            ps.setInt(1, 102); 
            ps.setString(2, "Sneha"); 
            ps.setString(3, "ISE"); 
            ps.setInt(4, 91); 
            ps.executeUpdate(); 
 
            System.out.println("Records Inserted Successfully."); 
 
            // Update 
            String update = "UPDATE student SET marks=? WHERE rollno=?"; 
            ps = con.prepareStatement(update); 
            ps.setInt(1, 95); 
            ps.setInt(2, 101); 
            ps.executeUpdate(); 
 
            System.out.println("Record Updated Successfully."); 
 
            // Search 
            String search = "SELECT * FROM student WHERE rollno=?"; 
            ps = con.prepareStatement(search); 
            ps.setInt(1, 101); 
 
            ResultSet rs = ps.executeQuery(); 
 
            System.out.println("\nStudent Details"); 
            while (rs.next()) { 
                System.out.println("Roll No : " + rs.getInt("rollno")); 
                System.out.println("Name : " + rs.getString("name")); 
                System.out.println("Department : " + rs.getString("department")); 
                System.out.println("Marks : " + rs.getInt("marks")); 
            } 
 
            // Display All Records 
            Statement st = con.createStatement(); 
            rs = st.executeQuery("SELECT * FROM student"); 
 
            System.out.println("\nStudent Records"); 
            System.out.println("--------------------------------------"); 
            System.out.println("Roll\tName\tDepartment\tMarks"); 
            System.out.println("--------------------------------------"); 
 
            while (rs.next()) { 
                System.out.println( 
                        rs.getInt("rollno") + "\t" + 
                        rs.getString("name") + "\t" + 
                        rs.getString("department") + "\t\t" + 
                        rs.getInt("marks")); 
            } 
 
            con.close(); 
 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
}
