import java.util.*; 
 
public class Main { 
 
    static class Student { 
        int roll; 
        String name; 
        double percentage; 
 
        Student(int roll, String name, double percentage) { 
            this.roll = roll; 
            this.name = name; 
            this.percentage = percentage; 
        } 
    } 
 
    static void printTable(ArrayList<Student> list) { 
        System.out.println("-----------------------------------"); 
        System.out.printf("%-8s%-10s%-10s%n", "Roll", "Name", "Percentage"); 
        System.out.println("-----------------------------------"); 
        for (Student s : list) { 
            System.out.printf("%-8d%-10s%-10.1f%n", s.roll, s.name, s.percentage); 
        } 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        ArrayList<Student> studentList = new ArrayList<>(); 
 
        System.out.print("Enter number of students: "); 
        int n = Integer.parseInt(sc.nextLine().trim()); 
 
        for (int i = 0; i < n; i++) { 
            System.out.println("Enter details for student " + (i + 1)); 
            System.out.print("Roll No: "); 
            int roll = Integer.parseInt(sc.nextLine().trim()); 
            System.out.print("Name: "); 
            String name = sc.nextLine().trim(); 
            System.out.print("Percentage: "); 
            double percentage = Double.parseDouble(sc.nextLine().trim()); 
            studentList.add(new Student(roll, name, percentage)); 
        } 
 
        System.out.println(); 
        System.out.println("Student Records (ArrayList)"); 
        System.out.println(); 
        printTable(studentList); 
 
        System.out.print("Enter Roll No to search: "); 
        int searchRoll = Integer.parseInt(sc.nextLine().trim()); 
 
        Student found = null; 
        for (Student s : studentList) { 
            if (s.roll == searchRoll) { 
                found = s; 
                break; 
            } 
        } 
 
        System.out.println(); 
        System.out.println("Searching for Roll No : " + searchRoll); 
        System.out.println(); 
 
        if (found != null) { 
            System.out.println("Record Found"); 
            System.out.println(); 
            System.out.println("Roll No   : " + found.roll); 
            System.out.println("Name      : " + found.name); 
            System.out.println("Percentage: " + found.percentage); 
        } else { 
            System.out.println("Record Not Found"); 
        } 
 
        if (!studentList.isEmpty()) { 
            studentList.remove(0); 
        } 
 
        System.out.println(); 
        System.out.println("After Removing First Student"); 
        System.out.println(); 
        printTable(studentList); 
 
        LinkedHashMap<Integer, Student> studentMap = new LinkedHashMap<>(); 
        for (Student s : studentList) { 
            studentMap.put(s.roll, s); 
        } 
 
        System.out.println(); 
        System.out.println("Student Records (HashMap)"); 
        System.out.println(); 
        System.out.println("-----------------------------------"); 
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) { 
            Student s = entry.getValue(); 
            System.out.printf("%d -> %s (%.1f%%)%n", s.roll, s.name, s.percentage); 
        } 
 
        sc.close(); 
    } 
}
