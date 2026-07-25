import java.util.*; 
import java.util.stream.*; 
 
class Employee { 
    int id; 
    String name; 
    String department; 
    double salary; 
 
    Employee(int id, String name, String department, double salary) { 
        this.id = id; 
        this.name = name; 
        this.department = department; 
        this.salary = salary; 
    } 
 
    public String toString() { 
        return id + " " + name + " " + department + " " + salary; 
    } 
} 
 
public class EmployeeAnalytics { 
    public static void main(String[] args) { 
 
        List<Employee> employees = Arrays.asList( 
                new Employee(101, "Rahul", "CSE", 55000), 
                new Employee(102, "Sneha", "ECE", 62000), 
                new Employee(103, "Kiran", "CSE", 48000), 
                new Employee(104, "Divya", "MECH", 51000), 
                new Employee(105, "Arjun", "ECE", 70000) 
        ); 
 
        // Display all employees 
        System.out.println("---- All Employees ----"); 
        employees.forEach(System.out::println); 
 
        // Employees with salary > 50000 in descending order 
        System.out.println("\n---- Salary Above 50000 (High to Low) ----"); 
        employees.stream() 
                .filter(e -> e.salary > 50000) 
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary)) 
                .forEach(e -> System.out.println(e.name + " -> " + e.salary)); 
 
        // Employee names 
        List<String> names = employees.stream() 
                .map(e -> e.name) 
                .collect(Collectors.toList()); 
 
        System.out.println("\n---- Employee Names ----"); 
        System.out.println(names); 
 
        // Group by department 
        Map<String, List<String>> grouped = employees.stream() 
                .collect(Collectors.groupingBy( 
                        e -> e.department, 
                        Collectors.mapping(e -> e.name, Collectors.toList()) 
                )); 
 
        System.out.println("\n---- Employees Grouped by Department ----"); 
        grouped.forEach((dept, empNames) -> 
                System.out.println(dept + " : " + empNames)); 
 
        // Average salary by department 
        Map<String, Double> avgSalary = employees.stream() 
                .collect(Collectors.groupingBy( 
                        e -> e.department, 
                        Collectors.averagingDouble(e -> e.salary) 
                )); 
 
        System.out.println("\n---- Average Salary per Department ----"); 
        avgSalary.forEach((dept, avg) -> 
                System.out.printf("%s : %.2f%n", dept, avg)); 
 
        // Total salary 
        double totalSalary = employees.stream() 
                .map(e -> e.salary) 
                .reduce(0.0, Double::sum); 
 
        System.out.printf("%nTotal Salary Paid : %.2f%n", totalSalary); 
 
        // Count CSE employees 
        long cseCount = employees.stream() 
                .filter(e -> e.department.equals("CSE")) 
                .count(); 
 
        System.out.println("Number of CSE Employees : " + cseCount); 
 
        // Highest paid employee 
        Optional<Employee> highestPaid = employees.stream() 
                .max(Comparator.comparingDouble(e -> e.salary)); 
 
        highestPaid.ifPresent(e -> 
                System.out.println("Highest Paid : " + e.name + " (" + e.salary + ")")); 
    }}
