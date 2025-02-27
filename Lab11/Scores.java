import java.util.Scanner; 

public class Scores {
  public static void main(String[] args) throws Exception {
    // Create a File instance
    Scanner INput = new Scanner(System.in);
    System.out.println("Enter the filename containing scores :");
    String filename = INput.nextLine();
    java.io.File file = new java.io.File(filename);

    // Create a Scanner for the file
    Scanner input = new Scanner(file);

    // Read data from a file
    int total = 0;
    String[] N1 = (String[])input.nextLine().split(" ");
    for (int i= 0 ; i < N1.length ; i++){
        int temp = Integer.parseInt(N1[i]);
        total += temp;
    }
    System.out.println("Total score : "+ total);
    System.out.println("Average score : "+ (double)total / N1.length);

    // Close the file
    input.close();
  }
}