import java.util.Scanner;

public class MathToolsClient {
 public static void main(String[] args) {
  	MathTools mathTools = new MathTools();
 	startService(mathTools);   
  }
 
 public static void startService(MathTools mathTools) {
 	System.out.println("Select a number from the menu choices:");
  	System.out.println("1 - Absolute Value");
  	System.out.println("2 - Power");
  	System.out.println("3 - Nth Root");
  	System.out.println("4 - Scientific Notation");
  
  	Scanner scanner = new Scanner(System.in);
  	int option = scanner.nextInt();
  	if(option != 1 && option != 2 && option != 3 && option != 4) {
      System.out.println("Invalid option.");
      System.out.println("Return to the menu? (yes/no)");
      scanner.nextLine();
      String yesOrNo = scanner.nextLine();
      if(yesOrNo.equals("yes")) {
        startService(mathTools);
      }else {
        System.out.println("Exiting MathToolsClient...");
      }
    }else if(option == 1) {
    	System.out.println("***Absolute Value***");
     	System.out.println("Enter the value:");
     	double value = scanner.nextDouble();
     	System.out.println("|" + value + "| = " + mathTools.absoluteValue(value));
     	System.out.println("Exiting MathToolsClient...");
    }else if(option == 2) {
     	System.out.println("***Power***");
     	System.out.println("Enter the value:");
		double value = scanner.nextDouble();
     	System.out.println("Enter the exponent:");
     	int exponent = scanner.nextInt();
     	System.out.println(value + "^" + exponent + " = " + mathTools.power(value, exponent));
    	System.out.println("Exiting MathToolsClient...");
    }else if(option == 3) {
		System.out.println("***Nth Root***");
     	System.out.println("Enter the value:");
		double value = scanner.nextDouble();
     	System.out.println("Enter the root:");
     	int exponent = scanner.nextInt();
     	System.out.println(value + "^(1/" + exponent + ") = " + mathTools.power(value, exponent));
    	System.out.println("Exiting MathToolsClient...");
    }else {
    	System.out.println("***Scientific Notation***");
     	System.out.println("Enter the value:");
		double value = scanner.nextDouble();
     	System.out.println("Scientific notation of " + value + " is " + mathTools.scientificNotation(value));
    	System.out.println("Exiting MathToolsClient...");
    }
  	scanner.close();
 }
 
}