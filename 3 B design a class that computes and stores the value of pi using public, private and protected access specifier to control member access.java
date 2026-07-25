import java.util.Scanner;

class PiCalculator {
    private int terms;
    public static final double EXACT_PI = Math.PI;

    public PiCalculator(int terms) {
        this.terms = terms;
    }

    public double getPiValue() {
        double pi = 0.0;
        for (int i = 0; i < terms; i++) {
            pi += Math.pow(-1, i) / (2 * i + 1);
        }
        return pi * 4;
    }

    protected void displayPrecisionInfo() {
        System.out.println("Protected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)");
    }

    public void displayPrivateData() {
        System.out.println("Private Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + getPiValue());
    }
}

public class PiCalculatorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Pi Calculator using Access Specifiers ===");
        System.out.print("Enter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();
        
        PiCalculator calc = new PiCalculator(terms);
        System.out.println("\nCalculating Pi using Leibniz Series...");
        System.out.println("Public Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + calc.getPiValue() + "\n");
        
        calc.displayPrecisionInfo();
        System.out.println();
        calc.displayPrivateData();
        
        sc.close();
    }
}
