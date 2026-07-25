class Box<T> { 
    private T item; 
 
    public void set(T item) { 
        this.item = item; 
    } 
 
    public T get() { 
        return item; 
    } 
 
    public void showType() { 
        System.out.println("Type of stored item : " + item.getClass().getName()); 
    } 
} 
 
class Pair<K, V> { 
    private K key; 
    private V value; 
 
    public Pair(K key, V value) { 
        this.key = key; 
        this.value = value; 
    } 
 
    public void display() { 
        System.out.println(key + " = " + value); 
    } 
} 
 
public class GenericDemo { 
 
    public static <T extends Comparable<T>> T findMax(T[] arr) { 
        T max = arr[0]; 
 
        for (int i = 1; i < arr.length; i++) { 
            if (arr[i].compareTo(max) > 0) { 
                max = arr[i]; 
            } 
        } 
 
        return max; 
    } 
 
    public static void main(String[] args) { 
 
        // Integer Box 
        Box<Integer> intBox = new Box<>(); 
        intBox.set(100); 
        System.out.println("Integer Box Value : " + intBox.get()); 
        intBox.showType(); 
 
        // String Box 
        Box<String> strBox = new Box<>(); 
        strBox.set("Hello Generics"); 
        System.out.println("String Box Value : " + strBox.get()); 
        strBox.showType(); 
 
        System.out.println("\n---- Key-Value Pairs ----"); 
 
        Pair<String, Integer> p1 = new Pair<>("Rahul", 88); 
        Pair<Integer, String> p2 = new Pair<>(101, "CSE"); 
 
        p1.display(); 
        p2.display(); 
 
        Integer[] numbers = {45, 89, 67, 12, 78}; 
        String[] names = {"Anu", "Ravi", "Sneha", "Kiran"}; 
        Double[] marks = {78.5, 92.3, 81.6, 88.9}; 
 
        System.out.println("\nMaximum Number : " + findMax(numbers)); 
        System.out.println("Maximum (Alphabetical) : " + findMax(names)); 
        System.out.println("Maximum Marks : " + findMax(marks)); 
    } 
}
