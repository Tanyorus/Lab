import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class WriteData_1 {
    public static void main(String[] args) throws java.io.IOException {
    String filename = "RwData.txt";
    File file = new File(filename);
    java.io.PrintWriter output = new java.io.PrintWriter(file);


    for (int i = 0 ; i < 100 ; i++){
    Random random = new Random();
    int randomInt = random.nextInt(100);
    output.print(randomInt);
    output.print(" ");
    }

    output.close();


    Scanner input = new Scanner(file);
    String[] N1 = (String[])input.nextLine().split(" ");
    int[] n1 = new int[N1.length];
    for(int i = 0 ; i < N1.length ; i++){
        n1[i] = Integer.parseInt(N1[i]);
    }

    Arrays.sort(n1);
    
    System.out.println("100 random integers written to"+ filename);
    System.out.println("Sorted integers :");
    System.out.println(Arrays.toString(n1));
    
    input.close();
}
}