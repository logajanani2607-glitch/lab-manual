import java.io.*; 
import java.util.Scanner; 
 
public class StudentFile { 
    public static void main(String[] args) throws Exception { 
 
        Scanner sc = new Scanner(System.in); 
 
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt")); 
 
        for (int i = 1; i <= 3; i++) { 
            System.out.println("Student " + i); 
 
            System.out.print("Roll No: "); 
            int roll = sc.nextInt(); 
            sc.nextLine(); 
 
            System.out.print("Name: "); 
            String name = sc.nextLine(); 
 
            System.out.print("Marks: "); 
            int marks = sc.nextInt(); 
 
            bw.write(roll + "," + name + "," + marks); 
            bw.newLine(); 
        } 
 
        bw.close(); 
        System.out.println("\nStudent records saved successfully."); 
 
        BufferedReader br = new BufferedReader(new FileReader("students.txt")); 
 
        System.out.println("\nStudent Records"); 
        String line; 
 
        while ((line = br.readLine()) != null) { 
            System.out.println(line); 
        } 
 
        br.close(); 
    } 
}
